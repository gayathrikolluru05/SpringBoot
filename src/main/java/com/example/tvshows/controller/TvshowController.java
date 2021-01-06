package com.example.tvshows.controller;

import com.example.tvshows.exception.ResourceNotFoundException;
import com.example.tvshows.model.Tvshow;
//import com.example.tvshows.model.TvshowDTO;
import com.example.tvshows.model.TvshowDTO;
import com.example.tvshows.service.TvshowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class TvshowController {
    @Autowired
    //private TvshowRepository repository;
    private TvshowService tvshowService;

    @PostMapping("/addTvshow")
    public String saveTvshow(@Validated @RequestBody Tvshow show){
        //repository.save(show);
        //return "added tvshow with Name: "+show.getName();
        return tvshowService.addInRepo(show);
    }

    @GetMapping("/allTvshows")
    public List<TvshowDTO> getAllshows(){
        //return repository.findAll();
        return tvshowService.getInRepo();
    }

    @GetMapping("/allTvshows/{s}")
    public String getdetailsShow(@Validated @RequestBody Tvshow show,@PathVariable String id) throws ResourceNotFoundException{
        return tvshowService.getdetails(show,id);
    }

    @DeleteMapping("/delete/{s}")
    public String deleteShow(@Validated @PathVariable String s) throws ResourceNotFoundException {
        //repository.deleteById(s);
        //return "Deleted show with Name: "+ s;
        return tvshowService.deleteshow(s);
    }

    @PutMapping("/allTvshows/watched/{id}/{b}")
    public String editWatch(@Validated @RequestBody Tvshow show,@PathVariable String id,@PathVariable Boolean b) throws ResourceNotFoundException{
//       Optional<Tvshow> sh= repository.findById(id);
//        if(! sh.isPresent()){
//            return "Not found";
//        }
//        show.setWatched(b);
//        repository.save(show);
//        return "Edited show with Name: "+show.getName()+" with Watched : "+show.getWatched();
        return tvshowService.edit_watched_show(show,id,b);
    }

    @PutMapping("/allTvshows/ratings/{id}/{r}")
    public String edit(@Validated @RequestBody Tvshow show,@PathVariable String id,@PathVariable int r) throws ResourceNotFoundException{
//        Optional<Tvshow> sh= repository.findById(id);
//        if(! sh.isPresent()){
//            return "Not found";
//        }
//        show.setRating(r);
//        repository.save(show);
//        return "Edited show with Name: "+show.getName()+" with rating : "+show.getRating();

        return " "+tvshowService.edit_rating_show(show,id,r).getStatusCode();
    }


}
