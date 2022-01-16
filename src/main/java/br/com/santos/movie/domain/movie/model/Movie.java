package br.com.santos.movie.domain.movie.model;

import java.util.List;

import br.com.santos.movie.domain.producer.model.Producer;
import br.com.santos.movie.domain.studio.model.Studio;
import lombok.Data;

@Data
public class Movie {

	private Long id;
	private Integer year;
	private String title;
	private String winner;
	private List<Studio> studios;
	private List<Producer> producers;
	
}
