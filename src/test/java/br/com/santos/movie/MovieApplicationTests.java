package br.com.santos.movie;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.santos.movie.adapter.controller.RestMovies;
import br.com.santos.movie.adapter.repository.RepositorySpringMovieImpl;
import br.com.santos.movie.domain.model.Movie;


@SpringBootTest
class MovieApplicationTests {
	
	@Autowired
	RestMovies restMovies;
	@Autowired
	RepositorySpringMovieImpl  repositorySpringMovieImpl;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void testInsert() {
		
		var listMovies = new ArrayList<Movie>();
		
		Movie movie = new Movie();
		movie.setProducers("Bo Derek");
		movie.setStudios("Cannon Films");
		movie.setTitle("Bolero");
		movie.setWinner("yes");
		movie.setYear(1984);
		listMovies.add(movie);
		
		movie = new Movie();
		movie.setProducers("Triumph Releasing");
		movie.setStudios(null);
		movie.setTitle("Ghosts Can't Do It");
		movie.setWinner("yes");
		movie.setYear(1990);
		listMovies.add(movie);
		
		
		movie = new Movie();
		movie.setProducers("Allan Carr");
		movie.setStudios("Associated Film Distribution");
		movie.setTitle("Can't Stop the Music");
		movie.setWinner("yes");
		movie.setYear(1990);
		listMovies.add(movie);
		
		 repositorySpringMovieImpl.insert(listMovies);
		 Integer countMovie = (repositorySpringMovieImpl.findAll()).size();
		 Assertions.assertEquals(3, countMovie);
	}
	
	@Test
	void testListaWinner() {
		
		var movie = restMovies.listWinners();
		
		//Assertions.assertEquals(0, movie.get));
		
		//var list = new ArrayList<Movie>();
		//var list = repositorySpringMovieImpl.insert(list);
		
	}

}
