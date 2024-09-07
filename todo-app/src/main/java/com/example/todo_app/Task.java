package com.example.todo_app;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity  // 이 클래스가 데이터베이스 테이블과 매핑된다는 것을 나타냄
public class Task {

    @Id  // 이 필드가 기본 키임을 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // 기본 키가 자동으로 생성됨
    private Long id;
    private String title;  // 작업 제목
    private String description;  // 작업 설명
    private boolean completed;  // 작업 완료 여부
    private String category;  // AI가 예측한 작업 카테고리

    // 기본 생성자 (JPA는 매개변수가 없는 생성자가 필요함)
    public Task() {}

    // 생성자: 객체를 생성할 때 값을 설정할 수 있음
    public Task(String title, String description, boolean completed, String category) {
        this.title = title;
        this.description = description;
        this.completed = completed;
        this.category = category;
    }

    // Getter와 Setter: 각 필드의 값을 읽고 쓸 수 있도록 함
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
