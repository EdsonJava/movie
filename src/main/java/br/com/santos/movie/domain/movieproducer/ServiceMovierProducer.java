package br.com.santos.movie.domain.movieproducer;

import java.util.List;

import br.com.santos.movie.domain.movie.model.MovieWinner;

public interface ServiceMovierProducer {

	List<MovieWinner> findAllWinners();
	List<MovieWinner> listWinnerMin(List<MovieWinner> list);
	List<MovieWinner> listWinnerMax(List<MovieWinner> list); 

}
