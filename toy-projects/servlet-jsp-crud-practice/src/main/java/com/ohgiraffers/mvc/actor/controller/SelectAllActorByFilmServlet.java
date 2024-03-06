package com.ohgiraffers.mvc.actor.controller;

import com.ohgiraffers.mvc.actor.model.dto.ActorDTO;
import com.ohgiraffers.mvc.actor.model.service.ActorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/actor/film")
public class SelectAllActorByFilmServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ActorService actorService = new ActorService();
        List<ActorDTO> actorList = actorService.selectAllActorByFilm();

        String path = "";
        if (actorList != null && !actorList.isEmpty()) {
            path = "/WEB-INF/views/actor/actorFilm.jsp";
            req.setAttribute("actorList", actorList);
        } else {
            path = "/WEB-INF/views/common/errorPage.jsp";
            req.setAttribute("message", "베우 전체 목록이 조회 되지 않았습니다.");
        }
        req.getRequestDispatcher(path).forward(req, resp);
    }
}
