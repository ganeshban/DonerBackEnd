package com.ganeshban.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "tblBloodGroup")
@Entity

public class BloodGroupModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String bloodGroupName;

}
