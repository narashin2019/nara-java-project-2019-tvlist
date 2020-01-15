package gomgugu.njp.tvlist.handler;

import java.sql.Date;
import java.util.Scanner;
import gomgugu.njp.tvlist.domain.Member;
import gomgugu.njp.util.ArrayList;

public class MemberHandler {
  
  ArrayList<Member> memberList;
  Scanner input; // default나 private. 생성자로 받기 때문
  
  //생성자 왜 한 개죠
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
  
    
  public void detailMember() {
    System.out.print("번호? ");
    int index = input.nextInt();
    input.nextLine(); 
    
    Member member = this.memberList.get(index);
    
    if (member == null) {
      System.out.println("회원 번호가 유효하지 않습니다.");
      return;
    }
    
    System.out.printf("이름: %s\n", member.getName());
    System.out.printf("이메일: %s\n", member.getEmail());
    System.out.printf("암호: %s\n", member.getPassword());
    System.out.printf("사진: %s\n", member.getPhoto());
    System.out.printf("전화: %s\n", member.getTel());
    System.out.printf("가입일: %s\n", member.getRegisteredDate());
  }
  
  
 
  public void updateMember() {
    System.out.print("번호? ");
    int index = input.nextInt();
    input.nextLine();
    
    Member oldMember = this.memberList.get(index);
    
    if (oldMember == null) {
      System.out.println("회원 번호가 유효하지 않습니다.");
      return;
    }
    
    boolean changed = false;
    String inputStr = null;
    Member newMember = new Member();
    
    newMember.setNo(oldMember.getNo());
    
    System.out.printf("이름(%s)? ", oldMember.getName());
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newMember.setName(oldMember.getName());
    } else {
      newMember.setName(inputStr);
      changed = true;
    }

    System.out.printf("이메일(%s)? ", oldMember.getEmail());
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newMember.setEmail(oldMember.getEmail());
    } else {
      newMember.setEmail(inputStr);
      changed = true;
    }

    System.out.printf("암호(%s)? ", oldMember.getPassword());
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newMember.setPassword(oldMember.getPassword());
    } else {
      newMember.setPassword(inputStr);
      changed = true;
    }

    System.out.printf("사진(%s)? ", oldMember.getPhoto());
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newMember.setPhoto(oldMember.getPhoto());
    } else {
      newMember.setPhoto(inputStr);
      changed = true;
    }

    System.out.printf("전화(%s)? ", oldMember.getTel());
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newMember.setTel(oldMember.getTel());
    } else {
      newMember.setTel(inputStr);
      changed = true;
    }

    //Date registeredDate = new Date(System.currentTimeMillis()); 
    //input.nextLine();
    
    if (changed) {
      this.memberList.set(index, newMember);
      System.out.println("회원을 변경했습니다.");
    } else {
      System.out.println("회원 변경을 취소하였습니다.");
    }
  }
  
  
  public void deleteMember() {
    System.out.print("번호? ");
    int index = input.nextInt();
    input.nextLine(); // 숫자 뒤의 남은 공백 제거
    
    Member member = this.memberList.get(index);
    
    if (member == null) {
      System.out.println("회원번호가 유효하지 않습니다.");
      return;
    }
    
    this.memberList.remove(index);
    
    System.out.println("게시글을 삭제했습니다.");
  }
  
  
  
  
}
