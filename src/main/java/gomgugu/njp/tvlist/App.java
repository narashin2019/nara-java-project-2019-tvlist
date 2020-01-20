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
import gomgugu.njp.util.Queue;
import gomgugu.njp.util.Stack;

public class App {

  static Scanner keyboard = new Scanner(System.in);

  static Stack<String> commandStack = new Stack<>();
  static Queue<String> commandQueue = new Queue<>();

  public static void main(String[] args) {


    Prompt prompt = new Prompt(keyboard);

    BoardHandler boardHandler = new BoardHandler(prompt);
    ShowHandler showHandler = new ShowHandler(prompt);
    MemberHandler memberHandler = new MemberHandler(prompt);

    String command;

    do {
      System.out.println("명령>");
      command = keyboard.nextLine();

      switch (command) {
        case "/show/add":
          // 인스턴스 메서드 호출 방법
          showHandler.addShow();
          break;

        case "/show/list":
          showHandler.listShow();
          break;

        case "/show/detail":
          showHandler.detailShow();
          break;

        case "/show/update":
          showHandler.updateShow();
          break;

        case "/show/delete":
          showHandler.deleteShow();
          break;

        case "/member/add":
          memberHandler.addMember();
          break;

        case "/member/list":
          memberHandler.listMember();
          break;

        case "/member/detail":
          memberHandler.detailMember();
          break;

        case "/member/update":
          memberHandler.updateMember();
          break;

        case "/member/delete":
          memberHandler.deleteMember();
          break;

        case "/board/add":
          boardHandler.addBoard();
          break;

        case "/board/list":
          boardHandler.listBoard();
          break;

        case "/board/detail":
          boardHandler.detailBoard();
          break;

        case "/board/update":
          boardHandler.updateBoard();
          break;

        case "/board/delete":
          boardHandler.deleteBoard();
          break;
        case "history":
          printCommandHistory();
          break;
        case "history2":
          printCommandHistory2();
          break;
        default:
          if (!command.equalsIgnoreCase("quit")) {
            System.out.println("실행할 수 없는 명령입니다.");
          }
      }
    } while (!command.equalsIgnoreCase("quit"));
    System.out.println("안녕!");

    keyboard.close();

  } // main

  private static void printCommandHistory() {
    Stack<String> historyStack = commandStack.clone();
    int count = 0;
    while (!historyStack.empty()) {
      System.out.println(historyStack.pop());
      count++;

      if ((count % 5) == 0) {
        System.out.print(":");
        String str = keyboard.nextLine();
        if (str.equalsIgnoreCase("q")) {
          break;
        }
      }
    }
  }

  private static void printCommandHistory2() {
    Queue<String> historyQueue = commandQueue.clone();
    int count = 0;

    while (historyQueue.size() > 0) {
      System.out.println(historyQueue.poll());

      if ((++count % 5) == 0) {
        System.out.print(":");
        String str = keyboard.nextLine();
        if (str.equalsIgnoreCase("q")) {
          break;
        }
      }
    }

  }

}// public class App

