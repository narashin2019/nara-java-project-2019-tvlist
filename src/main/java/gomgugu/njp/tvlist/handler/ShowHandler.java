package gomgugu.njp.tvlist.handler;

import java.sql.Date;
import java.util.Scanner;
import gomgugu.njp.tvlist.domain.Show;

public class ShowHandler {

  // 인스턴스 필드 (non-static field)
  // => 각 드라마 목록을 개별적으로 관리
  Show[] shows = new Show[SHOW_SIZE];
  int showCount = 0;

  //클래스 필드 (static field)
  static final int SHOW_SIZE = 100;
  public static Scanner keyboard;
  
  //클래스 메서드
  // => 인스턴스 없이 호출하는 메서드이다.
  // => 인스턴스를 사용하려면 파라미터를 통해 호출할 때 외부에서 받아야 한다.
  // => addShow는 클래스 메서드이지 클래스 필드가 아니다.
  // => 따라서 그냥 접근할 수 없고 접근 파라미터를 통해 외부에서 받는다.
  // => 레퍼런스 변수는 소문자로 시작
  public static void addShow(ShowHandler showHandler) {
    Show show = new Show();

    System.out.print("번호? ");
    show.no = keyboard.nextInt();
    keyboard.nextLine();

    System.out.print("국가? ");
    show.country = keyboard.nextLine();

    System.out.print("장르? ");
    show.genres = keyboard.nextLine();

    System.out.print("제목한글? ");
    show.titleKor = keyboard.nextLine();

    System.out.print("제목영문? ");
    show.titleEng = keyboard.nextLine();

    System.out.print("별점? ");
    show.ratedStar = keyboard.nextInt();
    keyboard.nextLine();

    System.out.print("코멘트? ");
    show.comments = keyboard.nextLine();

    System.out.print("키워드? ");
    show.keywords = keyboard.nextLine();

    System.out.print("시작일? ");
    show.startDate = Date.valueOf(keyboard.nextLine()); 

    System.out.print("종료일? ");
    show.endDate = Date.valueOf(keyboard.next()); 
    keyboard.nextLine();

    System.out.print("어디까지봤니? ");
    show.watchedEpisode = keyboard.nextInt();
    keyboard.nextLine();

    showHandler.shows[showHandler.showCount++] = show;
    System.out.println("저장하였습니다.");
  }
  
  public static void listShow(ShowHandler showHandler) {
    for (int i = 0; i < showHandler.showCount; i++) {
      Show s = showHandler.shows[i];
      System.out.printf("%d, %-20s, %s ~ %s, %d\n", 
          s.no, s.titleKor, s.startDate, 
          s.endDate, s.watchedEpisode);
    }
  }
  
}
