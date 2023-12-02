package com.ganeshban.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "tblGender")
@Entity
public class GenderModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String genderName;

}
