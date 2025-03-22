package com.patil.user_service.controller;

import org.springframework.web.bind.annotation.RestController;

import com.patil.user_service.dto.MovieDTO;
import com.patil.user_service.entity.UserDetailsEntity;
import com.patil.user_service.entity.WatchList;
import com.patil.user_service.service.WatchListService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class WatchListController {
	
	@Autowired
	WatchListService watchListService;
	
	
	@GetMapping("/watchlist")
	public List<MovieDTO> getAllMoviesOfUserFromWatchlist(@RequestParam Long id) {
		return watchListService.retrieveAllMoviesByUserId(id);
	}
	
	@PostMapping("/watchlist")
	public ResponseEntity<String> postToWatchlist(@RequestBody WatchList watchList) {
		
		return null;
	}
	
	

}
