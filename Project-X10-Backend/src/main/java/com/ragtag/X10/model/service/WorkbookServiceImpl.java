package com.ragtag.X10.model.service;

import com.ragtag.X10.model.dao.GroupsDao;
import com.ragtag.X10.model.dao.WorkbookDao;
import com.ragtag.X10.model.dto.GroupMember;
import com.ragtag.X10.model.dto.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class WorkbookServiceImpl implements WorkbookService{
    private final WorkbookDao workbookDao;
    private final GroupsDao groupsDao;

    @Autowired
    public WorkbookServiceImpl(WorkbookDao workbookDao, GroupsDao groupsDao) {
        this.workbookDao = workbookDao;
        this.groupsDao = groupsDao;
    }

    public int createWorkbook(Workbook workbook, int groupId) {
        try{
            int result1 = workbookDao.createWorkbook(workbook);

            if(result1 == 0)
                System.out.println("워크북 추가 실패");

            // 생성한 워크북의 아이디 저장
            int workbookId = workbook.getWorkbookId();

            // 그룹 아이디에 해당하는 유저 아이디 리스트 가져오기
            List<GroupMember> userList = groupsDao.selectAllUsers(groupId);

            // 반복문을 이용해 Dao에 유저 아이디 하나씩 넘겨줘서 Quota 생성
            int result2 = 0;
            for(GroupMember groupMember : userList){
                String userId = groupMember.getUserId();

                Map<String, Object> paramMap = new HashMap<>();
                paramMap.put("userId", userId);
                paramMap.put("workbookId", workbookId);
                workbookDao.createUserWorkbookQuota(paramMap);


                result2++;
            }

            return result1 + result2;

        } catch (Exception e) {
            // 트랜잭션 롤백
            throw new RuntimeException("Error creating workbook and quotas", e);
        }

    }


    public Workbook readWorkbookById(int workbookId) {
        return workbookDao.readWorkbookById(workbookId);
    }

    public List<Workbook> readAllWorkbooksBySubjectId(int subjectId) {
        return workbookDao.readAllWorkbooksBySubjectId(subjectId);
    }

    public List<Workbook> getRecentCreatedWorkbooksByUserId(String userId) {
        return workbookDao.getRecentCreatedWorkbooksByUserId(userId);
    }

    public List<Workbook> getRecentSolvedWorkbooksByUserId(String userId) {
        return workbookDao.getRecentSolvedWorkbooksByUserId(userId);
    }

    public int updateWorkbook(Workbook workbook) {
        return workbookDao.updateWorkbook(workbook);
    }

    public int deleteWorkbook(int workbookId) {
        return workbookDao.deleteWorkbook(workbookId);
    }
}
