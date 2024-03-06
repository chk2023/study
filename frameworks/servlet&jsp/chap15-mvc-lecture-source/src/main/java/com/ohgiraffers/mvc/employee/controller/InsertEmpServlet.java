package com.ohgiraffers.mvc.employee.controller;

import com.ohgiraffers.mvc.employee.model.dto.EmployeeDTO;
import com.ohgiraffers.mvc.employee.model.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/employee/insert")
public class InsertEmpServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String empName = req.getParameter("empName");
        String empNo = req.getParameter("empNo");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String deptCode = req.getParameter("deptCode");
        String jobCode = req.getParameter("jobCode");
        String salLevel = req.getParameter("salLevel");
        int salary = Integer.parseInt(req.getParameter("salary"));
        double bonus = Double.parseDouble(req.getParameter("bonus"));
        String managerId = req.getParameter("managerId");
        Date hireDate = Date.valueOf(req.getParameter("hireDate"));

        EmployeeDTO emp = new EmployeeDTO();
        emp.setEmpName(empName);
        emp.setEmpNo(empNo);
        emp.setEmail(email);
        emp.setPhone(phone);
        emp.setDeptCode(deptCode);
        emp.setJobCode(jobCode);
        emp.setSalLevel(salLevel);
        emp.setSalary(salary);
        emp.setBonus(bonus);
        emp.setManagerId(managerId);
        emp.setHireDate(hireDate);

        System.out.println("insert request emp : " + emp);

        EmployeeService employeeService = new EmployeeService();
        int result = employeeService.insertEmp(emp);

        if (result > 0) {
            /* insert가 성공 했을 경우 요청 url이 그대로 남아있으면 브라우저 새로고침 시 insert 재요청이 발생한다.
            * redirect 처리가 필요하며 전체 사원 목록을 조회하는 기능을 요청하도록 한다. */
            resp.sendRedirect(req.getContextPath() + "/employee/list");
        } else {
           req.setAttribute("message", "신규 직원 등록에 실패하였습니다.");
           req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
        }

    }
}
