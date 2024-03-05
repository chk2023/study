package com.ohgiraffers.mvc.employee.controller;

import com.ohgiraffers.mvc.employee.model.dto.EmployeeDTO;
import com.ohgiraffers.mvc.employee.model.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/employee/select")
public class SelectOneEmpByIdServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String empId = req.getParameter("empId");
        System.out.println("empId : " + empId);

        EmployeeService employeeService = new EmployeeService();
        EmployeeDTO selectedEmp = employeeService.selectOneEmpById(empId);
        System.out.println("selectedEmp : " + selectedEmp);

        String path = "";
        if(selectedEmp != null) {
            path = "/WEB-INF/views/employee/showEmpInfo.jsp";
            req.setAttribute("selectedEmp", selectedEmp);
        } else {
            path = "/WEB-INF/views/common/errorPage.jsp";
            req.setAttribute("message", "해당 사번을 가진 직원은 없습니다.");
        }

        req.getRequestDispatcher(path).forward(req, resp);

    }
}
