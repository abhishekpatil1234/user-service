package com.patil.user_service.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.patil.user_service.dto.MovieDTO;
import com.patil.user_service.entity.WatchList;
import com.patil.user_service.proxy.MovieServiceApplicationProxy;
import com.patil.user_service.repository.WatchListRepository;

@Service
public class WatchListService {
	
	@Autowired
	WatchListRepository watchListRepository;
	
	@Autowired
	MovieServiceApplicationProxy movieServiceApplicationProxy;
	
	
	public List<MovieDTO> retrieveAllMoviesByUserId(Long userId) {		 
		List<WatchList> watchList = watchListRepository.findByUserId(userId);
		List<Long> movieIds = watchList.stream().map(WatchList::getMovieId).collect(Collectors.toList());
		
		List<MovieDTO> movieList = movieServiceApplicationProxy.getMoviesListByIds(movieIds);
		
		return movieList;
	}
	
	
}
