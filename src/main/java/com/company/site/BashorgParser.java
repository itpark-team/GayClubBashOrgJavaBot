package com.company.site;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BashorgParser {
    public String getRandomQuote() throws Exception {
        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("http://bashorg.org/casual"))
                .build();

        HttpResponse httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        String bodyAsString = (String) httpResponse.body();

        Document document = Jsoup.parse(bodyAsString);
        Element divq = document.select("div.q").first();
        String plainHtml = divq.select("div").last().html();

        plainHtml = plainHtml.replace("<br>","\n").replace("&quot;","\"").replace("&lt;","<").replace("&gt;",">");

        return plainHtml;
    }
}
