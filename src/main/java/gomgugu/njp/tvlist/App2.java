// 프로젝트: 내가 본 드라마(TV Show) 목록 정리 및 공유
// App2: 회원정보
package gomgugu.njp.tvlist;

import java.util.Scanner;
import java.sql.Date;

public class App2 {

  public static void main(String[] args) {
    
    Scanner keyboard = new Scanner(System.in);

    class Member{
      int no;
      String name;
      String email; 
      String password; 
      String photo; 
      String tel; 
      Date registeredDate;
    }
    
    final int SIZE = 10000; 
    
    // Member 인스턴스의 주소를 저장할 레퍼런스 배열을 준비.
    Member[] members = new Member[SIZE];
    
    
    int count = 0;
    for (int i = 0; i < SIZE; i++) {
      count++;
      
      // 회원정보를 저장할 메모리를 Member 설계도에 따라 만든다.
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
      
      // 회원 정보가 담겨있는 인스턴스의 주소를 레퍼런스 배열에 보관한다.
      members[i] = member;
     
      System.out.println();
      System.out.println("계속 입력하시겠습니까?(Y/n)");
      String response = keyboard.next();
      
        if (!response.equalsIgnoreCase("y")) {
          break;
        }
    }

    keyboard.close();

    System.out.println();

    for (int i=0; i<count; i++) {
      // 위에 생성한 Member 배열을 불러온다.
      Member member = members[i];
      System.out.printf("%d, %s, %-30s, %-16s %s\n", member.no, 
          member.name, member.email, member.tel, 
          member.registeredDate);
    }
    
  }
}
