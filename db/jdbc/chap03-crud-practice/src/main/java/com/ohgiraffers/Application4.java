package com.ohgiraffers;

import com.ohgiraffers.model.dto.ActorDTO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application4 {
    public static void main(String[] args) {
        Connection con = getConnection();
        PreparedStatement pstmt = null;
        Properties prop = new Properties();
        int result = 0;

        Scanner sc = new Scanner(System.in);
        System.out.print("수정하실 배우의 ID를 입력하세요 : ");
        int updateActorId = sc.nextInt();
        System.out.print("배우의 성씨를 입력하세요 : ");
        sc.nextLine();
        String updateLastName = sc.nextLine();
        System.out.print("배우의 이름을 입력하세요 : ");
        String updateFirstName = sc.nextLine();

        ActorDTO changeActor = new ActorDTO();
        changeActor.setFirstName(updateFirstName);
        changeActor.setLastName(updateLastName);
        changeActor.setActorId(updateActorId);

        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/mapper/actor-query.xml"));
            String query = prop.getProperty("updateActor");

            pstmt = con.prepareStatement(query);
            pstmt.setString(1, changeActor.getFirstName());
            pstmt.setString(2, changeActor.getLastName());
            pstmt.setInt(3, changeActor.getActorId());

            result = pstmt.executeUpdate();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
            close(con);
        }

        if (result > 0) {
            System.out.println("수정 성공!");
        } else {
            System.out.println("수정 실패...");
        }

    }
}
