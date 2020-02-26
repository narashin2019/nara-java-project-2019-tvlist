package gomgugu.njp.tvlist.handler;

import java.util.List;
import gomgugu.njp.tvlist.domain.Show;
import gomgugu.njp.util.Prompt;

public class ShowDetailCommand implements Command {

  List<Show> showList;

  Prompt prompt;

  public ShowDetailCommand(Prompt prompt, List<Show> list) {
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

    Show show = this.showList.get(index);

    System.out.printf("제목한글: %s\n", show.getTitleKor());
    System.out.printf("제목영문: %s\n", show.getTitleEng());
    System.out.printf("별점: %d\n", show.getPoint());
    System.out.printf("코멘트: %s\n", show.getComments());
    System.out.printf("어디까지봤니: %d\n", show.getWatchedEpisode());
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
