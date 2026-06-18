package com.example.demo.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

    // ეს მეთოდი შესრულდება ყოველ 1 წუთში
    @Scheduled(fixedRate = 60000)
    public void reportCurrentTime() {
        System.out.println("სისტემა მუშაობს გამართულად. დრო: " + System.currentTimeMillis());
    }
}