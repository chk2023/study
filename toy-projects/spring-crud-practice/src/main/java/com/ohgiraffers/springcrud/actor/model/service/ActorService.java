package com.ohgiraffers.springcrud.actor.model.service;

import com.ohgiraffers.springcrud.actor.model.dao.ActorMapper;
import com.ohgiraffers.springcrud.actor.model.dto.ActorDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ActorService {
    private final ActorMapper actorMapper;

    public ActorService (ActorMapper actorMapper) {
        this.actorMapper = actorMapper;
    }

    public List<ActorDTO> findAllActor() {
        return actorMapper.findAllActor();
    }

    @Transactional
    public void registActor(ActorDTO actor) {
        actorMapper.registActor(actor);
    }
}
