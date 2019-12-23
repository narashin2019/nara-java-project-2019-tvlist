// 프로젝트: 내가 본 드라마(TV Show) 목록 정리 및 공유
// App2: 회원정보
package gomgugu.njp.tvlist;

import java.util.Scanner;
import java.sql.Date;

public class App2 {

  public static void main(String[] args) {
    
    Scanner keyboard = new Scanner(System.in);

    final int size = 10000; 
    int count = 0;

    int[] no = new int[size];
    String[] name = new String[size];
    String[] email = new String[size]; 
    String[] password = new String[size]; 
    String[] photo = new String[size]; 
    String[] tel = new String[size]; 
    Date[] registeredDate = new Date[size];


    for (int i = 0; i < size; i++) {
      System.out.print("번호? ");
      no[i] = keyboard.nextInt();
      keyboard.nextLine();

      System.out.print("이름? ");
      name[i] = keyboard.nextLine();

      System.out.print("이메일? ");
      email[i] = keyboard.nextLine();

      System.out.print("암호? ");
      password[i] = keyboard.nextLine();

      System.out.print("사진? ");
      photo[i] = keyboard.nextLine();

      System.out.print("전화? ");
      tel[i] = keyboard.nextLine();

      registeredDate[i] = new Date(System.currentTimeMillis()); 
      keyboard.nextLine();

      count++;
     
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
      System.out.printf("%d, %s, %-30s, %-16s %s\n", no[i], 
          name[i], email[i], tel[i], registeredDate[i]);
    }
    
  }
}
