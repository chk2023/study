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

public class Application3 {
    public static void main(String[] args) {
        Connection con = getConnection();
        PreparedStatement pstmt = null;
        Properties prop = new Properties();
        int result = 0;

        Scanner sc = new Scanner(System.in);
        System.out.println("추가하실 배우의 성씨를 입력하세요 : ");
        String insertLastName = sc.nextLine();
        System.out.println("추가하실 배우의 이름을 입력하세요 : ");
        String insertFirstName = sc.nextLine();

        ActorDTO insertActor = new ActorDTO();
        insertActor.setFirstName(insertFirstName);
        insertActor.setLastName(insertLastName);

        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/mapper/actor-query.xml"));
            String query = prop.getProperty("insertActor");

            pstmt = con.prepareStatement(query);
            pstmt.setString(1, insertActor.getFirstName());
            pstmt.setString(2, insertActor.getLastName());

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
            System.out.println("추가 성공!");
        } else {
            System.out.println("추가 실패...");
        }

    }
}
