package gomgugu.njp.tvlist.handler;

import java.util.Iterator;
import java.util.List;
import gomgugu.njp.tvlist.domain.Show;

public class ShowListCommand implements Command {

  List<Show> showList;


  public ShowListCommand(List<Show> list) {
    this.showList = list;
  }

  @Override
  public void execute() {
    Iterator<Show> iterator = showList.iterator();

    while (iterator.hasNext()) {
      Show s = iterator.next();
      System.out.printf("%d, %-20s, %d, %d\n", s.getNo(), s.getTitleKor(), s.getPoint(),
          s.getWatchedEpisode());
    }
  }


}
