package com.example.tvshows.repository;

import com.example.tvshows.model.Tvshow;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TvshowRepository extends MongoRepository<Tvshow,String> {
   // void save();
}
