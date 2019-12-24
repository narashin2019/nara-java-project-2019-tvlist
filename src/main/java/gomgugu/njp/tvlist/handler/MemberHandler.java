package gomgugu.njp.tvlist.handler;

import java.sql.Date;
import java.util.Scanner;
import gomgugu.njp.tvlist.domain.Member;

public class MemberHandler {
  
  //인스턴스 필드 = 논 스태틱 필드
  // => 개별적으로 관리해야 하는 변수
  // => new 명령을 통해 생성된다.
  Member[] members = new Member[MEMBER_SIZE];
  int memberCount = 0;
  
  //클래스 필드 = 스태틱 필드
  // => 공유하는 변수
  // => 클래스가 메모리에 로딩될 때 자동으로 생성된다.
  static final int MEMBER_SIZE = 100; 
  public static Scanner keyboard;
  
  //클래스 메서드
  public static void addMember(MemberHandler memberHandler) {
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

    memberHandler.members[memberHandler.memberCount++] = member;
    System.out.println("저장하였습니다.");
  }    
  
  
  public static void listMember(MemberHandler memberHandler) {
    for (int i=0; i<memberHandler.memberCount; i++) {
      Member m = memberHandler.members[i];
      System.out.printf("%d, %s, %-30s, %-15s %s\n", m.no, 
          m.name, m.email, m.tel, m.registeredDate);
    }
  }
  
  
}
