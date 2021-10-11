package com.example.board.services;

import com.example.board.beans.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.event.TransactionalEventListener;

@SpringBootTest
@Slf4j
public class BoardServiceTest {

    @Autowired
    private BoardService boardService;

    @Test
    public void testRegiter(){
        BoardVO board = new BoardVO();
        board.setTitle("수정된 글");
        board.setContent("수정된 글 내용");
        board.setWriter("user04");
        boardService.register(board);
        log.info("----------------------------------");
        log.info(board.getBno() + "");
        log.info("----------------------------------");
    }

    @Test
    public void testGet(){
        log.info(boardService.get(9L).toString());
    }

    @Test
    public void testModify(){
        BoardVO board = new BoardVO();
        board.setBno(9L);
        board.setTitle("수정된 글121212");
        board.setContent("수정된 글 내용");
        log.info("UPDATE : " + boardService.modify(board));
    }

    @Test
    public void testRemove(){
        log.info("DELETE : " + boardService.remove(9L));
    }

    @Test
    public void testGetList(){
        boardService.getList().forEach(board -> log.info(board.toString()));
    }















}
