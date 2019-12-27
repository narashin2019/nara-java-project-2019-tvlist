package gomgugu.njp.tvlist.handler;

//게시판 게시물은 언제든지 추가 될 수 있으므로 인스턴스로 만듬

import java.sql.Date;
import java.util.Scanner;
import gomgugu.njp.tvlist.domain.Board;

public class BoardHandler {

  //인스턴스 필드
  // => new 명령을 실행해야만 생성되는 변수이다. (클래스가 로딩되어도 존재하지 않음)
  // => 개별적으로 관리되어야 하는 값일 경우 인스턴스 필드로 선언한다. (static을 뺀다)
  Board[] boards = new Board[BOARD_SIZE];
  int boardCount = 0;

  //이전까지 게시물 데이터를 입력받을 때 키보드에서 입력 받을 수 있지만,
  // 향후 네트워크나 파일로부터도 입력 받을 수 있다.
  // 이런 경우를 대비하여 입력 데이터를 읽는 것을 keyboard로 한정하지 말자! input으로 바꿈.
  // 또한 각 게시판마다 입력받는 방식을 다르게 할 수 있도록 인스턴스 변수로 선언하자.
  Scanner input;

  //클래스 필드
  // => Method Area에 클래스 코드가 로딩될 때 자동 생성된다.
  // => 공통으로 허용할 값일 경우 클래스 필드로 선언한다.
  //new boardHandler()로 힙에 메모리 각각 만들어도 항상 변하지 않는 값이라 static으로 바꿈
  //외부패키지 공개 아니라 public 아님
  static final int BOARD_SIZE = 100;

  
  // 생성자
  // => 인스턴스를 생성할 때 반드시 호출되는 메서드
  // => new 명령을 실행할 때 호출할 생성자를 지정할 수 있다.
  // => 주로 의존객체를 초기화 시키는 코드를 넣는다.
  // => 생성자는 리턴 값이 없고 클래스 이름과 같은 이름으로 메서드를 정의한다.
  // => 생성자를 실행할 때 사용할 값은 파라미터로 받는다.
  // 다른 패키지에서 접근할 수 있도록 public으로 한다.
  public BoardHandler(Scanner input) {
    // BoardHandler를 실행하려면 데이터를 입력받는 도구가 반드시 있어야한다.
    // 이런 도구를 "의존객체(dependency object)" 라 부른다.
    // 보통 "dependency"라 줄여서 부른다
    // 생성자에서 해야할 일은 인스턴스를 생성할 때
    // 이런 의존 객체를 반드시 초기화 시키도록 하는 것이다.
    this.input = input;
    this.boards= new Board[BOARD_SIZE];
  }

  public BoardHandler(Scanner input, int capacity) { //5번!!!!!!! 게시판 사이즈를 바꾸고 싶을때 생성자 추가 값을 두갬받는 생성자 배열의 크기까지 받음. 
    this.input = input;
    if(capacity < BOARD_SIZE || capacity > 10000)
      this.boards = new Board[BOARD_SIZE];
    else
      this.boards = new Board[capacity];
  }
  
  
  
  //클래스 메서드 > 인스턴스메서드로 바꿈
  // 보드핸들러 객체를 받아 인스턴스 필드를 사용하는 메서드는 > 인스턴스 메서드로 바꾸자!
  // 인스턴스 메서드 
  // => 인스턴스가 있어야만 호출할 수 있는 메서드이다.
  // => 인스턴스를 사용하는 메서드인 경우 인스턴스 메서드로 선언하라.
  // => 호출 할 때는 반드시 인스턴스 주소를 줘야 한다.
  //    인스턴스주소.메서드명();
  // => 이렇게 인스턴스의 변수 값을 다루는 메서드를 '연산자'라 부를 수 있다. operator
  public void addBoard() {

    Board board = new Board();

    System.out.print("번호? ");
    board.no = input.nextInt();
    input.nextLine(); 

    System.out.print("제목? ");
    board.title = input.nextLine();

    System.out.print("내용? ");
    board.contents = input.nextLine();

    board.date = new Date(System.currentTimeMillis());

    board.viewCount = 0;

    this.boards[this.boardCount++] = board;
    System.out.println("저장하였습니다.");
  }


  public void listBoard() {
    for (int i = 0; i < this.boardCount; i++) {
      Board b = this.boards[i];
      System.out.printf("%d, %-20s, %s, %d\n", 
          b.no, b.title, b.date, b.viewCount);
    }
  }


  public void detailBoard() {
    System.out.println("게시물 번호? ");
    int no = input.nextInt();
    input.nextLine();

    Board board = null;
    for (int i = 0; i < this.boardCount; i++) {
      if (this.boards[i].no == no) {
        board = this.boards[i];
        break;
      }
    }

    if (board == null) {
      System.out.println("게시물 번호가 유효하지 않습니다.");
      return; //메소드의 리턴타입이 void일 경우 그냥 리턴만 쓰면 중단됨
    }

    System.out.printf("번호: %d\n", board.no);
    System.out.printf("제목: %s\n", board.title);
    System.out.printf("등록일: %s\n", board.date);
    System.out.printf("조회수: %d\n", board.viewCount);
  }

}
