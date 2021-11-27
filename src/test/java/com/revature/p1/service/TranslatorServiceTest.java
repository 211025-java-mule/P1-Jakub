package com.revature.p1.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

public class TranslatorServiceTest {

    TranslatorService translatorService;

    @Before
    public void setup(){
        org.springframework.web.client.RestTemplate restTemplate = new RestTemplate();
        translatorService = new TranslatorService(restTemplate);
    }

    @Test
    public void testGetTranslation() {
        Assert.assertEquals("Witam", translatorService.getTranslation("Hello").getTranslations().get(0).getText());
    }
}