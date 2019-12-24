# 12 - 클래스 필드와 클래스 메서드의 한계

## 학습 목표
- 지난 시간에 이어서 클래스를 패키지로 분류한다.
- 클래스 필드와 클래스 메서드의 한계를 이해한다.
- 보드의 수를 늘리고 싶다면?

## 실습 소스 및 결과
- gomgugu.njp.tvlist.domain 패키지 추가 
- src/main/java/gomgugu/njp/tvlist/domain/Show.java 변경
- src/main/java/gomgugu/njp/tvlist/domain/Member.java 변경
- src/main/java/gomgugu/njp/tvlist/domain/Board.java 변경
- src/main/java/gomgugu/njp/tvlist/domain/App.java 변경
- BoardHandler2.java 추가
- App.java 변경

## 실습

### 작업1) 데이터 타입 클래스를 별도의 패키지로 분류하라.

- 도메인 패키지 생성
    - `com.eomcs.lms.domain` 패키지 생성
- 도메인 클래스를 `domain` 패키지로 이동
    - `Lesson`, `Member`, `Board` 클래스를 `com.eomcs.lms.domain` 패키지로 옮긴다.
    - 다른 패키지에서 변수에 접근할 수 있도록 접근 제어를 `public` 으로 변경****
- 핸들러 클래스에 import 문 추가
    - `LessonHandler`, `MemberHandler`, `BoardHandler` 클래스를 변경한다.


### 작업2) 새 게시판을 추가하라.

- BoardHandler2.java
    - `/board2/add`, `/board2/list` 명령을 처리할 클래스를 추가한다.
- App.java
    - 새 명령을 처리하는 코드를 추가한다. import문 추가 및 키보드객체 설정 문구 추가

실행 결과:

```
명령> /board2/add
번호? 1
내용? 게시글1
저장하였습니다.

명령> /board2/add
번호? 2
내용? 게시글2
저장하였습니다.

명령> /board/add
번호? 100
내용? 게시글100
저장하였습니다.

명령> /board2/list
1, 게시글1                  , 2019-01-01, 0
2, 게시글2                  , 2019-01-01, 0

명령> /board/list
100, 게시글100              , 2019-01-01, 0
```

### 작업3) BoardHander와 BoardHander2에 /board/detail 명령어 추가하기  

- BoardHandler2.java
    - `/board2/add`, `/board2/list` 명령을 처리할 detailBoard()를 추가한다.
- App.java
    -  /board/detail 새 명령을 처리하는 코드를 추가한다.