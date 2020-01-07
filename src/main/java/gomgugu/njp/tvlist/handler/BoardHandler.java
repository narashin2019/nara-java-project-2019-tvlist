package gomgugu.njp.tvlist.handler;
//클래스를 다룰때 메서드마다 어떤 타입의 데이터 다루는지 리턴이나 파라미터에 특정타입으로만 동작하도록 제한거는것
// = 제네릭문법
import java.sql.Date;
import java.util.Scanner;
import gomgugu.njp.tvlist.domain.Board;
import gomgugu.njp.util.ArrayList;

public class BoardHandler {

  ArrayList<Board> boardList;
  Scanner input;

  public BoardHandler(Scanner input) {
    this.input = input;
    boardList = new ArrayList<>(); // <Board>에서 보드 생략가능 <>는 그대로
  }

  public BoardHandler(Scanner input, int capacity) {
    this.input = input;
    this.boardList = new ArrayList<>(capacity); // <Board>보드 생략가능
  }

  public void addBoard() {

    Board board = new Board();

    System.out.print("번호? ");
    board.setNo(input.nextInt());
    input.nextLine(); 

    System.out.print("제목? ");
    board.setTitle(input.nextLine());

    System.out.print("내용? ");
    board.setContents(input.nextLine());

    board.setDate(new Date(System.currentTimeMillis()));
    board.setViewCount(0);

    this.boardList.add(board);
    System.out.println("저장하였습니다.");
  }


  public void listBoard() {
    // BoardList의 보관된 값을 받을 배열을 준비한다.
    Board[] arr = new Board[this.boardList.size()];

    //toArray()에게 빈 배열을 넘겨서 복사 받는다.
    this.boardList.toArray(arr);

    for (Board b : arr) {
      System.out.printf("%d, %-20s, %s, %d\n", 
          b.getNo(), b.getTitle(), b.getDate(), b.getViewCount());
    }
  }


  public void detailBoard() {
    System.out.println("게시물 인덱스? ");
    int index = input.nextInt();
    input.nextLine();

    Board board = (Board) this.boardList.get(index);

    if (board == null) {
      System.out.println("게시물 인덱스가 유효하지 않습니다.");
      return;
    }

    System.out.printf("번호: %d\n", board.getNo());
    System.out.printf("제목: %s\n", board.getTitle());
    System.out.printf("등록일: %s\n", board.getDate());
    System.out.printf("조회수: %d\n", board.getViewCount());
  }

}
