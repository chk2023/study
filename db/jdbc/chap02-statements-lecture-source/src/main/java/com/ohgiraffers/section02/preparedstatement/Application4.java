package com.ohgiraffers.section02.preparedstatement;

import com.ohgiraffers.model.dto.EmployeeDTO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application4 {
    public static void main(String[] args) {

        /* XML 파일에 별도로 입력 한 sql 문을 통해 처리 */

        Connection con = getConnection();
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        EmployeeDTO selectedEmp = null;
        List<EmployeeDTO> empList = null;

        Scanner sc = new Scanner(System.in);
        System.out.println("조회할 이름의 성을 입력하세요 : ");
        String empName = sc.nextLine();

        Properties prop = new Properties();

        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/section02/preparedstatement/employee-query.xml"));
            String query = prop.getProperty("selectEmpByFamilyName");

            pstmt = con.prepareStatement(query);
            pstmt.setString(1, empName);

            rset = pstmt.executeQuery();

            empList = new ArrayList<>();

            /* 4. ResultSet에 담긴 값을 List 타입의 객체에 설정 */
            while(rset.next()) {
                selectedEmp = new EmployeeDTO();

                selectedEmp.setEmpId(rset.getString("emp_id"));
                selectedEmp.setEmpName(rset.getString("emp_name"));
                selectedEmp.setEmpNo(rset.getString("emp_no"));
                selectedEmp.setEmail(rset.getString("email"));
                selectedEmp.setPhone(rset.getString("phone"));
                selectedEmp.setDeptCode(rset.getString("dept_code"));
                selectedEmp.setJobCode(rset.getString("job_code"));
                selectedEmp.setSalLevel(rset.getString("sal_level"));
                selectedEmp.setSalary(rset.getInt("salary"));
                selectedEmp.setBonus(rset.getDouble("bonus"));
                selectedEmp.setManagerId(rset.getString("manager_id"));
                selectedEmp.setHireDate(rset.getDate("hire_date"));
                selectedEmp.setEntDate(rset.getDate("ent_date"));
                selectedEmp.setEntYn(rset.getString("ent_yn"));

                empList.add(selectedEmp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InvalidPropertiesFormatException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);
            close(con);
        }

        for(EmployeeDTO employeeDTO : empList) {
            System.out.println(employeeDTO);
        }

    }
}
