package com.patil.user_service.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.patil.user_service.dto.MovieDTO;


@FeignClient(name = "movie-service", url = "http://localhost:8081")
public interface MovieServiceApplicationProxy {
	
	@GetMapping("/")
	public MovieDTO getAllMovies(@RequestParam(required = false) Long id, @RequestParam(required = false) String name);
	
	@GetMapping("/movielist")
	public List<MovieDTO> getMoviesListByIds(@RequestParam List<Long> id);

}
