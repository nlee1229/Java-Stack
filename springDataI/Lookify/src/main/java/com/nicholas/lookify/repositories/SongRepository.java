package com.nicholas.lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nicholas.lookify.models.Song;

@Repository
public interface SongRepository extends CrudRepository<Song, Long> {
	List<Song> findAll();
	// For searching` function
	List<Song> findByArtistIgnoreCaseContaining(String name);
	//Top ten artists
	List<Song> findTop10ByOrderByRatingDesc();
}
