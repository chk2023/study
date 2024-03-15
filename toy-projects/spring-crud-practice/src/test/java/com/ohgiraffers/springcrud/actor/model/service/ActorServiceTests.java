package com.ohgiraffers.springcrud.actor.model.service;

import com.ohgiraffers.springcrud.actor.model.dto.ActorDTO;
import com.ohgiraffers.springcrud.configuration.SpringCrudPracticeApplication;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(classes = { SpringCrudPracticeApplication.class })
public class ActorServiceTests {
    @Autowired
    private ActorService actorService;

    @Test
    public void 서비스_의존성_주입_테스트() {
        assertNotNull(actorService);
    }

    @Test
    public void 배우_전체_조회_테스트() {
        List<ActorDTO> actorList = actorService.findAllActor();
        assertNotNull(actorList);
    }

    @Test
    @DisplayName("배우가 새로 등록되는지 서비스 클래스 확인")
    @Transactional
    public void testRegistActor() {
        //given
        ActorDTO actor = new ActorDTO();
        actor.setFirstName("형기");
        actor.setLastName("조");

        //when & then
        assertDoesNotThrow(() -> actorService.registActor(actor));
    }

    @Test
    @DisplayName("배우 등록 실패 테스트")
    @Transactional
    public void failTestRegistActor() {
        //given
        ActorDTO actor = new ActorDTO();
        actor.setFirstName("기기기기기기기기기기" +
                "기기기기기기기기기기" +
                "기기기기기기기기기기" +
                "기기기기기기기기기기" +
                "기기기기기기기기기기" +
                "기기기기기");
        actor.setLastName("조조조조조조조조조조" +
                "조조조조조조조조조조" +
                "조조조조조조조조조조" +
                "조조조조조조조조조조" +
                "조조조조조조조조조조" +
                "조조조조조");

        //when & then
        assertThrows(Exception.class, () -> actorService.registActor(actor));
    }



}
