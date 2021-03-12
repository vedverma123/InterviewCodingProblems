package gfg;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue<E> {

   private Queue<E> queue;
   int max;
   private ReentrantLock lock = new ReentrantLock(true);
   private Condition fullQueue, emptyQueue ;

   public BlockingQueue(int size){
      queue = new LinkedList();
      this.max = size;
      fullQueue = lock.newCondition();
      emptyQueue = lock.newCondition();
   }

   public void add(E item){
      lock.lock();
      try{
         if(queue.size() == max){
            fullQueue.await();
         }
         queue.add(item);
         emptyQueue.signalAll();
      }catch(InterruptedException e){
         //log exception here
      }
      finally{
         lock.unlock();
      }
   }

   public E remove() throws InterruptedException {
      lock.lock();
      try{
         while(queue.size() == 0){
            emptyQueue.await();
         }
         final E item = queue.remove();
         fullQueue.signalAll();
         return item;
      }catch(InterruptedException e){
         throw e;
      }
      finally{
         lock.unlock();}
   }
}
