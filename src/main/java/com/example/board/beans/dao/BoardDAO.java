package com.example.board.beans.dao;

import com.example.board.beans.vo.BoardVO;
import com.example.board.mappers.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

//원격에서 수정함
@Repository
@RequiredArgsConstructor
public class BoardDAO {
//    @Autowired
    private final BoardMapper mapper;
//    private BoardMapper mapper;

    public void register(BoardVO vo){
        mapper.insertSelectKey_bno(vo);
    }

    public BoardVO get(Long bno){
        return mapper.read(bno);
    }

    public boolean modify(BoardVO board){
        return mapper.update(board) == 1;
    }

    public boolean remove(Long bno){
        return mapper.delete(bno) == 1;
    }

    public List<BoardVO> getList(){
        return mapper.getList();
    }

}
