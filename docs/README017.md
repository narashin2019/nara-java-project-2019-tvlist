# 17 - 다형성과 형변환 응용

## 오늘 배운 것 
똑같은 기능인데 배열만 다르다.(List)
동물은 포유류, 유인원, 사람 , 파충류 다 가리킬 수 있다. 

- 다형적 변수를 활용하여 다양한 타입의 데이터를 다룰 수 있다.
- 형변환을 이해하고 다룰 수 있다.

## 실습 소스 및 결과
/handler/ShowList.java 삭제
/handler/MemberList.java 삭제
/handler/BoardList.java 삭제
/handler/ArrayList.java 추가
/handler/ShowHandler.java 변경
/handler/MemberHandler.java 변경
/handler/BoardHandler.java 변경

## 실습

### 작업1) Show, Member, Board를 모두 다룰 수 있는 List 클래스를 만들라.

- ArrayList.java
    - ShowList, MemberList, BoardList 클래스를 합쳐 한 클래스로 만든다.
- ShowHandler.java
    - `ArrayList` 클래스를 사용하여 데이터를 처리한다.
- MemberHandler.java
    - `ArrayList` 클래스를 사용하여 데이터를 처리한다.
- BoardHandler.java
    - `ArrayList` 클래스를 사용하여 데이터를 처리한다.
