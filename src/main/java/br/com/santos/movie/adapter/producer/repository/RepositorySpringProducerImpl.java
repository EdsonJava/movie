package br.com.santos.movie.adapter.producer.repository;

import java.util.List;
import java.util.stream.Collectors;

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

	@Override
	public List<Producer> findAllWinner() {
		
		return repositorySpringProducer.findAllWinner()
				.stream()
				.map(EntityProducer::convertToProducer)
				.collect(Collectors.toList());
	}
}
