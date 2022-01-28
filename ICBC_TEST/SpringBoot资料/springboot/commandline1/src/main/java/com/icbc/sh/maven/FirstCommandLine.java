package com.icbc.sh.maven;

//import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//import org.springframework.context.ConfigurableApplicationContext;


@Component
@Order(1)
public class FirstCommandLine implements CommandLineRunner {


//    @Autowired
//    private ConfigurableApplicationContext context;

    @Override
    public void run(String... args)  {

        try {
           for(int i=0;i<5;i++){
               Thread.sleep(1000);
               System.out.println("Waiting~~~~~~~");
           }

        } catch (InterruptedException e) {
            System.out.println("Exception oops!"+e.getMessage());
        } finally {
            System.out.println("End!!!!");
//            context.close();
//            System.exit(0);
        }

    }
}
