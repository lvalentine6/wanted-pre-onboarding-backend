# 원티드 프리온보딩 백엔드 인턴십 - 선발 과제

## 지원자 정보

- **성명**: 이승로
- **과제 제출일**: 2023.08.16

## 애플리케이션 실행 방법

### 로컬 환경

1. ```https://github.com/lvalentine6/wanted-pre-onboarding-backend.git``` 를 로컬에 clone 
2. docker-compose 설치 및 실행
3. 프로젝트 최상단 경로에서 mac인 경우 터미널에서 ```chmod +x docker-compose-up.sh``` windows인 경우 powershell에서 ```Set-ExecutionPolicy RemoteSigned -Scope CurrentUser``` 
4. ./docker-compose-up.sh 실행
5. localhost:8080/ 접속
6. [Postman document](https://documenter.getpostman.com/view/27692641/2s9Y5R1RPN)를 참조하여 api 테스트 진행
7. 터미널에서 ```docker-compose down -v``` 명령어로 애플리케이션 종료 

### 배포 환경

1. [배포 링크](http://43.202.12.122:8080) 접속
2. [Postman document](https://documenter.getpostman.com/view/27692641/2s9Y5R1RPN)를 참조하여 api 테스트 진행

## 인프라 구조

![wanted-infra](https://github.com/lvalentine6/wanted-pre-onboarding-backend/assets/77956808/64a899da-e786-495d-8ae0-d63249a79599)

## 데이터베이스 테이블 구조

![스크린샷 2023-08-16 234919](https://github.com/lvalentine6/wanted-pre-onboarding-backend/assets/77956808/eb137f52-de93-4e03-8d64-02a640f6bd28)

## 데모 영상

[여기](https://youtu.be/_Qfbih-SZm8)에서 데모 영상을 확인할 수 있습니다.

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
