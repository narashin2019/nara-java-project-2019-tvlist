package gomgugu.njp.tvlist.handler;

import java.util.List;
import gomgugu.njp.tvlist.domain.Show;
import gomgugu.njp.util.Prompt;

public class ShowAddCommand implements Command {

  List<Show> showList;

  Prompt prompt;

  public ShowAddCommand(Prompt prompt, List<Show> list) {
    this.prompt = prompt;
    this.showList = list;
  }

  @Override
  public void execute() {
    Show show = new Show();

    show.setNo(prompt.inputInt("번호? "));
    show.setCountry(prompt.inputString("국가? "));
    show.setGenres(prompt.inputString("장르? "));
    show.setTitleKor(prompt.inputString("제목한글? "));
    show.setTitleEng(prompt.inputString("제목영문? "));
    show.setPoint(prompt.inputInt("별점? "));
    show.setComments(prompt.inputString("코멘트? "));
    show.setKeywords(prompt.inputString("키워드? "));
    show.setStartDate(prompt.inputDate("시작일? "));
    show.setEndDate(prompt.inputDate("종료일? "));
    show.setWatchedEpisode(prompt.inputInt("어디까지봤니? "));

    showList.add(show);

    System.out.println("저장하였습니다.");
  }

}
