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
  
  //클래스 필드
  // => Method Area에 클래스 코드가 로딩될 때 자동 생성된다.
  // => 공통으로 허용할 값일 경우 클래스 필드로 선언한다.
  static final int BOARD_SIZE = 100;
  public static Scanner keyboard;
  
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
    board.no = keyboard.nextInt();
    keyboard.nextLine(); 

    System.out.print("제목? ");
    board.title = keyboard.nextLine();

    System.out.print("내용? ");
    board.contents = keyboard.nextLine();

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
    int no = keyboard.nextInt();
    keyboard.nextLine();
    
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
