-- 내부 조인 리뷰
-- 내부 조인: DEPARTMENT와 EMPLOYEE에 모두 존재하는 데이터
SELECT E.EMP_NO, E.NAME, D.DEPT_NAME, D.LOCATION
FROM DEPARTMENT D, EMPLOYEE E
WHERE D.DEPT_NO = E.DEPARTMENT;

-- 외부 조인
-- 1. LEFT OUTER JOIN: 왼쪽 테이블의 정보는 모두 포함, 오른쪽 테이블의 정보는 일치하는 정보만 포함
-- 2. RIGHT OUTER JOIN: 오른쪽 테이블의 정보는 모두 포함, 왼쪽 테이블의 정보는 일치하는 정보만 포함

-- 부서를 아직 배정 받지 않은 직원 1명 추가
INSERT INTO EMPLOYEE
VALUES (1005, '김미나', '사원', 'F', 2500000, SYSDATE, NULL);

-- 모든 직원의 사원번호(EMP_NO), 이름(NAME), 부서명(DEPT_NAME)을 조회하시오.
SELECT E.EMP_NO, E.NAME, D.DEPT_NAME
FROM DEPARTMENT D RIGHT OUTER JOIN EMPLOYEE E
ON D.DEPT_NO = E.DEPARTMENT;

SELECT E.EMP_NO, E.NAME, D.DEPT_NAME
FROM DEPARTMENT D, EMPLOYEE E
WHERE D.DEPT_NO(+) = E.DEPARTMENT;  -- 오른쪽 외부 조인: 반대(왼쪽) 방향에 '(+)'를 추가한다.
