package br.com.santos.movie.domain.producer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.santos.movie.adapter.movie.repository.model.EntityMovie;
import br.com.santos.movie.adapter.producer.repository.model.EntityProducer;
import br.com.santos.movie.domain.movie.model.MovieWinner;
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

	@Override
	public List<MovieWinner> findAllWinner() {

		var list = repositoryProducer.findAllWinner();
		var listAll = mountListMovieProducerWinner(list);
		listAll.sort(Comparator.comparing(MovieWinner::getInterval));

		return listAll;
	}

	private List<MovieWinner> mountListMovieProducerWinner(List<Producer> list) {

		var listWinner = new HashSet<>(list);
		var listMovieWinner = new ArrayList<MovieWinner>();

		if (!listWinner.isEmpty()) {
			Comparator<EntityMovie> comparator = Comparator.comparing(EntityMovie::getYear);
			listWinner.forEach(mov -> {
				var winners = new HashSet<EntityMovie>();
				mov.getMovies().forEach(m -> {
					if (null != m.getWinner() && m.getWinner().equals("yes")) {
						winners.add(m);
					}
				});

				var minMovie = winners.stream().min(comparator);
				var maxMovie = winners.stream().max(comparator);

				MovieWinner mw = new MovieWinner();
				if (minMovie.isPresent()) {
					mw.setProducer(mov.getName());
					mw.setPreviousWin(minMovie.get().getYear());
					mw.setFollowingWin(maxMovie.get().getYear());
					mw.setInterval(maxMovie.get().getYear() - minMovie.get().getYear());

					if (mw.getInterval() >= 1 || mw.getInterval() <= 99) {
						listMovieWinner.add(mw);
					}
				}
			});
		}
		return listMovieWinner;
	}

	@Override
	public List<MovieWinner> listWinnerMin(List<MovieWinner> list) {

		return list
				.stream().min(Comparator.comparing(MovieWinner::getInterval)).map(min -> list.stream()
						.filter(mov -> mov.getInterval().equals(min.getInterval())).collect(Collectors.toList()))
				.orElse(List.of());
	}

	@Override
	public List<MovieWinner> listWinnerMax(List<MovieWinner> list) {

		return list
				.stream().max(Comparator.comparing(MovieWinner::getInterval)).map(max -> list.stream()
						.filter(mov -> mov.getInterval().equals(max.getInterval())).collect(Collectors.toList()))
				.orElse(List.of());

	}
}
