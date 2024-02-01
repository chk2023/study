package com.ohgiraffers;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application5 {
    public static void main(String[] args) {
        Connection con = getConnection();
        PreparedStatement pstmt = null;
        Properties prop = new Properties();
        int result = 0;

        Scanner sc = new Scanner(System.in);
        System.out.println("삭제할 배우의 ID를 입력하세요 : ");
        int deleteActorId = sc.nextInt();

        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/mapper/actor-query.xml"));
            String query = prop.getProperty("deleteActor");

            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, deleteActorId);

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
            System.out.println("삭제 성공!");
        } else {
            System.out.println("삭제 실패...");
        }

    }
}
