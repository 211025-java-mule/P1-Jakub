package com.revature.p1.model;

import lombok.Data;

@Data
public class Translation {
    private String detected_source_language;
    private String text;
}
