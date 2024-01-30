package com.ohgiraffers.section02.preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application2 {
    public static void main(String[] args) {

        /* 1. Connection 생성 */
        Connection con = getConnection();
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        Scanner sc = new Scanner(System.in);
        System.out.println("조회하려는 사번을 입력해주세요 : ");
        String empId = sc.nextLine();
        String query = "SELECT emp_id, emp_name FROM employee WHERE emp_id = ?";

        try {
            /* 2. Connection의 prepareStatement(sql)을 이용한 PreparedStatement 인스턴스 생성*/
            pstmt = con.prepareStatement(query);

            /* 3. sql문의 위치홀더를 설정 */
            pstmt.setString(1, empId);

            /* 4. Statement의 executeQuery(sql)로 쿼리문 실행하고 결과를 ResultSet으로 반환 받음 */
            rset = pstmt.executeQuery();

            /* 5. ResultSet에 담긴 값을 컬럼명을 이용해 꺼내어 출력 */
            if (rset.next()) {
                System.out.println(rset.getString("emp_id") + ", " + rset.getString("emp_name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);
            close(con);
        }
    }
}