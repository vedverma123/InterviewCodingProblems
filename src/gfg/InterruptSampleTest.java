package gfg;

public class InterruptSampleTest {

   public InterruptSampleTest(){
      Thread myThread = new Thread(new Task());
      myThread.start();
      //after some time interrupt this thread.
      myThread.interrupt();
   }

   public static void main(String[] args){
      new InterruptSampleTest();
   }

   class Task implements Runnable{

      @Override
      public void run() {
         for(int i = 0; i < 100000; i ++) {

            System.out.println(i);
            //do some operation.
            if(Thread.currentThread().isInterrupted()){
               System.out.println("Thread has been interrupted...");
               return;
            }
         }
      }
   }

}
