// 프로젝트: 내가 본 드라마(TV Show) 목록 정리 및 공유
//데이터는 개별로 관리하고 메서드는 공유한다 = 인스턴스 필드의 존재이유
//스태틱 메서드를 인스턴스 메서드로 바꿔보자.

package gomgugu.njp.tvlist;

import java.util.Scanner;
import gomgugu.njp.tvlist.handler.BoardHandler;
import gomgugu.njp.tvlist.handler.MemberHandler;
import gomgugu.njp.tvlist.handler.ShowHandler;

public class App {
  
  //여러 메소드끼리 공유하니까 main메서드 밖으로 뺴고 static붙임
  static Scanner keyboard = new Scanner(System.in);
  
  public static void main(String[] args) {
    
    // LessonHandler, MemberHandler, BoardHandler 의 메서드를 사용하기 전에 
    // 그 메서드가 작업할 때 사용할 키보드 객체를 설정해줘야 한다.
    // 따로 관리할 필요 없어서 클래스에서 공유하는 변수를 사용
    ShowHandler.keyboard = keyboard;
    MemberHandler.keyboard = keyboard;
    BoardHandler.keyboard = keyboard;
    
    // BoardHandler의 메서드가 사용할 메모리만 게시판마다 따로 생성한다.
    // new BoardHandler(); 스태틱 안붙은 애들(메서드x 인스턴스 필트만)의 메모리 공간 Heap에 생성하고 그 주소를 boardHandler에 저장하라
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

