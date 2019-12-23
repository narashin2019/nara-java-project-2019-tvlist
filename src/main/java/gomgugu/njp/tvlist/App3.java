// 프로젝트: 내가 본 드라마(TV Show) 목록 정리 및 공유
// App3: 게시글
package gomgugu.njp.tvlist;

import java.util.Scanner;
import java.sql.Date;

public class App3 {

  public static void main(String[] args) {
    
    Scanner keyboard = new Scanner(System.in);

    class Board{
      int no; 
      String title;  
      String contents;
      Date date;
      int viewCount;
    }
    
    final int SIZE = 10000;
    Board[] boards = new Board[SIZE];

    int count = 0;
    for (int i = 0; i < SIZE; i++) {
      count++; // => count = count + 1;
      
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
      
      boards[i] = board;
      
      System.out.println();
      System.out.print("계속 입력하시겠습니까?(Y/n) ");
      String response = keyboard.next();

      if (!response.equalsIgnoreCase("y")) {
        break;
      }
    }

    keyboard.close();

    System.out.println();

    for (int i = 0; i < count; i++) {
      Board board = boards[i];
      System.out.printf("%d, %-20s, %s, %d\n", 
          board.no, board.title, board.date, board.viewCount);
    }

  }
}
