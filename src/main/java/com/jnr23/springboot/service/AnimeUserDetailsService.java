package com.jnr23.springboot.service;

import com.jnr23.springboot.repository.AnimeUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnimeUserDetailsService implements UserDetailsService {

    private final AnimeUserRepository animeUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        return Optional.ofNullable(animeUserRepository.findByUsername(username))
                .orElseThrow(() -> new UsernameNotFoundException("Anime User not found"));
    }

}
