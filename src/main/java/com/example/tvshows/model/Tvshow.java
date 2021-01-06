package com.example.tvshows.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Getter
@Setter
@ToString
@Document(collection = "Tvshow")

public class Tvshow {
    @Id
    public String name;


    public String director;
    public String available_on;
    public Boolean watched;
    public int rating;

}
