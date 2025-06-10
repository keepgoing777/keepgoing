/*
    JOIN
     - 두 개 이상의 테이블에서 데이터를 조회하고자 할 때 사용되는 구문
     - 조회 결과는 하나의 결과물(RESULT SET)으로 나옴
     - 관계형 데이터베이스는 최소한의 데이터로 각각의 테이블에 담고 있음
       (중복을 최소화하기위해 최대한 쪼개서 관리함)
       부서 테이블은 부서 테이블, 사원데이터는 사원 테이블, ...
       
       만약 어떤 사원이 어떤 부서에 속해있는지 부서명과 같이 조회하고 싶다면?
       => 즉, 관계형 데이터베이스에서 SQL문을 이용한 테이블 간에 "관계"를 맺어
          원하는 데이터를 조회하는 방법 
          
     "오라클 구문" 과 "ANSI 구문"
     ANSI(미국국립표준협회 == 산업 표준을 제정하는 단체)
*/

/*
     등가 조인(EQUAL JOIN) / 내부 조인(INNER/NATURAL JOIN)
      - 연결시키는 컬럼의 값이 일치하는 행들만 조인되서 조회
      
     오라클 구문
     SELECT 컬럼, 컬럼, ... 
     FROM 테이블1, 테이블2
     WHERE 테이블1.컬럼 = 테이블2.컬럼; 
     (PRIMARY AND FOREIGN KEY 연결시키는 부분)
     
     ANSI 구문
     SELECT 컬럼, 컬럼, ...
     FROM 테이블1
      JOIN 테이블2 ON (테이블1.컬럼 = 테이블2.컬럼);
     - FROM절에서 기준이 되는 테이블 기술
     - JOIN절에서 같이 조회하고자 하는 테이블 기술 후 매칭시킬 컬럼에 대한 조건을 기술
       (USING 또는 ON)-> 연결에 사용하는 컬럼명이 같은 경우 USING(컬럼)     
*/

--EMPLOYEE, DEPARTMENT 조인해서 사번(EMP_ID), 사원명(EMP_NAME),
--부서코드(DEPT_CODE), 부서명(DEPT_NAME) 조회

SELECT EMP_ID, EMP_NAME, DEPT_CODE
FROM EMPLOYEE; 
SELECT DEPT_ID, DEPT_TITLE 
FROM DEPARTMENT;                                                                                                                

--오라클 구문
SELECT EMP_ID, EMP_NAME, DEPT_CODE, DEPT_TITLE
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE = DEPT_ID;

-- ANSI 구문
SELECT EMP_ID, EMP_NAME, DEPT_CODE, DEPT_TITLE
FROM EMPLOYEE
  JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID);
  
--사번(EMP_ID) 사원명(EMP_NAME), 직급코드(JOB_CODE), 직급명(JOB_NAME)
--테이블 : EMPLOYEE, JOB
--연결할 두 컬럼이 같은 경우 : 테이블명 이용 또는 테이블에 별치 부여해서 이용

SELECT *
FROM JOB;

SELECT *
FROM EMPLOYEE;

SELECT EMP_ID, EMP_NAME, JOB_CODE FROM EMPLOYEE;
SELECT JOB_CODE, JOB_NAME FROM JOB;

SELECT EMP_ID, EMP_NAME, JOB.JOB_CODE, JOB_NAME
FROM EMPLOYEE, JOB
WHERE JOB.JOB_CODE = JOB_CODE;

SELECT EMP_ID, EMP_NAME, E.JOB_CODE, JOB_NAME
FROM EMPLOYEE E
 JOIN JOB J ON (E.JOB_CODE = J.JOB_CODE);

--컬럼명이 같은 경우에는 USING 사용 추천
SELECT EMP_ID, EMP_NAME, JOB_CODE, JOB_NAME
FROM EMPLOYEE
  JOIN JOB USING (JOB_CODE);
--자연 조인(NATURAL JOIM) : 각 테이블마다 동일한 컬럼이 한개만 존재할 경우
SELECT EMP_ID, EMP_NAME, JOB_CODE, JOB_NAME
FROM EMPLOYEE
  NATURAL JOIN JOB;

--대리 사원의 사번(EMP_ID) 이름(EMP_NAME) 직급명(JOB_NAME) 급여(SALARY)조회
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE 
  JOIN JOB USING(JOB_CODE)
  WHERE JOB_NAME = '대리';
  
SELECT *
FROM JOB;

SELECT *
FROM EMPLOYEE;

SELECT *
FROM DEPARTMENT;

SELECT *
FROM LOCATION;

--부서가 인사관리부인 사원들의 사번 이름 보너스 조회
SELECT EMP_ID, EMP_NAME, BONUS
FROM EMPLOYEE
 JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
 WHERE DEPT_TITLE = '인사관리부';

--DEPARTMENT 랑 LOCATTION 참고해서 전체 부서의 부서코드, 부서명, 지역코드, 지역명 조회
-- 부서가 총무부가 아닌 사원들의 사원명, 급여 조회

SELECT DEPT_ID, DEPT_TITLE, LOCATIONID FROM DEPARTMENT;
SELECT LOCAL_CODE, LOCAL_NAME, LOCAL_NAME FROM LOCATION;
SELECT DEPT_ID, DEPT_TITLE, LOCATION_ID, LOCAL_NAME
FROM DEPARTMENT JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE);

-- 부서가 총무부가 아닌 사원들의 사원명, 급여 조회
SELECT EMP_NAME, SALARY, DEPT_TITLE
FROM EMPLOYEE
 JOIN DEPARTMENT ON (DEPT_ID = DEPT_CODE)
  WHERE DEPT_TITLE != '총무부';
  
/*
     포괄 조인 / 외부 조인 (OUTER JOIN)
      - 단, 반드시 기준이 되는 테이블(컬럼)을 지정해야 한다. 
*/
-- 사원명, 부서명 조회
SELECT EMP_NAME, DEPT_TITLE
FROM EMPLOYEE 
LEFT JOIN DEPARTMENT ON (DEPT_ID = DEPT_CODE);
-- LEFT 추가함으로서 DEPARTMENT 에서 DEPT_TITLE이 없는 2명 나타남

SELECT EMP_NAME, DEPT_TITLE
FROM EMPLOYEE , DEPARTMENT
WHERE DEPT_ID(+) = DEPT_CODE;
-- 기준 삼는 테이블의 반대 테이블의 컬럼뒤에 (+)
-- 한쪽에만 쓸수 있어서 다소 불편, JOIN 많이 씀

SELECT EMP_NAME, DEPT_TITLE
FROM EMPLOYEE 
RIGHT JOIN DEPARTMENT ON (DEPT_ID = DEPT_CODE);
-- RIGHT 추가함으로서 EMPLOYEE 에서 EMP_NAME 없는 3명 나타남

/*
     FULL JOIN = LEFT JOIN + RIGHT JOIN
*/
SELECT EMP_NAME, DEPT_TITLE
FROM EMPLOYEE 
FULL JOIN DEPARTMENT ON (DEPT_ID = DEPT_CODE);

/*
     비등가 조인(NON EQUAL JOIN) 
      - 매칭시킬 칼럼에 대한 조건 작성시, '=' 등호를 사용하지 않는 조인문
         -> 값의 범위에서 포함되는 행들을 연결하는 방식
      - ANSI구문으로는 JOIN ON으로만 사용가능 (USING 사용불가)
*/

SELECT * 
FROM SAL_GRADE; 

SELECT *
FROM EMPLOYEE;

-- 사원명, 급여, 급여레벨 조회(ON BETWEEN 사용)
SELECT SAL_LEVEL, MIN_SAL, MAX_SAL FROM SAL_GRADE;

SELECT EMP_NAME, SALARY, SAl_LEVEL
FROM EMPLOYEE
  JOIN SAL_GRADE ON(SALARY BETWEEN MIN_SAL AND MAX_SAL);

/*
      자체 조인(SELF JOIN) 
       - 같은 테이블을 다시 한번 조인하는 경우(자기 자신과 조인) -> 대댓글 기능\
*/

--사원사번, 사원명, 사원부서코드, 사수사번, 사수명, 사수부서코드 조회
--MANAGER_ID의 번호가 EMP_ID

SELECT EMP_ID, EMP_NAME, DEPT_CODE, MANAGER_ID 
FROM EMPLOYEE M;
SELECT  E.EMP_ID, E.EMP_NAME, E.DEPT_CODE, 
        M.EMP_ID, M.EMP_NAME, M.DEPT_CODE
FROM EMPLOYEE E 
 JOIN EMPLOYEE M ON (E.MANAGER_ID = M.EMP_ID);
 
/*
      카테시안곱(CATESIAN PRODUCT) / 교차 조인(CROSS JOIN) 
       - 조인되는 모든 테이블의 각 행들이 서로 모두 매핑된 데이터가 검색(곱집합)
         두 테이블의 행들이 모두 곱해진 행들의 조합이 출력 -> 방대한 데이터 출력 과부화
*/ 

SELECT EMP_NAME, DEPT_TITLE
FROM EMPLOYEE
  CROSS JOIN DEPARTMENT;  -- 23*3
  
SELECT * FROM EMPLOYEE; --23
SELECT * FROM DEPARTMENT; -- 3
SELECT * FROM JOB;
/*
      다중 JOIN                          
       - 여러개의 테이블을 조인하는 경우
*/ 

-- 사원명, 부서명, 직급명 조회
-- EMPLOYEE, DEPARTMENT, JOB

SELECT EMP_NAME, DEPT_CODE, JOB_CODE FROM EMPLOYEE; 
SELECT DEPT_ID, DEPT_TITLE FROM DEPARTMENT; 
SELECT JOB_CODE, JOB_NAME FROM JOB;


--국가명, 지역명, 직급명, 부서명, 사원명, 급여, 급여등급 조회 (순서 중요)
--NATIONAL, LOCATION, JOB, DEPARTMENT, EMPLOYEE, SAL_GRADE
SELECT EMP_NAME, JOB_CODE, DEPT_CODE, SALARY FROM EMPLOYEE;
SELECT JOB_CODE, JOB_NAME FROM JOB; 
SELECT DEPT_ID, DEPT_TITLE, LOCATION_ID FROM DEPARTMENT;
SELECT LOCAL_CODE, NATIONAL_CODE, LOCAL_NAME FROM LOCATION;
SELECT NATIONAL_CODE, NATIONAL_NAME FROM NATIONAL;
SELECT SALARY_LEVEL, MIN_SAL, MAX-SAL FROM SAL_GRADE; 

SELECT NATIONAL_NAME, LOCAL_NAME, 
       JOB_NAME, DEPT_TITLE, EMP_NAME, SALARY, SAL_LEVEL
FROM EMPLOYEE 
 LEFT JOIN JOB USING (JOB_CODE)
 LEFT JOIN SAL_GRADE ON (SALARY BETWEEN MIN_SAL AND MAX_SAL)
 LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
 LEFT JOIN LOCATION ON (LOCAL_CODE = LOCATION_ID)
 LEFT JOIN NATIONAL USING (NATIONAL_CODE);
  
 
  
