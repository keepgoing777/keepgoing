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
