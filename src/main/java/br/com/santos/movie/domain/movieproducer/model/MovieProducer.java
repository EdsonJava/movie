package br.com.santos.movie.domain.movieproducer.model;

import java.util.Objects;

import br.com.santos.movie.domain.movie.model.Movie;
import br.com.santos.movie.domain.producer.model.Producer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MovieProducer {

	private Movie movie;
	private Producer producer;
	
	public Integer getYear() {
		return movie.getYear();
	}

	@Override
	public int hashCode() {
		return Objects.hash(producer);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MovieProducer other = (MovieProducer) obj;
		return Objects.equals(producer.getId(), other.producer.getId());
	}
	
	
	
	
}
