package com.masai.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Task;
@Repository
public interface TaskDao extends JpaRepository<Task	, Long> {

}
