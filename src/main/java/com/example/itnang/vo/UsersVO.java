package com.example.itnang.vo;

import com.example.itnang.entity.UsersEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@ToString
public class UsersVO {

    private Long NO;
    private String ID;
    private String PASS;
    private String NAME;
    private String EMAIL;
    private String PHONE;
    private Date SBSCRBDE;
    private char ADMIN;

    public static UsersVO toBoardVO(UsersEntity usersEntity) {
        UsersVO usersVO = new UsersVO();

        usersVO.setNO(usersEntity.getNO());
        usersVO.setID(usersEntity.getID());
        usersVO.setPASS(usersEntity.getPASS());
        usersVO.setNAME(usersEntity.getNAME());
        usersVO.setEMAIL(usersEntity.getEMAIL());
        usersVO.setPHONE(usersEntity.getPHONE());
        usersVO.setSBSCRBDE(usersEntity.getSBSCRBDE());
        //userVO.setADMIN(usersEntity.getADMIN());

        return usersVO;
    }

}
