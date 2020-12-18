package com.jnr23.springboot.mapper;

import com.jnr23.springboot.domain.Anime;
import com.jnr23.springboot.requests.AnimePostRequestBody;
import com.jnr23.springboot.requests.AnimePutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class AnimeMapper {

    public static final AnimeMapper INSTANCE = Mappers.getMapper(AnimeMapper.class);

    public abstract Anime toAnime(AnimePostRequestBody animePostRequestBody);

    public abstract Anime toAnime(AnimePutRequestBody animePutRequestBody);

}
