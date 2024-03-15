package com.ohgiraffers.springcrud.actor.model.dao;

import com.ohgiraffers.springcrud.actor.model.dto.ActorDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ActorMapper {
    List<ActorDTO> findAllActor();


    void registActor(ActorDTO actor);
}
