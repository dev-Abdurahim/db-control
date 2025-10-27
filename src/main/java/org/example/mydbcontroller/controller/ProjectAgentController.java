package org.example.mydbcontroller.controller;

import lombok.RequiredArgsConstructor;
import org.example.mydbcontroller.dto.projectagent.ProjectAgentCreateDto;
import org.example.mydbcontroller.dto.projectagent.ProjectAgentDto;
import org.example.mydbcontroller.service.ProjectAgentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/agent")
@RequiredArgsConstructor
public class ProjectAgentController {

    private final ProjectAgentService service;
    @PostMapping
    public ResponseEntity<ProjectAgentDto> create(@RequestBody ProjectAgentCreateDto dto) {
        ProjectAgentDto response = service.create(dto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
