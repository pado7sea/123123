package com.ragtag.X10.controller;

import com.ragtag.X10.model.dto.QuizRoom;
import com.ragtag.X10.model.dto.User;
import com.ragtag.X10.model.dto.UserQuizRoom;
import com.ragtag.X10.model.service.QuizRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"}, maxAge = 6000)
@RestController
@RequestMapping("")
public class QuizRoomController {

    @Autowired
    private QuizRoomService quizRoomService;

    @PostMapping("/quizroom/create")
    public ResponseEntity<?> newQuizRoom(@RequestBody QuizRoom quizRoom) {
        int result = quizRoomService.createRoom(quizRoom);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("/quizroom/detail/{quizRoomId}")
    public ResponseEntity<?> detailQuizRoom(@PathVariable("quizRoomId") int quizRoomId) {
        QuizRoom result = quizRoomService.detail(quizRoomId);
        if (result == null)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/quizroom/readAll/{groupId}")
    public ResponseEntity<?> groupsAllRoom(@PathVariable("groupId") int groupId) {
        List<QuizRoom> result = quizRoomService.searchRoom(groupId);
        if (result == null || result.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/quizroom/update")
    public ResponseEntity<?> updateMode(@RequestBody QuizRoom quizRoom) {
        int result = quizRoomService.changeMode(quizRoom);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/quizroom/delete/{quizRoomId}")
    public ResponseEntity<?> deleteQuizRoom(@PathVariable("quizRoomId") int quizRoomId) {
        // 인원이 한 명일 때 삭제
        // 이거는 프론트에서 확인해서 방 인원이 1명일 때, 이 API로 보내주면 될 듯
        int result = quizRoomService.deleteQuizRoom(quizRoomId);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    //UserQuizRoom 관련
    @PostMapping("/userquizroom/enter")
    public ResponseEntity<?> enterQuizRoom(@RequestBody UserQuizRoom userQuizRoom) {
        int result = quizRoomService.enterRoom(userQuizRoom);

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/userquizroom/isReady/{userId}")
    public ResponseEntity<?> changeReadyState(@PathVariable("userId") String userId) {
        int result = quizRoomService.userReady(userId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/userquizroom/setStartTime/{quizRoomId}")
    public ResponseEntity<?> setStartTime(@PathVariable("quizRoomId") int quizRoomId) {
        quizRoomService.startQuiz(quizRoomId);
        int result = quizRoomService.setStartTime(quizRoomId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/userquizroom/getStartTime/{userId}")
    public ResponseEntity<?> getStartTime(@PathVariable("userId") String userId) {
        String startTime = quizRoomService.getStartTime(userId);
        return new ResponseEntity<>(startTime, HttpStatus.OK);
    }

    @GetMapping("/userquizroom/userAll/{quizRoomId}")
    public ResponseEntity<?> allUserInTheRoom(@PathVariable("quizRoomId") int quizRoomId) {
        List<User> userList = quizRoomService.roomAllUser(quizRoomId);
        if (userList == null || userList.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @DeleteMapping("userquizroom/{quizRoomId}/delete/{userId}")
    public ResponseEntity<?> exitRoom(@PathVariable("quizRoomId") int quizRoomId, @PathVariable("userId") String userId) {
        //quizroom 정보를 우선 가져온 뒤
        QuizRoom quizRoom = quizRoomService.detail(quizRoomId);

        //경로를 통해 들어 온 userId가 방장인 경우 우선 방장 위임
        if (quizRoom.getQuizRoomCreator().equals(userId))
            quizRoomService.changeCreator(quizRoom);

        //이제 나가자
        int result = quizRoomService.exitRoom(userId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
