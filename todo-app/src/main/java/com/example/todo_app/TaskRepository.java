package com.example.todo_app;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
    // JpaRepository를 상속받아 Task 엔티티의 기본적인 CRUD 메서드를 제공함
}
