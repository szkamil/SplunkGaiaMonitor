package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HalApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void givenUsingTimer_whenSchedulingRepeatedTask_thenCorrect(){
		TimerTask repeatedTask = new TimerTask() {
			public void run() {
				System.out.println("Task performed on " + new Date());
			}
		};
		Timer timer = new Timer("Timer");

		long delay  = 1000L;
		long period = 1000L;
		timer.scheduleAtFixedRate(repeatedTask, delay, period);
	}

}
