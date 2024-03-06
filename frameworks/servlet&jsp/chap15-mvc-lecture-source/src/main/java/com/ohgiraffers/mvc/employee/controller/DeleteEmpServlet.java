package com.ohgiraffers.mvc.employee.controller;

import com.ohgiraffers.mvc.employee.model.dto.EmployeeDTO;
import com.ohgiraffers.mvc.employee.model.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/employee/delete")
public class DeleteEmpServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String empId = request.getParameter("empId");

        EmployeeService employeeService = new EmployeeService();
        int result = employeeService.deleteEmp(empId);

        if(result > 0) {
            response.sendRedirect(request.getContextPath() + "/employee/list");
        } else {
            request.setAttribute("message", "직원 정보 삭제에 실패하였습니다.");
            request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(request, response);
        }
    }
}










