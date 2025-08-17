/*
    DML (Data Manipulation Language)
    : 데이터 조작 언어로 테이블에 값을 삽입(INSERT)하거나, 수정(UPDATE)하거나,
      삭제(DELETE)하는 기능
      
    INSERT
     - 테이블에 새로운 행(데이터)를 추가하는 구문
     
    INSERT INTO 테이블명 VALUSES(값, 값, ...);
     - 테이블에 모든 컬럼에 대한 값을 INSERT 하고자 할 때 사용
       컬럼 순번을 지켜서 VALUSES 값을 나열해야 함
    INSERT INTO 테이블명(컬럼, 컬럼, ...) VALUSES(값, 값, ...);
     - 테이블의 특정 컬럼에 대한 값만 INSERT하고자 할 때 사용
       선택 안된 컬럼들은 기본적으로 NULL값이 들어감
       기본값(DEFAULT)이 지정되어 있으면 기본값이 들어감
    INSERT INTO 테이블명(서브쿼리);
     - VALUES 대신 서브쿼리로 조회한 결과값을 통째로 INSERT
     - 서브쿼리 결과값이 INSERT문에 지정된 테이블 컬럼의 개수와 데이터 타입이 같아야 함
*/

CREATE TABLE EMP_01(
EMP_ID NUMBER PRIMARY KEY, 
EMP_NAME VARCHAR2(30) NOT NULL,
DEPT_TITLE VARCHAR2(30),
HIRE_DATE DATE DEFAULT SYSDATE
);

SELECT * FROM EMP_01;

INSERT INTO EMP_01 
VALUES(100, '이승민', '서비스 개발팀', DEFAULT);

INSERT INTO EMP_01
VALUES(2OO, '박기민', '개발 지원팀');
--모든 컬럼 값을 지정하지 않아서 에러

INSERT INTO EMP_01
VALUES(300, '디자인팀', '성예찬', SYSDATE);
-- 에러는 발생하지 않지만 데이터가 잘못 저장, 운으로 데이터 타입은 맞음

INSERT INTO EMP_01
VALUES('기획팀', 400, '이상엽', DEFAULT);
--컬럼 순서와 데이터 타입 둘다 모두 맞지 않아서 에러

INSERT INTO EMP_01(EMP_ID, EMP_NAME, DEPT_TITLE, HIRE_DATE)
VALUES(500, '조규상', '마케팅팀', NULL);

INSERT INTO EMP_01(EMP_NAME, EMP_ID, DEPT_TITLE)
VALUES('최다인', 600, '인사팀');

INSERT INTO EMP_01(EMP_ID, DEPT_TITLE)
VALUES(700, '보안팀');
--EMP_NAME에 NOT NULL 조건 걸려있기때문에 에러

--서브쿼리
INSERT INTO EMP_01(
  SELECT EMP_ID, EMP_NAME, DEPT_TITLE, HIRE_DATE
  FROM EMPLOYEE
  JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
);
--순서랑 개수만 주의 
SELECT * FROM EMP_01;
SELECT * FROM DEPARTMENT;
SELECT * FROM EMPLOYEE;

TRUNCATE TABLE EMP_01;
DROP TABLE EMP_01;
--해당 테이블 값만 삭제(잘렸습니다)

INSERT INTO EMP_01(EMP_ID, EMP_NAME)(
  SELECT EMP_ID, EMP_NAME
  FROM EMPLOYEE
);

/*
    INSERT ALL
     - 두 개 이상의 테이블에 각각 INSERT 하는데 동일한 서브쿼리가 사용되는 경우
       INSERT ALL을 이용해 여러 테이블에 한 번에 데이터 삽입이 가능
       
       INSERT ALL 
          INTO 테이블1명(컬럼, ... ) VALUES (값, ...)
          INTO 테이블2명(컬럼, ... ) VALUES (값, ...)
          서브쿼리;
          
       INSERT ALL
          WHEN 조건 1 THEN
            INTO 테이블1명(컬럼, ... ) VALUES (값, ...) 
          WHEN 조건 2 THEN
            INTO 테이블2명(컬럼, ... ) VALUES (값, ...)
          서브쿼리;
*/
DROP TABLE EMP_DEPT;

CREATE TABLE EMP_DEPT
AS SELECT EMP_ID, EMP_NAME, DEPT_CODE, HIRE_DATE
FROM EMPLOYEE
WHERE 1=0; 
-- WHERE 1=0; 틀만 만들어달라는 명령어

SELECT *
FROM EMP_DEPT;

DROP TABLE EMP_MANAGER;

CREATE TABLE EMP_MANAGER
AS SELECT EMP_ID, EMP_NAME, MANAGER_ID
FROM EMPLOYEE
WHERE 1=0; 

SELECT *
FROM EMP_MANAGER;

--EMPLOYEE에서 부서코드가 D1인 직원의 사번, 이름, 부서코드, 입사일
INSERT ALL 
  INTO EMP_DEPT VALUES(EMP_ID, EMP_NAME, DEPT_CODE, HIRE_DATE)
  INTO EMP_MANAGER VALUES(EMP_ID, EMP_NAME, MANAGER_ID)
  SELECT EMP_ID, EMP_NAME, DEPT_CODE, HIRE_DATE, MANAGER_ID
  FROM EMPLOYEE
  WHERE DEPT_CODE = 'D1';
  
SELECT * 
FROM EMP_DEPT;

SELECT * 
FROM EMP_MANAGER;

-- EMPLOYEE에서 입사일 기준으로 2000년 1월 1일 이전 입사한 사원과 
-- 이후 입사한 사원의 테이블을 분리
DROP TABLE EMP_OLD;

CREATE TABLE EMP_OLD
AS SELECT EMP_ID, EMP_NAME, HIRE_DATE, SALARY
FROM EMPLOYEE 
WHERE 0=1;

DROP TABLE EMP_NEW;

CREATE TABLE EMP_NEW
AS SELECT EMP_ID, EMP_NAME, HIRE_DATE, SALARY
FROM EMPLOYEE
WHERE 0=1;

ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY/MM/DD';

INSERT ALL
  WHEN HIRE_DATE < '2000/01/01' THEN 
    INTO EMP_OLD VALUES(EMP_ID, EMP_NAME, HIRE_DATE, SALARY)
  WHEN HIRE_DATE >= '2000/01/01' THEN
    INTO EMP_NEW VALUES(EMP_ID, EMP_NAME, HIRE_DATE, SALARY)
SELECT EMP_ID, EMP_NAME, HIRE_DATE, SALARY
FROM EMPLOYEE;

SELECT * 
FROM EMP_OLD;

SELECT * 
FROM EMP_NEW;

DROP TABLE EMP_02;

CREATE TABLE EMP_02
AS SELECT EMP_ID, EMP_NAME 
FROM EMPLOYEE WHERE 0=1;

DROP TABLE USER_02;

CREATE TABLE USER_02
AS SELECT USER_ID, NAME, MBTI
FROM USER_INFO WHERE 0=1;

SELECT *
FROM EMP_02;

SELECT *
FROM USER_02;

INSERT ALL  
  INTO EMP_02 VALUES(USER_ID, NAME)
  INTO USER_02 VALUES(USER_ID, NAME, MBTI)
  SELECT USER_ID, NAME, MBTI
  FROM USER_INFO;
  
COMMIT;
  /*
      UPDATE
        - 테이블에 기록된 데이터를 수정하는 구문
    
      UPDATE 테이블명
      SET 
       컬럼명 = 변경하려는 값,
       컬럼명 = 변경하려는 값 ...
      WHERE 조건;
      
        - SET절에서 여러개의 컬럼을 콤마(,)로 나열하여 값을 동시에 변경할 수 있다.
        - WHERE절을 생략하면 모든 행의 데이터가 변경된다.
  */      -> WHERE 기본키(PRIMARY KEY) = 값

SELECT *
FROM USER_02;

UPDATE USER_02
  SET MBTI = 'INTP'
  WHERE MBTI IS NULL;
COMMIT;
-- COMMIT 누르면 ROLLBACK해도 되돌아가지 않음, 박제됨 

ROLLBACK;
-- TRUNCATE TABLE USER_02; > INSERT > COMMIT > SELECT 확인
-- UPDATE 모든것에 적용 > ROLLBACK; > COMMIT 직후(SELECT 확인)로 돌아감 
-- MBTI가 ISFP인 사람들을 MBTI ENTJ로 변경
UPDATE USER_02
 SET MBTI = 'ENTJ'
 WHERE MBTI = 'ISFP';
 
 SELECT * 
 FROM USER_02;

/*
      DELETE
        - 테이블에 기록된 데이터를 삭제하는 구문
        
      DELETE FROM TABLE명
      WHERE 조건식;
      -> WHERE을 제시하지 않으면 전체 행이 삭제됨 (=TRUNCATE)
      -> WHERE 기본키(PRIMARY KEY) = 값
*/
ROLLBACK;

SELECT *
FROM USER_02;
-- MBTI ISFJ인 사람들 삭제
DELETE FROM USER_02
WHERE MBTI = 'ISFJ';

--USER_O2 사람들 전체 삭제
DELETE FROM USER_02;

--USER_02 사람들 전체 TRUNCATE -> 롤백 적용 안됨
TRUNCATE TABLE USER_02;

/*
   삭제 옵션 : 부모테이블의 데이터 삭제 시 그 데이터를 사용하고 있는 자식테이블의 
              값을 어떻게 처리할 건지
              (자식 테이블 생성 시 외래키 제약조건 부여할 때 삭제 옵션 지정)
              
    - ON DELETE RESTRICTED (기본값)
      : 자식데이터로 쓰이는 부모데이터는 삭제 아예 안되게끔
      
    - ON DELETE SET NULL 
      : 부모데이터 삭제 시 해당 데이터를 쓰고 있는 자식데이터의 값을 NULL로 변경 
    
    - ON DELETE CASCADE 
      : 부모데이터 삭제 시 해당 데이터를 쓰고 있는 자식데이터도 같이 삭제시킴
*/

CREATE TABLE MEM_GRADE(
    GRADE_CODE NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    GRADE_NAME VARCHAR2(30) NOT NULL
);

INSERT INTO MEM_GRADE(GRADE_NAME) VALUES ('일반회원');
INSERT INTO MEM_GRADE(GRADE_NAME) VALUES ('우수회원');
INSERT INTO MEM_GRADE(GRADE_NAME) VALUES ('특별회원');

CREATE TABLE MEM_MEMBER2(
    MEM_NO NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    MEM_ID VARCHAR2(20) NOT NULL UNIQUE,
    MEM_PWD VARCHAR2(20) NOT NULL,
    MEM_NAME VARCHAR2(20) NOT NULL,
    GRADE_ID NUMBER,
    FOREIGN KEY (GRADE_ID) REFERENCES MEM_GRADE(GRADE_CODE)ON DELETE CASCADE);

INSERT INTO MEM_MEMBER2(MEM_ID, MEM_PWD, MEM_NAME, GRADE_ID)
VALUES('user01', 'pass01', '윤의진', 1);
INSERT INTO MEM_MEMBER2(MEM_ID, MEM_PWD, MEM_NAME, GRADE_ID)
VALUES('user02', 'pass02', '이진용', 2);
INSERT INTO MEM_MEMBER2(MEM_ID, MEM_PWD, MEM_NAME, GRADE_ID)
VALUES('user03', 'pass03', '곽병현', 3);

ROLLBACK;
SELECT * FROM MEM_MEMBER2;
SELECT * FROM MEM_GRADE;

-- MEM_GRADE 테이블에서 GRADE_CODE가 1인걸 삭제 
DELETE FROM MEM_GRADE WHERE GRADE_CODE = 1;
-- MEM-MEMBER2(자식 테이블)  MEM_GRADE(부모 테이블)
-- 부모테이블에서 먼저 삭제시 무결성 제약조건 에러(자식 레코드 발견)
-- on delete set null, cascade 에서는 바로 삭제 됨 (MEMBER2에서 null 값)

DELETE FROM MEM_MEMBER2 WHERE MEM_NO = 1;
-- 먼저 삭제 하고 난 뒤 GRADE_CODE = 1 삭제 
-- cascade에서는 위에서 동시에 삭제되어서 행이 아예 없음

DROP TABLE MEM_GRADE;
-- 외래 키에 의해 참조되는 고유/기본키가 테이블에 있습니다 에러 
DROP TABLE MEM_MEMBER2; 
-- 먼저 삭제를 해야함. 자식 테이블부터 삭제하고 부모 테이블 삭제 필요

DELETE FROM MEM_GRADE WHERE GRADE_CODE = 2;
-- GRADE_CODE의 값이 있고 참조되고 있지만 null로 변하면서 삭제바로 됨 
-- CREATE에서 FOREIGN KEY - ON DELETE SET NULL 


