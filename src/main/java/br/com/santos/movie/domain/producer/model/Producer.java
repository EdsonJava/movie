package br.com.santos.movie.domain.producer.model;

import java.util.List;

import br.com.santos.movie.adapter.movie.repository.model.EntityMovie;
import lombok.Data;

@Data
public class Producer {

	private Long id;
	private String name;
	private List<EntityMovie> movies;
	
}
