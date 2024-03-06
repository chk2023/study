package com.ohgiraffers.mvc.actor.controller;

import com.ohgiraffers.mvc.actor.model.dto.ActorDTO;
import com.ohgiraffers.mvc.actor.model.service.ActorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/actor/update")
public class UpdateActorServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String actorId = req.getParameter("actorId");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");

        ActorDTO actorDTO = new ActorDTO();
        actorDTO.setActorId(actorId);
        actorDTO.setFirstName(firstName);
        actorDTO.setLastName(lastName);

        ActorService actorService = new ActorService();
        int result = actorService.updateActor(actorDTO);

        if (result > 0) {
            resp.sendRedirect(req.getContextPath() + "/actor/select?actorId="+actorId);
        } else {
            req.setAttribute("message", "직원 정보 수정에 실패하였습니다.");
            req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
        }
    }
}
