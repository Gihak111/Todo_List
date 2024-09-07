package com.example.todo_app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller  // @RestController 대신 @Controller 사용 (HTML 템플릿을 반환하기 위해)
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private AIController aiController;

    // HTML 페이지로 작업 목록을 보여주는 GET 요청 처리
    @GetMapping
    public String getAllTasks(Model model) {
        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks);  // 모델에 작업 목록을 추가
        return "index";  // index.html 파일을 렌더링
    }

    // 새 작업을 추가하는 POST 요청 처리
    @PostMapping
    public String createTask(@RequestParam String title, @RequestParam String description, @RequestParam(required = false) boolean completed) {
        // AI를 사용해 작업의 카테고리 예측
        String category = aiController.predictCategory(description);
        Task task = new Task(title, description, completed, category);
        taskService.saveTask(task);
        return "redirect:/tasks";  // 작업을 추가한 후 다시 작업 목록 페이지로 리다이렉트
    }
}
