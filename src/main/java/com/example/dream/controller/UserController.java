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
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class UserController {

    @Autowired
    public UserService userService;

    // 데이터 가져오기
    @RequestMapping(value = "/view/get")
    public String getData(@RequestParam(required = false) Map<String, Object> param, Model model) {
        // 매서드 따로 만들기
        param.put("null", null);
        Map<String, Object> getUserData = userService.getUser(param);
        model.addAttribute("userData", getUserData.get("userData"));
        return "userInfo";
    }

    // 상세페이지, 수정페이지
    @RequestMapping(value = "/details/{num}")
    public String detailOfUser(@PathVariable String num, Model model) {
        System.out.println("num??" + num);
        Map<String, Object> params = new HashMap<>();
        params.put("num", num);
        // User vo로 받는 형태로 변경
        Map<String, Object> detailOfUser = userService.getUser(params);
        System.out.println("detailOfUser = " + detailOfUser.toString());
        model.addAttribute("userDetgail", detailOfUser);
        return "userDetail";
    }

    // 수정 페이지
    @RequestMapping(value = "/updatePage/{num}")
    public String updatePage(@PathVariable String num, Model model) {
        Map<String, Object> params = new HashMap<>();
        params.put("num", num);
        Map<String, Object> detailOfUser = userService.getUser(params);
        model.addAttribute("userDetail", detailOfUser);
        return "userUpdate";
    }

    // 데이터 수정하기
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<Map<String, Object>> updateData(@RequestBody List<User> user) {
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
