package br.com.santos.movie;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import br.com.santos.movie.adapter.infra.ReadFileUtils;
import br.com.santos.movie.domain.movie.ServiceMovie;
import br.com.santos.movie.domain.movie.model.Movie;
import br.com.santos.movie.domain.producer.ServiceProducer;
import br.com.santos.movie.domain.producer.model.Producer;
import br.com.santos.movie.domain.studio.ServiceStudio;
import br.com.santos.movie.domain.studio.model.Studio;
import lombok.AllArgsConstructor;

@Profile("!test")
@Component
@AllArgsConstructor
public class MovieApplicationRunner implements CommandLineRunner {

	private final ServiceMovie serviceMovie;
	private final ServiceStudio serviceStudio;
	private final ServiceProducer serviceProducer;

	@Override
	public void run(String... args) {

		String PATH = "src/main/resources/";
		List<List<String>> movies = ReadFileUtils.readFileCsv(PATH + "movielist.csv");
		
		var list = createListMovies(movies);

		list.forEach(movie -> {
			movie.getStudios().forEach(s -> {
				Studio studio = serviceStudio.findByName(s.getName());
				if(studio.getId() == null) {
					var entity = serviceStudio.insert(s);
					s.setId(entity.getId());
				} else {
					s.setId(studio.getId());
				}
			});		
			
			movie.getProducers().forEach(p -> {
				Producer producer = serviceProducer.findByName(p.getName());
				if(producer.getId() == null) {
					var entity = serviceProducer.insert(p);
					p.setId(entity.getId());
				} else {
					p.setId(producer.getId());
				}
			});
		});
		serviceMovie.insert(list);
	}

	private List<Movie> createListMovies(List<List<String>> movies) {

		List<Movie> list = new ArrayList<>();
		Movie m;

		for (int i = 1; i < movies.size(); i++) {
			m = new Movie();
			m.setYear(Integer.parseInt(movies.get(i).get(0)));
			m.setTitle(movies.get(i).get(1));
			m.setStudios(createListStudio(movies.get(i).get(2)));
			m.setProducers(createListProducer(movies.get(i).get(3)));
			if (movies.get(i).size() > 4) {
				m.setWinner(movies.get(i).get(4));
			}
			list.add(m);
		}
		return list;
	}

	private List<Producer> createListProducer(String producers) {

		var list = new ArrayList<Producer>();
		Producer p;
		String[] values = producers.split(",|and");

		for (String s : values) {
			p = new Producer();
			if(s.length() > 1 && s != "") {
				p.setName(s.trim());
				list.add(p);
			}
		}
		return list;
	}

	private List<Studio> createListStudio(String studio) {
		
		var list = new ArrayList<Studio>();
		Studio stu;
		String[] values = studio.split(",|and");

		for (String s : values) {
			stu = new Studio();
			stu.setName(s.trim());
			list.add(stu);
		}
		return list;
	}
	
}
