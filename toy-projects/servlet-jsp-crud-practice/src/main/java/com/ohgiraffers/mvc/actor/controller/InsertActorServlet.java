package com.ohgiraffers.mvc.actor.controller;

import com.ohgiraffers.mvc.actor.model.dto.ActorDTO;
import com.ohgiraffers.mvc.actor.model.service.ActorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/actor/insert")
public class InsertActorServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");

        ActorDTO actor = new ActorDTO();
        actor.setFirstName(firstName);
        actor.setLastName(lastName);

        ActorService actorService = new ActorService();
        int result = actorService.insertActor(actor);

        if (result > 0) {
            resp.sendRedirect(req.getContextPath() + "/employee/list");
        } else {
            req.setAttribute("message", "배우 등록에 실패하였습니다.");
            req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
        }

    }
}
