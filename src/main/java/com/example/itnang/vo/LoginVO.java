package com.example.itnang.vo;

import com.example.itnang.entity.LoginEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@ToString
public class LoginVO {

    private Long NO;
    private String ID;
    private String PASS;
    private String NAME;
    private String EMAIL;
    private String PHONE;
    private Date SBSCRBDE;
    private char ADMIN;

    public static LoginVO toBoardVO(LoginEntity loginEntity) {
        LoginVO loginVO = new LoginVO();

        loginVO.setNO(loginEntity.getNO());
        loginVO.setID(loginEntity.getID());
        loginVO.setPASS(loginEntity.getPASS());
        loginVO.setNAME(loginEntity.getNAME());
        loginVO.setEMAIL(loginEntity.getEMAIL());
        loginVO.setPHONE(loginEntity.getPHONE());
        loginVO.setSBSCRBDE(new Date());
        loginVO.setADMIN('n');

        return loginVO;
    }

}
