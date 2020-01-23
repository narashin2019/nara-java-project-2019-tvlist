# 26 - `커맨드(Command)` 디자인 패턴을 적용하기

## 학습 목표

- `Command` 디자인 패턴의 개념과 용도를 이해한다.
- `Command` 디자인 패턴을 활용할 수 있다.

## 'Command' 디자인 패턴

- "메서드의 객체화" 설계 기법 
- 명령어가 추가될 때 마다 해당 클래스에 메서드를 추가하는 대신에
  새 클래스를 추가하기 때문에 기존 소스를 손대지 않아 유지보수에 좋다.
- 즉 기존 소스에 영향을 끼치지 않고 새 기능을 추가하는 방식이다.
- 명령처리를 별도의 객체로 분리하기 떄문에 실행 내역을 관리하기 좋고,
- 명령처리를 원래 상태로 되돌리는 기능 등을 구현 하기 쉽다.  
- 인터페이스를 이용하면 메서드 호출 규칙을 단일화 할 수 있기 때문에
  코딩의 일관성을 높혀준다.
- 단 기능 추가할 때마다 해당 기능을 처리하는 새 클래스가 추가되기 때문에    
  클래스 개수는 늘어난다.
- 그러나 유지보수 측면에서는 클래스 개수가 늘어나는 것이  중요하지 않다.
- 소스 코드를 일관성 있게 유지보수 할 수 있는 게 더 중요하다.  


## 실습 소스 및 결과

- /handler/Command.java 추가
- /handler/ShowAddCommand.java 추가
- /handler/ShowListCommand.java 추가
- /handler/ShowDetailCommand.java 추가
- /handler/ShowUpdateCommand.java 추가
- /handler/ShowDeleteCommand.java 추가
- /handler/MemberAddCommand.java 추가
- /handler/MemberListCommand.java 추가
- /handler/MemberDetailCommand.java 추가
- /handler/MemberUpdateCommand.java 추가
- /handler/MemberDeleteCommand.java 추가
- /handler/BoardAddCommand.java 추가
- /handler/BoardListCommand.java 추가
- /handler/BoardDetailCommand.java 추가
- /handler/BoardUpdateCommand.java 추가
- /handler/BoardDeleteCommand.java 추가
- /handler/LessonHandler.java 삭제
- /handler/MemberHandler.java 삭제
- /handler/BoardHandler.java 삭제
- /App.java 변경

## 실습

### 훈련1. 메서드를 호출하는 쪽과 실행 쪽 사이의 규칙을 정의하라.

- Command.java
    - `App` 클래스와 명령을 처리하는 클래스 사이의 호출 규칙을 정의한다.

### 훈련2. 명령을 처리하는 각 메서드를 객체로 분리하라.

- ShowHandler.java
    - 수업 CRUD 각 기능을 `Command` 규칙에 따라 객체로 분리한다.
- MemberHandler.java
    - 수업 CRUD 각 기능을 `Command` 규칙에 따라 객체로 분리한다.
- BoardHandler.java
    - 수업 CRUD 각 기능을 `Command` 규칙에 따라 객체로 분리한다.
- App.java (App.java.01)
    - 명령어가 입력되면 `Command` 규칙에 따라 객체를 실행한다.
    - `/board2/xxx` 명령 처리는 삭제한다.

### 훈련 3: `Map`으로 `Command` 객체를 관리하라.

- App.java
    - 명령어를 `key`, `Command` 객체를 `value`로 하여 Map에 저장한다.
    - 각 명령에 대해 조건문으로 분기하는 부분을 간략하게 변경한다.

    
### 훈련 4: '/hello' 명령을 추가하라.
```
명령> /hello
이름? 홍길동
홍길동님 반갑습니다.

명령>
```


### 훈련 5: '/compute/plus' 명령을 추가하라.

```
명령> /compute/plus
수1? 100
수2? 200
계산결과는 300 입니다.

명령>
```