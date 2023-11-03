package com.example.itnang.entity;

import com.example.itnang.vo.UsersVO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Setter
@Getter
@Table(name = "users")
public class UsersEntity {
    // jpa ==> database를 객체처럼 사용 가능

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 오토인크리먼트
    private Long NO;

    @Column(unique = true)
    private String ID;

    @Column
    private String PASS;

    @Column
    private String NAME;

    @Column
    private String EMAIL;

    @Column
    private String PHONE;

    @Column
    private Date SBSCRBDE;

    @Column
    private char ADMIN;

    public static UsersEntity toUsersEntity(UsersVO usersVO) {
        UsersEntity usersEntity = new UsersEntity();

        usersEntity.setNO(usersVO.getNO());
        usersEntity.setID(usersVO.getID());
        usersEntity.setPASS(usersVO.getPASS());
        usersEntity.setNAME(usersVO.getNAME());
        usersEntity.setEMAIL(usersVO.getEMAIL());
        usersEntity.setPHONE(usersVO.getPHONE());
        usersEntity.setSBSCRBDE(usersVO.getSBSCRBDE());
        //userEntity.setBoardLast(usersVO.getBoardLast());
        return usersEntity;
    }

}
