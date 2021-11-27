package com.revature.p1.model;

import lombok.Data;

@Data
public class Source {
    private String source_id;
    private String type;
    private String region;
    private String ios_url;
    private String android_url;
    private String web_url;
    private String format;
    private float price;
    private String seasons;
    private String episodes;
}
