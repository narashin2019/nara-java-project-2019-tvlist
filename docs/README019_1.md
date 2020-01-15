# 19 - CRUD(Create/Retrieve/Update/Delete) 기능 완성

## 오늘 배운 거 

- 데이터를 등록/조회/수정/삭제하는 기능(CRUD)을 구현할 수 있다.

## 실습 소스 및 결과

util/ArrayList.java 변경
handler/ShowHandler.java 변경
handler/MemberHandler.java 변경
handler/BoardHandler.java 변경
domain/Show.java 변경
domain/Member.java 변경
domain/Board.java 변경
App.java 변경

## 실습

### 작업1) ArrayList 클래스에 항목 값을 조회하고 변경하고 삭제하는 기능을 추가하라.

- ArrayList.java
  - 목록의 특정 위치에 저장된 항목을 꺼내주는 get()을 정의한다.
  - 목록의 특정 위치에 저장된 항목을 바꾸는 set()을 정의한다.
  - 목록의 특정 위치에 저장된 항목을 삭제하는 remove()를 정의한다.


### 작업2) 드라마 데이터의 상세조회, 변경, 삭제 기능을 추가하라.

- ShowHandler.java 
  - 상세조회 기능을 수행하는 detailShow()을 정의한다.
  - 변경 기능을 수행하는 updateShow()을 정의한다.
  - 삭제 기능을 수행하는 deleteShow()을 정의한다.
- App.java
  - 상세조회, 변경, 삭제 명령에 대한 분기문을 추가한다.

#### 실행 결과

```
명령> /show/list


명령> /show/detail
번호? 2
~ 출력

명령> /show/detail
번호? 20
해당 드라마을 찾을 수 없습니다.

명령> /show/update
번호? 2
한글제목(이전제목)? 
제목영문?  <=== 입력하지 않으면 기존 값 사용
~출력
드라마를 변경했습니다.

명령> /show/update
번호? 20
해당 드라마를 찾을 수 없습니다.

명령> /show/delete
번호? 2
드라마를 삭제했습니다.

명령> /show/delete
번호? 20
해당 드라마를 찾을 수 없습니다.
```

### 작업3) ShowHandler 코드를 리팩토링하라.

- ShowHandler.java
    - 저장된 목록에서 드라마 번호로 항목을 찾는 코드를 indexOfLesson() 메서드로 분리한다.
- Show.java
    - 인스턴스 복제를 할 수 있도록 java.lang.Cloneable 인터페이스를 구현한다.
    - clone()을 오버라이딩 한다.


### 작업4) 회원 데이터의 상세조회, 변경, 삭제 기능을 추가하라.

- MemberHandler.java
    - 상세조회 기능을 수행하는 detailMember()을 정의한다.
    - 변경 기능을 수행하는 updateMember()을 정의한다.
    - 삭제 기능을 수행하는 deleteMember()을 정의한다.
    - 저장된 목록에서 회원 번호로 항목을 찾는 indexOfMember()를 정의한다.
- Member.java
    - 인스턴스 복제를 할 수 있도록 java.lang.Cloneable 인터페이스를 구현한다.
    - clone()을 오버라이딩 한다.
- App.java
    - 상세조회, 변경, 삭제 명령에 대한 분기문을 추가한다.

#### 실행 결과

```
명령> /member/list
1, 홍길동 , hong@test.com       , 1111-2222      , 2019-01-01
2, 임꺽정 , lim@test.com        , 1111-2223      , 2019-01-01
3, 전봉준 , jeon@test.com       , 1111-2224      , 2019-01-01

명령> /member/detail
번호? 2
이름: 홍길동
이메일: hong@test.com
암호: 1111
사진: hong.png
전화: 1111-2222
가입일: 2019-01-01

명령> /member/detail
번호? 20
해당 학생을 찾을 수 없습니다.

명령> /member/update
번호? 1
이름(홍길동)?     <=== 입력하지 않으면 기존 값 사용
이메일(hong@test.com)?
암호(1111)?
사진(hong.png)?
전화(1111-2222)?
회원을 변경했습니다.

명령> /member/update
번호? 20
해당 회원을 찾을 수 없습니다.

명령> /member/delete
번호? 2
회원을 삭제했습니다.

명령> /member/delete
번호? 20
해당 회원을 찾을 수 없습니다.
```

### 작업5) 게시글 데이터의 상세조회, 변경, 삭제 기능을 추가하라.

- BoardHandler.java
    - 상세조회 기능을 수행하는 detailBoard()을 정의한다.
    - 변경 기능을 수행하는 updateBoard()을 정의한다.
    - 삭제 기능을 수행하는 deleteBoard()을 정의한다.
    - 저장된 목록에서 회원 번호로 항목을 찾는 indexOfBoard()를 정의한다.
- Board.java
    - 인스턴스 복제를 할 수 있도록 java.lang.Cloneable 인터페이스를 구현한다.
    - clone()을 오버라이딩 한다.
- App.java
    - 상세조회, 변경, 삭제 명령에 대한 분기문을 추가한다.

#### 실행 결과

```
명령> /board/list
1, 게시글입니다.                , 2019-01-01, 0
2, 두 번째 게시글입니다.        , 2019-01-01, 0
3, 세 번째 게시글입니다.        , 2019-01-01, 0

명령> /board/detail
번호? 1
내용: 게시글입니다.
작성일: 2019-01-01

명령> /board/detail
번호? 20
해당 게시글을 찾을 수 없습니다.

명령> /board/update
번호? 1
내용?      <=== 입력하지 않으면 기존 값 사용
게시글을 변경했습니다.

명령> /board/update
번호? 20
해당 게시글을 찾을 수 없습니다.

명령> /board/delete
번호? 2
게시글을 삭제했습니다.

명령> /board/delete
번호? 20
해당 게시글을 찾을 수 없습니다.
```
