package com.study.board.service;

import com.study.board.entity.Board;
import com.study.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //이 Service는 컨트롤러에서 이용하면 된다.
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;
    //원래 자바는 new 연산자를 통해 객체를 생성해야하지만 @Autowired를 통해 주입을 해준다.

    //글 작성 처리
    public void write(Board board){
        boardRepository.save(board);
    }


    //게시글 리스트 처리
    public List<Board> boardList(){
        //1. board
        //2. baerkjnaelg
        // 저것들을 주물럭하는거에요 한국어로

        return boardRepository.findAll(); //리스트를 모두 반환
    }

    //특정 게시글 불러오기
    public Board boardView(Integer id){
        return boardRepository.findById(id).get();
    }

    //특정 게시글 삭제
    public void boardDelete(Integer id){
        boardRepository.deleteById(id);
    }
}
