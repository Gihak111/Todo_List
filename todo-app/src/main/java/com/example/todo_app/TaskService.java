package com.example.todo_app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service  // 이 클래스가 서비스 역할을 하는 빈(Bean)임을 나타냄
public class TaskService {

    @Autowired  // TaskRepository 객체를 자동으로 주입
    private TaskRepository taskRepository;

    // 모든 작업을 조회
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // 특정 작업을 ID로 조회
    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    // 새 작업을 저장
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    // 작업을 삭제
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
