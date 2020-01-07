package gomgugu.njp.tvlist.handler;

import java.sql.Date;
import java.util.Scanner;
import gomgugu.njp.tvlist.domain.Show;
import gomgugu.njp.util.ArrayList;

public class ShowHandler {

  ArrayList<Show> showList;
  
  Scanner input;

  public ShowHandler(Scanner input) {
    this.input = input;
    this.showList = new ArrayList<>();
  }
  
  public ShowHandler(Scanner input, int capacity) {
    this.input = input;
    this.showList = new ArrayList<>(capacity); 
  }
  
  
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

    showList.add(show);
    
    System.out.println("저장하였습니다.");
  }
  
  public void listShow() {
    // 수업 객체 목록을 복사 받을 배열을 준비하고, toArray()를 실행한다.
    // toArray()의 리턴 값은 파라미터로 넘겨준 배열의 주소이다. (기존배열그대로씀)
    Show[] arr = this.showList.toArray(new Show[this.showList.size()]);
    
    for (Show s : arr) {
      System.out.printf("%d, %-20s, %s ~ %s, %d\n", 
          s.getNo(), s.getTitleKor(), s.getStartDate(), 
          s.getEndDate(), s.getWatchedEpisode());
    }
  }
  
}
