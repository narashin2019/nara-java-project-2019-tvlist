package gomgugu.njp.tvlist;

<<<<<<< HEAD
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
=======
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
>>>>>>> c2cf5c280407991c6fe814c4aa1d3581a59914c4
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import gomgugu.njp.tvlist.context.ApplicationContextListener;
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

  Scanner keyboard = new Scanner(System.in);

  Deque<String> commandStack = new ArrayDeque<>();
  Queue<String> commandQueue = new LinkedList<>();

  List<Show> showList = new ArrayList<>();
  List<Board> boardList = new ArrayList<>();
  List<Member> memberList = new ArrayList<>();

  // 옵저버 목록을 관리할 객체 준비
  // - 같은 인스턴스를 중복해서 등록하지 않도록 한다. 그래서 리스트 대신 set 썼다.
  // - Set은 등록 순서를 따지지 않는다.
  Set<ApplicationContextListener> listeners = new HashSet<>();
  
  // 옵저버를 등록하는 메서드이다.
  public void addApplicationContextListener(ApplicationContextListener listener) {
    listeners.add(listener);
  }

  // 옵저버를 제거하는 메서드이다.
  public void removeApplicationContextListener(ApplicationContextListener listener) {
    listeners.remove(listener);
  }

  // 애플리케이션이 시작되면, 등록된 리스너에게 알린다.
  private void notifyApplicationInitialized() {
    for (ApplicationContextListener listener : listeners) {
      listener.contextInitialized();
    }
  }

  // 애플리케이션이 종료되면, 등록된 리스너에게 알린다.
  private void notifyApplicationDestroyed() {
    for (ApplicationContextListener listener : listeners) {
      listener.contextDestroyed();
    }
  }

  public void service() {

<<<<<<< HEAD
    notifyApplicationInitialized(); // 주석대신 외부 메서드로

=======
>>>>>>> c2cf5c280407991c6fe814c4aa1d3581a59914c4
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
    saveMemberData();
    saveBoardData();

    notifyApplicationDestroyed(); // 주석대신 외부 메서드로

  } // service()


  private void printCommandHistory(Iterator<String> iterator) {
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


<<<<<<< HEAD
  @SuppressWarnings("unchecked")
  private void loadShowData() {
    File file = new File("./lesson.ser2");

    try (ObjectInputStream in =
        new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
      showList = (List<Show>) in.readObject();
=======
  private static void loadShowData() {
    File file = new File("./show.json");

    try (BufferedReader in = new BufferedReader(new FileReader(file))) {
      showList.addAll(Arrays.asList(new Gson().fromJson(in, Show[].class)));
>>>>>>> c2cf5c280407991c6fe814c4aa1d3581a59914c4
      System.out.printf("총 %d 개의 드라마 데이터를 로딩했습니다.\n", showList.size());

    } catch (Exception e) {
      System.out.println("파일 읽기 중 오류 발생! - " + e.getMessage());
    }
  }

<<<<<<< HEAD

  @SuppressWarnings("unchecked")
  private void loadBoardData() {
    File file = new File("./board.ser2");

    try (ObjectInputStream in =
        new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
      boardList = (List<Board>) in.readObject();
      System.out.printf("총 %d 개의 게시물 데이터를 로딩했습니다.\n", boardList.size());

    } catch (Exception e) {
=======
  private static void loadBoardData() {
    File file = new File("./board.json");

    try (BufferedReader in = new BufferedReader(new FileReader(file))) {
      boardList.addAll(Arrays.asList(new Gson().fromJson(in, Board[].class)));
      System.out.printf("총 %d 개의 게시물 데이터를 로딩했습니다.\n", boardList.size());

    } catch (IOException e) {
>>>>>>> c2cf5c280407991c6fe814c4aa1d3581a59914c4
      System.out.println("파일 읽기 중 오류 발생! - " + e.getMessage());
    }
  }

<<<<<<< HEAD
  @SuppressWarnings("unchecked")
  private void loadMemberData() {
    File file = new File("./member.ser2");

    try (ObjectInputStream in =
        new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
      memberList = (List<Member>) in.readObject();
      System.out.printf("총 %d 개의 회원 데이터를 로딩했습니다.\n", memberList.size());

    } catch (Exception e) {
=======

  private static void loadMemberData() {
    File file = new File("./member.json");

    try (BufferedReader in = new BufferedReader(new FileReader(file))) {
      memberList.addAll(Arrays.asList(new Gson().fromJson(in, Member[].class)));
      System.out.printf("총 %d 개의 회원 데이터를 로딩했습니다.\n", memberList.size());

    } catch (IOException e) {
>>>>>>> c2cf5c280407991c6fe814c4aa1d3581a59914c4
      System.out.println("파일 읽기 중 오류 발생! - " + e.getMessage());
    }
  }

  private void saveShowData() {
    File file = new File("./show.ser2");

<<<<<<< HEAD
    try (ObjectOutputStream out =
        new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
    
      out.writeObject(showList);
      
      System.out.printf("총 %d 개의 드라마 데이터를 저장했습니다.\n", showList.size());
=======
  private static void saveShowData() {

    // 데이터가 보관된 파일 정보를 준비한다.
    File file = new File("./show.json");

    try (BufferedWriter out = new BufferedWriter(new FileWriter(file))) {
      out.write(new Gson().toJson(showList));
      System.out.printf("총 %d 개의 드라마 데이터를 저장했습니다.\n", showList.size());

>>>>>>> c2cf5c280407991c6fe814c4aa1d3581a59914c4
    } catch (IOException e) {
      System.out.println("파일 쓰기 중 오류 발생! - " + e.getMessage());
    }
  }

<<<<<<< HEAD
  private void saveBoardData() {
    File file = new File("./board.ser2");

    try (ObjectOutputStream out =
        new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
      out.writeObject(boardList);
=======

  private static void saveBoardData() {
    File file = new File("./board.json");

    try (BufferedWriter out = new BufferedWriter(new FileWriter(file))) {
      out.write(new Gson().toJson(boardList));
>>>>>>> c2cf5c280407991c6fe814c4aa1d3581a59914c4
      System.out.printf("총 %d 개의 게시물 데이터를 저장했습니다.\n", boardList.size());

    } catch (IOException e) {
      System.out.println("파일 쓰기 중 오류 발생! - " + e.getMessage());

    }
  }

<<<<<<< HEAD

  private void saveMemberData() {
    File file = new File("./member.ser2");

    try (ObjectOutputStream out =
        new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
      out.writeObject(memberList);
=======

  private static void saveMemberData() {
    File file = new File("./member.json");

    try (BufferedWriter out = new BufferedWriter(new FileWriter(file))) {
      out.write(new Gson().toJson(memberList));
>>>>>>> c2cf5c280407991c6fe814c4aa1d3581a59914c4
      System.out.printf("총 %d 개의 회원 데이터를 저장했습니다.\n", memberList.size());

    } catch (IOException e) {
      System.out.println("파일 쓰기 중 오류 발생! - " + e.getMessage());
    }
  }
  
  }






