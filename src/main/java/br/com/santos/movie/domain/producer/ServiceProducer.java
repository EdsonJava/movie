package br.com.santos.movie.domain.producer;

import java.util.List;

import br.com.santos.movie.adapter.producer.repository.model.EntityProducer;
import br.com.santos.movie.domain.movie.model.MovieWinner;
import br.com.santos.movie.domain.producer.model.Producer;

public interface ServiceProducer {

	EntityProducer insert(Producer producer) ;
	Producer findByName(String name);
	List<MovieWinner> findAllWinner();
	List<MovieWinner> listWinnerMin(List<MovieWinner> list);
	List<MovieWinner> listWinnerMax(List<MovieWinner> list); 

}
