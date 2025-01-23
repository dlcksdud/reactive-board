package com.example.dream.controller;

import com.example.dream.service.UserService;
import com.example.dream.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/postman")
public class UserRestController {

    @Autowired
    public UserService userService;

    // jcaos로 전체 server_ip 복호화 하기
    @PostMapping("/encryptServerIp")
    public ResponseEntity<Map<String, Object>> encryptedServerIp() throws Exception {
        Map<String, Object> encryptedServerIp = userService.encryptServerIp();
        return ResponseEntity.ok(encryptedServerIp);
    }
    
    // jcaos로 전체 server_ip 복호화 하기
    @PostMapping("/decryptServerIp")
    public ResponseEntity<Map<String, Object>> decryptServerIp() throws Exception {
        Map<String, Object> decryptServerIp = userService.decryptServerIp();
        return ResponseEntity.ok(decryptServerIp);
    }

    // 데이터 수정하기
    @PutMapping("/update/{num}")
    public ResponseEntity<Map<String, Object>> updateUser(@PathVariable String num,
                                                          @RequestBody User user) {
        Map<String, Object> response = userService.updatePostmanUser(num, user);
        return ResponseEntity.ok(response);
    }


    // 데이터 삭제하기
    @PostMapping("/delete/{num}")
    public ResponseEntity<Map<String, Object>> deleteUser(@PathVariable int num) {
        Map<String, Object> response = userService.deleteUser(num);
        return ResponseEntity.ok(response);
    }

    // 데이터 생성하기
    @PostMapping("/new")
    public ResponseEntity<Map<String, Object>> newUser(@RequestBody User user) {
        Map<String, Object> response = userService.newUser(user);
        return ResponseEntity.ok(response);
    }
}
