package gomgugu.njp.tvlist;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import com.google.gson.Gson;
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

  static List<Show> showList = new ArrayList<>();
  static List<Board> boardList = new ArrayList<>();
  static List<Member> memberList = new ArrayList<>();

  public static void main(String[] args) {

    // 파일에서 데이터 로딩
    loadShowData();
    loadBoardData();
    loadMemberData();

    Prompt prompt = new Prompt(keyboard);
    HashMap<String, Command> commandMap = new HashMap<>();

    commandMap.put("/board/add", new BoardAddCommand(prompt, boardList));
    commandMap.put("/board/list", new BoardListCommand(boardList));
    commandMap.put("/board/detail", new BoardDetailCommand(prompt, boardList));
    commandMap.put("/board/update", new BoardUpdateCommand(prompt, boardList));
    commandMap.put("/board/delete", new BoardDeleteCommand(prompt, boardList));

    commandMap.put("/show/add", new ShowAddCommand(prompt, showList));
    commandMap.put("/show/list", new ShowListCommand(showList));
    commandMap.put("/show/detail", new ShowDetailCommand(prompt, showList));
    commandMap.put("/show/update", new ShowUpdateCommand(prompt, showList));
    commandMap.put("/show/delete", new ShowDeleteCommand(prompt, showList));


    commandMap.put("/member/add", new MemberAddCommand(prompt, memberList));
    commandMap.put("/member/list", new MemberListCommand(memberList));
    commandMap.put("/member/detail", new MemberDetailCommand(prompt, memberList));
    commandMap.put("/member/update", new MemberUpdateCommand(prompt, memberList));
    commandMap.put("/member/delete", new MemberDeleteCommand(prompt, memberList));

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
        try {
          commandHandler.execute();
        } catch (Exception e) {
          System.out.printf("명령어 실행 중 오류 발생: %S\n", e.getMessage());
        }
      } else {
        System.out.println("실행할 수 없는 명령입니다.");
      }
    }

    keyboard.close();

    // 데이터를 파일에 저장
    saveShowData();
    saveBoardData();
    saveMemberData();

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


  private static void loadShowData() {
    File file = new File("./show.json");


    try (FileReader in = new FileReader(file)) {

      showList.addAll(Arrays.asList(new Gson().fromJson(in, Show[].class)));

      System.out.printf("총 %d 개의 드라마 데이터를 로딩했습니다.\n", showList.size());

    } catch (IOException e) {
      System.out.println("파일 읽기 중 오류 발생! - " + e.getMessage());
    }
  }

  private static void loadBoardData() {
    File file = new File("./board.json");

    try (FileReader in = new FileReader(file)) {
      boardList.addAll(Arrays.asList(new Gson().fromJson(in, Board[].class)));
      System.out.printf("총 %d 개의 게시물 데이터를 로딩했습니다.\n", boardList.size());

    } catch (IOException e) {
      System.out.println("파일 읽기 중 오류 발생! - " + e.getMessage());
    }
  }


  private static void loadMemberData() {
    File file = new File("./member.json");

    try (FileReader in = new FileReader(file)) {
      memberList.addAll(Arrays.asList(new Gson().fromJson(in, Member[].class)));
      System.out.printf("총 %d 개의 회원 데이터를 로딩했습니다.\n", memberList.size());

    } catch (IOException e) {
      System.out.println("파일 읽기 중 오류 발생! - " + e.getMessage());
    }
  }


  private static void saveShowData() {

    // 데이터가 보관된 파일 정보를 준비한다.
    File file = new File("./show.json");

    try (FileWriter out = new FileWriter(file)) {
      out.write(new Gson().toJson(showList));
      System.out.printf("총 %d 개의 드라마 데이터를 저장했습니다.\n", showList.size());

    } catch (IOException e) {
      System.out.println("파일 쓰기 중 오류 발생! - " + e.getMessage());
    }
  }


  private static void saveBoardData() {
    File file = new File("./board.json");

    try (FileWriter out = new FileWriter(file)) {
      out.write(new Gson().toJson(boardList));
      System.out.printf("총 %d 개의 게시물 데이터를 저장했습니다.\n", boardList.size());

    } catch (IOException e) {
      System.out.println("파일 쓰기 중 오류 발생! - " + e.getMessage());

    }
  }

  private static void saveMemberData() {
    File file = new File("./member.json");

    try (FileWriter out = new FileWriter(file)) {
      out.write(new Gson().toJson(memberList));
      System.out.printf("총 %d 개의 회원 데이터를 저장했습니다.\n", memberList.size());

    } catch (IOException e) {
      System.out.println("파일 쓰기 중 오류 발생! - " + e.getMessage());
    }
  }



}


