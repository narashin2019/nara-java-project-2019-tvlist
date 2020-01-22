package gomgugu.njp.tvlist;

import java.util.Scanner;
import gomgugu.njp.tvlist.domain.Board;
import gomgugu.njp.tvlist.domain.Member;
import gomgugu.njp.tvlist.domain.Show;
import gomgugu.njp.tvlist.handler.BoardHandler;
import gomgugu.njp.tvlist.handler.MemberHandler;
import gomgugu.njp.tvlist.handler.ShowHandler;
import gomgugu.njp.util.ArrayList;
import gomgugu.njp.util.LinkedList;
import gomgugu.njp.util.Prompt;
import gomgugu.njp.util.Queue;
import gomgugu.njp.util.Stack;

public class App {

  static Scanner keyboard = new Scanner(System.in);

  static Stack<String> commandStack = new Stack<>();
  static Queue<String> commandQueue = new Queue<>();

  public static void main(String[] args) {

    Prompt prompt = new Prompt(keyboard);

    // 단지 유지보수를 좋게 하기 위해 ArrayList와 LinkedList의 공통 분모를 뽑아서
    // 만든 클래스가 List이다.
    // List는 클래스는 실제 작업을 하는 클래스가 아니다.
    // 그럼에도 불구하고 개발자가 다음과 같이 List 객체를 사용하려 한다면 막을 수 없다.
    // => BoardHandler의 경우 아무런 작업을 수행하지 않을 것이다.
    // => 왜? List 클래스에 정의된 메서드는 아무것도 하지 않는다.
    //
    // List<Board> boardList = new List<>();

    // 해결책?
    // => 이렇게 generalization을 통해 만든 클래스의 경우
    // 서브 클래스에게 공통 분모를 물려주기 위한 용도로 사용된다.
    // => 이런 류의 클래스는 직접 인스턴스를 생성하지 못하도록 해서
    // 직접 사용하는 것을 막아야 한다.
    // => 이런 용도로 사용하는 문법이 "추상 클래스(abstract class)"이다.
    //
    // List 클래스(AbstractList로 이름 변경함)를 추상 클래스로 만들면,
    // 다음과 같이 인스턴스를 생성할 수 없다.
    // 아예 인스턴스 생성을 원천적으로 차단하는 효과가 있다.
    //
    // AbstractList<Board> boardList = new AbstractList<>(); // 컴파일 오류!
    //

    // 받드시 AbstractList의 일반 하위 객체를 정의해야 한다.
    //

    LinkedList<Board> boardlist = new LinkedList<>();
    BoardHandler boardHandler = new BoardHandler(prompt, boardlist);

    ArrayList<Show> showlist = new ArrayList<>();
    ShowHandler showHandler = new ShowHandler(prompt, showlist);

    LinkedList<Member> memberList = new LinkedList<>();
    MemberHandler memberHandler = new MemberHandler(prompt, memberList);

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

