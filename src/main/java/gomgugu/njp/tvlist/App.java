// 프로젝트: 내가 본 드라마(TV Show) 목록 정리 및 공유
// 생성자 연습
// 생성자 constructor
// 오류메시지: The constructor BoardHandler() is undefined
// 생성자!!
// 생성된 인스턴스가 사용하기 전에 유효한 값으로 초기화 시키는 것.
// 생성자 여러 개 만들어서 기본인 경우, 추가적인 경우 등 설정할 수 있음.

package gomgugu.njp.tvlist;

import java.util.Scanner;
import gomgugu.njp.tvlist.handler.BoardHandler;
import gomgugu.njp.tvlist.handler.MemberHandler;
import gomgugu.njp.tvlist.handler.ShowHandler;

public class App {
  
  static Scanner keyboard = new Scanner(System.in);
  
  public static void main(String[] args) {
    
    
    // BoardHandler의 메서드가 사용할 메모리만 게시판마다 따로 생성한다.
    // new BoardHandler(); 스태틱 안붙은 애들(메서드x 인스턴스 필트만)의 메모리 공간 Heap에 생성하고 그 주소를 boardHandler1에 저장하라
    // (); 생성자를 호출하는 명령
    //BoardHandler에 입력객체를 반드시 꼽도록 생성자에 강제화함.
    BoardHandler boardHandler1 = new BoardHandler(keyboard);
    BoardHandler boardHandler2 = new BoardHandler(keyboard, 200);
    BoardHandler boardHandler3 = new BoardHandler(keyboard, 1000);
    BoardHandler boardHandler4 = new BoardHandler(keyboard);
    BoardHandler boardHandler5 = new BoardHandler(keyboard, 9000);
    BoardHandler boardHandler6 = new BoardHandler(keyboard, 20000);
    
    ShowHandler 정규드라마 = new ShowHandler(keyboard);
    MemberHandler 일반회원 = new MemberHandler(keyboard);
    
    String command;

    do {
      System.out.println("명령>");
      command = keyboard.nextLine();

      switch (command) {
        case "/show/add" :
          //인스턴스 메서드 호출 방법
          정규드라마.addShow();
          break;

        case "/show/list" :
          정규드라마.listShow();
          break;

        case "/member/add" :
          일반회원.addMember();
          break;

        case "/member/list" :
          일반회원.listMember();
          break;

        case "/board/add" :
          boardHandler1.addBoard();
          break;

        case "/board/list" :
          boardHandler1.listBoard();
          break;     
          
        case "/board/detail" :
          boardHandler1.detailBoard();
          break;   

        case "/board2/add" :
          boardHandler2.addBoard();
          break;

        case "/board2/list" :
          boardHandler2.listBoard();
          break;        
          
        case "/board2/detail" :
          boardHandler2.detailBoard();
          break;   
          
        case "/board3/add" :
          boardHandler3.addBoard();
          break;

        case "/board3/list" :
          boardHandler3.listBoard();
          break;        
          
        case "/board3/detail" :
          boardHandler3.detailBoard();
          break; 
          
        case "/board4/add" :
          boardHandler4.addBoard();
          break;

        case "/board4/list" :
          boardHandler4.listBoard();
          break;        
          
        case "/board4/detail" :
          boardHandler4.detailBoard();
          break; 
          
        case "/board5/add" :
          boardHandler5.addBoard();
          break;

        case "/board5/list" :
          boardHandler5.listBoard();
          break;        
          
        case "/board5/detail" :
          boardHandler5.detailBoard();
          break; 
          
        case "/board6/add" :
          boardHandler6.addBoard();
          break;

        case "/board6/list" :
          boardHandler6.listBoard();
          break;        
          
        case "/board6/detail" :
          boardHandler6.detailBoard();
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

