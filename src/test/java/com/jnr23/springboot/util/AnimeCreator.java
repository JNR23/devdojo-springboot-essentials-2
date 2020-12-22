package com.jnr23.springboot.util;

import com.jnr23.springboot.domain.Anime;

public class AnimeCreator {


    public static Anime createAnimeToBeSaved() {
        return Anime.builder()
                .name("Hajime no Ippo")
                .build();
    }

    public static Anime createValidAnime() {
        return Anime.builder()
                .name("Hajime no Ippo")
                .build();
    }

    public static Anime createValidUpdatedAnime() {
        return Anime.builder()
                .name("Hajime no Ippo 2")
                .id(1L)
                .build();
    }

}
