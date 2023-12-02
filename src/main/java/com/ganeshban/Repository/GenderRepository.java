package com.ganeshban.Repository;

import com.ganeshban.Model.BloodGroupModel;
import com.ganeshban.Model.GenderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenderRepository extends JpaRepository<GenderModel, Long> {
}

