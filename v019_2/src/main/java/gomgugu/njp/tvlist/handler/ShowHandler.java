// 게시글 인덱스로 객체를 찾는 대신에 
// 게시글을 입력할 때 등록한 번호로 객체를 찾도록 변경한다. 
// 게시글 번호로 객체를 찾는 코드를 관리하기 쉽게 별도의 메서드로 분리한다.
// => indexOfBoard(int) 메서드 추가
//
//
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
    show.setPoint(input.nextInt());
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
    System.out.print("번호? ");
    int no = input.nextInt();
    input.nextLine(); // 숫자 뒤의 남은 공백 제거
    
    int index = indexOfShow(no);
    
    if (index == -1) {
      System.out.println("해당 번호의 드라마 정보가 없습니다.");
      return;
    }

    Show show = this.showList.get(index);

    System.out.printf("제목한글: %s\n", show.getTitleKor());
    System.out.printf("제목영문: %s\n", show.getTitleEng());
    System.out.printf("기간: %s ~ %s\n", show.getStartDate(), show.getEndDate());
    System.out.printf("별점: %d\n", show.getPoint());
    System.out.printf("키워드: %s\n", show.getKeywords());
    System.out.printf("어디까지봤니: %d\n", show.getWatchedEpisode());
  }


  public void updateShow() {
    System.out.print("번호? ");
    int no = input.nextInt();
    input.nextLine(); // 숫자 뒤의 남은 공백 제거
    
    int index = indexOfShow(no);
    
    if (index == -1) {
      System.out.println("해당 번호의 드라마 정보가 없습니다.");
      return;
    }
    
    Show oldShow = this.showList.get(index); 

    boolean changed = false;
    String inputStr = null;
    Show newShow = new Show();
    
    newShow.setNo(oldShow.getNo());
    
    System.out.printf("제목한글(%s)? ", oldShow.getTitleKor());
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newShow.setTitleKor(oldShow.getTitleKor());
    } else {
      newShow.setTitleKor(inputStr);
      changed = true;
    }

    System.out.printf("제목영문(%s)? ", oldShow.getTitleEng());
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newShow.setTitleEng(oldShow.getTitleEng());
    } else {
      newShow.setTitleEng(inputStr);
      changed = true;
    }

    System.out.printf("시작일(%s)? ", oldShow.getStartDate());
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newShow.setStartDate(oldShow.getStartDate());
    } else {
      newShow.setStartDate(Date.valueOf(inputStr));
      changed = true;
    }

    System.out.printf("종료일(%s)? ", oldShow.getEndDate());
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newShow.setEndDate(oldShow.getEndDate());
    } else {
      newShow.setEndDate(Date.valueOf(inputStr));
      changed = true;
    }


    System.out.printf("별점(%d)? ", oldShow.getPoint());
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newShow.setPoint(oldShow.getPoint());
    } else {
      newShow.setPoint(Integer.parseInt(inputStr));
      changed = true;
    }
    
    
    System.out.printf("키워드(%s)? ", oldShow.getKeywords());
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newShow.setKeywords(oldShow.getKeywords());
    } else {
      newShow.setKeywords(inputStr);
      changed = true;
    }

    System.out.printf("어디까지봤니(%d)? ", oldShow.getWatchedEpisode());
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newShow.setWatchedEpisode(oldShow.getWatchedEpisode());
    } else {
      newShow.setWatchedEpisode(Integer.parseInt(inputStr));
      changed = true;
    }

    if (changed) {
      this.showList.set(index, newShow);
      System.out.println("드라마 정보를 변경했습니다.");
    } else {
      System.out.println("변경을 취소하였습니다.");
    }
  }



  
  public void deleteShow() {
    System.out.print("번호? ");
    int no = input.nextInt();
    input.nextLine(); // 숫자 뒤의 남은 공백 제거
    
    int index = indexOfShow(no);
    
    if (index == -1) {
      System.out.println("해당 번호의 드라마 정보가 없습니다.");
      return;
    }
    
    this.showList.remove(index);
    
    System.out.println("드라마를 삭제했습니다.");
  }

  private int indexOfShow(int no) {
    for (int i = 0; i < this.showList.size(); i++) {
      if (this.showList.get(i).getNo() == no) {
        return i;
      }
    }
    return -1;
  }
  
  
  
  

}
