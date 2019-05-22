package com.hanwq;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description: ddswaggerservicea
 * Created by hanwq on 2019/5/22 17:53
 */
@EnableSwagger2Doc
@EnableDiscoveryClient
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class).web(true).run(args);
    }

    @RestController
    class AaaController {

        @Autowired
        DiscoveryClient discoveryClient;

        @GetMapping("/service-b")
        public String dc() {
            String services = "Services: " + discoveryClient.getServices();
            System.out.println(services);
            return services;
        }

    }

}
