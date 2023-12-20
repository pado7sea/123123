-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema X10
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema X10
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `X10` DEFAULT CHARACTER SET utf8 ;
USE `X10` ;

-- -----------------------------------------------------
-- Table `X10`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `X10`.`User` (
  `userId` VARCHAR(45) NOT NULL,
  `userPassword` VARCHAR(45) NOT NULL,
  `userName` VARCHAR(45) NOT NULL,
  `userNickname` VARCHAR(45) NOT NULL,
  `userEmail` VARCHAR(45) NOT NULL,
  `userImg` VARCHAR(400) NULL,
  `userSolvedQuestion` INT NULL DEFAULT 0,
  `userLevel` INT NULL DEFAULT 0,
  PRIMARY KEY (`userId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `X10`.`Group`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `X10`.`Group` (
  `groupId` INT NOT NULL AUTO_INCREMENT,
  `groupLeaderId` VARCHAR(45) NOT NULL,
  `groupName` VARCHAR(45) NOT NULL,
  `groupDetail` VARCHAR(200) NULL,
  `groupImg` VARCHAR(450) NULL,
  PRIMARY KEY (`groupId`),
  INDEX `fk_Group_User1_idx` (`groupLeaderId` ASC) VISIBLE,
  CONSTRAINT `fk_Group_User1`
    FOREIGN KEY (`groupLeaderId`)
    REFERENCES `X10`.`User` (`userId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `X10`.`Subject`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `X10`.`Subject` (
  `subjectId` INT NOT NULL AUTO_INCREMENT,
  `groupId` INT NOT NULL,
  `subjectTitle` VARCHAR(45) NOT NULL,
  `subjectContent` VARCHAR(450) NOT NULL,
  PRIMARY KEY (`subjectId`, `groupId`),
  CONSTRAINT `fk_Subject_Group1`
    FOREIGN KEY (`groupId`)
    REFERENCES `X10`.`Group` (`groupId`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `X10`.`Workbook`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `X10`.`Workbook` (
  `workbookId` INT NOT NULL AUTO_INCREMENT,
  `subjectId` INT NOT NULL,
  `workbookTitle` VARCHAR(45) NOT NULL,
  `workbookDetail` VARCHAR(200) NOT NULL,
  `workbookDeadline` DATETIME NOT NULL,
  `workbookQuota` INT NOT NULL,
  `workbookDate` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`workbookId`, `subjectId`),
  CONSTRAINT `fk_Workbook_Subject1`
    FOREIGN KEY (`subjectId`)
    REFERENCES `X10`.`Subject` (`groupId`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `X10`.`Question`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `X10`.`Question` (
  `questionId` INT NOT NULL AUTO_INCREMENT,
  `workbookId` INT NOT NULL,
  `questionQ` VARCHAR(100) NOT NULL,
  `questionA` VARCHAR(45) NOT NULL,
  `questionType` INT NOT NULL COMMENT '1 : 객관식\n2 : 단답형\n3 : O/X',
  `questionExplain` TEXT NOT NULL,
  `questionDifficulty` INT NOT NULL COMMENT '1 : 하\n2 : 중\n3 : 상',
  `questionMaker` VARCHAR(45) NOT NULL,
  `questionSave` TINYINT NULL DEFAULT 0 COMMENT '0 : 임시 저장\n1 : 저장\n',
  `questionImg` VARCHAR(450) NULL,
  PRIMARY KEY (`questionId`, `workbookId`),
  INDEX `fk_Quiz_Workbook1_idx` (`workbookId` ASC) VISIBLE,
  CONSTRAINT `fk_Quiz_Workbook1`
    FOREIGN KEY (`workbookId`)
    REFERENCES `X10`.`Workbook` (`workbookId`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `X10`.`GroupMember`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `X10`.`GroupMember` (
  `userId` VARCHAR(45) NOT NULL,
  `groupId` INT NOT NULL,
  `isOnline` TINYINT NULL DEFAULT 0,
  PRIMARY KEY (`userId`, `groupId`),
  INDEX `fk_GroupMember_User1_idx` (`userId` ASC) VISIBLE,
  INDEX `fk_GroupMember_Group1_idx` (`groupId` ASC) VISIBLE,
  CONSTRAINT `fk_GroupMember_User1`
    FOREIGN KEY (`userId`)
    REFERENCES `X10`.`User` (`userId`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_GroupMember_Group1`
    FOREIGN KEY (`groupId`)
    REFERENCES `X10`.`Group` (`groupId`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `X10`.`Notice`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `X10`.`Notice` (
  `noticeId` INT NOT NULL AUTO_INCREMENT,
  `receiverId` VARCHAR(45) NOT NULL,
  `noticeType` INT NOT NULL,
  `noticeTitle` VARCHAR(45) NOT NULL,
  `noticeContent` VARCHAR(200) NOT NULL,
  `noticeCheck` TINYINT NULL DEFAULT 0,
  `noticeDate` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`noticeId`, `receiverId`),
  INDEX `fk_Notice_User1_idx` (`receiverId` ASC) VISIBLE,
  CONSTRAINT `fk_Notice_User1`
    FOREIGN KEY (`receiverId`)
    REFERENCES `X10`.`User` (`userId`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `X10`.`UserWorkbookQuota`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `X10`.`UserWorkbookQuota` (
  `userId` VARCHAR(45) NOT NULL,
  `workbookId` INT NOT NULL,
  `isSubmit` TINYINT NULL DEFAULT 0 COMMENT '0 : 아직 다 안냄\n1 : 다 냄',
  PRIMARY KEY (`userId`, `workbookId`),
  INDEX `fk_User_has_Workbook_Workbook1_idx` (`workbookId` ASC) VISIBLE,
  INDEX `fk_User_has_Workbook_User1_idx` (`userId` ASC) VISIBLE,
  CONSTRAINT `fk_User_has_Workbook_User1`
    FOREIGN KEY (`userId`)
    REFERENCES `X10`.`User` (`userId`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_User_has_Workbook_Workbook1`
    FOREIGN KEY (`workbookId`)
    REFERENCES `X10`.`Workbook` (`workbookId`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `X10`.`MultipleChoice`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `X10`.`MultipleChoice` (
  `multipleChoiceId` INT NOT NULL AUTO_INCREMENT,
  `questionId` INT NOT NULL,
  `choiceContent` VARCHAR(200) NOT NULL,
  `isAnswer` TINYINT NULL DEFAULT 0,
  PRIMARY KEY (`multipleChoiceId`, `questionId`),
  INDEX `fk_MultipleChoice_Question1_idx` (`questionId` ASC) VISIBLE,
  CONSTRAINT `fk_MultipleChoice_Question1`
    FOREIGN KEY (`questionId`)
    REFERENCES `X10`.`Question` (`questionId`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `X10`.`QuizRoom`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `X10`.`QuizRoom` (
  `quizRoomId` INT NOT NULL AUTO_INCREMENT,
  `groupId` INT NOT NULL,
  `quizRoomTitle` VARCHAR(45) NOT NULL,
  `quizRoomWorkbookId` INT NOT NULL,
  `quizRoomTimeLimit` INT NOT NULL,
  `quizRoomSingly` TINYINT NULL DEFAULT 1 COMMENT '0 : 한번에 해설 보기\n1 : 문제별 해설 보기',
  `quizRoomCreator` VARCHAR(45) NULL,
  `quizRoomMaxNum` INT NULL,
  `isStarted` TINYINT NULL DEFAULT 0 COMMENT '0 : 모집 중\n1 : 진행 중',
  PRIMARY KEY (`quizRoomId`, `groupId`),
  INDEX `fk_QuizRoom_Group1_idx` (`groupId` ASC) VISIBLE,
  CONSTRAINT `fk_QuizRoom_Group1`
    FOREIGN KEY (`groupId`)
    REFERENCES `X10`.`Group` (`groupId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `X10`.`UserQuizRoom`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `X10`.`UserQuizRoom` (
  `userQuizRoomId` INT NOT NULL AUTO_INCREMENT,
  `userId` VARCHAR(45) NOT NULL,
  `quizRoomId` INT NOT NULL,
  `startTime` VARCHAR(45) NULL,
  `isReady` TINYINT NULL DEFAULT 0 COMMENT '0 : 준비 중\n1 : 준비 완료',
  PRIMARY KEY (`userQuizRoomId`, `userId`, `quizRoomId`),
  INDEX `fk_table1_QuizRoom1_idx` (`quizRoomId` ASC) VISIBLE,
  INDEX `fk_table1_User1_idx` (`userId` ASC) VISIBLE,
  CONSTRAINT `fk_table1_QuizRoom1`
    FOREIGN KEY (`quizRoomId`)
    REFERENCES `X10`.`QuizRoom` (`quizRoomId`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_table1_User1`
    FOREIGN KEY (`userId`)
    REFERENCES `X10`.`User` (`userId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `X10`.`UserQuestionRecord`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `X10`.`UserQuestionRecord` (
  `questionId` INT NOT NULL,
  `userId` VARCHAR(45) NOT NULL,
  `isCorrect` TINYINT NOT NULL COMMENT '0 : 틀림\n1 : 맞음',
  `recordTime` DATETIME NOT NULL,
  PRIMARY KEY (`questionId`, `userId`),
  INDEX `fk_User_has_Question_Question1_idx` (`questionId` ASC) VISIBLE,
  INDEX `fk_User_has_Question_User1_idx` (`userId` ASC) VISIBLE,
  CONSTRAINT `fk_User_has_Question_User1`
    FOREIGN KEY (`userId`)
    REFERENCES `X10`.`User` (`userId`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_User_has_Question_Question1`
    FOREIGN KEY (`questionId`)
    REFERENCES `X10`.`Question` (`questionId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `X10`.`TodoList`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `X10`.`TodoList` (
  `todoId` INT NOT NULL AUTO_INCREMENT,
  `userId` VARCHAR(45) NOT NULL,
  `todoState` INT NULL DEFAULT 0 COMMENT '0 : 진행 전\n1 : 진행 중\n2 : 완료',
  `todo` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`todoId`, `userId`),
  INDEX `fk_Todo_User1_idx` (`userId` ASC) VISIBLE,
  CONSTRAINT `fk_Todo_User1`
    FOREIGN KEY (`userId`)
    REFERENCES `X10`.`User` (`userId`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
