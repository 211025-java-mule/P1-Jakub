package com.revature.p1.Model;

import lombok.Data;

@Data
public class Movie {
    public String id;
    public String title;
    public String year;
    public String imDbRating;
    public String plot;
}