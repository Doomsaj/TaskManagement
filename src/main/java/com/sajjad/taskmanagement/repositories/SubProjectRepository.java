package com.sajjad.taskmanagement.repositories;

import com.sajjad.taskmanagement.entities.SubProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubProjectRepository extends JpaRepository<SubProject, Integer> {
}