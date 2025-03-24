package com.patil.user_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patil.user_service.entity.WatchList;

@Repository
public interface WatchListRepository extends JpaRepository<WatchList, Long>{

	public List<WatchList> findByUserId(Long userId);
}
