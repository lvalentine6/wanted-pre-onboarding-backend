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

## API 명세

### 과제 1. 사용자 회원가입 엔드포인트

| Endpoint               | Method   | Request (json)                                                                     | Response (json)                                                                                    |
|------------------------|----------|------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------|
| `/join`                | `POST`   | {<br/> "email": "user@email.com",<br/> "password": "password123"<br/> }            | { "code": 200, "message": "User successfully registered" }                                         |
| `/login`               | `POST`   | {<br/> "email": "user@email.com",<br/> "password": "password123"<br/> }            | { "code": 200, "token": "access_token_here" }                                                      |
| `/articles`            | `GET`    |                                                                                    | { "code": 200, "data": [ { "articleId": 1, "title": "Article1", "contents": "Contents1" }, ... ] } |
| `/article`             | `POST`   | {<br/> "title": "New Article",<br/> "contents": "Article contents here"<br/> }     | { "code": 201, "message": "Article successfully created" }                                         |
| `/article/{articleId}` | `GET`    |                                                                                    | { "code": 200, "data": { "articleId": 1, "title": "Article1", "contents": "Contents1" } }          |
| `/article/{articleId}` | `PUT`    | {<br/> "title": "Updated Article",<br/> "contents": "Updated contents here"<br/> } | { "code": 200, "message": "Article successfully updated" }                                         |
| `/article/{articleId}` | `DELETE` |                                                                                    | { "code": 200, "message": "Article successfully deleted" }                                         |

---
