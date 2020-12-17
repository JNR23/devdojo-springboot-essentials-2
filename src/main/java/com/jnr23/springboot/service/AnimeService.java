package com.jnr23.springboot.service;

import com.jnr23.springboot.domain.Anime;
import com.jnr23.springboot.repository.AnimeRepository;
import com.jnr23.springboot.requests.AnimePostRequestBody;
import com.jnr23.springboot.requests.AnimePutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimeService {

    private final AnimeRepository animeRepository;

    public List<Anime> listAll() {
        return animeRepository.findAll();
    }

    public Anime findByIdorThrowBadRequestException(long id) {
        return animeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "Anime not found"));
    }

    public Anime save(AnimePostRequestBody animePostRequestBody) {
        return animeRepository.save(Anime.builder().name(animePostRequestBody.getName()).build());
    }

    public void delete(long id) {
        animeRepository.delete(findByIdorThrowBadRequestException(id));
    }

    public void replace(AnimePutRequestBody animePutRequestBody) {
        findByIdorThrowBadRequestException(animePutRequestBody.getId());
        Anime anime = Anime.builder().id(animePutRequestBody.getId())
                .name(animePutRequestBody.getName()).build();
        animeRepository.save(anime);
    }
}
