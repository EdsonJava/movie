package br.com.santos.movie.adapter.movie.controller.model;

import java.util.List;

import lombok.Data;

@Data
public class Root {
    public List<MovieDTO> min;
    public List<MovieDTO> max;
}
