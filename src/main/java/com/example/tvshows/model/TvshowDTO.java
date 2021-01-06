package com.example.tvshows.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@ToString

public class TvshowDTO {
    @Id
    public String name;


    public String director;
    public String available_on;
    public Boolean watched;
}
