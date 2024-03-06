package com.ohgiraffers.mvc.employee.controller;

import com.ohgiraffers.mvc.employee.model.dto.EmployeeDTO;
import com.ohgiraffers.mvc.employee.model.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/employee/update")
public class UpdateEmpServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String empId = req.getParameter("empId");
        String empName = req.getParameter("empName");

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setEmpId(empId);
        employeeDTO.setEmpName(empName);

        EmployeeService employeeService = new EmployeeService();
        int result = employeeService.updateEmp(employeeDTO);

        if (result > 0) {
            resp.sendRedirect(req.getContextPath() + "/employee/select?empId="+empId);
        } else {
            req.setAttribute("message", "직원 정보 수정에 실패하였습니다.");
            req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
        }
    }
}









