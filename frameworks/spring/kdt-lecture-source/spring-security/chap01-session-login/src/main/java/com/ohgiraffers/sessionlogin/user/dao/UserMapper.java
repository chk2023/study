package com.ohgiraffers.sessionlogin.user.dao;

import com.ohgiraffers.sessionlogin.user.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    UserDTO findUserById(String userId);

    void registUser(UserDTO user);
}
