package br.com.santos.movie.adapter.movie.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.com.santos.movie.adapter.movie.repository.model.EntityMovie;
import br.com.santos.movie.domain.movie.RepositoryMovie;
import br.com.santos.movie.domain.movie.modelo.Movie;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class RepositorySpringMovieImpl implements RepositoryMovie {

	private RepositorySprinMovie repositorySprinMovie;

	@Override
	public List<EntityMovie> insert(List<Movie> list) {
		
		List<EntityMovie> listEntity = new ArrayList<EntityMovie>();				
		list.forEach(item ->{
			listEntity.add(EntityMovie.convertToEntityMovie(item));
		});
		return repositorySprinMovie.saveAll(listEntity);
		
	}

	@Override
	public List<Movie> listWinners() {
	
		var list = repositorySprinMovie.listWinners()
				.stream()
				.map(EntityMovie::convertToMovie)
				.collect(Collectors.toList());
				
		return list;
	}

}