package br.com.throchadev;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class TelegramBot {
  public static void main(String[] args) throws IOException, InterruptedException {

    var token = "my token";
    var chatId = "chat id";

    HttpClient httpClient = HttpClient.newBuilder().build();

    var urlGetMe = "https://api.telegram.org/bot" + token + "/getMe";

    HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(urlGetMe))
            .GET()
            .build();

    HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

    System.out.println(response.statusCode());
    System.out.println(response.body());

    var urlGetUpdates = "https://api.telegram.org/bot" + token + "/getUpdates";

    request = HttpRequest.newBuilder()
            .uri(URI.create(urlGetUpdates))
            .GET()
            .build();

    response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

    System.out.println(response.statusCode());
    System.out.println(response.body());

    var urlSendMessage = "https://api.telegram.org/bot" + token + "/sendMessage";

    var text = "Hi";

    request = HttpRequest.newBuilder()
        .uri(URI.create(urlSendMessage + "?chat_id=" + chatId + "&text=" + text))
        .GET()
        .build();

    response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

    System.out.println(response.statusCode());
    System.out.println(response.body());

  }
}