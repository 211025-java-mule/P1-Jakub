package com.revature.p1.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "moviesPL")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int myID;
    public String id;
    public String title;
    public String year;
    public String imDbRating;
    @Column(length = 1000)
    public String plot;
}