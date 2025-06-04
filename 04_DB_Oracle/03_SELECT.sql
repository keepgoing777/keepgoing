-- 데이터베이스 : 데이터(data) + 베이스(base)
-- DBMS : Database Management System 의 약자, 데이터베이스 관리 시스템
-- 관계형(Relational) 데이터베이스
--   1. 가장 대표적인 데이터베이스 시스템 ex) 오라클
--   2. 데이터를 데이블 형태(행과 열)로 저장하고, 여러 테이블 간 관계를 설명하고,
--      데이터 관계를 표현 및 분석
--   3. 데이터의 중복을 최소화하고 무결성, 트랜젝션 관리 등 뛰어난 데이터 관리 성능을 제공
-- SQL(Structured Query Language)
-- : 관계형 데이터베이스에서 데이터를 조회하거나 조작하기 위해 사용하는 표준 언어
-- SQL 종류 
-- 1. DML(Data Manipulation Language) : 데이터 조작어
--    - 데이터를 조작하기 위한 언어
--    - INSERT : 추가 / SELECT : 조회 / UPDATAE : 수정 / DELETE : 삭제
--      BackEnd: CRUD(Create / Read / Update / Delete) 
--    - SELECT 조회를 의미하며 일부에서는 DQL(Data Query Languate)로 분류하기도함
-- 2. DDL(Data Definition Language) : 데이터 정의어
--    - DB의 구조를 정의하거나 변경, 삭제하기 위한 언어
--    - CREATE : 생성 / ALTER : 수정 / DROP : 삭제 -
--    - 테이블 변경과 관련
-- 3. DCL(Data Control Language) : 데이터 제어어
--    - DB의 보안, 권한관리, 무결성 제어를 위한 언어
--    - GRANT : 권한 부여 / REVOKE : 권한 회수
-- 4. TCL(Transaction Control Language) : 트랜젝션 제어어
--    - 트랜젝션 처리 및 제어를 위한 언어
--    - COMMIT : 실행 / ROLLBACK : 취소 / SAVEPOINT : 임시저장 

/*
   SELECT 컬럼1, 컬럼2, ... 
   FROM 테이블명;
   - 테이블에서 데이터를 조회할 때 사용하는 SQL문
   - SELECT 실행 결과를 Result Set 이라고 한다. 결과 세트
   - 조회하고자하는 컬럼은 반드시 FROM절에 지정한 테이블에 존재해야한다. 
   - 테이블의 모든 컬럼을 조회하려면 * 기호를 사용
*/
-- USER_INFO 테이블 전체 조회
SELECT * FROM USER_INFO;
-- USER_INFO 이름(NAME), 나이(AGE), 취미(HOBBY) 조회
SELECT NAME FROM USER_INFO;
SELECT AGE FROM USER_INFO;
SELECT HOBBY FROM USER_INFO;
SELECT NAME, AGE, HOBBY FROM USER_INFO; 
-- select name, age, hobby from user_info;
-- SELECT name, age, hobby from user_info;  MySQL
-- SELECT NAME, AGE, HOBBY FROM USER_INRO; 오라클 관행
-- EMPLOYEE 테이블의 직원명(EMP_NAME), 이메일(EMAIL) 조회
SELECT EMP_NAME, EMAIL FROM EMPLOYEE;

/*
컬럼 산술 연산
- SELECT 절에 컬럼명 입력부분에 산술연산자를 사용하여 결과 조회
-- USER_INFO에서 나이(AGE)에 10년 후를 계산 
-- 컬럼 별칭 : 컬럼 AS 별칭 / 컬럼 AS "별칭" / 컬럼 별칭 / 컬럼 "별칭"
--            산술 연산 후 지저분해진 컬럼명 변경 가능
*/
SELECT NAME 이름,
         AGE 나이,
         AGE+10 AS "10년 후" 
         FROM USER_INFO;
-- EMPLOYEE 에서 직원명(EMP_NAME), 월급(SALARY), 연봉 조회
SELECT EMP_NAME, SALARY, SALARY*12 AS 연봉 FROM EMPLOYEE;
 
-- 리터럴(문자열) 
-- - SELECT 절에 리터럴을 사용하면 테이블에 존재하는 데이터처럼 조회가능
--  - 즉, 리터럴은 RESULT SET의 모든행에 반복적으로 출력
SELECT NAME, AGE || '살' AS "나이" FROM USER_INFO;

/*
연결 연산자 : ||
 - 여러 컬럼값들을 마치 하나의 컬럼인것처럼 연결
 - 컬럼값과 리터럴도 연결할 수 있음 
*/ 
 -- USER_INFO에서 이름(NAME)의 MBTI는 XXXX입니다. 
 SELECT NAME || '의 MBTI는' ||MBTI || '입니다.' AS MBTI FROM USER_INFO;

/*
DISTINCT 
- 컬럼에 중복된 값들을 한번씩만 표시하고자 할 때
- 주의사항 : DISTINCT는 SELECT절에서 한번만 기술 가능
*/ 
-- USER_INFO에서 나이(AGE)가 중복되지 않게 조회
SELECT DISTINCT AGE FROM USER_INFO;

--USER_INFO에서 MBTI가 중복되지 않게 조회
SELECT DISTINCT MBTI FROM USER_INFO;

/*
WHERE 절 : 조회하고자하는 테이블로부터 "특정 조건"에 만족하는 데이터만 조회하고자 할 때
           이 때, WHERE절에 조선식 제시, 조건식에는 다양한 연산자 사용 가능

SELECT 컬럼, 컬럼, ...
FROM 테이블명
WHERE 조건식;

비교 연산자 
= : 같음
!= <> : 같지 않음
>, <, >=, <= : 대소비교
*/
-- USER_INFO에서 나이가 30이상인 이름(NAME), 나이(AGE), 생년월일(BIRTHDATE)
SELECT NAME, AGE, BIRTHDATE FROM USER_INFO WHERE AGE >=30;

-- EMPLOYEE에서 부서코드(DEPT_CODE)가 D9인 사원들 모든 컬럼 조회
SELECT * FROM EMPLOYEE WHERE DEPT_CODE = 'D9';

/* 
  OR(또는), ADN(rmflrh)
*/
-- 테이블 : USER_INFO
-- 성별(GENDER)이 여자이거나 나이(AGE)가 25살 이하인 사람들 조회
SELECT * FROM USER_INFO WHERE GENDER = '여' OR AGE <= 25 ;
-- 테이블 : EMPLOYEE
-- 급여(SALARY)가 350만원 이상 600만원 이하를 받는 사원들 조회
SELECT * FROM EMPLOYEE WHERE SALARY >= 3500000 AND SALARY <= 6000000;
SELECT * FROM EMPLOYEE WHERE SALARY BETWEEN 3500000 AND 6000000;
-- BETWEEN AND : 몇 이상 몇 이하인 범위에 대한 조건을 제시할때 사용
-- EX) 컬럼 BETWEEN 하한값 AND 상한값 
-- USER_INFO에서 나이가 25~30 사이인 사람들 조회
SELECT * FROM USER_INFO WHERE AGE BETWEEN 25 AND 30;

/* 
 LIKE
  - 비교하고자 하는 컬럼값이 특정 패턴에 만족할 경우 조회 
  - 컬럼 LIKE '특정패턴' 필요 
  - 특정패턴에는 '%', '_'를 와일드 카드로 사용
  
  '_' : 1글자 
  '_문자' : 앞에 1글자 올수 있고 + 문자
  '__문자' : 앞에 2글자 올수 있고 + 문자
  '_문자_' : 문자 앞뒤에 1글자씩 
  
  '%' : 0글자 이상
  '문자%' : 문자로 시작
  '%문자' : 문자로 끝남
  '%문자%' : 문자 포함 (키워드 검색 시 사용) 
*/
-- 테이블 : USER_INFO
-- 이름이 '은'으로 끝나는 경우 '__은'
SELECT * FROM USER_INFO WHERE NAME LIKE '%은';
-- 성이 '성'씨인 경우 조회 '성__'(외자없을경우)
SELECT * FROM USER_INFO WHERE NAME LIKE '성%';
-- MBTI가 'E'면서 'T'인 경우
SELECT * FROM USER_INFO WHERE MBTI LIKE 'E_T_';
-- 전화번호가 010-2XXX-XXXX인 경우
SELECT * FROM USER_INFO WHERE CONTACT LIKE '010-2%';
-- 나이가 25 이하이면서 경기도에 사는 사람이거나 MBTI가 INTP인 경우 
SELECT * FROM USER_INFO WHERE AGE <= 25 AND ADDRESS LIKE '경기%' OR 
MBTI LIKE 'INTP';
-- 테이블 EMPLOYEE, 이메일 중 _ 앞글자가 3글자인 사원들 조회
-- ESCAPE OPTION : 나만의 와일드카드($, # 상관없음) 만들어서 사용!
SELECT * FROM EMPLOYEE WHERE EMAIL LIKE '___$_%' ESCAPE '$';
-- 위 사원들 이외의 사원들 조회
-- 부정연산자 : NOT (WHERE 컬럼 앞뒤 상관없음)
SELECT * FROM EMPLOYEE WHERE NOT EMAIL LIKE '___$_%' ESCAPE '$';
SELECT * FROM EMPLOYEE WHERE EMAIL NOT LIKE '___$_%' ESCAPE '$';
/*
  IS NULL / IS NOT NULL
  - 컬럼값에 NULL이 있을 경우 NULL 값 비교에 사용되는 연산자, IS 필수!
*/ 
-- MBTI가 NULL 인 사람들 조회 
SELECT * FROM USER_INFO WHERE MBTI IS NULL;
SELECT * FROM USER_INFO WHERE MBTI IS NOT NULL;
-- EMPLOYEE에서 보너스(BONUS)를 받지 않는 사원들 조회
SELECT * FROM EMPLOYEE WHERE BONUS IS NULL;
-- EMPLOYEE에서 부서 배치를 아직 받지 않고, 보너스는 받는 사원들 조회
SELECT * FROM EMPLOYEE WHERE DEPT_CODE IS NULL AND BONUS IS NOT NULL;
--USER_INFO에서 MBTI가 INFP 또는 INTJ인 사용자 조회
SELECT * FROM USER_INFO WHERE MBTI = 'INFP' OR MBTI = 'INTJ';
SELECT * FROM USER_INFO WHERE MBTI IN ('INFP', 'INTJ');
/* IN(A,B) A 또는 B 
   - 컬럼값이 내가 제시한 목록 중에 일치하는 값이 있는지 
     컬럼 IN ('값1', '값2', ... ) -> 검색필터에 자주 사용
*/
-- EMPLOYEE에서 부서코드 DEPT_CODE D5, D6, D8 사원들 조회
SELECT * FROM EMPLOYEE WHERE DEPT_CODE IN ('D5', 'D6', 'D8');

-- 직급 코드(JOB_CODE) 가 J7이거나 J2인 사원들 중 급여가 200만원인 사원들 조회
SELECT * FROM EMPLOYEE WHERE JOB_CODE = 'J7' AND SALARY >= '2000000'
OR JOB_CODE = 'J2' AND SALARY>=2000000; 
SELECT *FROM EMPLOYEE WHERE JOB_CODE IN('J7', 'J2') AND SALARY >= '2000000';

/* 연산자 우선순위
  0. ()
  1. 산술연산자 : *, /, +, -
  2. 문자열 연결 : ||
  3. 비교연산자 : =, !=, <>, <, >, <=, >=
  4. IS NULL / LIKE / IN / BETWEEN
  5. NOT
  6. AND
  7. OR 
*/

/*
   OREDER BY 
    - SELECT문 가장 마지막줄에 작성 뿐만 아니라 실행순서 또한 마지막
    
    SELECT 컬럼, 컬럼...
    FROM 테이블명
    WHERE 조건식
    ORDER BY 정렬하고자 하는 컬럼값 [ASC| DESC];
    
    - ASC : 오름차순 정렬(생략시 기본값)
    - DESC : 내림차순 정렬
*/
-- USER_INFO에서 나이를 오름차순 정렬
SELECT * FROM USER_INFO ORDER BY AGE ASC;
-- MBTI 오름차순, AGE 내림차순 정렬 
-- 조건은 MBTI가 I인 분들 조회
SELECT NAME, AGE, GENDER, MBTI FROM USER_INFO ORDER BY MBTI ASC, AGE DESC;
SELECT NAME, AGE, GENDER, MBTI FROM USER_INFO ORDER BY 4 ASC, 2 DESC;
-- SELECT 컬럼이 여러개인 경우, 그 중 하나로 정렬 시 숫자차례로 대체 가능 
SELECT NAME, AGE, GENDER, MBTI FROM USER_INFO ORDER BY MBTI DESC NULLS LAST;
-- 오라클에서만 제공되는 예, NULL 값만 마지막으로 보내기 NULLS LAST 
-- 내림차순에서는 NULL이 가장 먼저 나오므로 강제적으로 명령어 입력해야함 
-- EMPLOYEE 에서 전체 사원의 사원명, 보너스 조회 (보너스 기준으로 오름차순 정렬)
SELECT EMP_NAME, BONUS FROM EMPLOYEE ORDER BY BONUS NULLS FIRST;
-- 오라클에서만 제공되는 예, NULL 값만 맨 위로 보내기 NULLS FIRST 
-- (원래 오름차순으로 정렬 시 NULL은 마지막에 배치됨)
SELECT EMP_NAME, BONUS FROM EMPLOYEE ORDER BY BONUS DESC NULLS LAST; 

























