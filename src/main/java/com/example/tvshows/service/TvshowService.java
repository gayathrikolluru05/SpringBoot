package com.example.tvshows.service;

import com.example.tvshows.exception.ResourceNotFoundException;
import com.example.tvshows.model.Tvshow;
import com.example.tvshows.model.TvshowDTO;
import com.example.tvshows.repository.TvshowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service


public class TvshowService{
    @Autowired
    TvshowRepository tvshowRepository;

    public List<TvshowDTO> getInRepo(){
        List<Tvshow> all_shows = tvshowRepository.findAll();
        int n=all_shows.size();
       List<TvshowDTO> mylist =  new ArrayList<TvshowDTO>();
        //shows_DTO= new TvshowDTO[n];
        for(Tvshow dto:all_shows) {
            TvshowDTO pp = new TvshowDTO();
            pp.setName(dto.getName());
            pp.setDirector(dto.getDirector());
            pp.setAvailable_on(dto.getAvailable_on());
            pp.setWatched(dto.getWatched());
              mylist.add(pp);
        }

            return mylist;
    }
//    public List<Tvshow> getInRepo(){
//        return tvshowRepository.findAll();
//    }


    public String addInRepo(Tvshow tvshow){
       tvshowRepository.save(tvshow);
       return "saved successfully";
    }

    public String deleteshow(String s) throws ResourceNotFoundException {
        tvshowRepository.deleteById(s);
        return "deleted successfully";
    }

    public String getdetails(Tvshow tvshow,String id) throws ResourceNotFoundException {
        Optional<Tvshow> sh= Optional.ofNullable(tvshowRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id)));
        if(! sh.isPresent()){
            return "Not found";
        }
        return tvshow.toString();
    }

    public String edit_watched_show(Tvshow tvshow,String s,Boolean b) throws ResourceNotFoundException{
        //tvshowRepository.findById();
        //#return "deleted successfully";
        Optional<Tvshow> sh= Optional.ofNullable(tvshowRepository.findById(s)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + "Parameter not matched")));
        if(! sh.isPresent()){
            return "Not found";
        }
        tvshow.setWatched(b);
        tvshowRepository.save(tvshow);
        return "Edited show with Name: "+tvshow.getName()+" with Watched : "+tvshow.getWatched();
    }

    public ResponseEntity<Optional<Tvshow>> edit_rating_show(Tvshow tvshow, String s, Integer b) throws ResourceNotFoundException{
        //tvshowRepository.findById();
        //#return "deleted successfully";
        Optional<Tvshow> sh= Optional.ofNullable(tvshowRepository.findById(s)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + s)));
        if(! sh.isPresent()){
            return ResponseEntity.ok().body(sh);
        }
        tvshow.setRating(b);
        tvshowRepository.save(tvshow);
        //return "Edited show with Name: "+tvshow.getName()+" with Watched : "+tvshow.getRating();
        return ResponseEntity.ok().body(sh);
    }



}
