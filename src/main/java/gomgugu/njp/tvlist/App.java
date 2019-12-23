// 프로젝트: 내가 본 드라마(TV Show) 목록 정리 및 공유
// App: 드라마, 회원, 게시글

package gomgugu.njp.tvlist;

import java.util.Scanner;
import java.sql.Date;

public class App {
  
  static Scanner keyboard = new Scanner(System.in);

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

  static class Member{
    int no;
    String name;
    String email; 
    String password; 
    String photo; 
    String tel; 
    Date registeredDate;
  }

  static final int MEMBER_SIZE = 10000; 
  static Member[] members = new Member[MEMBER_SIZE];
  static int memberCount = 0;

  static class Board{
    int no; 
    String title;  
    String contents;
    Date date;
    int viewCount;
  }

  static final int BOARD_SIZE = 10000;
  static Board[] boards = new Board[BOARD_SIZE];
  static int boardCount = 0;

  
  public static void main(String[] args) {
 
    String command;

    do {
      System.out.println("명령>");
      command = keyboard.nextLine();

      switch (command) {
        case "/show/add" :
          // 분리된 메서드 호출하는 방법
          addShow();
          break;

        case "/show/list" :
          listShow();
          break;

        case "/member/add" :
          addMember();
          break;

        case "/member/list" :
          listMember();
          break;

        case "/board/add" :
          addBoard();
          break;

        case "/board/list" :
          listBoard();
          break;        

        default : 
          if (!command.equalsIgnoreCase("quit"))
            System.out.println("실행할 수 없는 명령입니다.");
      }

    } while (!command.equalsIgnoreCase("quit"));
    
    System.out.println("안녕!");

    keyboard.close();
  } //main
  
  
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
    
  static void addMember() {
    Member member = new Member();

    System.out.print("번호? ");
    member.no = keyboard.nextInt();
    keyboard.nextLine();

    System.out.print("이름? ");
    member.name = keyboard.nextLine();

    System.out.print("이메일? ");
    member.email = keyboard.nextLine();

    System.out.print("암호? ");
    member.password = keyboard.nextLine();

    System.out.print("사진? ");
    member.photo = keyboard.nextLine();

    System.out.print("전화? ");
    member.tel = keyboard.nextLine();

    member.registeredDate = new Date(System.currentTimeMillis()); 
    keyboard.nextLine();

    members[memberCount++] = member;
    System.out.println("저장하였습니다.");
  }    
  
  static void listMember() {
    for (int i=0; i<memberCount; i++) {
      Member m = members[i];
      System.out.printf("%d, %s, %-30s, %-15s %s\n", m.no, 
          m.name, m.email, m.tel, m.registeredDate);
    }
  }
  
  static void addBoard() {
    Board board = new Board();

    System.out.print("번호? ");
    board.no = keyboard.nextInt();
    keyboard.nextLine(); 

    System.out.print("제목? ");
    board.title = keyboard.nextLine();

    System.out.print("내용? ");
    board.contents = keyboard.nextLine();

    board.date = new Date(System.currentTimeMillis());

    board.viewCount = 0;

    boards[boardCount++] = board;
    System.out.println("저장하였습니다.");
  }
  
  static void listBoard() {
    for (int i = 0; i < boardCount; i++) {
      Board b = boards[i];
      System.out.printf("%d, %-20s, %s, %d\n", 
          b.no, b.title, b.date, b.viewCount);
    }
  }
    
}//public class App

