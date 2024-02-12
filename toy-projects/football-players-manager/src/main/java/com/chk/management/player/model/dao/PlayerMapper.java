package com.chk.management.player.model.dao;

import com.chk.common.SearchCondition;
import com.chk.management.player.model.dto.PlayerDTO;

import java.util.List;
import java.util.Map;

public interface PlayerMapper {
    List<PlayerDTO> selectAllPlayerList();

    List<PlayerDTO> selectPlayerByCondition(SearchCondition searchCondition);

    int insertPlayer(PlayerDTO player);

    int updatePlayer(PlayerDTO player);

    int deletePlayer(Map<String, String> parameter);
}
