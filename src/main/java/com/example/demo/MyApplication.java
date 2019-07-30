package com.example.demo;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.net.HttpURLConnection;

@SpringBootApplication
public class MyApplication implements CommandLineRunner {

    @Autowired
    private YAMLConfig myConfig;

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(MyApplication.class);
        app.run();
    }
/*
add error handling/ what if there is a timeout /???????????????
 */
@Scheduled(fixedRate = 5000)
    public void run(String... args) throws Exception {
//        System.out.println("using environment: " + myConfig.getEnvironment());
//        System.out.println("name: " + myConfig.getName());
//        System.out.println("servers: " + myConfig.getServers());
//


        List<String> listOfUrl= myConfig.getServers();
//        System.out.println(listOfUrl);

        listOfUrl.stream().forEach( u -> {
//                    System.out.println( u );
                    try {
                        URL url = new URL( u );
                        HttpURLConnection con = (HttpURLConnection) url.openConnection();
                        con.setRequestMethod( "GET" );
                        System.out.println(u);
                        InputStream in = con.getInputStream();
                        String body = IOUtils.toString(in);
                        System.out.println(body);
                    } catch (Exception e) {
                        System.out.println("Unable to connect to " +  u);
                    }


                }

        );


    }
}