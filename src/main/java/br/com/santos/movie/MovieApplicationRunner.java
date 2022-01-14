package br.com.santos.movie;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import br.com.santos.movie.adapter.infra.ReadFileUtils;
import br.com.santos.movie.domain.movie.ServiceMovie;
import br.com.santos.movie.domain.movie.model.Movie;
import lombok.AllArgsConstructor;

@Profile("!test")
@Component
@AllArgsConstructor
public class MovieApplicationRunner implements CommandLineRunner {

	private final ServiceMovie serviceMovie;

	@Override
	public void run(String... args) {

		String PATH = "src/main/resources/";
		List<List<String>> movies = ReadFileUtils.readFileCsv(PATH + "movielist.csv");
		serviceMovie.insert(createListMovies(movies));
	}

	private List<Movie> createListMovies(List<List<String>> movies) {

		List<Movie> list = new ArrayList<>();
		Movie m;

		for (int i = 1; i < movies.size(); i++) {
			m = new Movie();
			m.setYear(Integer.parseInt(movies.get(i).get(0)));
			m.setTitle(movies.get(i).get(1));
			m.setStudios(movies.get(i).get(2));
			m.setProducers(movies.get(i).get(3));
			if (movies.get(i).size() > 4) {
				m.setWinner(movies.get(i).get(4));
			}
			list.add(m);
		}
		return list;
	}

	
}
