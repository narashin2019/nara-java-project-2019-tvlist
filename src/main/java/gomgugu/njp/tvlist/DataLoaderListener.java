package gomgugu.njp.tvlist;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import gomgugu.njp.tvlist.context.ApplicationContextListener;
import gomgugu.njp.tvlist.domain.Board;
import gomgugu.njp.tvlist.domain.Member;
import gomgugu.njp.tvlist.domain.Show;

// 애플리케이션이 시작되거나 종료될 때
// 데이터를 로딩하고 저장하는 일을 한다.
//
public class DataLoaderListener implements ApplicationContextListener {

  List<Show> showList = new ArrayList<>();
  List<Member> memberList = new ArrayList<>();
  List<Board> boardList = new ArrayList<>();

  @Override
  public void contextInitialized(Map<String, Object> context) {
    System.out.println("데이터를 로딩합니다.");

    // 애플리케이션이 시작되면 이 메서드가 호출될 것이고,
    // 이 메서드에서는 애플리케이션에서 사용할 데이터를 로딩하는 일을 한다.
    loadBoardData();
    loadShowData();
    loadMemberData();

    // 데이터가 저장되어 있는 List 객체를 이 메서드를 호출한 쪽(App)에서
    // 사용할 수 있도록 Map 객체에 담아둔다.
    context.put("boardList", boardList);
    context.put("lessonList", showList);
    context.put("memberList", memberList);
  }

  @Override
  public void contextDestroyed(Map<String, Object> context) {
    System.out.println("데이터를 저장합니다.");

    // 애플리케이션이 종료되면 이 메서드가 호출될 것이고,
    // 이 메서드에서는 애플리케이션이 작업한 데이터를 저장하는 일을 한다.
    saveBoardData();
    saveShowData();
    saveMemberData();

  }

  @SuppressWarnings("unchecked")
  private void loadShowData() {
    File file = new File("./show.ser2");

    try (ObjectInputStream in =
        new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
      showList = (List<Show>) in.readObject();
      System.out.printf("총 %d 개의 드라마 데이터를 로딩했습니다.\n", showList.size());

    } catch (Exception e) {
      System.out.println("파일 읽기 중 오류 발생! - " + e.getMessage());
    }
  }

  private void saveShowData() {
    File file = new File("./show.ser2");

    try (ObjectOutputStream out =
        new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
      out.writeObject(showList);
      System.out.printf("총 %d 개의 드라마 데이터를 저장했습니다.\n", showList.size());

    } catch (IOException e) {
      System.out.println("파일 쓰기 중 오류 발생! - " + e.getMessage());
    }
  }

  @SuppressWarnings("unchecked")
  private void loadMemberData() {
    File file = new File("./member.ser2");

    try (ObjectInputStream in =
        new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
      memberList = (List<Member>) in.readObject();
      System.out.printf("총 %d 개의 회원 데이터를 로딩했습니다.\n", memberList.size());

    } catch (Exception e) {
      System.out.println("파일 읽기 중 오류 발생! - " + e.getMessage());
    }
  }

  private void saveMemberData() {
    File file = new File("./member.ser2");

    try (ObjectOutputStream out =
        new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
      out.writeObject(memberList);
      System.out.printf("총 %d 개의 회원 데이터를 저장했습니다.\n", memberList.size());

    } catch (IOException e) {
      System.out.println("파일 쓰기 중 오류 발생! - " + e.getMessage());
    }
  }

  @SuppressWarnings("unchecked")
  private void loadBoardData() {
    File file = new File("./board.ser2");

    try (ObjectInputStream in =
        new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
      boardList = (List<Board>) in.readObject();
      System.out.printf("총 %d 개의 게시물 데이터를 로딩했습니다.\n", boardList.size());

    } catch (Exception e) {
      System.out.println("파일 읽기 중 오류 발생! - " + e.getMessage());
    }
  }

  private void saveBoardData() {
    File file = new File("./board.ser2");

    try (ObjectOutputStream out =
        new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
      out.writeObject(boardList);
      System.out.printf("총 %d 개의 게시물 데이터를 저장했습니다.\n", boardList.size());

    } catch (IOException e) {
      System.out.println("파일 쓰기 중 오류 발생! - " + e.getMessage());

    }
  }
}
