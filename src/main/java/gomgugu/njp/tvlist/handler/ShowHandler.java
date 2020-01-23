package gomgugu.njp.tvlist.handler;

import java.util.Iterator;
import java.util.List;
import gomgugu.njp.tvlist.domain.Show;
import gomgugu.njp.util.Prompt;

public class ShowHandler {

  List<Show> showList;

  Prompt prompt;

  public ShowHandler(Prompt prompt, List<Show> list) {
    this.prompt = prompt;
    this.showList = list;
  }


  public void addShow() {
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


  public void listShow() {

    // 컬렉션에서 값을 꺼내는 일을 해 줄 Iterator 준비하기
    Iterator<Show> iterator = showList.iterator();

    // Iterator 객체를 통해 ShowList에 보관되어 있는 값을 꺼낸다.
    while (iterator.hasNext()) {
      Show s = iterator.next();
      System.out.printf("%d, %-20s, %s ~ %s, %d\n", s.getNo(), s.getTitleKor(), s.getStartDate(),
          s.getEndDate(), s.getWatchedEpisode());
    }
  }



  public void detailShow() {
    int index = indexOfShow(prompt.inputInt("번호? "));

    if (index == -1) {
      System.out.println("해당 번호의 드라마 정보가 없습니다.");
      return;
    }

    Show show = this.showList.get(index);

    System.out.printf("제목한글: %s\n", show.getTitleKor());
    System.out.printf("제목영문: %s\n", show.getTitleEng());
    System.out.printf("기간: %s ~ %s\n", show.getStartDate(), show.getEndDate());
    System.out.printf("별점: %d\n", show.getPoint());
    System.out.printf("키워드: %s\n", show.getKeywords());
    System.out.printf("어디까지봤니: %d\n", show.getWatchedEpisode());
  }


  public void updateShow() {
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


  public void deleteShow() {
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
