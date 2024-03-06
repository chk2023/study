package com.ohgiraffers.mvc.actor.model.dao;

import com.ohgiraffers.mvc.actor.model.dto.ActorDTO;

import java.util.List;

public interface ActorMapper {
    ActorDTO selectOneActorById(String actorId);

    List<ActorDTO> selectAllActor();
}
