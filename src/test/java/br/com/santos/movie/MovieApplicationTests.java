package br.com.santos.movie;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import br.com.santos.movie.adapter.controller.RestMovies;
import br.com.santos.movie.adapter.repository.RepositorySpringMovieImpl;
import br.com.santos.movie.domain.model.Movie;

@ActiveProfiles("test")
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
		movie.setProducers("Bo Derek");
		movie.setStudios("Triumph Releasing");
		movie.setTitle("Ghosts Can't Do It");
		movie.setWinner("yes");
		movie.setYear(1990);
		listMovies.add(movie);
		
		
		movie = new Movie();
		movie.setProducers("Edson Bernardo");
		movie.setStudios("Cannon Films");
		movie.setTitle("Bolero");
		movie.setWinner("yes");
		movie.setYear(1920);
		listMovies.add(movie);
		
		movie = new Movie();
		movie.setProducers("Edson Bernardo");
		movie.setStudios("Cannon Films");
		movie.setTitle("Bolero");
		movie.setWinner("yes");
		movie.setYear(1999);
		listMovies.add(movie);
		
		
		movie = new Movie();
		movie.setProducers("Allan Carr");
		movie.setStudios("Associated Film Distribution");
		movie.setTitle("Can't Stop the Music");
		movie.setWinner("yes");
		movie.setYear(1990);
		listMovies.add(movie);
		
		 repositorySpringMovieImpl.insert(listMovies);
		 Integer countMovie = (restMovies.listWinners().getBody().size());
		 Assertions.assertEquals(2, countMovie);
		 
	}
}
