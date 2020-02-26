package gomgugu.njp.tvlist;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayDeque;
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

  static LinkedList<Show> showList = new LinkedList<>();
  static LinkedList<Board> boardList = new LinkedList<>();
  static LinkedList<Member> memberList = new LinkedList<>();

  public static void main(String[] args) {

    // 프로그램이 실생되면 파일에서 데이터를 읽어온다
    loadShowData();
    loadBoardData();
    loadMemberData();

    // 키보드에서 사용자로부터 입력을 받을 도구를 준비한다.=프롬프트 객체를 생성한다.
    Prompt prompt = new Prompt(keyboard);

    // 사용자명령어를 처리할 객체를 담을 맵을 = 보관소를 준비한다.
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

    // 쇼 멤버 보드 데이터를 파일에 저장(보관).
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
    File file = new File("./show.csv"); // 현재폴더: 비트캠프-프로젝트

    FileReader in = null;
    Scanner dataScan = null;

    try {
      in = new FileReader(file);
      dataScan = new Scanner(in);

      int count = 0;


      // 해당되는 파일에서 데이터를 다읽을 때까지 반복문을 돌린다.
      while (true) {
        try {
          // 스캐너를 통해 해당 파일에서 한 줄을 읽는다.
          String line = dataScan.nextLine(); // 넥스트라인은 노서치엘리먼트 익셉션을 던질때로 데이터 읽었냐 안읽었냐 판단

          // 한 줄 문자열을 콤마(,)를 기준으로 데이터를 쪼갠다
          String[] data = line.split(",");

          Show show = new Show();

          show.setNo(Integer.parseInt(data[0]));
          show.setCountry(data[1]);
          show.setGenre(data[2]);
          show.setTitleKor(data[3]);
          show.setTitleEng(data[4]);
          show.setPoint(Integer.parseInt(data[5]));
          show.setComments(data[6]);
          show.setWatchedEpisode(Integer.parseInt(data[7]));

          showList.add(show);
          count++;

        } catch (Exception e) {
          break; // 반복문을 돌다가 읽어 들일 것이 없으면 반복문을 break한다.
        }
      }

      System.out.printf("총 %d 개의 드라마 데이터를 로딩했습니다.\n", count);


    } catch (FileNotFoundException e) {
      System.out.println("파일 읽기 중 오류 발생! - " + e.getMessage());
      // 파일에서 데이터를 읽다가 오류가 발생하더라도
      // 시스템을 멈추지 않고 계속 실행하게 한다.
      // 이것이 예외처리를 하는 이유이다.
    } finally {
      // 자원이 서로 연결된 경우에는 안쪽 = 다른 자원을 이용하는 객체부터 닫는다.
      try {
        dataScan.close();
      } catch (Exception e) {
        // Scanner 객체 닫다가 오류가 발생하더라도 무시.
      }

      try {
        in.close();
      } catch (Exception e) { // IOException은 널포인트익셉션 처리 못해서 Exception으로 바꿨다.
        // close() 실행 하다가 오류가 발생한 경우 무시.
        // 왜? 닫다가 발생한 오류는 특별히 처리할 게 없다.
      }
    }

  }

  private static void loadBoardData() {
    File file = new File("./board.csv");
    FileReader in = null;
    Scanner dataScan = null;

    try {
      in = new FileReader(file);
      dataScan = new Scanner(in);
      int count = 0;

      while (true) {
        try {
          String line = dataScan.nextLine();
          String[] data = line.split(",");
          Board board = new Board();

          board.setNo(Integer.parseInt(data[0]));
          board.setTitle(data[1]);
          board.setDate(Date.valueOf(data[2])); //
          board.setViewCount(Integer.parseInt(data[3]));
          board.setWriter(data[4]);

          boardList.add(board);
          count++;

        } catch (Exception e) {
          break;
        }
      }
      System.out.printf("총 %d 개의 게시글 데이터를 로딩했습니다.\n", count);

    } catch (FileNotFoundException e) {
      System.out.println("파일 읽기 중 오류 발생! - " + e.getMessage());
    } finally {
      try {
        dataScan.close();
      } catch (Exception e) {
        // Scanner 객체 닫다가 오류가 발생하더라도 무시.
      }
      try {
        in.close();
      } catch (Exception e) {
        // close() 실행하다가 오류가 발생한 경우 무시.
        // 왜? 닫다가 발생한 오류는 특별히 처리할 게 없다.
      }
    }

  }

  private static void loadMemberData() {
    // 데이터가 보관된 파일을 정보를 준비한다.
    File file = new File("./member.csv");

    FileReader in = null;
    Scanner dataScan = null;

    try {
      // 파일을 읽을 때 사용할 도구를 준비한다.
      in = new FileReader(file);

      // .csv 파일에서 한 줄 단위로 문자열을 읽는 기능이 필요한데,
      // FileReader에는 그런 기능이 없다.
      // 그래서 FileReader를 그대로 사용할 수 없고,
      // 이 객체에 다른 도구를 연결하여 사용할 것이다.
      //
      dataScan = new Scanner(in);
      int count = 0;

      while (true) {
        try {
          // 파일에서 한 줄을 읽는다.
          String line = dataScan.nextLine();

          // 한 줄을 콤마(,)로 나눈다.
          String[] data = line.split(",");

          // 한 줄에 들어 있던 데이터를 추출하여 Member 객체에 담는다.
          // => 데이터 순서는 다음과 같다.
          // 번호,이름,이메일,비번,포토,전화번호,등록일
          Member member = new Member();
          member.setNo(Integer.parseInt(data[0]));
          member.setName(data[1]);
          member.setEmail(data[2]);
          member.setPassword(data[3]);
          member.setPhoto(data[4]);
          member.setTel(data[5]);
          member.setRegisteredDate(Date.valueOf(data[6]));

          // Member 객체를 Command가 사용하는 목록에 저장한다.
          memberList.add(member);
          count++;

        } catch (Exception e) {
          break;
        }
      }
      System.out.printf("총 %d 개의 회원 데이터를 로딩했습니다.\n", count);

    } catch (FileNotFoundException e) {
      System.out.println("파일 읽기 중 오류 발생! - " + e.getMessage());
      // 파일에서 데이터를 읽다가 오류가 발생하더라도
      // 시스템을 멈추지 않고 계속 실행하게 한다.
      // 이것이 예외처리를 하는 이유이다!!!
    } finally {
      // 자원이 서로 연결된 경우에는 다른 자원을 이용하는 객체부터 닫는다.
      try {
        dataScan.close();
      } catch (Exception e) {
        // Scanner 객체 닫다가 오류가 발생하더라도 무시한다.
      }
      try {
        in.close();
      } catch (Exception e) {
        // close() 실행하다가 오류가 발생한 경우 무시한다.
        // 왜? 닫다가 발생한 오류는 특별히 처리할 게 없다.
      }
    }
  }


  private static void saveShowData() {

    // 데이터가 보관된 파일 정보를 준비한다.
    File file = new File("./show.csv");

    FileWriter out = null;

    try {
      // 파일에 데이터를 저장할 때 사용할 도구를 준비한다.
      out = new FileWriter(file);
      int count = 0;

      for (Show show : showList) {
        String line = String.format("%d,%s,%s,%s,%s,%d,%s,%d\n", show.getNo(), show.getCountry(),
            show.getGenre(), show.getTitleKor(), show.getTitleEng(), show.getPoint(),
            show.getComments(), show.getWatchedEpisode());


        out.write(line);
        count++;
      }
      System.out.printf("총 %d 개의 드라마 데이터를 저장했습니다.\n", count);

    } catch (IOException e) {
      System.out.println("파일 쓰기 중 오류 발생! - " + e.getMessage());

    } finally {
      try {
        out.close();
      } catch (IOException e) {
        // FileWriter를 닫을 때 발생하는 예외는 무시.

      }
    }
  }

  private static void saveBoardData() {


    File file = new File("./board.csv");

    FileWriter out = null;

    try {
      // 파일에 데이터를 저장할 때 사용할 도구를 준비한다.
      out = new FileWriter(file);
      int count = 0;

      for (Board board : boardList) {
        // 게시글 목록에서 게시글 데이터를 꺼내 CSV 형식의 문자열로 만든다.
        String line = String.format("%d,%s,%s,%d,%s\n", board.getNo(), board.getTitle(),
            board.getDate(), board.getViewCount(), board.getWriter());

        out.write(line);
        count++;
      }
      System.out.printf("총 %d 개의 게시글 데이터를 저장했습니다.\n", count);

    } catch (IOException e) {
      System.out.println("파일 쓰기 중 오류 발생! - " + e.getMessage());

    } finally {
      try {
        out.close();
      } catch (IOException e) {
        // FileWriter를 닫을 때 발생하는 예외는 무시.
      }
    }

  }

  private static void saveMemberData() {
    // 데이터가 보관된 파일을 정보를 준비한다.
    File file = new File("./member.csv");

    FileWriter out = null;

    try {
      // 파일에 데이터를 저장할 때 사용할 도구를 준비한다.
      out = new FileWriter(file);
      int count = 0;

      for (Member member : memberList) {
        // 회원 목록에서 회원 데이터를 꺼내 CSV 형식의 문자열로 만든다.
        String line = String.format("%d,%s,%s,%s,%s,%s,%s\n", member.getNo(), member.getName(),
            member.getEmail(), member.getPassword(), member.getPhoto(), member.getTel(),
            member.getRegisteredDate());

        out.write(line);
        count++;
      }
      System.out.printf("총 %d 개의 회원 데이터를 저장했습니다.\n", count);

    } catch (IOException e) {
      System.out.println("파일 쓰기 중 오류 발생! - " + e.getMessage());

    } finally {
      try {
        out.close();
      } catch (IOException e) {
        // FileWriter를 닫을 때 발생하는 예외는 무시.
      }
    }

  }



}


