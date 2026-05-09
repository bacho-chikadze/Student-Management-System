
package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
მთავარი კლასი.
აქედან იწყება Spring Boot აპლიკაცია.
*/

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

        // პროგრამის გაშვება
        SpringApplication.run(DemoApplication.class, args);
    }
}
