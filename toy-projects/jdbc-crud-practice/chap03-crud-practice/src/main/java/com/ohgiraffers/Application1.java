package com.ohgiraffers;

import com.ohgiraffers.model.dto.ActorDTO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application1 {
    public static void main(String[] args) {
        /* 전체 행 출력 */
        Connection con = getConnection();
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        Properties prop = new Properties();

        List<ActorDTO> list = new ArrayList<>();
        ActorDTO actorDTO = null;

        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/mapper/actor-query.xml"));
            String query = prop.getProperty("selectActor");

            pstmt = con.prepareStatement(query);
            rset = pstmt.executeQuery();

            while (rset.next()) {
                actorDTO = new ActorDTO();
                actorDTO.setActorId(rset.getInt("actor_id"));
                actorDTO.setFirstName(rset.getString("first_name"));
                actorDTO.setLastName(rset.getString("last_name"));

                list.add(actorDTO);
            }

            for (ActorDTO actorList : list) {
                System.out.println(actorList);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);
            close(con);
        }
    }
}
