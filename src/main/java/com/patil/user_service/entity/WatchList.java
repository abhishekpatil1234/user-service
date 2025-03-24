package com.patil.user_service.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class WatchList {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	Long watchListId;
	Long userId;
	Long movieId;
	Date addedAt;
	
}
