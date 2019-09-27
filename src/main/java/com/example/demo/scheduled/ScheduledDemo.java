package com.example.demo.scheduled;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * 定时任务
 */
@Configuration
@EnableScheduling
public class ScheduledDemo {
    @Scheduled(fixedDelay = 1000)
    public void scheduleFixedDealyTask() {
        System.out.println("Fixed delay task - " + System.currentTimeMillis() / 1000);
    }
}
