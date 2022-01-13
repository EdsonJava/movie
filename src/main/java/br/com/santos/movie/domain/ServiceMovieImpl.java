package br.com.santos.movie.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.santos.movie.domain.model.Movie;
import br.com.santos.movie.domain.model.MovieWinner;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ServiceMovieImpl implements ServiceMovie {

	private final RepositoryMovie repositoryMovie;

	@Override
	public void insert(List<Movie> list) {
	
		repositoryMovie.insert(list);
	}

	@Override
	public List<MovieWinner> listWinners() {
			
		var listFinal = new ArrayList<MovieWinner>();
		var list = repositoryMovie.listWinners();
		
		var listAll = mountListMovieWinner(list);
		listAll.sort((o1, o2) -> o1.getInterval().compareTo(o2.getInterval()));
		
		var listMinInterval = minInterval(listAll);
		var listMaxInterval = maxInterval(listAll);
		
		listFinal.add(listMinInterval);
		listFinal.add(listMaxInterval);
		return listFinal;
	}

	private MovieWinner  maxInterval(List<MovieWinner> listAll) {
		
		Comparator<MovieWinner> comparator = Comparator.comparing( MovieWinner::getInterval);
		MovieWinner minMovie = listAll.stream().min(comparator).get();
		return minMovie;
	}

	private MovieWinner minInterval(List<MovieWinner> listAll) {
		
		Comparator<MovieWinner> comparator = Comparator.comparing( MovieWinner::getInterval);
		MovieWinner maxMovie = listAll.stream().max(comparator).get();
		return maxMovie;
	}

	private List<MovieWinner> mountListMovieWinner(List<Movie> list) {
		
		var listWinner = list.stream().collect(Collectors.toSet());
		var listMovieWinner = new ArrayList<MovieWinner>();
		
		Comparator<Movie> comparator = Comparator.comparing( Movie::getYear);
		
		if(!listWinner.isEmpty()) {
			MovieWinner mw = new MovieWinner();
			listWinner.forEach( w -> {
				var moviesWinners = list
									.stream()
									.filter(producer -> producer.getProducers().equals(w.getProducers()))
									.collect(Collectors.toList());
				
				Movie minMovie = moviesWinners.stream().min(comparator).get();
				Movie maxMovie = moviesWinners.stream().max(comparator).get();
				
				if(minMovie.getId() !=null && maxMovie != null) {
					mw.setProducer(w.getProducers());	
					mw.setPreviousWin(minMovie.getYear());
					mw.setFollowingWin(maxMovie.getYear());
					mw.setInterval(maxMovie.getYear() - minMovie.getYear());
					
					if(mw.getInterval() >= 1 || mw.getInterval() <=99)  {
						listMovieWinner.add(mw);
					}
					
				}
			});
		}
		return listMovieWinner;
	}

	@Override
	public List<Movie> findAll() {
		
		return repositoryMovie.findAll();
	}

}
