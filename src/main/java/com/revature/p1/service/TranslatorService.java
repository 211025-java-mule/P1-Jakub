package com.revature.p1.service;

import com.revature.p1.Model.TranslationList;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TranslatorService {

    private final RestTemplate restTemplate;

    public TranslatorService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    //Returns TranslationList object based on the given string, uses the DeepL API
    public TranslationList getTranslation(String stringToTranslate) {

        ResponseEntity<TranslationList> responseEntity = restTemplate.exchange(
                "https://api-free.deepl.com/v2/translate?auth_key=9b4e3079-e7c7-0384-6a03-1373f3a95e39:fx&text=" + stringToTranslate + "&target_lang=PL",
                HttpMethod.GET,
                HttpEntity.EMPTY,
                TranslationList.class
        );
        return responseEntity.getBody();
    }
}
