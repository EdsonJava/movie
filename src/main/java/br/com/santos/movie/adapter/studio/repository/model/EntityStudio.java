package br.com.santos.movie.adapter.studio.repository.model;

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
import br.com.santos.movie.domain.studio.model.Studio;
import lombok.Data;

@Data
@Entity
@Table(name="studio")
public class EntityStudio {

	@Id
	@GeneratedValue (strategy =  GenerationType.IDENTITY)
	private Long id;
	@Column(name="NAME")
	private String name;
	@ManyToMany(mappedBy="studios", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<EntityMovie> movies;
	
	public static EntityStudio convertToEntityStudio(Studio studio) {
		
		EntityStudio entityStudio = new EntityStudio();
		entityStudio.setId(studio.getId());
		entityStudio.setName(studio.getName());
		
		return entityStudio;
	}
	
	public Studio convertToStudio() {
		Studio studio = new Studio();
		studio.setId(this.getId());
		studio.setName(this.getName());
		
		return studio;
	}	
	
}

