// 게시글 인덱스로 객체를 찾는 대신에 
// 게시글을 입력할 때 등록한 번호로 객체를 찾도록 변경한다. 
// 게시글 번호로 객체를 찾는 코드를 관리하기 쉽게 별도의 메서드로 분리한다.
// => indexOfBoard(int) 메서드 추가
//
//
package gomgugu.njp.tvlist.handler;

import java.sql.Date;
import java.util.Scanner;
import gomgugu.njp.tvlist.domain.Board;
import gomgugu.njp.util.ArrayList;

public class BoardHandler {

  ArrayList<Board> boardList;
  
  Scanner input;

  public BoardHandler(Scanner input) {
    this.input = input;
    this.boardList = new ArrayList<>(); // <Board>에서 Board 생략가능 <>는 그대로
  }

  public BoardHandler(Scanner input, int capacity) {
    this.input = input;
    this.boardList = new ArrayList<>(capacity); // <Board>에서 Board 생략가능 <>는 그대로
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
    
    System.out.print("작성자? ");
    board.setWriter(input.nextLine());
    
    
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
    System.out.println("번호? ");
    int no = input.nextInt();
    input.nextLine();

    // 게시글 번호로 객체를 찾는다.
    int index = indexOfBoard(no);

    if (index == -1) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }
    
    Board board = this.boardList.get(index);
    System.out.printf("번호: %d\n", board.getNo());
    System.out.printf("제목: %s\n", board.getTitle());
    System.out.printf("등록일: %s\n", board.getDate());
    System.out.printf("조회수: %d\n", board.getViewCount());
  }
   
  
  public void updateBoard() {
    System.out.print("번호? ");
    int no = input.nextInt();
    input.nextLine(); // 숫자 뒤의 남은 공백 제거
    
    // 게시글 번호로 객체를 찾는다.
    int index = indexOfBoard(no);
    
    if (index == -1) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }
    
    Board oldBoard = this.boardList.get(index);
    
    System.out.printf("내용(%s)? ", oldBoard.getContents());
    String contents = input.nextLine();
    
    if (contents.length() == 0) {
      System.out.println("게시글 변경을 취소했습니다.");
      return;
    }
    
    Board newBoard = new Board();
    newBoard.setNo(oldBoard.getNo());
    newBoard.setViewCount(oldBoard.getViewCount());
    newBoard.setTitle(oldBoard.getTitle());
    newBoard.setTitle(contents);
    newBoard.setDate(new Date(System.currentTimeMillis()));
    
    this.boardList.set(index, newBoard);
    
    System.out.println("게시글을 변경했습니다.");
  }
  
  public void deleteBoard() {
    System.out.print("번호? ");
    int no = input.nextInt();
    input.nextLine(); // 숫자 뒤의 남은 공백 제거
    
    // 게시글 번호로 객체를 찾는다.
    int index = indexOfBoard(no);
    
    if (index == -1) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }
    
    
    this.boardList.remove(index);
    
    System.out.println("게시글을 삭제했습니다.");
  }
  
  private int indexOfBoard(int no) {
    for (int i = 0; i < this.boardList.size(); i++) {
      if (this.boardList.get(i).getNo() == no) {
        return i;
      }
    }
    return -1;
  }
  
}
