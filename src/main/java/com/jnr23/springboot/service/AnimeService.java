package com.jnr23.springboot.service;

import com.jnr23.springboot.domain.Anime;
import com.jnr23.springboot.exception.BadRequestException;
import com.jnr23.springboot.mapper.AnimeMapper;
import com.jnr23.springboot.repository.AnimeRepository;
import com.jnr23.springboot.requests.AnimePostRequestBody;
import com.jnr23.springboot.requests.AnimePutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimeService {

    private final AnimeRepository animeRepository;

    public Page<Anime> listAll(Pageable pageable) {
        return animeRepository.findAll(pageable);
    }

    public List<Anime>  listAllNonPageable() {
        return animeRepository.findAll();
    }

    public List<Anime> findByName(String name) {
        return animeRepository.findByName(name);
    }

    public Anime findByIdorThrowBadRequestException(long id) {
        return animeRepository.findById(id).orElseThrow(() -> new BadRequestException("Anime not found"));
    }

    @Transactional
    public Anime save(AnimePostRequestBody animePostRequestBody) {
        return animeRepository.save(AnimeMapper.INSTANCE.toAnime(animePostRequestBody));
    }

    public void delete(long id) {
        animeRepository.delete(findByIdorThrowBadRequestException(id));
    }

    public void replace(AnimePutRequestBody animePutRequestBody) {
        Anime savedAnime = findByIdorThrowBadRequestException(animePutRequestBody.getId());
        Anime anime = AnimeMapper.INSTANCE.toAnime(animePutRequestBody);
        anime.setId(savedAnime.getId());
        animeRepository.save(anime);
    }

}
