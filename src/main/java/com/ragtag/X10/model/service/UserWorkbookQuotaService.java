package com.ragtag.X10.model.service;

import com.ragtag.X10.model.dto.UserWorkbookQuota;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserWorkbookQuotaService {
    // 문제집 할당량 조회
    List<UserWorkbookQuota> readUserWorkbookQuota(int workbookId, String userId);

    // 문제집 할당량 수정
    int updateUserWorkbookQuota(UserWorkbookQuota userWorkbookQuota);

    // 문제집 할당량 삭제
    int deleteUserWorkbookQuota(int workbookId, String userId);

}
