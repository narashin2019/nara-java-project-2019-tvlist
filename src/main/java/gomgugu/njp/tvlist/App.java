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
import gomgugu.njp.util.Prompt;

public class App {

  static Scanner keyboard = new Scanner(System.in);

  public static void main(String[] args) {


    Prompt prompt = new Prompt(keyboard);
    
    BoardHandler boardHandler1 = new BoardHandler(prompt);
    ShowHandler showHandler = new ShowHandler(prompt);
    MemberHandler memberHandler = new MemberHandler(prompt);

    String command;

    do {
      System.out.println("명령>");
      command = keyboard.nextLine();

      switch (command) {
        case "/show/add" :
          //인스턴스 메서드 호출 방법
          showHandler.addShow();
          break;

        case "/show/list" :
          showHandler.listShow();
          break;

        case "/show/detail" :
          showHandler.detailShow();
          break;

        case "/show/update" :
          showHandler.updateShow();
          break;

        case "/show/delete" :
          showHandler.deleteShow();
          break;

        case "/member/add" :
          memberHandler.addMember();
          break;

        case "/member/list" :
          memberHandler.listMember();
          break;

        case "/member/detail" :
          memberHandler.detailMember();
          break;

        case "/member/update" :
          memberHandler.updateMember();
          break;

        case "/member/delete" :
          memberHandler.deleteMember();
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

        case "/board/update" :
          boardHandler1.updateBoard();
          break; 

        case "/board/delete" :
          boardHandler1.deleteBoard();
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

