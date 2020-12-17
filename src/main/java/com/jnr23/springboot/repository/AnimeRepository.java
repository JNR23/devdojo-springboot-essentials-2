package com.jnr23.springboot.repository;

import com.jnr23.springboot.domain.Anime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimeRepository extends JpaRepository<Anime, Long> {

}
