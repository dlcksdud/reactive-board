package com.example.dream.service;

import com.example.dream.vo.User;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;

public interface UserService {

    // server ip 암호화 복호화
    Map<String, Object> encryptServerIp() throws Exception;
    Map<String, Object> decryptServerIp() throws Exception;

    Map<String, Object> getUser();

    Map<String, Object> updatePostmanUser(String num, User user);
    Map<String, Object> updateUser(User user);

    Map<String, Object> deleteUser(int num);

    Map<String, Object> newUser(User user);

    Map<String, Object> deleteUserManyNums(List<Integer> nums);

    User getOneUser(String num);

    Map<String, Object> getColumn();
}
