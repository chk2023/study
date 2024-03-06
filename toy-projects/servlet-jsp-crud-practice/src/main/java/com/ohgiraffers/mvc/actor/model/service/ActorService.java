package com.ohgiraffers.mvc.actor.model.service;

import com.ohgiraffers.mvc.actor.model.dao.ActorMapper;
import com.ohgiraffers.mvc.actor.model.dto.ActorDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.mvc.common.mybatis.Template.getSqlSession;

public class ActorService {

    private ActorMapper actorMapper;

    public ActorDTO selectOneActorById(String actorId) {

        SqlSession sqlSession = getSqlSession();

        actorMapper = sqlSession.getMapper(ActorMapper.class);

        ActorDTO selectedActor = actorMapper.selectOneActorById(actorId);

        sqlSession.close();

        return selectedActor;
    }

    public List<ActorDTO> selectAllActor() {

        SqlSession sqlSession = getSqlSession();

        actorMapper = sqlSession.getMapper(ActorMapper.class);

        List<ActorDTO> actorList = actorMapper.selectAllActor();

        sqlSession.close();

        return actorList;
    }

    public int insertActor(ActorDTO actor) {

    }
}




















