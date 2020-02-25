package gomgugu.njp.tvlist.handler;

import java.util.List;
import gomgugu.njp.tvlist.domain.Show;
import gomgugu.njp.util.Prompt;

public class ShowUpdateCommand implements Command {

  List<Show> showList;

  Prompt prompt;

  public ShowUpdateCommand(Prompt prompt, List<Show> list) {
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

    Show oldShow = this.showList.get(index);
    Show newShow = new Show();


    newShow.setNo(oldShow.getNo());

    newShow.setTitleKor(prompt.inputString(String.format("제목한글(%s)? ", oldShow.getTitleKor()),
        oldShow.getTitleKor()));

    newShow.setTitleEng(prompt.inputString(String.format("제목영문(%s)? ", oldShow.getTitleEng()),
        oldShow.getTitleEng()));

    newShow.setStartDate(prompt.inputDate(String.format("시작일(%s)? ", oldShow.getStartDate()),
        oldShow.getStartDate()));

    newShow.setEndDate(
        prompt.inputDate(String.format("종료일(%s)? ", oldShow.getEndDate()), oldShow.getEndDate()));

    newShow.setPoint(
        prompt.inputInt(String.format("별점(%d)? ", oldShow.getPoint()), oldShow.getPoint()));

    newShow.setKeywords(prompt.inputString(String.format("키워드(%s)? ", oldShow.getKeywords()),
        oldShow.getKeywords()));

    newShow.setWatchedEpisode(prompt.inputInt(
        String.format("어디까지봤니(%d)? ", oldShow.getWatchedEpisode()), oldShow.getWatchedEpisode()));

    /*
     * int oldValue = oldShow.getPoint(); String label = "별점(" + oldValue + ")? "; int newValue =
     * inputInt(label, oldValue); newShow.setPoint(newValue);
     */

    if (oldShow.equals(newShow)) {
      System.out.println("드라마 정보 변경을 취소하였습니다.");
      return;
    }

    this.showList.set(index, newShow);
    System.out.println("드라마 정보를 변경했습니다.");
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
