
package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

/*
მთავარი კლასი.
აქედან იწყება Spring Boot აპლიკაცია.
*/

@SpringBootApplication
@EnableCaching
@EnableScheduling
public class DemoApplication {

    public static void main(String[] args) {

        // პროგრამის გაშვება
        SpringApplication.run(DemoApplication.class, args);
    }
}
