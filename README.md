# 원티드 프리온보딩 백엔드 인턴십 - 선발 과제

## 지원자 정보

- **성명**: 이승로
- **과제 제출일**: 2023.08.16

## 애플리케이션 실행 방법

### 로컬 환경

1. [git 주소](https://github.com/lvalentine6/wanted-pre-onboarding-backend.git)를 로컬에 clone
2. docker-compose 설치 및 실행
3. 터미널 실행 후 프로젝트 최상단 디렉터리에서 ./docker-compose-up.sh 실행
4. localhost:8080/ 접속
5. API 명세서를 참고하여 [Postman](https://www.postman.com/) 과 같은 툴로 api 테스트 진행

### 배포 환경

1. [배포 링크](http://43.202.12.122:8080) 접속
2. API 명세서를 참고하여 [Postman](https://www.postman.com/) 과 같은 툴로 api 테스트 진행

## 인프라 구조

## 데이터베이스 테이블 구조

- **테이블1**:
    - 컬럼1: 설명
    - 컬럼2: 설명
    - ...

- **테이블2**:
  ...

## 데모 영상

[여기](링크를 입력해주세요)에서 데모 영상을 확인할 수 있습니다.

## 구현 방법 및 이유

- **과제 1**: [과제 1에 대한 구현 방법 및 이유를 설명]
- ...

## API 목록

| Endpoint               | Method | Request                                                                                                                          | Response                                                                                                                                                                |
|------------------------|--------|----------------------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `/join`                | POST   | email: user@email.com<br>password: password123                                                                                   | code: 200<br>message: "The request has been processed successfully"<br>data: { ... }<br>success: true                                                                   |
| `/login`               | POST   | email: user@email.com<br>password: password123                                                                                   | code: 200<br>message: "The request has been processed successfully"<br>data: { ... <br>bearerToken: "..."}<br>success: true                                             |
| `/articles?page=0`     | GET    |                                                                                                                                  | code: 200<br>message: "The request has been processed successfully"<br>data: [ { "articleId": 1, "title": "Article1", "contents": "Contents1" }, ... ]<br>success: true |
| `/article`             | POST   | title: "New Article"<br>contents: "Article contents here"                                                                        | code: 200<br>message: "The request has been processed successfully"<br>success: true                                                                                    |
| `/article/{articleId}` | GET    |                                                                                                                                  | code: 200<br>message: "The request has been processed successfully"<br>data: { "articleId": 1, "title": "Article1", "contents": "Contents1" }<br>success: true          |
| `/article/{articleId}` | PUT    | HttpHeader {<br>bearerToken: "..."<br>}<br><br>HttpBody { <br>title: "Updated Article"<br>contents: "Updated contents here"<br>} | code: 200<br>message: "The request has been processed successfully"<br>success: true                                                                                    |
| `/article/{articleId}` | DELETE | HttpHeader {<br>bearerToken: "..."<br>}<br><br>                                                                                  | code: 200<br>message: "The request has been processed successfully"<br>success: true                                                                                    |

---
