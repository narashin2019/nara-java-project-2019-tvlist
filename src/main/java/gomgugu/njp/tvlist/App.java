package gomgugu.njp.tvlist;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import gomgugu.njp.tvlist.domain.Board;
import gomgugu.njp.tvlist.domain.Member;
import gomgugu.njp.tvlist.domain.Show;
import gomgugu.njp.tvlist.handler.BoardAddCommand;
import gomgugu.njp.tvlist.handler.BoardDeleteCommand;
import gomgugu.njp.tvlist.handler.BoardDetailCommand;
import gomgugu.njp.tvlist.handler.BoardListCommand;
import gomgugu.njp.tvlist.handler.BoardUpdateCommand;
import gomgugu.njp.tvlist.handler.Command;
import gomgugu.njp.tvlist.handler.HelloCommand;
import gomgugu.njp.tvlist.handler.MemberAddCommand;
import gomgugu.njp.tvlist.handler.MemberDeleteCommand;
import gomgugu.njp.tvlist.handler.MemberDetailCommand;
import gomgugu.njp.tvlist.handler.MemberListCommand;
import gomgugu.njp.tvlist.handler.MemberUpdateCommand;
import gomgugu.njp.tvlist.handler.ShowAddCommand;
import gomgugu.njp.tvlist.handler.ShowDeleteCommand;
import gomgugu.njp.tvlist.handler.ShowDetailCommand;
import gomgugu.njp.tvlist.handler.ShowListCommand;
import gomgugu.njp.tvlist.handler.ShowUpdateCommand;
import gomgugu.njp.util.Prompt;

public class App {

  static Scanner keyboard = new Scanner(System.in);
  static Deque<String> commandStack = new ArrayDeque<>();
  static Queue<String> commandQueue = new LinkedList<>();

  public static void main(String[] args) {

    Prompt prompt = new Prompt(keyboard);

    HashMap<String, Command> commandMap = new HashMap<>();



    LinkedList<Board> boardList = new LinkedList<>();
    commandMap.put("board/add", new BoardAddCommand(prompt, boardList));
    commandMap.put("board/list", new BoardListCommand(boardList));
    commandMap.put("board/detail", new BoardDetailCommand(prompt, boardList));
    commandMap.put("board/update", new BoardUpdateCommand(prompt, boardList));
    commandMap.put("board/delete", new BoardDeleteCommand(prompt, boardList));

    ArrayList<Show> showList = new ArrayList<>();
    commandMap.put("show/add", new ShowAddCommand(prompt, showList));
    commandMap.put("show/list", new ShowListCommand(showList));
    commandMap.put("show/detail", new ShowDetailCommand(prompt, showList));
    commandMap.put("show/update", new ShowUpdateCommand(prompt, showList));
    commandMap.put("show/delete", new ShowDeleteCommand(prompt, showList));


    LinkedList<Member> memberList = new LinkedList<>();
    commandMap.put("member/add", new MemberAddCommand(prompt, memberList));
    commandMap.put("member/list", new MemberListCommand(memberList));
    commandMap.put("member/detail", new MemberDetailCommand(prompt, memberList));
    commandMap.put("member/update", new MemberUpdateCommand(prompt, memberList));
    commandMap.put("member/delete", new MemberDeleteCommand(prompt, memberList));

    commandMap.put("/hello", new HelloCommand(prompt));


    String command;

    while (true) {
      System.out.print("\n명령> ");
      command = keyboard.nextLine();

      if (command.length() == 0)
        continue;

      if (command.equals("quit")) {
        System.out.println("안녕!");
        break;
      } else if (command.equals("history")) {
        printCommandHistory(commandStack.iterator());
        continue;
      } else if (command.contentEquals("history2")) {
        printCommandHistory(commandQueue.iterator());
        continue;
      }

      commandStack.push(command);

      commandQueue.offer(command);

      Command commandHandler = commandMap.get(command);

      if (commandHandler != null) {
        commandHandler.execute();
      } else {
        System.out.println("실행할 수 없는 명령입니다.");
      }
    }

    keyboard.close();

  }



  // 이전에는 Stack에서 값을 꺼내는 방법과 Queue에서 값을 꺼내는 방법이 다르기 때문에
  // printCommandHistory()와 printCommandHistory2() 메서드를 따로 정의했다.
  // 이제 Stack과 Queue는 일관된 방식으로 값을 꺼내주는 Iterator가 있기 때문에
  // 두 메서드를 하나로 합칠 수 있다.
  // 파라미터로 Iterator를 받아서 처리하기만 하면 된다.
  //
  private static void printCommandHistory(Iterator<String> iterator) {
    int count = 0;

    while (iterator.hasNext()) {
      System.out.println(iterator.next());
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

}


