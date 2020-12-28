package com.jnr23.springboot.repository;

import com.jnr23.springboot.domain.AnimeUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimeUserRepository extends JpaRepository<AnimeUser, Long> {

    AnimeUser findByUsername(String username);

}
