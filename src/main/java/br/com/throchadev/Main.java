package br.com.throchadev;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
  public static void main(String[] args) throws IOException, InterruptedException {
    System.out.println("Hello world!");

    String url = "http://api.telegram.org/bot/sendMessage";

    HttpClient httpClient = HttpClient.newBuilder().build();

    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(url + "?chat_id=&text=Oi"))
        .GET()
        .build();

    HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

    System.out.println(response.statusCode());
    System.out.println(response.body());


  }
}