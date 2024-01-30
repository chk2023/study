package com.ohgiraffers;

import com.ohgiraffers.model.dto.ActorDTO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application2 {
    public static void main(String[] args) {
        /* id로 검색하여 출력 */
        Connection con = getConnection();
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        Properties prop = new Properties();

        Scanner sc = new Scanner(System.in);
        System.out.println("검색하실 배우의 ID를 입력하세요 : ");
        int inputId = sc.nextInt();

        ActorDTO searchDTO = new ActorDTO();
        searchDTO.setActorId(inputId);

        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/mapper/actor-query.xml"));
            String query = prop.getProperty("selectActorById");

            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, searchDTO.getActorId());
            rset = pstmt.executeQuery();

            if (rset.next()) {
                System.out.println(rset.getString("actor_id") + ": " + rset.getString("last_name"));
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
