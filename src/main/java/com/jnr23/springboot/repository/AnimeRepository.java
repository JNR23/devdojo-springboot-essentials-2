package com.jnr23.springboot.repository;

import com.jnr23.springboot.domain.Anime;

import java.util.List;

public interface AnimeRepository {

    List<Anime> listAll();

}
