package com.ragtag.X10.controller;

import com.ragtag.X10.model.dto.User;
import com.ragtag.X10.model.service.UserService;
import com.ragtag.X10.util.JwtUtil;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.util.*;

@CrossOrigin(origins = {"*"}, maxAge = 6000)
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    ResourceLoader resLoader;

    @PostMapping("/signup")
    public ResponseEntity<?> signUpUser(@RequestBody User user) {
        int result = userService.signUpUser(user);

        // result 가 0이면 등록 실패, result 가 1이면 등록 성공
        return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> selectAll(@RequestBody User user, HttpSession session) {
        User tempUser = userService.loginUser(user.getUserId());
        // 아이디 없음
        if (tempUser == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        // 비밀번호 불일치
        if (!tempUser.getUserPassword().equals(user.getUserPassword())) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        // 로그인 성공
        User result = userService.userInfo(user.getUserId());
        // 세션에 사용자 정보 저장
        session.setAttribute("loggedInUser", result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

//    @PostMapping("/login")
//    public ResponseEntity<Map<String, Object>> selectAll(@RequestBody User user) {
//        Map<String, Object> result = new HashMap<>();
//
//        // 클라이언트에서 보내온 비밀번호를 해싱
//        String hashedPassword = user.getUserPassword();
//        user.setUserPassword(hashedPassword);
//
//        // 서비스에서 사용자 검증을 수행
//        User loginUserInfo = userService.loginUser(user);
//
//        System.out.println(hashedPassword);
//
//        if (loginUserInfo != null) {
//            // 로그인 성공: JWT 토큰 생성 및 반환
//            try {
//                String token = jwtUtil.createToken("id", loginUserInfo.getUserId());
//                result.put("user", loginUserInfo);
//                result.put("access-token", token);
//                result.put("message", "success");
//                return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
//            } catch (UnsupportedEncodingException e) {
//                result.put("message", "fail");
//                return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
//            }
//        } else {
//            // 로그인 실패
//            result.put("message", "fail");
//            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @PostMapping("/users/logout")
    public ResponseEntity<?> logout(HttpSession session) {
        // 세션에서 사용자 정보 제거
        session.removeAttribute("loggedInUser");

        // 세션을 완전히 무효화
        session.invalidate();

        // 여기에서는 로그아웃 성공을 HttpStatus.OK로 응답
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/read/{userId}")
    public ResponseEntity<?> getUserInfo(@PathVariable("userId") String userId) {
        User user = userService.userInfo(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody User user){
        int result = userService.modifyUser(user);

        if(result == 0)
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/updateProfile/{userId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateInfo(@PathVariable("userId") String userId, @RequestPart(name="file", required = false) MultipartFile file) {
        try {
            User user = userService.userInfo(userId);
            System.out.println(file.getOriginalFilename());

            if (file != null && file.getSize() > 0) {
                Resource res = resLoader.getResource("classpath:/static/upload");
                System.out.println(res.getFile().getCanonicalFile());
                user.setUserImg(System.currentTimeMillis() + "_" + file.getOriginalFilename());
                file.transferTo(new File(res.getFile().getCanonicalFile() + "/" + user.getUserImg()));
            }
            // 나머지 게시글 등록 로직
            int result = userService.modifyUserImg(user);

            if (result == 0)
                return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);

            return new ResponseEntity<>(user, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/leader/{userId}")
    public ResponseEntity<?> isUserLeader(@PathVariable("userId") String userId) {
        boolean result = userService.isLeader(userId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/search/{keyword}")
    public ResponseEntity<List<User>> searchUser(@PathVariable("keyword") String keyword) {
        List<User> result = userService.searchUser(keyword);

        if (result == null || result.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable("userId") String userId) {
        int result = userService.deleteUser(userId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/{userId}/expup/{exp}")
    public ResponseEntity<?> expUp(@PathVariable("userId") String userId, @PathVariable("exp") int exp) {
        int result = userService.updateExp(userId, exp);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
