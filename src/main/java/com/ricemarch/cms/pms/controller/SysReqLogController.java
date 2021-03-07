package com.ricemarch.cms.pms.controller;


import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author ricemarch
 * @since 2021-03-05
 */
@RestController
@RequestMapping("/api/pms/sys-req-log")
public class SysReqLogController {

    @GetMapping("/hi")
    public String hi() {
        return "hi! cool boy!";
    }

//    @PostMapping("/hip")
//    public String hip(@Validated @RequestBody Test test) {
//        return "hi beautiful boy!";
//    }
}

