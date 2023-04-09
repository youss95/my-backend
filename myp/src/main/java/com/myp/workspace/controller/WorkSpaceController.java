package com.myp.workspace.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/workspace")
@RequiredArgsConstructor
public class WorkSpaceController {

    /**
     * 유저가 속해 있는 워크스페이스 조회
     */
    @GetMapping("/my")
    public void getWorkspace() {

    }

}
