package gomgugu.njp.tvlist.handler;

import java.sql.Date;
import java.util.Scanner;
import gomgugu.njp.tvlist.domain.Member;

public class MemberHandler {
  
  //인스턴스 필드 = 논 스태틱 필드
  // => 개별적으로 관리해야 하는 변수
  // => new 명령을 통해 생성된다.
  Member[] members;
  int memberCount = 0;
  
  //클래스 필드 = 스태틱 필드
  // => 공유하는 변수
  // => 클래스가 메모리에 로딩될 때 자동으로 생성된다.
  static final int MEMBER_SIZE = 100; 
  
  //keyboard대신 input으로 / static뺌
  public Scanner input;
  
  
  //생성자 / 공개로 해야함./this라는 내장 파라미터 있음
  public MemberHandler(Scanner input) {
    this.input = input;
    this.members = new Member[MEMBER_SIZE];
  }
  
  
  //클래스 메서드 > 인스턴스 메서드로
  public void addMember() {
    Member member = new Member();

    System.out.print("번호? ");
    member.setNo(input.nextInt());
    input.nextLine();

    System.out.print("이름? ");
    member.setName(input.nextLine());

    System.out.print("이메일? ");
    member.setEmail(input.nextLine());

    System.out.print("암호? ");
    member.setPassword(input.nextLine());

    System.out.print("사진? ");
    member.setPhoto(input.nextLine());

    System.out.print("전화? ");
    member.setTel(input.nextLine());

    member.setRegisteredDate(new Date(System.currentTimeMillis())); 
    input.nextLine();

    this.members[this.memberCount++] = member;
    System.out.println("저장하였습니다.");
  }    
  
  
  public void listMember() {
    for (int i=0; i<this.memberCount; i++) {
      Member m = this.members[i];
      System.out.printf("%d, %s, %-30s, %-15s %s\n", m.getNo(), 
          m.getName(), m.getEmail(), m.getTel(), m.getRegisteredDate());
    }
  }
  
  
}
