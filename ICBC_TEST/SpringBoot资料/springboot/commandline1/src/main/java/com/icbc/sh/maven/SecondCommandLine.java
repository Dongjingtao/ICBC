package com.icbc.sh.maven;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class SecondCommandLine implements CommandLineRunner {
    @Override
    public void run(String... args) {

        try {
            for(int i=0;i<5;i++){
                Thread.sleep(1000);
                System.out.println("Second Thread Waiting~~~~~~~");


            }

        } catch (InterruptedException e) {
            System.out.println("Second Thread Exception oops!"+e.getMessage());
        } finally {
            System.out.println("Second Thread End!!!!");
//            context.close();
            System.exit(0);
        }

    }
}
