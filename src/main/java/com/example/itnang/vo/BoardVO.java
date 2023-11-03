package com.example.itnang.vo;

import com.example.itnang.entity.BoardEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;


@Getter
@Setter
@NoArgsConstructor
@ToString
public class BoardVO {

    //게시판 ID
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

    public static BoardVO toBoardVO(BoardEntity boardEntity) {
        BoardVO boardVO = new BoardVO();
        boardVO.setBoardId(boardEntity.getBoardId());
        boardVO.setNO(boardEntity.getNO());
        boardVO.setBoardSj(boardEntity.getBoardSj());
        boardVO.setBoardCn(boardEntity.getBoardCn());
        boardVO.setBoardCo(boardEntity.getBoardCo());
        boardVO.setBoardAt(boardEntity.getBoardAt());
        boardVO.setBoardFrst(boardEntity.getBoardFrst());
        boardVO.setBoardLast(boardEntity.getBoardLast());
        return boardVO;
    }

}
