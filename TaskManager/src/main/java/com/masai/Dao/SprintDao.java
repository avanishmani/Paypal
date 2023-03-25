package com.masai.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Sprint;
@Repository
public interface SprintDao extends JpaRepository<Sprint	, Long> {

}
