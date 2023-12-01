package com.ganeshban.DTO;


import lombok.Data;

@Data
public class ChangePasswordDTO {
    private  long id;
    private String oldPassword;
    private String newPassword;
    private String confirmPassword;
}



