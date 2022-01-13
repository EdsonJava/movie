package br.com.santos.movie.adapter.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.com.santos.movie.adapter.repository.model.EntityMovie;
import br.com.santos.movie.domain.RepositoryMovie;
import br.com.santos.movie.domain.model.Movie;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class RepositorySpringMovieImpl implements RepositoryMovie {

	private RepositorySprinMovie repositorySprinMovie;

	@Override
	public void insert(List<Movie> list) {
		
		List<EntityMovie> listEntity = new ArrayList<EntityMovie>();				
		list.forEach(item ->{
			listEntity.add(EntityMovie.convertToEntityMovie(item));
		});
		repositorySprinMovie.saveAll(listEntity);
		
	}

	@Override
	public List<Movie> listWinners() {
	
		var list = repositorySprinMovie.listWinners()
				.stream()
				.map(EntityMovie::convertToMovie)
				.collect(Collectors.toList());
				
		return list;
	}

	@Override
	public List<Movie> findAll() {
		
		return repositorySprinMovie.findAll()
				.stream()
				.map(EntityMovie::convertToMovie)
				.collect(Collectors.toList());
	}
}
