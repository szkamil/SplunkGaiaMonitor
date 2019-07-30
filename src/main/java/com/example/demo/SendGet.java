package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
@SpringBootApplication
public class SendGet {

    String fileName = "src/main/resources/test.txt";
    public void hitUrl() throws Exception {


        List<String> lines = Files.readAllLines( Paths.get( fileName ),
                StandardCharsets.UTF_8 );

        for (String line : lines) {

            System.out.println( line );


            URL obj = new URL( line );
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();


            int responseCode = con.getResponseCode();
            System.out.println( "\nSending 'GET' request to URL : " + line );
            System.out.println( "Response Code : " + responseCode );

            BufferedReader in = new BufferedReader(
                    new InputStreamReader( con.getInputStream() ) );
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append( inputLine );
            }
            in.close();

            //print result
            System.out.println( response.toString() );
        }

    }
}