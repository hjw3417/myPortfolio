# Who's the Best ⚽

아마추어 축구 동호회를 위한 팀 관리 / 경기 매칭 / 기록 관리 웹 서비스.
휴먼교육센터 3차 팀 프로젝트(팀명: **문주군단**) 결과물입니다.

---

## 프로젝트 개요

- **주제**: 축구 동호인을 위한 통합 관리 플랫폼
- **유형**: 팀 프로젝트 (3차)
- **기간**: 2024.06.21 ~ 2024.07.12 (약 3주)
- **패키징**: WAR (외장 Tomcat 배포 가능, 내장 Tomcat 실행도 지원)

사용자는 팀을 만들고 가입하며, 다른 팀과 경기를 잡고, 경기장을 예약하고,
경기 결과·기록을 남길 수 있습니다. 관리자는 회원/팀/경기 전반을 관리합니다.

---

## 주요 기능

### 일반 회원
- **회원 관리**: 회원가입, 로그인, 아이디/비밀번호 찾기, 마이페이지
- **팀**: 팀 생성, 팀 가입/탈퇴, 팀원 관리, 팀 프로필
- **경기**:
  - 경기 생성 및 상대팀 매칭
  - 경기장(구장) 목록 조회 및 예약
  - 경기 일정 / 결과 / 상세 정보
  - 경기 멤버(스쿼드) 구성, 경기 기록 입력
- **커뮤니티**: 게시판(글쓰기/수정/상세)
- **랭킹**: 팀별 전적 기반 랭킹
- **마이페이지**: 내 정보 수정, 내 경기 기록 조회

### 관리자
- 회원 목록 / 상세 / 관리
- 팀 목록 / 상세 / 관리
- 경기 목록 / 상세 / 관리

---

## 기술 스택

| 영역 | 사용 기술 |
|------|----------|
| Language | Java 17 |
| Framework | Spring Boot 3.2.6 (Web, JDBC) |
| Persistence | MyBatis 3.0.3, Oracle (ojdbc8) |
| View | JSP + JSTL 3.0 |
| Build | Gradle |
| Packaging | WAR (Tomcat embed-jasper) |
| Logging | Logback, log4jdbc-log4j2 |
| Util | Lombok, json-lib |
| DevTools | Spring Boot DevTools (LiveReload) |

---

## 프로젝트 구조

```
src/main/java/dc/human/whosthebest
├── WhosthebestApplication.java   # 부트 진입점
├── ServletInitializer.java       # WAR 배포용
├── PageController.java           # 단순 페이지 라우팅
├── DemoController.java
│
├── user/         # 회원 (controller / service / dao)
├── team/         # 팀
├── game/         # 경기 / 경기장 예약
├── aboutteam/    # 다른 팀 조회 (일정, 기록)
├── myPage/       # 마이페이지
├── main/         # 메인 / 게시판
├── admin/        # 관리자
└── vo/           # 도메인 VO (Game, Team, User, Board, Squad, Rank 등)

src/main/resources
├── application.properties
├── mappers/      # MyBatis XML (user, team, game, myPage, admin, main, aboutteam)
└── static/       # css, js, image

src/main/webapp/WEB-INF/views   # JSP 화면
├── user/         # 로그인, 회원가입, 아이디/비밀번호 찾기
├── team/         # 팀 생성, 팀 목록, 내 팀, 랭킹, 스케줄, 팀원
├── game/         # 경기 생성, 경기장 목록/예약, 경기 정보/결과
├── myPage/       # 마이페이지, 내 경기 기록, 정보 수정
├── main/         # 서비스 메인, 게시판
├── aboutteam/    # 타팀 일정 / 기록
└── admin/        # 관리자 대시보드 및 상세 화면
```

각 도메인은 **Controller(interface) → ControllerImpl → Service(interface) → ServiceImpl → DAO → MyBatis Mapper XML** 구조로 일관되게 분리되어 있습니다.

---

## 실행 방법

### 사전 요구사항
- JDK 17
- Oracle DB (XE 가능) — 스키마/데이터는 `문주군단 - 3차프로젝트(完)/8. 3차 DB - 문주군단(完).sql` 참고

### DB 설정
`src/main/resources/application.properties` 에서 본인 환경에 맞게 수정:

```properties
spring.datasource.url=jdbc:log4jdbc:oracle:thin:@<HOST>:1521:XE
spring.datasource.username=<USER>
spring.datasource.password=<PASSWORD>
spring.datasource.driver-class-name=net.sf.log4jdbc.sql.jdbcapi.DriverSpy
```

기본 서버 포트는 `8092`.

### 빌드 & 실행

```bash
# 실행 (개발)
./gradlew bootRun

# WAR 빌드
./gradlew bootWar
# → build/libs/whosthebest-0.0.1-SNAPSHOT.war
```

브라우저에서 `http://localhost:8092` 접속.

---

## 산출물

`문주군단 - 3차프로젝트(完)/` 디렉토리에 프로젝트 산출물이 포함되어 있습니다.

- 화면설계서 (초기 / 최종)
- 스토리보드
- UML 다이어그램 (관리자 / 일반회원)
- 테이블 정의서, DB 스크립트, 데이터 삽입 시트
- 소스 리스트, 테스트 시나리오
- 발표 자료
- 빌드된 WAR 파일

---

## 팀

**문주군단 (3차 프로젝트 팀)**
