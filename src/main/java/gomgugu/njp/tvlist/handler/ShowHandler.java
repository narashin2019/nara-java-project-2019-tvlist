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



  public void detailShow() {
    System.out.println("번호? ");
    int index = input.nextInt();
    input.nextLine();

    Show show = (Show) this.showList.get(index); //(Show) 가 있는것 ㅇㅄ는것으 ㅣ차이?

    if (show == null) {
      System.out.println("해당 드라마를 찾을 수 없습니다.");
      return;
    }

    System.out.printf("제목한글: %s\n", show.getTitleKor());
    System.out.printf("제목영문: %s\n", show.getTitleEng());
    System.out.printf("기간: %s ~ %s\n", show.getStartDate(), show.getEndDate());
    System.out.printf("별점: %d\n", show.getRatedStar());
    System.out.printf("키워드: %s\n", show.getKeywords());
    System.out.printf("어디까지봤니: %d\n", show.getWatchedEpisode());
  }


  public void updateShow() {
    System.out.println("번호? ");
    int index = input.nextInt();
    input.nextLine();

    Show oldShow = this.showList.get(index); 

    if (oldShow == null) {
      System.out.println("해당 드라마를 찾을 수 없습니다.");
      return;
    }

    System.out.printf("제목한글(%s)? ", oldShow.getTitleKor());
    String titleKor = input.nextLine();

    System.out.printf("제목영문(%s)? ", oldShow.getTitleEng());
    String titleEng = input.nextLine();

    System.out.printf("시작일(%s)? ", oldShow.getStartDate());
    Date startDate = Date.valueOf(input.next());

    System.out.printf("종료일(%s)? ", oldShow.getEndDate());
    Date endDate = Date.valueOf(input.next());

    System.out.printf("별점(%d)? ", oldShow.getRatedStar());
    int ratedStar = input.nextInt();
    input.nextLine();
    
    System.out.printf("키워드(%s)? ", oldShow.getKeywords());
    String keywords = input.nextLine();

    System.out.printf("어디까지봤니(%d)? ", oldShow.getWatchedEpisode());
    int watchedEpisode = input.nextInt();
    input.nextLine();

    //    if (description.length() == 0) {
    //      System.out.println("수업정보 변경을 취소했습니다.");
    //      return;
    //    }



    Show newShow = new Show();
    newShow.setNo(oldShow.getNo());
    newShow.setTitleKor(titleKor);
    newShow.setTitleEng(titleEng);
    newShow.setStartDate(startDate);
    newShow.setEndDate(endDate);
    newShow.setRatedStar(ratedStar);
    newShow.setKeywords(keywords);
    newShow.setWatchedEpisode(watchedEpisode);

    this.showList.set(index, newShow);

    System.out.println("드라마 정보를 변경했습니다.");
  }

  
  public void deleteShow() {
    System.out.print("게시글 인덱스? ");
    int index = input.nextInt();
    input.nextLine(); // 숫자 뒤의 남은 공백 제거
    
    Show show = this.showList.get(index);
    
    if (show == null) {
      System.out.println("게시글 인덱스가 유효하지 않습니다.");
      return;
    }
    
    this.showList.remove(index);
    
    System.out.println("게시글을 삭제했습니다.");
  }

  
  
  
  
  

}
