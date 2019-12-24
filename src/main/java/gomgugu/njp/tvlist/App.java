// 프로젝트: 내가 본 드라마(TV Show) 목록 정리 및 공유
// App에서 LessonHandler, MemberHandler, BoardHandler 클래스 소스코드 분리
// 스캐너 키보드 객체설정, 호출 등 자세히 볼 것 

package gomgugu.njp.tvlist;

import java.util.Scanner;
import gomgugu.njp.tvlist.handler.BoardHandler;
import gomgugu.njp.tvlist.handler.MemberHandler;
import gomgugu.njp.tvlist.handler.ShowHandler;

public class App {
  
  static Scanner keyboard = new Scanner(System.in);
  
  public static void main(String[] args) {
    
    // LessonHandler, MemberHandler, BoardHandler 의 메서드를 사용하기 전에 
    // 그 메서드가 작업할 때 사용할 키보드 객체를 설정해줘야 한다.
    ShowHandler.keyboard = keyboard;
    MemberHandler.keyboard = keyboard;
    BoardHandler.keyboard = keyboard;
    
    // BoardHandler의 메서드가 사용할 메모리만 게시판마다 따로 생성한다.
    // new BoardHandler(); 스태틱 안붙은 애들(메서드x 인스턴스 필트만)의 메모리 공간 Heap에 생성하고 그 주소를 boardHandler1에 저장하라
    BoardHandler boardHandler1 = new BoardHandler();
    BoardHandler boardHandler2 = new BoardHandler();
    BoardHandler boardHandler3 = new BoardHandler();
    BoardHandler boardHandler4 = new BoardHandler();
    BoardHandler boardHandler5 = new BoardHandler();
    BoardHandler boardHandler6 = new BoardHandler();
    
    ShowHandler 정규드라마 = new ShowHandler();
    MemberHandler 일반회원 = new MemberHandler();
    
    String command;

    do {
      System.out.println("명령>");
      command = keyboard.nextLine();

      switch (command) {
        case "/show/add" :
          //다른 클래스로 분리한 메서드를 호출할 때는 클래스를 이름을 지정해야 한다.
          ShowHandler.addShow(정규드라마); // 파라미터로 어느 배열에 저장할 지 주소 줘.
          break;

        case "/show/list" :
          ShowHandler.listShow(정규드라마);
          break;

        case "/member/add" :
          MemberHandler.addMember(일반회원);
          break;

        case "/member/list" :
          MemberHandler.listMember(일반회원);
          break;

        case "/board/add" :
          BoardHandler.addBoard(boardHandler1);
          break;

        case "/board/list" :
          BoardHandler.listBoard(boardHandler1);
          break;     
          
        case "/board/detail" :
          BoardHandler.detailBoard(boardHandler1);
          break;   

        case "/board2/add" :
          BoardHandler.addBoard(boardHandler2);
          break;

        case "/board2/list" :
          BoardHandler.listBoard(boardHandler2);
          break;        
          
        case "/board2/detail" :
          BoardHandler.detailBoard(boardHandler2);
          break;   
          
        case "/board3/add" :
          BoardHandler.addBoard(boardHandler3);
          break;

        case "/board3/list" :
          BoardHandler.listBoard(boardHandler3);
          break;        
          
        case "/board3/detail" :
          BoardHandler.detailBoard(boardHandler3);
          break; 
          
        case "/board4/add" :
          BoardHandler.addBoard(boardHandler4);
          break;

        case "/board4/list" :
          BoardHandler.listBoard(boardHandler4);
          break;        
          
        case "/board4/detail" :
          BoardHandler.detailBoard(boardHandler4);
          break; 
          
        case "/board5/add" :
          BoardHandler.addBoard(boardHandler5);
          break;

        case "/board5/list" :
          BoardHandler.listBoard(boardHandler5);
          break;        
          
        case "/board5/detail" :
          BoardHandler.detailBoard(boardHandler5);
          break; 
          
        case "/board6/add" :
          BoardHandler.addBoard(boardHandler6);
          break;

        case "/board6/list" :
          BoardHandler.listBoard(boardHandler6);
          break;        
          
        case "/board6/detail" :
          BoardHandler.detailBoard(boardHandler6);
          break; 
          
        default : 
          if (!command.equalsIgnoreCase("quit")) {
            System.out.println("실행할 수 없는 명령입니다.");
          }
      }

    } while (!command.equalsIgnoreCase("quit"));
    
    System.out.println("안녕!");

    keyboard.close();
  } //main
  
  
}//public class App

