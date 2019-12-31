package gomgugu.njp.tvlist.handler;

import java.sql.Date;
import java.util.Scanner;
import gomgugu.njp.tvlist.domain.Show;

public class ShowHandler {

  // 인스턴스 필드 (non-static field)
  // => 각 드라마 목록을 개별적으로 관리
  Show[] shows;
  int showCount = 0;

  public Scanner input;

  //클래스 필드 (static field)
  // => 공유하는 변수
  static final int SHOW_SIZE = 100;
  
  public ShowHandler(Scanner input) {
    this.input = input;
    this.shows = new Show[SHOW_SIZE];
  }
  
  
  //클래스 메서드 > 인스턴스 메서드로!
  public void addShow() {
    Show show = new Show();

    System.out.print("번호? ");
    show.setNo(input.nextInt());
    input.nextLine();

    System.out.print("국가? ");
    show.setCountry(input.nextLine());

    System.out.print("장르? ");
    show.setGenres(input.nextLine());

    System.out.print("제목한글? ");
    show.setTitleKor(input.nextLine());

    System.out.print("제목영문? ");
    show.setTitleEng(input.nextLine());

    System.out.print("별점? ");
    show.setRatedStar(input.nextInt());
    input.nextLine();

    System.out.print("코멘트? ");
    show.setComments(input.nextLine());

    System.out.print("키워드? ");
    show.setKeywords(input.nextLine());

    System.out.print("시작일? ");
    show.setStartDate(Date.valueOf(input.nextLine())); 

    System.out.print("종료일? ");
    show.setEndDate(Date.valueOf(input.next())); 
    input.nextLine();

    System.out.print("어디까지봤니? ");
    show.setWatchedEpisode(input.nextInt());
    input.nextLine();

    this.shows[this.showCount++] = show;
    System.out.println("저장하였습니다.");
  }
  
  public void listShow() {
    for (int i = 0; i < this.showCount; i++) {
      Show s = this.shows[i];
      System.out.printf("%d, %-20s, %s ~ %s, %d\n", 
          s.getNo(), s.getTitleKor(), s.getStartDate(), 
          s.getEndDate(), s.getWatchedEpisode());
    }
  }
  
}
