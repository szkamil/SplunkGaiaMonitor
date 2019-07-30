package com.example.demo;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class SomeClass {


    public static void main(String[] args) {
        TimerTask repeatedTask = new TimerTask() {
            SendGet sendGet = new SendGet();

            public void run() {
                System.out.println( "Task performed on " + new Date() );

                try {
                    sendGet.hitUrl();
                } catch (Exception e) {
                    System.out.println( "Error calling actuators on " + new Date() );
                }

            }
        };
        Timer timer = new Timer( "Timer" );

        long delay = 5000L;
        long period = 5000L;
        timer.scheduleAtFixedRate( repeatedTask, delay, period );
    }


}

