/*
  함수 : 컬럼값을 읽어서 가공된 값을 반환
  
  - 단일행 함수 : N개의 값을 받아서 N개의 결과 반환
  - 그룹 함수 : N개의 값을 받아서 1개의 결과 반환 
  
  >> 단일행 함수와 그룹 함수는 SELECT절에서 함께 사용할 수 없음!
  >> 함수를 사용할 수 있는 위치 : SELECT, WHERE, ORDER BY, GROUP BY, HAVING 
*/
-- 1. 단일행 함수
/*
  문자 처리 함수 
  
  LENGTH : 문자 수 반환
  - 한글 1글자 : 1개로 인식 
  - 영문자/숫자/특수문자 : 1개로 인식
  LENGTHB : 바이트 수 반환
  - 한글 '한' : 3개로 인식
  - 영문자/숫자/특수문자 : 1개로 인식
*/
SELECT
LENGTH('데이터베이스'), LENGTHB('데이터베이스'),
LENGTH('database'), LENGTHB('database')
FROM DUAL;

/*
  INSTR(컬럼, 찾을문자, 시작위치, 몇번째)
  - 특정 문자가 몇 번째 위치하는지 반환 
  - 없으면 0 반환
  - 시작위치 : 1(앞에서부터)  -1(뒤에서부터) 
*/
SELECT
 INSTR('AABAACAABBAA', 'B', -1, 2), 
 -- 뒤에서부터 2번째에 있는 B를 찾는 함수(숫자는 앞에서부터 세아림)
 INSTR('AABAACAABBAA', 'D')
FROM DUAL;
--USER_INFO에서 각 전화번호(CONTACT)에서 앞에서부터 5가 들어간 위치 조회
SELECT CONTACT, INSTR(CONTACT, 5) 
FROM USER_INFO;
--EMPLOYEE에서 's'가 포함되어 있는 이메일 중 @위치 조회
SELECT EMAIL, INSTR(EMAIL, '@') 
FROM EMPLOYEE
WHERE EMAIL LIKE '%s%';

/*
  LPAD / RPAD (컬럼, 최종적으로 반환할 문자의 길이, 덧붙이고자 하는 문자)
   - 문자열 조회 시 통일감있게 조회하고자 할 때 사용
*/
SELECT
 LPAD('HELLO', 10), LPAD('HELLO', 10, 'A'),
 RPAD('HELLO', 10), RPAD('HELLO', 10, 'A')
 FROM DUAL; 

/*
  LTRIM / RTRIM (컬럼, 제거하고자 하는 문자들)
   - 문자열에서 특정 문자를 제거한 나머지를 반환 
*/
SELECT
 LTRIM('      K H     '), -- 왼쪽 공백 제거 
 LTRIM('ACBAACCCKH', 'ABC'), --왼쪽에서 ABC에 해당되는 문자들 모두 제거 
 RTRIM('46548518KH54568', '0123456789') -- 오른쪽에서부터 숫자들 제거
FROM DUAL;

/*
  TRIM(LEADING|TRAILING|BOTH 제거하고자 하는 문자들 FROM 컬럼)
   - 문자열의 양쪽(앞/뒤)에 있는 지정한 문자들을 제거한 나머지 문자열 반환  
*/
SELECT 
  TRIM(LEADING 'Z' FROM 'ZZZKHZZZ'), -- LTRIM
  TRIM(TRAILING 'Z' FROM 'ZZZKHZZZ'), -- RTRIM
  TRIM(BOTH 'Z' FROM 'ZZZKHZZZ'), --양쪽 모두 제거 
  TRIM('          KH          ')
FROM DUAL;

/*
  SUBSTR(컬럼, 시작위치, 추출위치) 
   - 문자열에서 특정 부분을 잘라서 추출
*/
SELECT
 SUBSTR('PROGRAMMING', 5, 2),
 SUBSTR('PROGRAMMING', 1, 6),
 SUBSTR('PROGRAMMING', -8, 3)
 FROM DUAL;
 
--USER_INFO에서 전화번호(CONTACT)에서 가운데 번호 4자리만 조회 
SELECT 
 CONTACT, 
 INSTR(CONTACT, '-') + 1,
 SUBSTR(CONTACT, INSTR(CONTACT, '-') + 1, 4)
FROM USER_INFO;

--EMPLOYEE에서 이메일에서 아이디만 (@ 앞에) 조회
--SELECT RTRIM(EMAIL, '@kh.or.kr')
SELECT EMAIL, 
INSTR(EMAIL, '@'), 
SUBSTR(EMAIL, 1, INSTR(EMAIL, '@')-1)
FROM EMPLOYEE;
-- REPLACE 사용한 다른 해답
SELECT EMAIL, REPLACE(EMAIL, '@kh.or.kr', '')
FROM EMPLOYEE;

--주민등록번호(EMP_NO)를 000000-0******로 조회
-- 000000-0 <- 자르면! SUBSTR 사용해서 

SELECT EMP_NO,
INSTR(EMP_NO, '-')+1,
SUBSTR(EMP_NO, 1, INSTR(EMP_NO, '-') + 1),
RPAD(SUBSTR(EMP_NO, 1, INSTR(EMP_NO, '-') + 1), 14, '*'),
SUBSTR(EMP_NO, 1, 8)||'******'
FROM EMPLOYEE;

/*SELECT 
    EMP_NO, 
    RPAD(SUBSTR(EMP_NO, 1, INSTR(EMP_NO, '-') + 1), 14, '*'),
    SUBSTR(EMP_NO, 1, 8) || '******',
    SUBSTR(EMP_NO, 1, INSTR(EMP_NO, '-') + 1), 
    INSTR(EMP_NO, '-') + 1
FROM EMPLOYEE;
*/

--REPLACE 사용한 다른 답변
SELECT EMP_NO, REPLACE(EMP_NO, SUBSTR(EMP_NO, -6, 6), '******')
FROM EMPLOYEE;

--남자 사원만 조회 
SELECT EMP_NO, 
INSTR(EMP_NO, '-') + 1,
SUBSTR(EMP_NO, INSTR(EMP_NO, '-') + 1, 1)
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, INSTR(EMP_NO, '-') + 1, 1) = 1;

/*
    LOWER : 다 소문자로 변경
    UPPER : 다 대문자로 변경
*/

SELECT LOWER('Welcome'), UPPER('Welcome')
FROM DUAL;

/*
  CONCAT(문자열, 문자열)
   - 문자열 두개 전달받아 하나로 합친 후 결과 반환(세개는 두번 연결해야함)
*/

SELECT CONCAT('가나다라', '1234')
FROM DUAL;
--SELECT '가나다라' || '1234' 
--FROM DUAL;
SELECT CONCAT(CONCAT('가나다라', 'ABCD'),'1234')
FROM DUAL;

/*
   REPALCE(컬럼, 바꾸고 싶은 문자열, 바꿀 문자열)
    - 특정 문자열 변경
*/

SELECT REPLACE('서울시 강남구 역삼동', '역삼동', '삼성동') 
FROM DUAL;
--USER_INFO에서 서울이신 분들을 모두 경기로 바꾸기
SELECT ADDRESS,
REPLACE(ADDRESS, '서울', '경기')
FROM USER_INFO;
-- EMPLOYEE에서 사원들의 이메일 kh.or.kr을 gmail.com으로 바꾸기
SELECT EMAIL, 
REPLACE(EMAIL, 'kh.or.kr', 'gmail.com')
FROM EMPLOYEE;

/*
   숫자 처리 함수 
   
   ABS : 절대값 반환
   MOD(숫자, 숫자) : 두 수를 나눈 나머지 값 반환 
   CEIL : 올림
   FLOOR : 내림

*/
SELECT ABS(5.7), ABS(-10), MOD(10, 3), CEIL(8.8), FLOOR(8.8)
FROM DUAL;

/*
   ROUND(숫자, 위치) : 반올림한 결과 반환
*/
SELECT ROUND(123.456),-- 위치 생략 시 0 
       ROUND(123.456, 1), -- 소숫점 첫째자리까지
       ROUND(123.456, -2) -- 100의 자리까지       
FROM DUAL;

/*
   TRUNC(숫자, 위치) : 위치 지정하여 버림 처리 (FLOOR랑 비슷하지만 위치 지정가능)
*/
SELECT TRUNC(123.952), -- 위치 생략 시 소숫점 다 버림 123
       TRUNC(123.952, 1), -- 소숫점 첫째자리까지 버림 123.9
       TRUNC(123.952, 0)
FROM DUAL;

/*
    날짜 처리 함수 
    SYSDATE : 시스템의 날짜를 반환 (현재 날짜)
    
*/

SELECT SYSDATE FROM DUAL;
-- 날짜 포맷 변경
ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD HH:MI:SS';
ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD';
ALTER SESSION SET NLS_DATE_FORMAT = 'DD/MM/YY'; --원래 포맷

/*
  MONTHS_BETWEEN(날짜, 날짜) 
   - 입력받은 두 달짜 사이의 개월 수 반환
*/

SELECT FLOOR(MONTHS_BETWEEN('20251216', SYSDATE)) FROM DUAL; -- 1달

--USER_INFO에서 몇개월생인지 조회 (BIRTHDATE)
SELECT BIRTHDATE, FLOOR(MONTHS_BETWEEN(SYSDATE, BIRTHDATE))
FROM USER_INFO;

/*
   ADD_MONTHS(날짜, 숫자) 
    - 특정 날짜에 입력받는 숫자만큼 개월수를 더한 날짜 반환
*/

SELECT ADD_MONTHS(SYSDATE, 6) FROM DUAL;

-- USER_INFO에서 해당 태어난 날짜로부터 20년이 지났을 경우
SELECT BIRTHDATE,
ADD_MONTHS(BIRTHDATE, 240)
FROM USER_INFO;

/*
   NEXT_DAY(날짜, 요일(문자/숫자))
    - 특정 날짜에서 구하려는 요일의 가장 가까운 날짜 리턴
    - 요일 1-일요일, 2-월요일, 3-화요일 ... 7-토요일 
*/

SELECT SYSDATE, NEXT_DAY(SYSDATE, 'MONDAY')FROM DUAL;
SELECT SYSDATE, NEXT_DAY(SYSDATE, '월요일') FROM DUAL;
SELECT SYSDATE, NEXT_DAY(SYSDATE, '금') FROM DUAL;
SELECT SYSDATE, NEXT_DAY(SYSDATE, 1) FROM DUAL;

--언어변경
ALTER SESSION SET NLS_LANGUAGE = AMERICAN;
ALTER SESSION SET NLS_LANGUAGE = KOREAN;

/*
   LAST_DAY (날짜)
     - 해당 월의 마지막 날짜 반환
*/

SELECT LAST_DAY(SYSDATE), LAST_DAY('20250815'), LAST_DAY('2025/12/25') 
FROM DUAL; 

/*
   EXTRACT(YEAR|MONTH|DAY FROM 날짜)
     - 특정 날짜에서 연도, 월, 일 정보를 추출
*/

-- USER_INFO에서 BIRTHDATE로 연도, 월, 일 따로 조회
SELECT BIRTHDATE, 
EXTRACT(YEAR FROM BIRTHDATE) 연도,
EXTRACT(MONTH FROM BIRTHDATE) 월,
EXTRACT(DAY FROM BIRTHDATE) 일
FROM USER_INFO;

/*
   TO_CHAR(날짜|숫자, 포맷)
    - 날짜 또는 숫자형 데이터를 문자 타입으로 변환
*/
SELECT TO_CHAR(1234, 'L99999') FROM DUAL; -- 현재 설정된 화폐단위에 따라 달라짐
ALTER SESSION SET NLS_CURRENCY = '$';

--EMPLOYEE에서 연봉을 TO_CHAR를 이용해서 조회 (,)
SELECT TO_CHAR(SALARY*12, '999,999,999') 연봉
FROM EMPLOYEE
ORDER BY 연봉; -- 별칭으로도 정렬 가능

-- 날짜 -> 문자 
SELECT 
  TO_CHAR(SYSDATE, 'RRRR'), --년 RR, YY, RRRR, YYYY, YEAR(영어식, 잘안씀)
  TO_CHAR(SYSDATE, 'MM'), --월 MM, MON, MONTH, RM(잘안씀)
  TO_CHAR(SYSDATE, 'DD'), --일 D(주단위) DD(월단위) DDD(년기준)
  TO_CHAR(SYSDATE, 'DY'),  --요일 DY(한글자: 수) DAY (세글자:수요일)
  TO_CHAR(SYSDATE, 'PM HH:MI:SS'),-- 시분초 
  TO_CHAR(SYSDATE, 'AM HH24:MI:SS') -- AM이지만 HH를 24시간으로 봄
FROM DUAL;

-- BIRTHDATE를 '2025년 06월 04일 수요일' 포맷으로 조회
SELECT 
TO_CHAR(BIRTHDATE, 'RRRR')
|| '년',
TO_CHAR(BIRTHDATE, 'MM')
|| '월',
TO_CHAR(BIRTHDATE, 'DD')
|| '일',
TO_CHAR(BIRTHDATE, 'DAY')
FROM USER_INFO;

SELECT TO_CHAR(BIRTHDATE, 'YYYY"년" MM"월" DD"일" DAY')
FROM USER_INFO;

/*
   TO_DATE(숫자|문자, 포맷)
     - 숫자 또는 문자형 데이터를 날짜타입으로 변환
*/
SELECT TO_DATE(20250604) FROM DUAL;
SELECT TO_DATE(20250604164230, 'YYYY-MM-DD HH24:MI:SS') FROM DUAL; 

SELECT TO_DATE('20250604') FROM DUAL;
SELECT TO_DATE('20250604164230', 'YYYY-MM-DD HH24:MI:SS' ) FROM DUAL;

/*
   TO_NUMBER(문자, 포맷) 
     - 문자형 데이터를 숫자 타입으로 변환
*/

SELECT '100000' + '550000' FROM DUAL;
SELECT TO_NUMBER('100,000', '999,999')
    + TO_NUMBER('550,000', '999,999')
FROM DUAL;

/*
    NULL 처리 함수
    
    NVL/COALESCE(값1, 값2)
      - 값1이 NULL이 아니면 값1을 반환하고, 값1이 NULL이면 값2를 반환
*/
--USER_INFO MBTI가 NULL인 경우 'MBTI 모름' 처리 
SELECT NVL(MBTI, 'MBTI 모름')
FROM USER_INFO;
-- COALESCE(값1, 값2, 값3 ...) 여러가지의 값이 들어올 수 있음
-- MBTI가 NULL이 아니면 MBTI, NULL 이면 HOBBY, 이것도 NULL이면 '모름'
SELECT COALESCE(MBTI, HOBBY, '모름')
FROM USER_INFO;

/*
   NVL2(값1, 값2, 값3) 
     - 값1이 NULL이 아니면 값2, NULL 이면 값3
*/
--EMPLOYEE에서 부서코드(DEPT_CODE)가 있으면 '부서있음' 없으면 '부서없음'
SELECT NVL2(DEPT_CODE, '부서있음', '부서없음') 
FROM EMPLOYEE;

/*
    NULLIF(값1, 값2)
      - 두 개의 값이 동일하면 NULL, 동일하지 않으면 값1
*/

SELECT NULLIF('123', '123'), NULLIF('123', '456')
FROM DUAL;

/*
    선택함수 : 여러가지 경우에 선택할 수 있는 기능을 제공
    
    DECODE(값, 조건값1, 결과값1, 조건값2, 결과값2, ... )
    비교하고자하는 값과 조건값과 일치하는 경우 그에 해당하는 결과값 반환
    
    CASE WHEN 조건식1 THEN 결과값1
         WHEN 조건식2 THEN 결과값2 ...
         ELSE 결과값N 
    END(Swithch+if 섞은 듯한 느낌)
    
*/
 
--EMPLOYEE에서 주민번호(EMP_NO)로 성별(남, 여) 조회
SELECT 
  SUBSTR(EMP_NO, 8, 1),
  DECODE(SUBSTR(EMP_NO, 8, 1), 1, '남', 2, '여')
FROM EMPLOYEE;

SELECT
 EMP_NAME, EMP_NO,
 CASE WHEN SUBSTR(EMP_NO, 8, 1) = 1 THEN '남'
      WHEN SUBSTR(EMP_NO, 8, 1) = 2 THEN '여'
 END
 FROM EMPLOYEE;

-- 직급 코드가 J7인 사원은 급여를 10% 인상
-- 직급 코드가 J6인 사원은 급여를 15% 인상
-- 직급 코드가 J5인 사원은 급여를 20% 인상
-- 그 외 직급 사원은 급여를 5% 인상
-- 정렬: 직급코드(JOB_CODE) J1부터, 인상된 급여 높은 순서대로

SELECT 
JOB_CODE, SALARY, 
DECODE(JOB_CODE, 'J5', SALARY * 1.2, 
                 'J6', SALARY * 1.15, 
                 'J7', SALARY * 1.1, SALARY * 1.05) "인상급여"
FROM EMPLOYEE
ORDER BY JOB_CODE, "인상급여" DESC;

SELECT
  CASE JOB_CODE 
    WHEN 'J7' THEN SALARY*1.
    WHEN 'J6' THEN SALARY*1.15
    WHEN 'J5' THEN SALARY*1.2
    ELSE SALARY*1.05
  END
FROM EMPLOYEE;

-- 급여가 500만원 초과일 경우 1등급
-- 급여가 500만원 이하 350만원 초과일경우 2등급
-- 급여가 350만원 이하 200만원 초과일경우 3등급
-- 그 외의 경우 4등급

SELECT 
SALARY,
 CASE WHEN SALARY > 5000000 THEN '1등급' 
     WHEN SALARY>3500000 THEN '2등급'
     WHEN SALARY>2000000 THEN '3등급'
     ELSE '4등급'
 END
FROM EMPLOYEE;

/*
    그룹함수 -> 결과값 1개(단일행 함수와의 차이, 함께 사용하지 못하는 이유)
      - 대량의 데이터들로 집꼐나 통계 같은 작업을 처리해야하는 경우
      - 모든 그룹 함수는 NULL값을 자동으로 제외하고 값이 있는 것들만 계산
*/

--SUM : 해당 컬럼 값들의 총 합계 

--USER_INFO 나이 모두 더한 값 
SELECT
SUM(AGE)
FROM USER_INFO;

--EMPLOYEE 에서 부서코드가 D5인 사원들의 총 연봉 조회
SELECT SUM(SALARY * 12)
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5';

SELECT 
SUM(DECODE(DEPT_CODE, 'D5', SALARY * 12, 0))
FROM EMPLOYEE; 

SELECT
SUM(CASE WHEN DEPT_CODE = 'D5' THEN SALARY * 12 ELSE 0 END)
FROM EMPLOYEE; 

/*SELECT 위와 같은 결과값을 가져옴
SUM(CASE DEPT_CODE WHEN 'D5' THEN SALARY * 12 ELSE 0 END)
FROM EMPLOYEE; 
*/ 

/*
     AVG 
      - 해당 컬럼값들의 평균값
      - 모든 그룹 함수는 NULL값을 자동으로 제외하기 때문에 NVL 함수랑 함께 사용 권장
*/

--USER_INFO 에서 평균나이
SELECT FLOOR(AVG(CASE WHEN AGE<100 THEN AGE END))
FROM USER_INFO;
--EMPLOYEE에서 평균 보너스값
SELECT AVG( NVL(BONUS, 0))
FROM EMPLOYEE;

/*
    MIN : 해당 컬럼 값들 중에 가장 작은 값
    MAX : 해당 컬럼 값들 중에 가장 큰 값
*/

--EMPLOYEE에서 MIN, MAX, 전부 사용해서 
--사원명(EMP_NAME), 급여(SALARY), 입사일(HIRE_DATE)

SELECT MIN(EMP_NAME), MIN(SALARY), MIN(HIRE_DATE),
MAX(EMP_NAME), MAX(SALARY), MAX(HIRE_DATE)
FROM EMPLOYEE;

/*
   COUNT : 가장 많이 사용, 컬럼 또는 행의 개수를 세서 변환
    - * : 조회 결과에 해당하는 모든 행의 개수 반환
    - 컬럼 : 해당 컬럼값이 NULL이 아닌 행 개수 반환
    - DISTINCT 컬럼 : 해당 컬럼값의 중복을 제거한 행 개수 반환
*/

--USER_INFO 전체 사람 수
SELECT COUNT(USER_ID)
FROM USER_INFO;

SELECT COUNT(*)
FROM USER_INFO;

--서울에 사는 사람 수만 조회
SELECT COUNT(*)
FROM USER_INFO
WHERE ADDRESS LIKE '%서울%';

SELECT COUNT(CASE WHEN ADDRESS LIKE '%서울%' THEN 1 END)
FROM USER_INFO;

--EMPLOYEE 보너스를 받은 사원의 수 조회
SELECT COUNT(BONUS)
FROM EMPLOYEE;

SELECT COUNT(*)
FROM EMPLOYEE
WHERE BONUS IS NOT NULL;

--부서가 배치된 사원 수 조회
SELECT COUNT(DEPT_CODE)
FROM EMPLOYEE; 

--현재 사원들이 속해있는 부서 수 조회
SELECT COUNT(DISTINCT DEPT_CODE)
FROM EMPLOYEE; 

/*
     집계 함수 
      - 그룹별 산출한 결과 값의 중간 집계를 계산해주는 함수
      - ROLLUP(컬럼1, 컬럼2) : 컬럼 1을 가지고 다시 중간집계를 내는 함수 
      - CUBE(컬럼1, 컬럼2) : 컬럼 1을 가지고 중간집계도 내고, 
                            컬럼 2를 가지고 중간집계를 또 내는 함수  
*/
--EMPLOYEE에서 직급별 급여 평균
SELECT JOB_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY JOB_CODE;

--ROLLUP 전체 합계까지 추산(맨아래)
SELECT JOB_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY ROLLUP(JOB_CODE);

--CUBE 전체 합계까지 추산(맨위), 컬럼 하나일때는 ROLLUP과 CUBE 차이 없음
SELECT JOB_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY CUBE(JOB_CODE);

-- 부서코드와 직급코드가 같은 사원들의 급여 합계
SELECT JOB_CODE, DEPT_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY JOB_CODE, DEPT_CODE;

--ROLLUP: DEPT_CODE 기준으로만 합계 추가
SELECT JOB_CODE, DEPT_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY ROLLUP(JOB_CODE, DEPT_CODE);

SELECT JOB_CODE, DEPT_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY CUBE(JOB_CODE, DEPT_CODE);

/*
     GROUPING
      - ROLLUP이나 CUBE에 의해 산출된 값이 해당 컬럼 집합의 산출물이면
        0을 반환, 아니면 1을 반환하는 함수      
*/

SELECT JOB_CODE, DEPT_CODE, SUM(SALARY),
       GROUPING(DEPT_CODE), GROUPING(JOB_CODE)
FROM EMPLOYEE
GROUP BY ROLLUP(JOB_CODE, DEPT_CODE);

SELECT JOB_CODE, DEPT_CODE, SUM(SALARY),
       GROUPING(DEPT_CODE), GROUPING(JOB_CODE)
FROM EMPLOYEE
GROUP BY CUBE(JOB_CODE, DEPT_CODE);

/*
     집합연산자
      - 여러 개의 쿼리문을 하나의 쿼리문으로 만드는 연산자
      - 여러 개의 쿼리문에서 조회하려고 하는 컬럼의 개수와 이름이 같아야 집합 연산자를
        사용할 수 있음.
        
      UNION(합집합): 두 쿼리문을 수행한 결과값을 하나로 합쳐서 추출 - 중복값 제거
      UNION ALL(합집합) : 두 쿼리문을 수행한 결과값을 하나로 합쳐서 추출 - 중복 포함
      INTERSECT(교집합): 두 쿼리문을 수행한 결과값을 중복된 결과값만 추출
      MINUS(차집합): 두 쿼리문을 수행한 결과값에서 후행 쿼리문의 결과값을 뺀 나머지 
                    결과값만 추출
*/

--부서코드가 D5인 사원들의 사번 사원명 부서코드 급여 조회
SELECT * FROM EMPLOYEE;
--1. UNION : 부서코드가 D5이거나 급여가 300만원 초과인 사원들 조회
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
UNION
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000;
-- 급여가 300만원 초과인 사원들의 사번, 사원명, 부서코드, 급여 조회

-- 위 쿼리문 대신 WHERE절에서  OR 연산자 사용해서도 처리 가능
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5' OR SALARY > 3000000;

--2. UNION ALL : 중복 (대북혼)
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
UNION ALL
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000;

--3. INTERSECT 
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
INTERSECT
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000;

-- 위 쿼리문 대신 WHERE절에서  AND 연산자 사용해서도 처리 가능
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5' AND SALARY > 3000000;

--4. MINUS
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
MINUS
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000;

-- 위 쿼리문 대신 WHERE절에서  AND 연산자 사용해서도 처리 가능
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5' AND SALARY <= 3000000;

/*
     GROUPING SETS
      - 그룹별로 처리된 여러개의 SELECT문을 하나로 합친 결과를 원할 때 사용
*/

--부서별, 직급별 사원수(UNION ALL)
SELECT DEPT_CODE, COUNT(*)
FROM EMPLOYEE
GROUP BY DEPT_CODE
UNION ALL
SELECT JOB_CODE, COUNT(*)
FROM EMPLOYEE
GROUP BY JOB_CODE;

--부서별, 직급별 사원수(GROUP BY 뒤에)
SELECT DEPT_CODE, JOB_CODE, COUNT(*)
FROM EMPLOYEE
GROUP BY GROUPING SETS(DEPT_CODE, JOB_CODE);



