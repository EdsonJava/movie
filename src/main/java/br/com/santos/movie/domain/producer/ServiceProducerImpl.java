package br.com.santos.movie.domain.producer;

import org.springframework.stereotype.Service;

import br.com.santos.movie.adapter.producer.repository.model.EntityProducer;
import br.com.santos.movie.domain.producer.model.Producer;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ServiceProducerImpl implements ServiceProducer {

	RepositoryProducer repositoryProducer;

	@Override
	public EntityProducer insert(Producer producer) {

		return repositoryProducer.insert(producer);
	}

	@Override
	public Producer findByName(String name) {

		return repositoryProducer.findByName(name);
	}
}
