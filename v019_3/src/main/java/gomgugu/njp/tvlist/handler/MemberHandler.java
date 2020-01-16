// 게시글 인덱스로 객체를 찾는 대신에 
// 게시글을 입력할 때 등록한 번호로 객체를 찾도록 변경한다. 
// 게시글 번호로 객체를 찾는 코드를 관리하기 쉽게 별도의 메서드로 분리한다.
// => indexOfBoard(int) 메서드 추가
// Prompt로 변경
//

package gomgugu.njp.tvlist.handler;

import java.sql.Date;
import gomgugu.njp.tvlist.domain.Member;
import gomgugu.njp.util.ArrayList;
import gomgugu.njp.util.Prompt;

public class MemberHandler {

  ArrayList<Member> memberList;

  Prompt prompt;


  public MemberHandler(Prompt prompt) {
    this.prompt = prompt;
    memberList = new ArrayList<>();
  }



  public void addMember() {
    Member member = new Member();

    member.setNo(prompt.inputInt("번호? "));
    member.setName(prompt.inputString("이름? "));
    member.setEmail(prompt.inputString("이메일? "));
    member.setPassword(prompt.inputString("암호? "));
    member.setPhoto(prompt.inputString("사진? "));
    member.setTel(prompt.inputString("전화? "));
    member.setRegisteredDate(new Date(System.currentTimeMillis()));

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
    int index = indexOfMember(prompt.inputInt("번호? "));

    if (index == -1) {
      System.out.println("해당 번호의 회원이 없습니다.");
      return;
    }

    Member member = this.memberList.get(index);

    System.out.printf("이름: %s\n", member.getName());
    System.out.printf("이메일: %s\n", member.getEmail());
    System.out.printf("암호: %s\n", member.getPassword());
    System.out.printf("사진: %s\n", member.getPhoto());
    System.out.printf("전화: %s\n", member.getTel());
    System.out.printf("가입일: %s\n", member.getRegisteredDate());
  }



  public void updateMember() {
    int index = indexOfMember(prompt.inputInt("번호? "));

    if (index == -1) {
      System.out.println("해당 번호의 회원이 없습니다.");
      return;
    }

    Member oldMember = this.memberList.get(index);
    Member newMember = new Member();

    newMember.setNo(oldMember.getNo());

    newMember.setName(prompt.inputString(
        String.format("이름(%s)? ", oldMember.getName()), 
        oldMember.getName()));

    newMember.setEmail(prompt.inputString(
        String.format("이메일(%s)? ", oldMember.getEmail()), 
        oldMember.getEmail()));

    newMember.setPassword(prompt.inputString(
        String.format("암호(%s)? ", oldMember.getPassword()), 
        oldMember.getPassword()));

    newMember.setPhoto(prompt.inputString(
        String.format("사진(%s)? ", oldMember.getPhoto()), 
        oldMember.getPhoto()));

    newMember.setTel(prompt.inputString(
        String.format("전화(%s)? ", oldMember.getTel()), 
        oldMember.getTel()));

    if (oldMember.equals(newMember)) {
      System.out.println("회원 변경을 취소하였습니다.");
      return;
    }
    this.memberList.set(index, newMember);
    System.out.println("회원을 변경했습니다.");
  }


  public void deleteMember() {
    int index = indexOfMember(prompt.inputInt("번호? "));

    if (index == -1) {
      System.out.println("해당 번호의 회원이 없습니다.");
      return;
    }
    this.memberList.remove(index);

    System.out.println("회원을 삭제했습니다.");
  }

  private int indexOfMember(int no) {
    for (int i = 0; i < this.memberList.size(); i++) {
      if (this.memberList.get(i).getNo() == no) {
        return i;
      }
    }
    return -1;
  }


}
