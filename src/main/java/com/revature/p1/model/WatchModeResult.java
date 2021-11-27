package com.revature.p1.model;

import lombok.Data;

import java.util.ArrayList;

@Data
public class WatchModeResult {
    ArrayList<Title> title_results = new ArrayList<>();
    ArrayList<Object> people_results = new ArrayList<>();
}
