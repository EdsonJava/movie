package br.com.santos.movie.domain.movie;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.santos.movie.domain.movie.model.Movie;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ServiceMovieImpl implements ServiceMovie {

	private final RepositoryMovie repositoryMovie;

	@Override
	public void insert(List<Movie> list) {
	
		repositoryMovie.insert(list);
	}

}
