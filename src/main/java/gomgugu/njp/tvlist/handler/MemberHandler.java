package gomgugu.njp.tvlist.handler;

import java.sql.Date;
import java.util.Scanner;
import gomgugu.njp.tvlist.domain.Member;
import gomgugu.njp.util.ArrayList;

public class MemberHandler {
  
  ArrayList<Member> memberList;
  Scanner input; // default나 private. 생성자로 받기 때문
  
  public MemberHandler(Scanner input) {
    this.input = input;
    memberList = new ArrayList<>();
  }
  
  
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

    this.memberList.add(member);
    System.out.println("저장하였습니다.");
  }    
  
  
  public void listMember() {
    // Member 객체의 목록을 저장할 배열을 넘기는데 크기가 0인 배열을 넘긴다.
    // toArray()는 내부에서 새 배열을 만들고, 값을 복사한 후 리턴한다.(리턴값은 새배열!)
    Member[] arr = this.memberList.toArray(new Member[] {});
    for (Member m : arr) {
      System.out.printf("%d, %s, %-30s, %-15s %s\n", m.getNo(), 
          m.getName(), m.getEmail(), m.getTel(), m.getRegisteredDate());
    }
  }
  
  
}
