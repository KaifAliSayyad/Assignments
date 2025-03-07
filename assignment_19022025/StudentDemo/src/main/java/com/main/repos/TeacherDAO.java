package com.main.repos;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.entities.Teacher;

@Repository
public interface TeacherDAO extends JpaRepository<Teacher, Integer>{

}
