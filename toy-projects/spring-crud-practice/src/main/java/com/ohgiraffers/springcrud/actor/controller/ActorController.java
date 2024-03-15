package com.ohgiraffers.springcrud.actor.controller;

import com.ohgiraffers.springcrud.actor.model.dto.ActorDTO;
import com.ohgiraffers.springcrud.actor.model.service.ActorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/actor")
public class ActorController {

    private static final Logger logger = LoggerFactory.getLogger(ActorController.class);

    private final ActorService actorService;

    @Autowired
    public ActorController (ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping("/list")
    public String actorList(Model model) {
        List<ActorDTO> actorList = actorService.findAllActor();

        model.addAttribute("actorList", actorList);

        return "actor/list";
    }

    @GetMapping("/regist")
    public void registPage() {}

    @PostMapping("/regist")
    public String registActor(@ModelAttribute ActorDTO actor) {
        actorService.registActor(actor);
        return "redirect:/actor/list";
    }


}
