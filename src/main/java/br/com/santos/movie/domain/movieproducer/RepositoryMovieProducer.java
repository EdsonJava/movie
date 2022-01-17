package br.com.santos.movie.domain.movieproducer;

import java.util.List;
import br.com.santos.movie.domain.movieproducer.model.MovieProducer;

public interface RepositoryMovieProducer {

	List<MovieProducer> findAllWinners();	

}
