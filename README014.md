# 14 - 생성자가 필요한 이유

## 오늘 배운 것

- 생성자의 용도 이해한다.
- 생성자를 이용하여 인스턴스를 사용하기 전에 필요한 값들을 준비할 수 있다.

## 실습 소스 및 결과

- BoardHandler.java 변경
- LessonHandler.java 변경
- MemberHandler.java 변경
- App.java 변경

## 실습

### 작업1) 핸들러 객체의 필수 입력 값인 keyboard를 반드시 설정하게 만들라!

- ShowHandler.java
    - 기본 생성자 대신에 파라미터로 keyboard를 받는 생성자를 추가한다.
- MemberHandler.java
    - 기본 생성자 대신에 파라미터로 keyboard를 받는 생성자를 추가한다.
- BoardHandler.java
    - 기본 생성자 대신에 파라미터로 keyboard를 받는 생성자를 추가한다.
- App.java
    - 핸들러의 인스턴스를 생성할 때 파라미터의 값으로 keyboard 객체를 넘긴다.
