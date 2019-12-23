package gomgugu.njp.tvlist;

import java.sql.Date;
import java.util.Scanner;

public class ShowHandler {

  static class Show {
    int no;
    String country;
    String genres;
    String titleKor;
    String titleEng;
    int ratedStar;
    String comments;
    String keywords;
    Date startDate;
    Date endDate;
    int watchedEpisode;
  }
  static final int SHOW_SIZE = 10000;
  static Show[] shows = new Show[SHOW_SIZE];
  static int showCount = 0;
  //키보드는 app의 키보드를 쓴다고 코드입력해야함, import문 반드시 입력
  static Scanner keyboard;
  
  static void addShow() {
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

    shows[showCount++] = show;
    System.out.println("저장하였습니다.");
  }
  
  static void listShow() {
    for (int i = 0; i < showCount; i++) {
      Show s = shows[i];
      System.out.printf("%d, %-20s, %s ~ %s, %d\n", 
          s.no, s.titleKor, s.startDate, 
          s.endDate, s.watchedEpisode);
    }
  }
  
}
