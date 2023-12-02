package com.ganeshban.Repository;

import com.ganeshban.Model.BloodGroupModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BloodGroupRepository extends JpaRepository<BloodGroupModel, Long> {
}
