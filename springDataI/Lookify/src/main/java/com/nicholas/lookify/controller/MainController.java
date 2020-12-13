package com.nicholas.lookify.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nicholas.lookify.models.Song;
import com.nicholas.lookify.services.SongService;

@Controller
public class MainController {
	
	@Autowired
	private SongService songServ;

	
	@GetMapping("")
	public String index() {
		return "index.jsp";
	}

// -----------------------RETRIEVING A SONG OR SONGS-------------------- //

	// RETRIEVING ALL SONGS
	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		// RETRIEVING ALL SONGS
		List<Song> allSongs = songServ.getAllSongs();
		// PASS ALL THE SONGS TO JSP
		model.addAttribute("allSongs", allSongs);
		return "dashboard.jsp";
		}
	
	// RETRIEVING ONE SONG
	@GetMapping("/songs/{id}")
	public String show(@PathVariable("id")Long id, Model model) {
		// RETRIEVE ONE SONG
		Song oneSong = songServ.findById(id);
		// PASS SONG TO JSP
		model.addAttribute("song", oneSong);
		return "show.jsp";
	}
	
// -----------------------CREATING A SONG -------------------- //
	// RENDERING THE CREATE PAGE
	@GetMapping("/songs/new")
	public String create(@ModelAttribute("songObj") Song song) {
		return "new.jsp";
	}
	// PROCESSING THE CREATION OF SONG
	@PostMapping("/songs/new")
	public String createSong( @Valid @ModelAttribute("songObj")Song song, BindingResult results) {
		if(results.hasErrors()) {
			return "new.jsp";
		}
		else {
			songServ.createSong(song);
			return "redirect:/dashboard";
		}
	}
// ----------------------DELETE ARTIST------------------------- //
	@GetMapping("/songs/{id}/delete")
	public String delete(@PathVariable("id") Long id) {
		songServ.deleteById(id);
		return "redirect:/dashboard";
	}
	
	//FUNCTION FOR ACCESSING ARTISTS
	@GetMapping("/search")
	public String search(@RequestParam(value="search")String name, Model model) {
		List<Song> songs = songServ.findSongByArtist(name);
		model.addAttribute("songs", songs);
		return "search.jsp";
	}
	
	//-----------------FIND TOP 10 SONGS----------------------------//
	
	@GetMapping("/search/topTen")
	public String searchTopTen(Model model) {
		List<Song> topTenSongs = songServ.findTopTenSongs();
		model.addAttribute("topSongs", topTenSongs);
		
		return "topTen.jsp";
	}
	
}
