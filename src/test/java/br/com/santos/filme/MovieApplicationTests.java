package br.com.santos.filme;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.santos.filme.adapter.controller.RestMovies;
import br.com.santos.filme.adapter.repository.RepositorySpringMovieImpl;

@SpringBootTest
class MovieApplicationTests {
	
	@Autowired
	RestMovies restMovies;
	@Autowired
	RepositorySpringMovieImpl  repositorySpringMovieImpl;
	
	@Test
	void contextLoads() {
		
	//	var movie = restMovies.producerIntervalAward();
		
		//Assertions.assertEquals(0, movie.get));
		
	}
	
	
	
	void testarInserir() {
		
		//var list = new ArrayList<Movie>();
		//var list = repositorySpringMovieImpl.insert(list);
		
	}

}
