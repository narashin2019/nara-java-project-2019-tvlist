package gomgugu.njp.tvlist;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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

  // 옵저버 목록을 관리할 객체 준비
  // - 같은 인스턴스를 중복해서 등록하지 않도록 한다.
  // - Set은 등록 순서를 따지지 않는다.
  Set<ApplicationContextListener> listeners = new HashSet<>();

  // 옵저버와 공유할 값을 보관할 객체를 준비한다.
  Map<String, Object> context = new HashMap<>();

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
      // 옵저버를 실행할 때 작업 결과를 리턴 받을 수 있도록 바구니를 넘긴다.
      // 물론 옵저버에게 전달할 값이 있으면 넘기기 전에 바구니에 담도록 한다.
      // 파라미터 Map과 같은 객체를 사용하면 이런 점에서 편하다.
      // 즉 파라미터로 값을 전달(IN)하고 리턴(OUT) 받을 수 있다.
    
      listener.contextInitialized(context);
    }
  }

  // 애플리케이션이 종료되면, 등록된 리스너에게 알린다.
  private void notifyApplicationDestroyed() {
    for (ApplicationContextListener listener : listeners) {
      // 옵저버를 실행할 때 작업 결과를 리턴 받을 수 있도록 바구니를 넘긴다.
      // 물론 옵저버에게 전달할 값이 있으면 넘기기 전에 바구니에 담도록 한다.
      // 파라미터 Map과 같은 객체를 사용하면 이런 점에서 편하다.
      // 즉 파라미터로 값을 전달(IN)하고 리턴(OUT) 받을 수 있다.
      listener.contextDestroyed(context);
    }
  }

  @SuppressWarnings("unchecked")
  public void service() {

    // 애플리케이션이 시작되면 등록된 옵저버를 실행한다.
    // 즉 DataLoaderListener를 실행한다.
    notifyApplicationInitialized(); 


    // 옵저버의 실행이 끝났으면 DataLoaderListener 옵저버가 준비한
    // List 객체를 꺼내보자!
    // command에서 쓸 수 있도록
    List<Board> boardList = (List<Board>) context.get("boardList");
    List<Show> showList = (List<Show>) context.get("showList");
    List<Member> memberList = (List<Member>) context.get("memberList");
    
    
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


  public static void main(String[] args) {
    App app = new App();

    // 애플리케이션 시작 종료 시 인사하는 것을 추가한다.
    app.addApplicationContextListener(new GreetingListener());
    // 애플리케이션의 상태를 정보를 받을 옵저버를 등록한다.
    app.addApplicationContextListener(new DataLoaderListener());

    app.service();
  }
}





