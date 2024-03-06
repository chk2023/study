package com.ohgiraffers.mvc.actor.controller;

import com.ohgiraffers.mvc.actor.model.service.ActorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/actor/delete")
public class DeleteActorServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String actorId = req.getParameter("actorId");

        ActorService actorService = new ActorService();
        int result = actorService.deleteActor(actorId);

        if (result > 0) {
            resp.sendRedirect(req.getContextPath()+"/actor/list");
        } else {
            req.setAttribute("message", "직원 정보 삭제에 실패하였습니다.");
            req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
        }
    }
}
