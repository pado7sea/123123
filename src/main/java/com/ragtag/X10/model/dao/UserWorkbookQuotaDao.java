package com.ragtag.X10.model.dao;

import com.ragtag.X10.model.dto.UserWorkbookQuota;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserWorkbookQuotaDao {

    // 문제집 할당량 조회
    List<UserWorkbookQuota> readUserWorkbookQuota(@Param("workbookId") int workbookId, @Param("userId") String userId);

    // 문제집 할당량 수정
    int updateUserWorkbookQuota(UserWorkbookQuota userWorkbookQuota);

    // 문제집 할당량 삭제
    int deleteUserWorkbookQuota(@Param("workbookId") int workbookId, @Param("userId") String userId);

}
