package com.jb.taas.repos;

import com.jb.taas.beans.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;


@Repository
public interface TaskRepository extends JpaRepository<Task,Integer> {

    List<Task> findByOrderByWhenAsc();
    List<Task> findByOrderByWhenDesc();
    List<Task> findByWhenBetween(Timestamp start, Timestamp end);

    List<Task> findByUserId(int userId);
}