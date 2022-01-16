package br.com.santos.movie;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import br.com.santos.movie.adapter.movie.controller.RestMovies;
import br.com.santos.movie.adapter.movie.repository.RepositorySpringMovieImpl;
import br.com.santos.movie.adapter.producer.repository.RepositorySpringProducerImpl;
import br.com.santos.movie.adapter.producer.repository.model.EntityProducer;
import br.com.santos.movie.adapter.studio.repository.RepositorySpringStudioImpl;
import br.com.santos.movie.adapter.studio.repository.model.EntityStudio;
import br.com.santos.movie.domain.movie.model.Movie;
import br.com.santos.movie.domain.producer.model.Producer;
import br.com.santos.movie.domain.studio.model.Studio;

@ActiveProfiles("test")
@SpringBootTest
class MovieApplicationTests {

	@Autowired
	RestMovies restMovies;
	@Autowired
	RepositorySpringMovieImpl repositorySpringMovieImpl;
	@Autowired
	RepositorySpringStudioImpl repositorySpringStudioImpl;
	@Autowired
	RepositorySpringProducerImpl repositorySpringProducerImpl;

	@Test
	void contextLoads() {
	}

	@Test
	void testInsert() {

		var listMovies = new ArrayList<Movie>();

		Studio s1 = insertStudio("HP Films");
		Producer p1 = insertProducer("Pedro Santos");
		Movie m1 = createMovie(s1, p1, "Teste", "yes", 1986);
		listMovies.add(m1);

		Movie m2 = createMovie(s1, p1, "Disco", "yes", 1985);
		listMovies.add(m2);

		Studio s2 = insertStudio("Triumph Releasing");
		Producer p2 = insertProducer("Bo Derek");
		Movie m3 = createMovie(s2, p2, "Sexta-Feira", "yes", 1985);
		listMovies.add(m3);

		Movie m4 = createMovie(s2, p2, "Ghosts Can't Do It", "yes", 1986);
		listMovies.add(m4);

		Studio s3 = insertStudio("Cannon Films");
		Producer p3 = insertProducer("Edson Bernardo");
		Movie m5 = createMovie(s3, p3, "Bolero", "yes", 1920);
		listMovies.add(m5);

		Movie m6 = createMovie(s3, p3, "Bolero", "yes", 1990);
		listMovies.add(m6);

		Studio s4 = insertStudio("Associated Film Distribution");
		Producer p4 = insertProducer("Allan Carr");
		Movie m7 = createMovie(s4, p4, "Can't Stop the Music", "yes", 1961);
		listMovies.add(m7);

		insertListMovies(listMovies);
		producerInterValMin();
		producerInterValMax();
	}

	private void producerInterValMax() {
		Integer count = restMovies.listWinners().getBody().getMax().size();
		Assertions.assertEquals(1, count);
	}

	private void producerInterValMin() {
		Integer count = restMovies.listWinners().getBody().getMin().size();
		Assertions.assertEquals(2, count);
	}

	private void insertListMovies(ArrayList<Movie> listMovies) {
		Integer count = repositorySpringMovieImpl.insert(listMovies).size();
		Assertions.assertEquals(7, count);
	}

	private Movie createMovie(Studio studio, Producer producer, String title, String winner, int year) {

		Movie movie = new Movie();
		var listPro = new ArrayList<Producer>();
		var listStu = new ArrayList<Studio>();
		movie.setTitle(title);
		movie.setWinner(winner);
		movie.setYear(year);
		movie.setProducers(listPro);
		movie.setStudios(listStu);
		movie.getProducers().add(producer);
		movie.getStudios().add(studio);

		return movie;
	}

	private Producer insertProducer(String pruducerName) {

		Producer producer = new Producer();
		producer.setName(pruducerName);
		EntityProducer entityProducer = repositorySpringProducerImpl.insert(producer);
		Assertions.assertEquals(pruducerName, entityProducer.getName());
		producer.setId(entityProducer.getId());

		return producer;
	}

	private Studio insertStudio(String nameStudio) {

		Studio studio = new Studio();
		studio.setName(nameStudio);
		EntityStudio entityStudio = repositorySpringStudioImpl.insert(studio);
		Assertions.assertEquals(nameStudio, entityStudio.getName());
		studio.setId(entityStudio.getId());

		return studio;
	}
}
