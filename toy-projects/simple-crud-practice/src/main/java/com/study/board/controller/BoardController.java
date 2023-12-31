package com.study.board.controller;

import com.study.board.entity.Board;
import com.study.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller //컨트롤러로 설정
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/board/write") //localhost:8080/board/write로 매핑
    public String boardWriteForm(){
        return "boardwrite";
    } //boardwrite html 파일을 불러온다

    @PostMapping("/board/writepro")
    public String boardWritePro(Board board){
    //public String boardWritePro(String title, String content){
    // html의 name 중 title과 content를 파라미터 값으로 받는다.
    // 하지만 파라머티가 많아지면 복잡해지기 때문에 Board 클래스이 entity 형태를 그대로 받아올 수 있다.

        boardService.write(board);
        return "redirect:/board/list";
    }

    @GetMapping("/board/list")
    public String boardList(Model model){
        model.addAttribute("list", boardService.boardList());
        return "boardlist";
    }

    @GetMapping("/board/view") //localhost:8080/board/view?id=1 여기의 1이 아래 메소드 파라미터로 전달
    public String boardView(Model model, Integer id){

        model.addAttribute("board", boardService.boardView(id));
        return "boardview";
    }

    @GetMapping("board/delete")
    public String boardDelete(Integer id){
        boardService.boardDelete(id); //넘어온 id 값을 받아서 삭제처리
        return "redirect:/board/list";
    }

    @GetMapping("/board/modify/{id}")
    public String boardModify(@PathVariable("id") Integer id,
                                Model model){
        model.addAttribute("board", boardService.boardView(id));
        //pathvariable은 modify 뒤 /{id} 부분을 인식해 파라미터로 넘겨줌
        return "boardmodify";
    }

    @PostMapping("/board/update/{id}")
    public String boardUpdate(@PathVariable("id") Integer id, Board board){
        Board boardTemp = boardService.boardView(id);
        boardTemp.setTitle(board.getTitle());
        boardTemp.setContent(board.getContent());

        boardService.write(boardTemp);

        return "redirect:/board/list";
    }
}

