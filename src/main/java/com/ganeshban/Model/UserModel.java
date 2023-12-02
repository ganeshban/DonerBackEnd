package com.ganeshban.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "tbl_user_information")
@Entity
public class UserModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String password;
    private String address;
    private String dob;
    private String doa;
    private String bloodGrp;
    private Integer gender;

}










