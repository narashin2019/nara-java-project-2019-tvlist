// 프로젝트: 내가 본 드라마(TV Show) 목록 정리 및 공유
// App: 드라마정보
package gomgugu.njp.tvlist;

import java.util.Scanner;
import java.sql.Date;

public class App {

  public static void main(String[] args) {
    
    Scanner keyboard = new Scanner(System.in);

    final int LENGTH = 10000;
    int count = 0;

    int[] no = new int[LENGTH];
    String[] country = new String[LENGTH];
    String[] genres = new String[LENGTH];
    String[] titleKor = new String[LENGTH];
    String[] titleEng = new String[LENGTH];
    int[] ratedStar = new int[LENGTH];
    String[] comments = new String[LENGTH];
    String[] keywords = new String[LENGTH];
    Date[] startDate = new Date[LENGTH];
    Date[] endDate = new Date[LENGTH];
    int[] watchedEpisode = new int[LENGTH];


    for (int i = 0; i < LENGTH; i++ ) {
      System.out.print("번호? ");
      no[i] = keyboard.nextInt();
      keyboard.nextLine();

      System.out.print("국가? ");
      country[i] = keyboard.nextLine();

      System.out.print("장르? ");
      genres[i] = keyboard.nextLine();

      System.out.print("제목한글? ");
      titleKor[i] = keyboard.nextLine();

      System.out.print("제목영문? ");
      titleEng[i] = keyboard.nextLine();

      System.out.print("별점? ");
      ratedStar[i] = keyboard.nextInt();
      keyboard.nextLine();

      System.out.print("코멘트? ");
      comments[i] = keyboard.nextLine();

      System.out.print("키워드? ");
      keywords[i] = keyboard.nextLine();

      System.out.print("시작일? ");
      startDate[i] = Date.valueOf(keyboard.nextLine()); 

      System.out.print("종료일? ");
      endDate[i] = Date.valueOf(keyboard.next()); 
      keyboard.nextLine();

      System.out.print("어디까지봤니? ");
      watchedEpisode[i] = keyboard.nextInt();
      keyboard.nextLine();

      count++;

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
      System.out.printf("%d, %-20s, %s ~ %s, %d\n", no[i], titleKor[i], 
          startDate[i], endDate[i], watchedEpisode[i]);
    }
    
    
  }
}
