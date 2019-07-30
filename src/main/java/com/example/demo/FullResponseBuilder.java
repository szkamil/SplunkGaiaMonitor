package com.example.demo;

import java.io.IOException;
import java.net.HttpURLConnection;

public class FullResponseBuilder {
    public static String getFullResponse(HttpURLConnection con) throws IOException {
        StringBuilder fullResponseBuilder = new StringBuilder();

        // read status and message

        // read headers

        // read response content

        fullResponseBuilder.append(con.getResponseCode())
                .append(" ")
                .append(con.getResponseMessage())
                .append("\n");

        return fullResponseBuilder.toString();
    }
}