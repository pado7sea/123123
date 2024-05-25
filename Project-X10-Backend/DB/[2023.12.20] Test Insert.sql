

-- Insert sample data into User table
INSERT INTO `X10`.`User` (`userId`, `userPassword`, `userName`, `userNickname`, `userEmail`, `userImg`, `userSolvedQuestion`, `userLevel`) VALUES
('leader123', 'password', '리더1', '닉네임리더123', 'leader1@example.com', '이미지1.jpg', 100, 1),
('leader456', 'password', '리더2', '닉네임리더456', 'leader2@example.com', '이미지2.jpg', 215, 2),
('person1', 'password1', '팀원1', '닉네임111', 'person1@example.com', '이미지1.jpg', 100, 1),
('person2', 'password2', '팀원2', '닉네임222', 'person2@example.com', '이미지2.jpg', 215, 2),
('person3', 'password3', '팀원3', '닉네임333', 'person3@example.com', '이미지1.jpg', 100, 1),
('person4', 'password4', '팀원4', '닉네임444', 'person4@example.com', '이미지2.jpg', 215, 2),
('person5', 'password5', '팀원5', '닉네임555', 'person5@example.com', '이미지2.jpg', 215, 2),
('person6', 'password6', '팀원6', '닉네임666', 'person6@example.com', '이미지2.jpg', 215, 2);


-- Insert sample data into Group table
INSERT INTO `X10`.`Group` (`groupLeaderId`, `groupName`, `groupDetail`) VALUES
('leader123', '그룹 1', '그룹 1에 대한 설명'),
('leader456', '그룹 2', '그룹 2에 대한 설명');

INSERT INTO `X10`.`GroupMember` (`userId`, `groupId`, `isOnline`) VALUES 
('leader123', 1, 0),
('leader456', 2, 0),
('person1', 1, 0),
('person2', 1, 0),
('person3', 1, 0),
('person4', 2, 0),
('person5', 2, 0),
('person6', 2, 0);


-- Insert sample data into Subject table
INSERT INTO `X10`.`Subject` (`groupId`, `subjectTitle`, `subjectContent`) VALUES
(1, '그룹 1 - 과목 1', '그룹 1의 첫 번째 과목에 대한 설명'),
(1, '그룹 1 - 과목 2', '그룹 1의 두 번째 과목에 대한 설명'),
(2, '그룹 2 - 과목 1', '그룹 2의 첫 번째 과목에 대한 설명');

-- Insert sample data into Workbook table
INSERT INTO `X10`.`Workbook` (`workbookId`, `subjectId`, `workbookTitle`, `workbookDetail`, `workbookDeadline`, `workbookQuota`, `workbookDate`) VALUES
(1, 1, '과목 1 - 문제집 1', '과목 1의 첫 번째 문제집에 대한 설명', '2023-12-31 23:59:59', 50, '2023-01-01 12:00:00'),
(2, 1, '과목 1 - 문제집 2', '과목 1의 두 번째 문제집에 대한 설명', '2023-12-31 23:59:59', 50, '2023-01-02 12:00:00'),
(3, 2, '과목 2 - 문제집 1', '과목 2의 첫 번째 문제집에 대한 설명', '2023-12-31 23:59:59', 50, '2023-01-03 12:00:00');

-- Insert sample data into Question table
INSERT INTO `X10`.`Question` (`questionId`, `workbookId`, `questionQ`, `questionA`, `questionType`, `questionExplain`, `questionDifficulty`, `questionMaker`, `questionSave`, `questionImg`) VALUES
(1, 1, '1 + 1은?', '2', 2, '간단한 덧셈 문제입니다.', 1, 'leader123', 1, NULL),
(2, 1, '2 - 1은?', '1', 2, '간단한 뺄셈 문제입니다.', 1, 'leader123', 1, NULL),
(3, 2, '3 * 4는?', '12', 2, '간단한 곱셈 문제입니다.', 2, 'leader123', 1, NULL),
(4, 2, '10 / 2는?', '5', 2, '간단한 나눗셈 문제입니다.', 2, 'leader123', 1, NULL),
(5, 3, '한국의 수도는?', '서울', 2, '국가와 수도를 매칭하는 문제입니다.', 1, 'leader456', 1, NULL),
(6, 3, '세계에서 가장 큰 대륙은?', '아시아', 2, '지리에 관한 문제입니다.', 3, 'leader456', 0, NULL);

-- 예시 데이터 삽입
INSERT INTO `X10`.`UserQuestionRecord` (`questionId`, `userId`, `isCorrect`, `recordTime`)
VALUES
  (4, 'leader123', 1, '2023-01-01 10:30:00'),
  (2, 'leader123', 0, '2023-01-02 15:45:00'),
  (4, 'person1', 1, '2023-01-03 09:20:00'),
  (3, 'person2', 1, '2023-01-04 14:10:00'),
  (2, 'person3', 0, '2023-01-05 11:00:00');


-- 객관식 문제 테스트
-- Insert sample data into Question table
INSERT INTO `X10`.`Question` (`questionId`, `workbookId`, `questionQ`, `questionA`, `questionType`, `questionExplain`, `questionDifficulty`, `questionMaker`, `questionSave`, `questionImg`) VALUES
(7, 1, '2 곱하기 3은?(객관식)', '0', 1, '2 X 3 = 6', 1, 'leader123', 1, NULL);

INSERT INTO `X10`.`MultipleChoice` (`multipleChoiceId`, `questionId`, `choiceContent`, `isAnswer`) VALUES 
(1, 7, '6', 1),
(2, 7, '5', 0),
(3, 7, '4', 0),
(4, 7, '3', 0),
(5, 7, '2', 0);


select * from user;

select * from groupmember;

SELECT * FROM `Group`;

select * from subject;

select * from workbook;

select * from question;

select * from  UserQuestionRecord;


