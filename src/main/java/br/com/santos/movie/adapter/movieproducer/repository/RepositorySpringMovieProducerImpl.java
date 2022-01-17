package br.com.santos.movie.adapter.movieproducer.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.com.santos.movie.adapter.movieproducer.repository.model.EntityMovieProducer;
import br.com.santos.movie.domain.movieproducer.RepositoryMovieProducer;
import br.com.santos.movie.domain.movieproducer.model.MovieProducer;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class RepositorySpringMovieProducerImpl  implements RepositoryMovieProducer{

	RepositorySprinMovieProducer repositorySprinMovieProducer;

	@Override
	public List<MovieProducer> findAllWinners() {
		
		List<EntityMovieProducer> list = repositorySprinMovieProducer.findAllWinners();
		
		return list.stream()
				.map(EntityMovieProducer::convertToMovieProducer)
				.collect(Collectors.toList());
	
		 
	}
}
