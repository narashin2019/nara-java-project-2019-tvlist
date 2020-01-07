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
    
    Show show = (Show) this.showList.get(index);
    
    if (show == null) {
      System.out.println("해당 드라마를 찾을 수 없습니다.");
      return;
    }
    
    System.out.printf("제목한글: %s\n", show.getTitleKor());
    System.out.printf("제목영문: %s\n", show.getTitleEng());
    System.out.printf("기간: %s ~ %s\n", show.getStartDate(), show.getEndDate());
    System.out.printf("별점: %s\n", show.getRatedStar());
    System.out.printf("어디까지봤니: %s\n", show.getWatchedEpisode());
  }
  
  
  public void updateShow() {
    System.out.println("번호? ");
    int index = input.nextInt();
    input.nextLine();
    
    Show oldShow = (Lesson) this.lessonList.get(index); 
    
    if (oldLesson == null) {
      System.out.println("해당 수업을 찾을 수 없습니다.");
      return;
    }
    
    System.out.printf("수업명(%s)? ", oldLesson.getTitle());
    String title = input.nextLine();
    
    
    System.out.printf("수업내용? ", oldLesson.getDescription());
    String description = input.nextLine();

//    if (description.length() == 0) {
//      System.out.println("수업정보 변경을 취소했습니다.");
//      return;
//    }
    
    System.out.printf("시작일(%s)? ", oldLesson.getStartDate());
    Date startDate = Date.valueOf(input.next());
      
    System.out.printf("종료일(%s)? ", oldLesson.getEndDate());
    Date endDate = Date.valueOf(input.next());
    
    System.out.printf("총수업시간(%s)? ", oldLesson.getDescription());
    int totalHours = input.nextInt();
    
    System.out.printf("일수업시간(%s)? ", oldLesson.getDescription());
    int dayHours = input.nextInt();
    input.nextLine(); 
    
    
    
    
    Lesson newLesson = new Lesson();
    newLesson.setNo(oldLesson.getNo());
    newLesson.setTitle(title);
    newLesson.setDescription(description);
    newLesson.setStartDate(startDate);
    newLesson.setEndDate(endDate);
    newLesson.setTotalHours(totalHours);
    newLesson.setDayHours(dayHours);
    
    this.lessonList.set(index, newLesson);
    
    System.out.println("수업을 변경했습니다.");
  }
  
  
  
}
