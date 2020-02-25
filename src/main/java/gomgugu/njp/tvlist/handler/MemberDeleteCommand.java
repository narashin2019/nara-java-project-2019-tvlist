package gomgugu.njp.tvlist.handler;

import java.util.List;
import gomgugu.njp.tvlist.domain.Member;
import gomgugu.njp.util.Prompt;

public class MemberDeleteCommand implements Command {


  List<Member> memberList;

  Prompt prompt;

  public MemberDeleteCommand(Prompt prompt, List<Member> list) {
    this.prompt = prompt;
    this.memberList = list;
  }

  @Override
  public void execute() {

    int index = indexOfBoard(prompt.inputInt("번호? "));

    if (index == -1) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    this.memberList.remove(index);

    System.out.println("게시글을 삭제했습니다.");
  }

  private int indexOfBoard(int no) {
    for (int i = 0; i < this.memberList.size(); i++) {
      if (this.memberList.get(i).getNo() == no) {
        return i;
      }
    }
    return -1;
  }


}
