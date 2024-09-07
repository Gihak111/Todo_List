package com.example.todo_app;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service  // 이 클래스가 서비스 역할을 하는 빈(Bean)임을 나타냄
public class AIController {

    private final RestTemplate restTemplate = new RestTemplate();  // HTTP 요청을 보내기 위한 RestTemplate 객체
    private final String FLASK_URL = "http://localhost:5000/predict";  // Flask 서버의 예측 API URL

    // 작업 설명을 사용해 카테고리를 예측하는 메서드
    public String predictCategory(String description) {
        // Flask API로 POST 요청을 보내고, 응답을 문자열로 받음
        ResponseEntity<String> response = restTemplate.postForEntity(FLASK_URL, new CategoryRequest(description), String.class);
        return response.getBody();
    }

    // Flask API에 보낼 요청 데이터 클래스
    private static class CategoryRequest {
        private String description;

        public CategoryRequest(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }
}
