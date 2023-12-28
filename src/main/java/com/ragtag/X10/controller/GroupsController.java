package com.ragtag.X10.controller;

import com.ragtag.X10.model.dto.GroupMember;
import com.ragtag.X10.model.dto.Groups;
import com.ragtag.X10.model.dto.User;
import com.ragtag.X10.model.service.GroupsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@CrossOrigin(origins = {"*"}, maxAge = 6000)
@RestController
@RequestMapping("/groups")
public class GroupsController {

    @Autowired
    private GroupsService groupsService;

    @Autowired
    ResourceLoader resLoader;

    // 그룹 생성
    @PostMapping("/create")
    public ResponseEntity<?> newGroup(@RequestBody Groups groups) {
        int groupId = groupsService.insertGroups(groups);

        if (groupId == 0)
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(groupId, HttpStatus.OK);
    }

    // 그룹 상세정보 조회
    @GetMapping("read/{groupId}")
    public ResponseEntity<?> selectOne(@PathVariable("groupId") int groupId) {
        Groups groups = groupsService.selectOne(groupId);

        if (groups == null)
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(groups, HttpStatus.OK);
    }

    // 유저 가입 그룹 전체 조회
    @GetMapping("readAll/{userId}")
    public ResponseEntity<?> selectUserGroups(@PathVariable("userId") String userId) {
        List<Groups> groups = groupsService.selectUserGroups(userId);

        if (groups == null || groups.isEmpty())
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(groups, HttpStatus.OK);
    }

    // 그룹 내 유저 전체 조회
    @GetMapping("readAllMember/{groupId}")
    public ResponseEntity<?> selectAllUsers(@PathVariable("groupId") int groupId) {
        List<User> users = groupsService.selectAllUsersInfo(groupId);

        if (users == null || users.isEmpty())
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // 그룹 수정
    @PutMapping("/update")
    public ResponseEntity<?> updateGroups(@RequestBody Groups groups) {
        int result = groupsService.updateGroups(groups);
        if (result == 0)
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/updateProfile/{groupId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateInfo(@PathVariable("groupId") int groupId, @RequestPart(name="groupImg", required = false) MultipartFile file) {
        try {
            Groups group = groupsService.selectOne(groupId);

            if (file != null && file.getSize() > 0) {
                Resource res = resLoader.getResource("classpath:/static/upload");
                System.out.println(res.getFile().getCanonicalFile());
                group.setGroupImg(System.currentTimeMillis() + "_" + file.getOriginalFilename());
                file.transferTo(new File(res.getFile().getCanonicalFile() + "/" + group.getGroupImg()));
            }
            // 나머지 게시글 등록 로직
            int result = groupsService.updateGroupsImg(group);

            if (result == 0)
                return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);

            return new ResponseEntity<>(group, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 그룹 삭제
    @DeleteMapping("/delete/{groupId}")
    public ResponseEntity<?> deleteGroups(@PathVariable("groupId") int groupId) {
        int result = groupsService.deleteGroups(groupId);
        if (result == 0)
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // 그룹원 초대
    @PostMapping("{groupId}/invite/{userId}")
    public ResponseEntity<?> inviteUser(@PathVariable("groupId") int groupId, @PathVariable("userId") String userId) {
        int result = groupsService.inviteUser(groupId, userId);

        if (result == 0)
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // 그룹원 탈퇴
    @DeleteMapping("{groupId}/delete/{userId}")
    public ResponseEntity<?> quitGroup(@PathVariable("groupId") int groupId, @PathVariable("userId") String userId) {
        int result = groupsService.quitGroup(groupId, userId);

        if (result == 0)
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
