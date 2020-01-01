package gomgugu.njp.tvlist.handler;

import java.sql.Date;
import java.util.Scanner;
import gomgugu.njp.tvlist.domain.Member;

public class MemberHandler {
  
  MemberList memberList;
  
  public Scanner input;
  
  //생성자 / 공개로 해야함./this라는 내장 파라미터 있음
  public MemberHandler(Scanner input) {
    this.input = input;
    memberList = new MemberList();
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

    memberList.add(member);
    System.out.println("저장하였습니다.");
  }    
  
  
  public void listMember() {
    Member[] members = memberList.toArray();
    for (Member m : members) {
      System.out.printf("%d, %s, %-30s, %-15s %s\n", m.getNo(), 
          m.getName(), m.getEmail(), m.getTel(), m.getRegisteredDate());
    }
  }
  
  
}
