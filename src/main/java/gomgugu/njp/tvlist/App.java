// 프로젝트: 내가 본 드라마(TV Show) 목록 정리 및 공유
// App: 드라마정보
package gomgugu.njp.tvlist;

import java.util.Scanner;
import java.sql.Date;

public class App {

  public static void main(String[] args) {
    
    Scanner keyboard = new Scanner(System.in);
    
    class Show {
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
    
    
    final int SIZE = 10000;

    // Show인스턴스 주소를 담을 레퍼런스 배열을 만들었다.
    Show[] shows = new Show[SIZE];


    int count = 0;
    for (int i = 0; i < SIZE; i++ ) {
      count++;

      //Show형식으로 된 식판을 하나 만들었다. 그 주소는 show
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

      // 위에 생성한 배열에 식판을 꼽는다.
      shows[i] = show;
      
      System.out.println();
      System.out.println("계속 입력하시겠습니까?(Y/n)");
      String response = keyboard.next();

      if(!response.equalsIgnoreCase("y")) {
        break;
      }
    }

    keyboard.close();
    
    System.out.println();
    
    for (int i = 0; i < count; i++) {
      // 위에서 만든 배열 불러오기
      Show show = shows[i];
      System.out.printf("%d, %-20s, %s ~ %s, %d\n", 
          show.no, show.titleKor, show.startDate, 
          show.endDate, show.watchedEpisode);
    }
    
  }
}
