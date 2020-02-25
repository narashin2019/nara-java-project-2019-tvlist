package gomgugu.njp.tvlist.handler;

import java.util.List;
import gomgugu.njp.tvlist.domain.Show;
import gomgugu.njp.util.Prompt;

public class ShowDeleteCommand implements Command {

  List<Show> showList;

  Prompt prompt;

  public ShowDeleteCommand(Prompt prompt, List<Show> list) {
    this.prompt = prompt;
    this.showList = list;
  }

  @Override
  public void execute() {
    int index = indexOfShow(prompt.inputInt("번호? "));

    if (index == -1) {
      System.out.println("해당 번호의 드라마 정보가 없습니다.");
      return;
    }

    this.showList.remove(index);

    System.out.println("드라마를 삭제했습니다.");
  }

  private int indexOfShow(int no) {
    for (int i = 0; i < this.showList.size(); i++) {
      if (this.showList.get(i).getNo() == no) {
        return i;
      }
    }
    return -1;
  }



}
