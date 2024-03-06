package com.ohgiraffers.mvc.actor.controller;

import com.ohgiraffers.mvc.actor.model.dto.ActorDTO;
import com.ohgiraffers.mvc.actor.model.service.ActorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/actor/select")
public class SelectOneActorByIdServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String actorId = req.getParameter("actorId");

        ActorService actorService = new ActorService();
        ActorDTO selectedActor = actorService.selectOneActorById(actorId);

        String path = "";
        if (selectedActor != null) {
            path = "/WEB-INF/views/actor/showActorInfo.jsp";
            req.setAttribute("selectedActor", selectedActor);
        } else {
            path = "/WEB-INF/views/common/errorPage.jsp";
            req.setAttribute("message", "해당 아이디를 가진 배우는 없습니다.");
        }
        req.getRequestDispatcher(path).forward(req, resp);
    }
}
