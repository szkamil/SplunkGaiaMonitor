package com.example.demo;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ReadFile {


    public static void main(String[] args) throws IOException {

        String fileName = "src/main/resources/test.txt";

        List<String> lines = Files.readAllLines( Paths.get( fileName ),
                StandardCharsets.UTF_8 );

        for (String line : lines) {

            System.out.println( line );
        }
    }
}
