package org.example.mydbcontroller.controller;

import org.example.mydbcontroller.dto.projectdatabase.ProjectDatabaseCreateDto;
import org.example.mydbcontroller.dto.projectdatabase.ProjectDatabaseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/project-database")
public class ProjectDatabaseController {

    @GetMapping("/test")
    public String test(){
        return "Hello world";
    }
    public ResponseEntity<ProjectDatabaseDto> create(ProjectDatabaseCreateDto dto) {
        return null;
    }
}
