package br.com.santos.movie;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import br.com.santos.movie.adapter.movie.controller.RestMovies;
import br.com.santos.movie.adapter.movie.repository.RepositorySpringMovieImpl;
import br.com.santos.movie.domain.movie.model.Movie;


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
		movie.setProducers("Pedro Santos");
		movie.setStudios("Cannon Films");
		movie.setTitle("Disco");
		movie.setWinner("yes");
		movie.setYear(1985);
		listMovies.add(movie);
		
		movie = new Movie();
		movie.setProducers("Pedro Santos");
		movie.setStudios("Cannon Films");
		movie.setTitle("Teste");
		movie.setWinner("yes");
		movie.setYear(1986);
		listMovies.add(movie);
		
		movie = new Movie();
		movie.setProducers("Bo Derek");
		movie.setStudios("Cannon Films");
		movie.setTitle("Bolero");
		movie.setWinner("yes");
		movie.setYear(1985);
		listMovies.add(movie);
		
		movie = new Movie();
		movie.setProducers("Bo Derek");
		movie.setStudios("Triumph Releasing");
		movie.setTitle("Ghosts Can't Do It");
		movie.setWinner("yes");
		movie.setYear(1986);
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
		movie.setYear(1990);
		listMovies.add(movie);
		
		movie = new Movie();
		movie.setProducers("Allan Carr");
		movie.setStudios("Associated Film Distribution");
		movie.setTitle("Can't Stop the Music");
		movie.setWinner("yes");
		movie.setYear(1990);
		listMovies.add(movie);

		 Integer counInsert =  repositorySpringMovieImpl.insert(listMovies).size();
		 Assertions.assertEquals(7, counInsert);
		 
		 var listMin = restMovies.listWinners().getBody().getMin();
		 Integer countMin = listMin.size();
		 Assertions.assertEquals(2, countMin);
		 
		 var listMax = restMovies.listWinners().getBody().getMax();	 
		 Integer countMax = listMax.size();
		 Assertions.assertEquals(1, countMax);
	}
}
