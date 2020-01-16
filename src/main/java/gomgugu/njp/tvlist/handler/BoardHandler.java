// 게시글 인덱스로 객체를 찾는 대신에 
// 게시글을 입력할 때 등록한 번호로 객체를 찾도록 변경한다. 
// 게시글 번호로 객체를 찾는 코드를 관리하기 쉽게 별도의 메서드로 분리한다.
// => indexOfBoard(int) 메서드 추가
// Prompt로 변경
//
package gomgugu.njp.tvlist.handler;

import java.sql.Date;
import gomgugu.njp.tvlist.domain.Board;
import gomgugu.njp.util.LinkedList;
import gomgugu.njp.util.Prompt;

public class BoardHandler {

  LinkedList<Board> boardList;
  
  Prompt prompt;

  public BoardHandler(Prompt prompt) {
    this.prompt = prompt;
    this.boardList = new LinkedList<>(); // <Board>에서 Board 생략가능 <>는 그대로
  }

  
  public void addBoard() {

    Board board = new Board();

    board.setNo(prompt.inputInt("번호? "));

    board.setTitle(prompt.inputString("제목? "));
    
    board.setContents(prompt.inputString("내용? "));
    
    board.setWriter(prompt.inputString("작성자? "));
    
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

    // 게시글 번호로 객체를 찾는다.
    int index = indexOfBoard(prompt.inputInt("번호? "));

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
    int index = indexOfBoard(prompt.inputInt("번호? "));

    if (index == -1) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }
    
    Board oldBoard = this.boardList.get(index);
    Board newBoard = new Board();
    
    newBoard.setNo(oldBoard.getNo());
    newBoard.setViewCount(oldBoard.getViewCount());
    newBoard.setDate(new Date(System.currentTimeMillis()));
    
    newBoard.setTitle(prompt.inputString(
        String.format("제목(%s)? ", oldBoard.getTitle()), 
        oldBoard.getTitle()));
    
    newBoard.setTitle(prompt.inputString(
        String.format("내용(%s)? ", oldBoard.getContents()), 
        oldBoard.getContents()));
 
    
    if (newBoard.equals(oldBoard)) {
      System.out.println("게시글 변경을 취소했습니다.");
      return;
    }
    
 
    this.boardList.set(index, newBoard);
    System.out.println("게시글을 변경했습니다.");
  }
  
  public void deleteBoard() {
    int index = indexOfBoard(prompt.inputInt("번호? "));
    
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
