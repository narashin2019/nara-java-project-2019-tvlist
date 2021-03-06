# 28_3 - 파일 포맷으로 JSON 도입하기 

## 학습 목표 

- 외부 라리브러리를 가져와서 프로젝트에 적용할 수 있다.
- JSON 포맷의 사용 이점을 이해한다.
- Google JSON 라이브러리를 사용할 수 있다.

## JSON 데이터 포맷 특징

- 문자열로 데이터를 표현한다.
- '{프로퍼티:값, ...}' 방식으로 객체의 값을 저장한다.
- 바이너리 방식에 비해 데이터가 커지는 문제가 있지만,
  모든 프로그래밍 언어에서 다룰 수 있다는 장점이 있다.
- 그래서 이기종 플랫폼(OS, 프로그래밍 언어 등ㅇ) 간에 데이터를 교환할 때 많이 사용한다.
  



## 실습 소스 및 결과

- build.gradle 변경
- App.java 변경
  
## 실습  

### 훈련 1: Gradle 스크립트 파일(build.gradle)에 Google JSON 라이브러리를 추가하라.

- mvnrepository.com에서 라이브러리 검색
   - json.org 사이트에서 자바 라이브러리 확인 / google-gson
   - 'gson' 키워드로 검색
   - 최신버전 그레이들 눌러서 나오는 코드 복사. 
  
-build.gradle을 편집한다.
   -의존 라이브러리(dependencies) 블록에 gson 정보를 추가한다.
- 이클립스 설정 파일을 갱신한다.
   -'gradle eclipse'를 실행
   - 이클립스 에서 해당 프로젝트를 'refresh'한다
   - 'Referenced Libraries' 노드에서 gson 라이브러리 파일이 추가된 것을 확인한다.
   
   
### 훈련 2: 게시물 데이터를 저장하고 읽을 때 JSON형식을 사용하라.

- App.java
  - saveBoardData() 메서드 변경
  - loadBoardData() 메서드 변경 
  
### 훈련 3: 회원 데이터를 저장하고 읽을 때 JSON형식을 사용하라.

- App.java
  - saveMemberData() 메서드 변경
  - loadMemberData() 메서드 변경 
  
### 훈련 4: 드라마 데이터를 저장하고 읽을 때 JSON형식을 사용하라.

- App.java
  - saveShowData() 메서드 변경
  - loadShowData() 메서드 변경 
  
  
### 훈련 5: Arrays 의 메서드를 활용하여 배열을 List 객체로 만들어라.

- App.java
  - 해당 부분의 코드를 변경한다. 
  
  
##참고:
[{"no":1,"title":"asdcvmsad,asd,","date":"1월 23, 2020","viewCount":0}]

gson 파일 형식 읽기: 

대괄호 -> 배열, 어레이리스트 링크드리스트 형식 다 같아.
중괄호 -> 한 객체
그 객체 안에 no프로퍼티 값은 1

*csv문제: 값안에 콤마가 있으면 제대로 안읽혀 > json은 가능하다!
*웹 안드로이드 아이폰 어플 개발 제이슨 백퍼 쓴다 필수사항

바이너리 데이터 : 이미지 pdf: 메모장 편집 불가
문자열 데이터 캐릭터 데이터 : 메모장 편집가능
장점:  바이너리 방식에 비해 데이터가 커지는 문제가 있지만, 
모든 프로그래밍 언어에서 다룰 수 있다는 장점이 있다.
그래서 이기종 플랫폼(OS, 프로그래밍 언어 등) 간에 데이터를 교환할 때 많이 사용한다.
데이터가 더 정교하다. 

