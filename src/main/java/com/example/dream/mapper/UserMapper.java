package com.example.dream.mapper;

import com.example.dream.vo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {


    List<Map<String, String>> getUser(Map<String, Object> param);

    int updateUser(String num, User user);

    int deleteUser(int num);

    int newUser(User user);

    int updateServerIp(String num, String encryptedIp);

//    List<Map<String, String>> getUserNoParam();
}
