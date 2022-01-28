package com.icbc.sh.maven;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;



@Component
public class FirstCommandLine implements CommandLineRunner {


    @Autowired
    private ConfigurableApplicationContext context;

    @Override
    public void run(String... args) {
        if(args.length == 0){
            System.out.println("无参数调用");
            return;
        }else{
            System.out.println("参数打印："+args[0]);
        }

        try {
           for(int i=0;i<5;i++){
               Thread.sleep(1000);
               System.out.println("Waiting~~~~~~~");
           }

        } catch (InterruptedException e) {
            System.out.println("Exception oops!"+e.getMessage());
        } finally {
            System.out.println("End!!!!");
            context.close();
//            System.exit(0);
        }

    }
}
