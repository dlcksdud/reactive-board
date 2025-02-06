package com.example.dream.service;

import com.example.dream.mapper.UserMapper;
import com.example.dream.utils.CryptoUtil;
import com.example.dream.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserMapper userMapper;

    public byte[] encryptionKey;
    public UserServiceImpl(){
        encryptionKey = new CryptoUtil().random(16);
    }

    public Map<String, Object> encryptServerIp() throws Exception {
        List<Map<String, String>> userData = userMapper.getUser();
        Map<String, Object> response = new HashMap<>();

        for (Map<String, String> user : userData) {
            String serverIp = user.get("SERVER_IP");
            String num = String.valueOf(user.get("num"));
            // 암호화
            String encryptedIp = new CryptoUtil().encrypt(serverIp, encryptionKey);
            System.out.println("encryptionKey = " + encryptionKey);
            
            // 암호화 된 걸 다시 db에 저장하기
            try{
                int suc = userMapper.updateServerIp(num, encryptedIp);
                if(suc > 0) {
                    response.put("server ip 암호화 결과 : ", "성공");
                } else {
                    response.put("server ip 암호화 결과 : ", "실패");
                }
            } catch (Exception e) {
                response.put("에러로그를 참고하세요. : ", e.toString());
            }
        }
        return response;
    }

    @Override
    public Map<String, Object> decryptServerIp() throws Exception {
        List<Map<String, String>> userData = userMapper.getUser();
        Map<String, Object> response = new HashMap<>();

        for (Map<String, String> user : userData) {
            String serverIp = user.get("SERVER_IP");
            String num = String.valueOf(user.get("num"));
            // 복호화
            String decryptedIp = new CryptoUtil().decrypt(serverIp, encryptionKey);
            System.out.println("encryptionKey = " + encryptionKey);

            // 복호화 된 걸 다시 db에 저장하기
            try{
                int suc = userMapper.updateServerIp(num, decryptedIp);
                if(suc > 0) {
                    response.put("server ip 복호화 결과 : ", "성공");
                } else {
                    response.put("server ip 복호화 결과 : ", "실패");
                }
            } catch (Exception e) {
                response.put("에러로그를 참고하세요. : ", e.toString());
            }
        }
        return response;
    }


    @Override
    public Map<String, Object> getUser() {
        Map<String, Object> response = new HashMap<>();
        try{
            // param이 있을 경우 아직 미개발 ex)num 1~5까지만 조회 기능 등
            List<Map<String, String>> getUserData = userMapper.getUser();
            response.put("userData", getUserData);
        } catch (Exception e) {
            response.put("에러 로그를 확인하세요.", e.toString());
        }
        return response;
    }

    @Override
    public User getOneUser(String num) {
        try{
            return userMapper.getOneUser(num);
        } catch (Exception e) {
            System.out.println(e.toString());
            throw new RuntimeException(e);
        }
    }

    @Override
    public Map<String, Object> getColumn() {
        Map<String, Object> response = new HashMap<>();
        try {
            List<String> getColumn = userMapper.getColumn();
            response.put("getColumn", getColumn);
            System.out.println("getColumn : " + getColumn.toString());
        } catch (Exception e) {
            response.put("에러가 발생했습니다.", e.toString());
            throw new RuntimeException(e);
        }
        return response;
    }


    @Override
    public Map<String, Object> updatePostmanUser(String num, User user) {
        Map<String, Object> response = new HashMap<>();
        int suc = userMapper.updateUser(num, user);

        try{
            if(suc > 0) {
                response.put("update 결과 : ", "성공");
            } else {
                response.put("update 결과 : ", "실패");
            }
        } catch (Exception e) {
            response.put("에러로그를 확인하세요.", e.toString());
        }
        return response;
    }

    @Override
    public Map<String, Object> updateUser(User user) {
        Map<String, Object> response = new HashMap<>();
        int suc = 0;

        if(user != null) {
            suc = userMapper.updateUser(user.getNum(), user);
        } else {
            // 수정할 user가 없을 때
            response.put("수정할 데이터가 없습니다.", "");
        }
        try{
            if(suc > 0) {
                response.put("수정 결과 : ", "성공");
            } else {
                response.put("수정 결과 : ", "실패");
            }
        } catch (Exception e) {
            response.put("에러로그를 확인하세요.", e.toString());
        }
        return response;
    }

    @Override
    public Map<String, Object> deleteUser(int num) {
        Map<String, Object> response = new HashMap<>();
        try {
            int suc = userMapper.deleteUser(num);
            if(suc > 0) {
                response.put("삭제 결과 : ", "성공");
            } else {
                response.put("삭제 결과 : ", "실패");
            }
        } catch (Exception e) {
            response.put("에러로그를 확인하세요.", e.toString());
        }
        return response;
    }

    @Override
    public Map<String, Object> newUser(User user) {
        Map<String, Object> response = new HashMap<>();
        try{
            int suc = userMapper.newUser(user);
            if(suc > 0) {
                response.put("생성 결과 : ", "성공");
            } else {
                response.put("생성 결과 : ", "실패");
            }
        } catch (Exception e) {
            response.put("에러로그를 확인하세요.", e.toString());
        }
        return response;
    }

    @Override
    public Map<String, Object> deleteUserManyNums(List<Integer> nums) {
        Map<String, Object> response = new HashMap<>();
        StringBuilder deleteResults = new StringBuilder(); // 삭제 결과를 누적할 StringBuilder

        for(int element : nums) {
            int suc = userMapper.deleteUser(element);
            if(suc > 0) {
                deleteResults.append("ID " + element + " 삭제 성공\n");
            } else {
                deleteResults.append("ID " + element + " 삭제 실패\n");
            }
        }
        // 삭제 결과를 response 객체에 넣어 JSON 형식으로 반환
        response.put("삭제 결과", deleteResults);

        return response;
    }

}