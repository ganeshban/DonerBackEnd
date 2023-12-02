package com.ganeshban.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "tblAddress")
@Entity
public class AddressModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String lineOne;
    private String lineTwo;
    private String city;
    private String state;
    private String zipCode;
    private String country;

}







