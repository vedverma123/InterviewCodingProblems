package gfg;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {

    public static void main(String[] args) {
        AtomicInteger integer = new AtomicInteger(000000);

        for(int i = 1; i < 45; i ++){
            String str = String.format("%06d", i);
            System.out.println(str);
        }
        
    }

}
