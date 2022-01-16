package br.com.santos.movie.adapter.producer.repository.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import br.com.santos.movie.adapter.movie.repository.model.EntityMovie;
import br.com.santos.movie.domain.producer.model.Producer;
import lombok.Data;

@Data
@Entity
@Table(name="producer")
public class EntityProducer {

	@Id
	@GeneratedValue (strategy =  GenerationType.IDENTITY)
	private Long id;
	@Column(name="NAME")
	private String name;
	@ManyToMany(mappedBy="producers", 
			cascade = CascadeType.ALL,  fetch = FetchType.EAGER)
	private List<EntityMovie> movies;
	
	
	public static EntityProducer convertToEntityProducer(Producer producer) {
		
		EntityProducer entityProducer = new EntityProducer();
		entityProducer.setId(producer.getId());
		entityProducer.setName(producer.getName());
		
		
		entityProducer.setMovies(producer.getMovies() == null ? null :
								producer.getMovies());
		
		//entityProducer.setMovies(producer.getMovies() == null ? null :
		//	producer.getMovies()
		//					.stream()
		//					.map(EntityMovie::convertToEntityMovie)
		//					.collect(Collectors.toList()));
		
		return entityProducer;
	}

	public Producer convertToProducer() {
		Producer producer = new Producer();
		producer.setId(this.getId());
		producer.setName(this.getName());
		producer.setMovies(this.getMovies() == null ? null :
								this.getMovies());
		
		//producer.setMovies(this.getMovies() == null ? null :
		//	this.getMovies()
		//					.stream()
		//					.map(EntityMovie::convertToMovie)
		//					.collect(Collectors.toList()));
		
		return producer;
	}	
	
}

