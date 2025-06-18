/*
   LIMIT 
     - ODRDER BY 절보다 뒤에 조건을 걸고 싶을 때 사용
     - 출력되는 향의 수를 제한하는 MySQL 전용 비표준 구문
     - 데이터 양을 제한하고자 할 때 유용 (페이징 처리)
*/

SELECT * 
FROM actor
ORDER BY first_name;
LIMIT 0, 10; 
LIMIT 10 OFFSET 20;-

/*
  CONCAT(컬럼, 컬럼, ...)
     - 문자열을 하나로 합친 후 결과 반환(검색 기능 - like, %)
*/

SELECT CONCAT(title, description, special_features) FROM film;
/*
  날짜 처리 함수
    - 문자열을 하나로 합친 후 결과 반환(검색 기능 - like, %)
  NOW() CURRENT_TIMESTAMP() : 현재 날짜와 시간 반환
  CURDATE(), CURRENT_DATE() : 현재 날짜 반환 
  CURTIME(), CURRENT_TIME() : 현재 시간 반
*/
SELECT NOW();

/*
  YEAR(날짜), MONTH(날짜), DAY(날짜)
  HOUR(날짜), MINUTE(날짜), SECOND(날짜)
*/

/*
  포맷 함수
  FORMAT (숫자, 위치) : 숫자에 3단위만큼 콤마 추가해서 반환alter
  DAETE-FORMAT(날짜, 포맷형식) : 잘ㄹ짜 형식을 변경해서 사용
*/

SELECT
    FORMAT(amount, 2),
    DATE_FORMAT(payment_date, '%Y년 %m월 %d일 %H시 %i분 %s초'),
    DATE_FORMAT(last_update, '%Y.%m.%d.%T')
FROM payment;

/*
  null 처리 함수 
  IFNULL | COALESCE(값, 값이 null일 경우 반환값)
*/

SELECT address, address2, IFNULL(address2, '주소없음') FROM address;

/*
  IF(값1, 값2, 값3) | IF(조건, 조건 True인 경우. 저간 false 경우)
   - 값 1이 null 이 아니면 값 2 반환, null이면 값 3 반환
   조건에 해당되면 두번째 값 번환, 해당되지 않으면 마지막 값 반환
*/

SELECT 
    address2,
    IF(address2 IS NOT NULL AND address2 != '', '주소있음', '주소없음'),
    address,
    IF(address LIKE '1%', '해당값 true', 'false')
FROM address;


