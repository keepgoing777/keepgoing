/*
     서브쿼리(SUBQUERY)
      - 하나의 SQL문 안에 포함된 또다른 SQL문
*/

--노옹철 사원의 부서코드 조회 
SELECT DEPT_CODE
FROM EMPLOYEE 
WHERE EMP_NAME = '노옹철';  --D9

--D9인 사원들 조회
SELECT EMP_NAME
FROM EMPLOYEE
WHERE DEPT_CODE = 'D9'; -- 선동일, 송종기, 노옹철

--노옹철 사원과 같은 부서원들 조회
SELECT EMP_NAME
FROM EMPLOYEE
WHERE DEPT_CODE = (SELECT DEPT_CODE
                   FROM EMPLOYEE 
                   WHERE EMP_NAME = '노옹철');
    
--전 직원의 평균 급여보다 더 많은 급여를 받는 사원들 조회
SELECT *
FROM EMPLOYEE
WHERE SALARY > (SELECT ROUND(AVG(SALARY),2)
                FROM EMPLOYEE); 

/*
     서브쿼리의 종류
      - 서브쿼리를 수행한 결과값이 몇 행 몇 열이냐에 따라 분류
      - 서브쿼리의 종류에 따라 서브쿼리 앞에 붙는 연산자가 달라짐
      
     1. 단일행 서브쿼리
      - 서브쿼리의 조회 결과값의 개수가 오로지 1개일 때 (한 행 한 열)
      - 일반 비교 연산자 사용 가능 : =, !=, >, <. >=, <=
*/

--노옹철 사원의 급여보다 더 많이 받는 사원들 조회
SELECT * 
FROM EMPLOYEE 
WHERE SALARY > (SELECT SALARY
                FROM EMPLOYEE
                WHERE EMP_NAME = '노옹철'); //3700000

--부서별 급여의 합이 가장 큰 부서의 부서코드, 급여 합 조회
SELECT DEPT_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING SUM(SALARY) = (SELECT MAX(SUM(SALARY))
                      FROM EMPLOYEE
                      GROUP BY DEPT_CODE); 

--전지연 사원이 속해있는 부서원들 조회(단, 전지연 제외)
SELECT *
FROM EMPLOYEE
WHERE DEPT_CODE = (SELECT DEPT_CODE
                   FROM EMPLOYEE
                   WHERE EMP_NAME = '전지연') AND EMP_NAME != '전지연';
                   
/*
     2. 다중행 서브쿼리
      - 서브쿼리 조회 결과 값의 개수가 여러 행일때 (여러행 한 열)
      - IN 서브쿼리 : 여러개의 결과값 중에서 한 개라도 일치하는 값이 있다면
*/

--각 부서별 최고 급여를 받는 사원들 조회
SELECT *
FROM EMPLOYEE
WHERE SALARY IN (SELECT MAX(SALARY)
                 FROM EMPLOYEE
                 GROUP BY DEPT_CODE);
                 
--각 부서별 최고 급여를 받는 사원들 조회
SELECT *
FROM EMPLOYEE E
WHERE SALARY = (SELECT MAX(SALARY)
               FROM EMPLOYEE
               WHERE DEPT_CODE = E.DEPT_CODE)
   OR SALARY = (SELECT MAX(SALARY)
                FROM EMPLOYEE
                WHERE DEPT_CODE IS NULL);

--사원에 대해 사번, 이름, 부서코드, 구분(사수/사원)조회
--MANAGER_ID가 있으면 사수가 있음(사원임), 없다면 본인이 사수

--NVL2 구문
SELECT EMP_ID, EMP_NAME, DEPT_CODE, NVL2(MANAGER_ID, '사원', '사수')AS 구분
FROM EMPLOYEE;

--CASE WHEN 구문
SELECT EMP_ID, EMP_NAME, DEPT_CODE,
 CASE WHEN MANAGER_ID IS NULL THEN '사수'
      WHEN MANAGER_ID IS NOT NULL THEN '사원'
-- ELSE '사원'으로도 대체 가능(바로 윗 문장)
 END AS 구분
FROM EMPLOYEE;

--서브쿼리문 (CASE WHEN 응용)
SELECT DISTINCT MANAGER_ID
FROM EMPLOYEE
WHERE MANAGER_ID IS NOT NULL; -- 누군가의 사수인분들

SELECT EMP_ID, EMP_NAME, DEPT_CODE,
 CASE WHEN EMP_ID IN (SELECT DISTINCT MANAGER_ID
                      FROM EMPLOYEE
                      WHERE MANAGER_ID IS NOT NULL) THEN '사수'
 ELSE '사원'
 END AS 구분
FROM EMPLOYEE;

/*
     비교대상 > ANY (서브쿼리) : 여러개의 결과값 중에서 '한개라도' 클 경우
                             (여러개의 결과값 중에서 가장 작은 값보다 클 경우)
     비교대상 < ANY (서브쿼리) : 여러개의 결과값 중에서 '한개라도' 작을 경우
                             (여러개의 결과값 중에서 가장 큰 값보다 클 경우)
*/

--대리 직급임에도 불구하고 과장 직급들의 최소 급여보다 많이 받는 직원들
--직원의 사번, 이름, 직급명, 급여 조회

--일반 검색
SELECT SALARY
FROM EMPLOYEE
  JOIN JOB USING(JOB_CODE)
WHERE JOB_NAME = '대리';

--MIN 사용
SELECT MIN(SALARY)
FROM EMPLOYEE
  JOIN JOB USING(JOB_CODE)
WHERE JOB_NAME = '과장';

--일반 검색
SELECT SALARY
FROM EMPLOYEE
  JOIN JOB USING(JOB_CODE)
WHERE JOB_NAME = '과장';

-- > ANY 사용 + 일반검색
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE
  JOIN JOB USING(JOB_CODE)
WHERE JOB_NAME = '대리'
 AND SALARY > ANY (SELECT SALARY
                   FROM EMPLOYEE
                   JOIN JOB USING(JOB_CODE)
                   WHERE JOB_NAME = '과장');

-- MIN 적용 
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE
  JOIN JOB USING(JOB_CODE)
WHERE JOB_NAME = '대리'
 AND SALARY > (SELECT MIN(SALARY)
              FROM EMPLOYEE
              JOIN JOB USING(JOB_CODE)
              WHERE JOB_NAME = '과장');
              

/*
     비교대상 > ALL(서브쿼리) : 여러개의 "모든" 결과값들보다 클 경우
     비교대성 < ALL(서브쿼리) : 여러개의 "모든" 결과값들보다 작을 경우
*/

-- 과장 직급임에도 차장직급의 최대 급여보다 더 많는 직원들 조회
SELECT SALARY
FROM EMPLOYEE 
 JOIN JOB USING(JOB_CODE)
WHERE JOB_NAME = '과장';

--MAX사용
SELECT MAX(SALARY)
FROM EMPLOYEE 
 JOIN JOB USING(JOB_CODE)
WHERE JOB_NAME = '차장';

--일반 검색               
SELECT SALARY
FROM EMPLOYEE 
 JOIN JOB USING(JOB_CODE)
WHERE JOB_NAME = '차장';

-- > ALL 사용 + 일반검색
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE 
 JOIN JOB USING(JOB_CODE)
WHERE JOB_NAME = '과장'
 AND SALARY > ALL (SELECT SALARY
                   FROM EMPLOYEE 
                   JOIN JOB USING(JOB_CODE)
                   WHERE JOB_NAME = '차장');

-- MAX 사용 
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE 
 JOIN JOB USING(JOB_CODE)
WHERE JOB_NAME = '과장'
 AND SALARY > (SELECT MAX(SALARY)
               FROM EMPLOYEE 
               JOIN JOB USING(JOB_CODE)
               WHERE JOB_NAME = '차장');


/*
    3. 다중열 서브쿼리
      - 서브쿼리의 조회 결과값이 한 행이지만 컬럼이 여러개일때 (한 행 여러 열)
*/
-- 하이유 사원과 같은 부서 코드, 같은 직급코드에 해당하는 사원들 조회

SELECT DEPT_CODE, JOB_CODE
FROM EMPLOYEE
WHERE EMP_NAME = '하이유';

SELECT *
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5' AND JOB_CODE = 'J5';

SELECT * 
FROM EMPLOYEE
WHERE DEPT_CODE = (SELECT DEPT_CODE
                   FROM EMPLOYEE
                   WHERE EMP_NAME = '하이유')
    AND JOB_CODE = (SELECT JOB_CODE
                    FROM EMPLOYEE
                    WHERE EMP_NAME = '하이유');
SELECT *
FROM EMPLOYEE
WHERE(DEPT_CODE, JOB_CODE) = (('D5', 'J5'));

SELECT *
FROM EMPLOYEE
WHERE(DEPT_CODE, JOB_CODE) = (SELECT DEPT_CODE, JOB_CODE
                              FROM EMPLOYEE
                              WHERE EMP_NAME = '하이유');
                              
/*
    4. 다중행 다중열 서브쿼리
      - 서브쿼리의 조회 결과값이 여러 행, 여러 열일 경우
*/

-- 각 직급별로 최소 급여를 받는 사원들의 사번, 이름, 직급코드, 급여조회

SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE (JOB_CODE, SALARY) IN (SELECT JOB_CODE, MIN(SALARY)
                             FROM EMPLOYEE
                             GROUP BY JOB_CODE);

SELECT JOB_CODE, MIN(SALARY)
FROM EMPLOYEE
GROUP BY JOB_CODE;

/*
    인라인 뷰
     - FROM 절에 서브쿼리를 제시하고, 서브쿼리를 수행한 결과를 테이블 대신 사용
*/

--전 직원 중 급여가 가장 높은 상위 5명 순위, 이름, 급여 조회
--ROWNUM : 오라클에서 제공하는 컬럼, 조회된 순서대로 1부터 순번 부여
SELECT ROWNUM, EMP_NAME, SALARY
FROM EMPLOYEE
ORDER BY SALARY DESC;
-- SELECT 실행 순서 : FROM -> SELECT(ROWNUM 부여받음) -> ORDER BY 
SELECT ROWNUM, EMP_NAME, SALARY
FROM (SELECT EMP_NAME, SALARY
FROM EMPLOYEE
ORDER BY SALARY DESC)
--ORDER BY 전체를 표로 보고 FROM에 넣음, ROWNUM이 순서대로 배치 됨
WHERE ROWNUM <= 5; 

--부서별 평균 급여가 높은 3개 부서의 부서 코드, 평균 급여 조회
SELECT ROWNUM, DEPT_CODE, 평균급여
FROM (SELECT DEPT_CODE, ROUND(AVG(NVL(SALARY,0))) 평균급여
      FROM EMPLOYEE
      GROUP BY DEPT_CODE
      ORDER BY AVG(NVL(SALARY,0)) DESC)
WHERE ROWNUM <= 3;


WITH TOPN_SAL AS(
SELECT DEPT_CODE, ROUND(AVG(NVL(SALARY,0))) AVG_SALARY
FROM EMPLOYEE
GROUP BY DEPT_CODE
ORDER BY ROUND(AVG(NVL(SALARY,0))) DESC)
SELECT DEPT_CODE, AVG_SALARY
FROM TOPN_SAL
WHERE ROWNUM <= 3;

/*
    RANK 함수
     - RANK() OVER(정렬 기준) : 동일한 순위 이후의 등수를 동일한 인원수만큼 건너뛰고 
                               순위 계산
       EX) 공동 1위가 2명이면 다음 순위는 3위
     - DENSE_RANK() OVER(정렬 기준) : 동일한 순위 이후의 등수를 무조건 1씩 증가
       EX) 공동 1위가 2명이면 다음 순위는 2위
*/ 

--사원별 급여가 높은 순서대로 조회
SELECT 
  RANK() OVER(ORDER BY SALARY DESC),
  EMP_NAME, SALARY        
FROM EMPLOYEE;
-- 공동 19위가 2명이라 뒤에 순위가 21위
SELECT 
  DENSE_RANK() OVER(ORDER BY SALARY DESC),
  EMP_NAME, SALARY        
FROM EMPLOYEE;
-- 공동 19위가 2명이라 뒤에 순위가 20위

SELECT *
FROM (SELECT 
 RANK() OVER(ORDER BY SALARY DESC) RANK,
 EMP_NAME, SALARY
 FROM EMPLOYEE)
 WHERE RANK >= 19;

/*
    LAG / LEAD 함수
      - LAG(컬럼) OVER(정렬기준) : 이전 행의 값을 현재 기준으로 
      - LEAD(컬럼) ODVER(정렬기준) : 다음 행의 값을 현재 기준으로 
*/

SELECT 
  EMP_NAME, SALARY,
  LAG(SALARY) OVER(ORDER BY SALARY DESC),
  LEAD(SALARY) OVER(ORDER BY SALARY DESC)
FROM EMPLOYEE;
-- 행 간의 데이터를 비교하거나 변화하는 걸 분석하고자 할 때

-- 이전 사원과의 급여 차이 조회
SELECT 
 EMP_NAME, SALARY, LAG(SALARY) OVER(ORDER BY SALARY DESC),
 SALARY - LAG(SALARY) OVER(ORDER BY SALARY DESC)
FROM EMPLOYEE;
 
-- 다음 사원과의 급여 차이 조회
SELECT EMP_NAME, SALARY, LEAD(SALARY) OVER(ORDER BY SALARY DESC),
 SALARY - LEAD(SALARY) OVER(ORDER BY SALARY DESC)
FROM EMPLOYEE;

-- 페이징 처리(기존 방식) 1. 인라인뷰 들어가기 2. ROWNUM 부여 3. WHERE로 자르기
SELECT ROWNUM, E.*
FROM (SELECT * FROM EMPLOYEE) E
WHERE ROWNUM <= 10;
-- 1페이지
SELECT *
FROM (SELECT ROWNUM NUM, E.*
FROM (SELECT * FROM EMPLOYEE) E
WHERE ROWNUM <= 20)
WHERE NUM >= 11;
-- 2페이지 (1페이지 복사해서 다시 FROM에 붙이고 NUM값 추가)

-- 오라클 이전 버전 X
SELECT *
FROM EMPLOYEE
OFFSET 10 ROWS FETCH NEXT 5 ROWS ONLY;
