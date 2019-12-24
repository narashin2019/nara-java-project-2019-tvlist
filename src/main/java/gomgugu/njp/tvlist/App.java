// 프로젝트: 내가 본 드라마(TV Show) 목록 정리 및 공유
// App에서 LessonHandler, MemberHandler, BoardHandler 클래스 소스코드 분리
// 스캐너 키보드 객체설정, 호출 등 자세히 볼 것 

package gomgugu.njp.tvlist;

import java.util.Scanner;
//import java.sql.Date;
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
    
    String command;

    do {
      System.out.println("명령>");
      command = keyboard.nextLine();

      switch (command) {
        case "/show/add" :
          //다른 클래스로 분리한 메서드를 호출할 때는 클래스를 이름을 지정해야 한다.
          ShowHandler.addShow();
          break;

        case "/show/list" :
          ShowHandler.listShow();
          break;

        case "/member/add" :
          MemberHandler.addMember();
          break;

        case "/member/list" :
          MemberHandler.listMember();
          break;

        case "/board/add" :
          BoardHandler.addBoard();
          break;

        case "/board/list" :
          BoardHandler.listBoard();
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

