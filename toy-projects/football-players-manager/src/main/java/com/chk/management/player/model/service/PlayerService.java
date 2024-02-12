package com.chk.management.player.model.service;

import com.chk.common.SearchCondition;
import com.chk.management.player.model.dao.PlayerMapper;
import com.chk.management.player.model.dto.PlayerDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

import static com.chk.common.Template.getSqlSession;

public class PlayerService {
    private PlayerMapper playerMapper;
    public List<PlayerDTO> selectAllPlayerList() {
        SqlSession sqlSession = getSqlSession();

        playerMapper = sqlSession.getMapper(PlayerMapper.class);

        List<PlayerDTO> playerList = playerMapper.selectAllPlayerList();

        sqlSession.close();

        return playerList;
    }

    public List<PlayerDTO> selectPlayerBycondition(SearchCondition searchCondition) {
        SqlSession sqlSession = getSqlSession();

        playerMapper = sqlSession.getMapper(PlayerMapper.class);

        List<PlayerDTO> player = playerMapper.selectPlayerByCondition(searchCondition);

        return player;
    }

    public boolean registNewPlayer(PlayerDTO player) {
        SqlSession sqlSession = getSqlSession();

        playerMapper = sqlSession.getMapper(PlayerMapper.class);

        int result = playerMapper.insertPlayer(player);

        boolean bool;

        if (result > 0) {
            bool = true;
            sqlSession.commit();
        } else {
            bool = false;
            sqlSession.rollback();
        }
        return bool;
    }

    public boolean modifyPlayerInfo(PlayerDTO player) {
        SqlSession sqlSession = getSqlSession();
        playerMapper = sqlSession.getMapper(PlayerMapper.class);

        int result = playerMapper.updatePlayer(player);

        boolean bool;

        if (result > 0) {
            bool = true;
            sqlSession.commit();
        } else {
            bool = false;
            sqlSession.rollback();
        }
        return bool;
    }

    public boolean deletePlayer(Map<String, String> parameter) {
        SqlSession sqlSession = getSqlSession();
        playerMapper = sqlSession.getMapper(PlayerMapper.class);

        int result = playerMapper.deletePlayer(parameter);

        boolean bool;

        if (result > 0) {
            bool = true;
            sqlSession.commit();
        } else {
            bool = false;
            sqlSession.rollback();
        }
        return bool;
    }
}
