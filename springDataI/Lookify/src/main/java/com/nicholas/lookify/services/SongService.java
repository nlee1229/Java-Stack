package com.nicholas.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nicholas.lookify.models.Song;
import com.nicholas.lookify.repositories.SongRepository;

@Service
public class SongService {
	
	@Autowired
	private SongRepository songRepo;
	
	public List<Song> getAllSongs(){
		return songRepo.findAll();
	}
	
	public Song findById(Long id) {
		Optional<Song> song = songRepo.findById(id);
		if(song.isPresent()) {
			return song.get();
		}
		else {
			return null;
		}
	}
	
	public Song createSong(Song song) {
		return songRepo.save(song);
	}
	
	public void deleteById(Long id) {
		songRepo.deleteById(id);
	}
	
	public List<Song> findSongByArtist(String name) {
		return songRepo.findByArtistIgnoreCaseContaining(name);
	}
	
	public List<Song> findTopTenSongs() {
	return songRepo.findTop10ByOrderByRatingDesc();
	}
}
