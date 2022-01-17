package br.com.santos.movie.adapter.producer.repository;

import org.springframework.stereotype.Component;

import br.com.santos.movie.adapter.producer.repository.model.EntityProducer;
import br.com.santos.movie.domain.producer.RepositoryProducer;
import br.com.santos.movie.domain.producer.model.Producer;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class RepositorySpringProducerImpl implements RepositoryProducer{

	RepositorySprinProducer repositorySpringProducer;
	
	@Override
	public EntityProducer insert(Producer producer) {
		 return repositorySpringProducer.save(
				 EntityProducer.convertToEntityProducer(producer));
	}

	@Override
	public Producer findByName(String name) {
		
		var entity = repositorySpringProducer.findByName(name)
				.orElseGet(() -> 
					new EntityProducer());
			return entity.convertToProducer();
	}

}
