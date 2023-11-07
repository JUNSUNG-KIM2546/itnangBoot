package com.example.itnang.entity;

import com.example.itnang.vo.LoginVO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Setter
@Getter
@Table(name = "users")
public class LoginEntity {
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

    public static LoginEntity toUsersEntity(LoginVO loginVO) {
        LoginEntity loginEntity = new LoginEntity();

        loginEntity.setNO(loginVO.getNO());
        loginEntity.setID(loginVO.getID());
        loginEntity.setPASS(loginVO.getPASS());
        loginEntity.setNAME(loginVO.getNAME());
        loginEntity.setEMAIL(loginVO.getEMAIL());
        loginEntity.setPHONE(loginVO.getPHONE());
        loginEntity.setSBSCRBDE(new Date());
        loginEntity.setADMIN('n');
        return loginEntity;
    }

}
