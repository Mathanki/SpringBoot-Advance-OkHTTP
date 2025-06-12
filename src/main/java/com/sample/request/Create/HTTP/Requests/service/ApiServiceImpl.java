package com.sample.request.Create.HTTP.Requests.service;

import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ApiServiceImpl {

    private final OkHttpClient OkHttpClient = new OkHttpClient();

    public String makeGetRequest(String apiUrl) throws IOException {
        Request request = new Request.Builder().url(apiUrl).build();
        try (Response response = OkHttpClient.newCall(request).execute()) {
            if (response.isSuccessful()) {
                return response.body().string();
            } else {
                throw new IOException("Unexpected response: " + response.code());
            }
        }
    }

    public String makePostRequest(String apiUrl, String requestBody) throws IOException {
        RequestBody body = RequestBody.create(requestBody, MediaType.parse("application/json"));
        Request request = new Request.Builder().url(apiUrl).post(body).build();

        try (Response response = OkHttpClient.newCall(request).execute()) {
            if (response.isSuccessful()) {
                return response.body().string();
            } else {
                throw new IOException("Unexpected response: " + response.code());
            }
        }
    }

    public String makePutRequest(String url) throws IOException {
        RequestBody emptyBody = RequestBody.create(new byte[0], null);
        Request request = new Request.Builder()
                .url(url)
                .put(emptyBody)
                .build();

        try (Response response = OkHttpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            return response.body().string();
        }
    }

    public String makeDeleteRequest(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .delete()
                .build();

        try (Response response = OkHttpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            return response.body().string();
        }
    }
}
