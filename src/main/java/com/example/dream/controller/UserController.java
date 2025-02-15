package com.example.dream.controller;

import com.example.dream.service.UserService;
import com.example.dream.vo.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    public UserService userService;

    // 데이터 가져오기
    @RequestMapping(value = "/view/get")
    public String getData(Model model) {
        // 매서드 따로 만들기
        Map<String, Object> getUserData = userService.getUser();
        model.addAttribute("userData", getUserData.get("userData"));
        return "userInfo";
    }

    @RequestMapping(value = "/getUserInfo")
    public ResponseEntity<Map<String, Object>> getData() {
        // 매서드 따로 만들기
        Map<String, Object> getUserData = userService.getUser();
        System.out.println("getUserData : " + getUserData);
        return ResponseEntity.ok(getUserData);
    }

    
    // 컬럼만 가져오기
    @RequestMapping(value = "getColumn")
    public ResponseEntity<Map<String, Object>> getColumn() {
        Map<String, Object> getColumn = userService.getColumn();
        return ResponseEntity.ok(getColumn);
    }

    // 상세페이지, 수정페이지
    @RequestMapping(value = "/getOneUser/{num}")
    public String detailOfUser(@PathVariable String num, Model model) {
        // User vo로 받는 형태로 변경
        User user  = userService.getOneUser(num);
        System.out.println("One User = " + user.toString());
        model.addAttribute("user", user);
        return "userDetail";
    }

    // 데이터 수정하기
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<Map<String, Object>> updateData(@RequestBody User user) {
        System.out.println("User = " + user.toString());
        Map<String, Object> updateData = userService.updateUser(user);
        return ResponseEntity.ok(updateData);
    }


    // 데이터 삭제하기
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> deleteUser(@RequestBody List<Integer> nums) {
        Map<String, Object> response = userService.deleteUserManyNums(nums);
        return ResponseEntity.ok(response);
    }

    // 데이터 생성하기 페이지
    @RequestMapping(value = "/userCreatePage")
    public String userCreatePage() {
        return "userCreate";
    }

    // 데이터 생성하기
    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> newUser(@RequestBody User user) {
        Map<String, Object> response = userService.newUser(user);
        return ResponseEntity.ok(response);
    }
}
