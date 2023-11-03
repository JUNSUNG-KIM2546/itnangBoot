package com.example.itnang.entity;

import com.example.itnang.vo.BoardVO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "board")
public class BoardEntity {
    // jpa ==> database를 객체처럼 사용 가능

    //게시판 ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 오토인크리먼트
    private Long boardId;

    //사용자 ID
    private Long NO;

    //게시물 명
    private String boardSj;

    //게시물 내용
    private String boardCn;

    //조회수
    private int boardCo;

    //등록자 IP
    private String boardIp;

    //공지여부
    private String boardAt;

    //이미지
    private  String boardImg;

    //최초등록시점
    private java.util.Date boardFrst;

    //최종수정시점
    private java.util.Date boardLast;

    public static BoardEntity toBoardEntity(BoardVO boardVO) {
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setBoardId(boardVO.getBoardId());
        boardEntity.setNO(boardVO.getNO());
        boardEntity.setBoardSj(boardVO.getBoardSj());
        boardEntity.setBoardCn(boardVO.getBoardCn());
        boardEntity.setBoardCo(boardVO.getBoardCo());
        boardEntity.setBoardAt(boardVO.getBoardAt());
        boardEntity.setBoardFrst(boardVO.getBoardFrst());
        boardEntity.setBoardLast(boardVO.getBoardLast());
        return boardEntity;
    }

}
