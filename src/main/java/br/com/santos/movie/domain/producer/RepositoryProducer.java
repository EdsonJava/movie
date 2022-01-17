package br.com.santos.movie.domain.producer;

import br.com.santos.movie.adapter.producer.repository.model.EntityProducer;
import br.com.santos.movie.domain.producer.model.Producer;

public interface RepositoryProducer {
	
	EntityProducer insert(Producer producer) ;
	Producer findByName(String name) ;
	
}
