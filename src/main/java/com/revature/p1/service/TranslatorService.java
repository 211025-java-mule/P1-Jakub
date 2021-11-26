package com.revature.p1.service;

import com.revature.p1.model.TranslationList;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TranslatorService {

    private final RestTemplate restTemplate;
    private static final String API_KEY = System.getenv("api_key");

    public TranslatorService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    //Returns TranslationList object based on the given string, uses the DeepL API
    public TranslationList getTranslation(String stringToTranslate) {
        System.out.println(API_KEY);
        ResponseEntity<TranslationList> responseEntity = restTemplate.exchange(
                "https://api-free.deepl.com/v2/translate?auth_key=" + API_KEY + "&text=" + stringToTranslate + "&target_lang=PL",
                HttpMethod.GET,
                HttpEntity.EMPTY,
                TranslationList.class
        );
        return responseEntity.getBody();
    }
}
