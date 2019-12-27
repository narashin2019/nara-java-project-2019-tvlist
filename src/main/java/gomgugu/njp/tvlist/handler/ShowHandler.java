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
  // => 공유하는 변수
  static final int SHOW_SIZE = 100;
  public static Scanner keyboard;
  
  //클래스 메서드 > 인스턴스 메서드로!
  public void addShow() {
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

    this.shows[this.showCount++] = show;
    System.out.println("저장하였습니다.");
  }
  
  public void listShow() {
    for (int i = 0; i < this.showCount; i++) {
      Show s = this.shows[i];
      System.out.printf("%d, %-20s, %s ~ %s, %d\n", 
          s.no, s.titleKor, s.startDate, 
          s.endDate, s.watchedEpisode);
    }
  }
  
}
