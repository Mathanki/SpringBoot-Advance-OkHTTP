package com.sample.request.Create.HTTP.Requests.controller;

import com.sample.request.Create.HTTP.Requests.service.ApiServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping("/api-sample")
public class ApiController {

    @Autowired
    private ApiServiceImpl apiService;

    @GetMapping("/get-api")
    public String getApiExample() {
        String apiUrl = "https://jsonplaceholder.typicode.com/posts/1";

        try {
            String apiResponse = apiService.makeGetRequest(apiUrl);
            return "GET Response: " + apiResponse;
        } catch (IOException e) {
            e.printStackTrace();
            return "While making GET request, getting Error: " + e.getMessage();
        }
    }

    @PostMapping("/post-api")
    public String postApiExample() {
        String apiUrl = "https://jsonplaceholder.typicode.com/posts";

        // This is the request body
        String requestBody = "{\"title\":\"foo\",\"body\":\"bar\",\"userId\":1}";

        try {
            String apiResponse = apiService.makePostRequest(apiUrl, requestBody);
            return "POST Response: " + apiResponse;
        } catch (IOException e) {
            e.printStackTrace();
            return "While making POST request, getting Error: " + e.getMessage();
        }
    }

    @PutMapping("/put-api")
    public String putApiExample() {
        String apiUrl = "https://jsonplaceholder.typicode.com/posts/1";

        try {
            String apiResponse = apiService.makePutRequest(apiUrl);
            return "PUT Response: " + apiResponse;
        } catch (IOException e) {
            e.printStackTrace();
            return "While making PUT request, getting Error: " + e.getMessage();
        }

    }

    @DeleteMapping("/delete-api")
    public String deleteApiExample() {
        String apiUrl = "https://jsonplaceholder.typicode.com/posts/1";

        try {
            String apiResponse = apiService.makeDeleteRequest(apiUrl);
            return "DELETE Response: " + apiResponse;
        } catch (IOException e) {
            e.printStackTrace();
            return "While making DELETE request, getting Error: " + e.getMessage();
        }

    }



}
