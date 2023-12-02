package com.ganeshban.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Table(name = "tblUserInformation")
@Entity
public class UserModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 100)
    @NotBlank(message = "you must provide firstName")
    private String firstName;
    @Column(length = 100)
    private String lastName;
    @NotBlank(message = "you must provide phone")
    @Column(unique = true,length = 50)
    private String phone;
    @Column(unique = true ,length = 50)
    @NotBlank(message = "you must provide email")
    private String email;
    @Column(length = 50)
    @Size(min = 8,max = 50,message = "password must be at least 8 character long.")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]*$",message = "password should contain at least one Capital Letter, one Small Letter and one numeric Character.")
    private String password;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "addressID",referencedColumnName = "id")
    private AddressModel address;
    @Column(length = 10)
    private String dob;
    @Column(length = 10)
    private String doa= LocalDateTime.now().toString();
    @ManyToOne
    @JoinColumn(name = "bloodGroup",referencedColumnName = "id")
    private BloodGroupModel bloodGrp;
    @ManyToOne
    @JoinColumn(name = "gender",referencedColumnName = "id")
    private GenderModel gender;
    private boolean canDonate;

}











