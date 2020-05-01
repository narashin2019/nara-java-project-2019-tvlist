package gomgugu.njp.tvlist.domain;

import java.io.Serializable;
import java.sql.Date;

public class Board implements Serializable{

  
  private static final long serialVersionUID = 20200501L;
  
  private int no;
  private String title;
  private String content;
  private Date date;
  private int viewCount;
  private String writer;

  // CSV 포맷:
  // - 번호,제목,등록일,조회수,작성자
  //
  public static Board valueOf(String csv) { // csv파일에서 값을 꺼내서 board 식판에 넣는 메서드
    String[] data = csv.split(",");

    Board board = new Board();
    board.setNo(Integer.parseInt(data[0]));
    board.setTitle(data[1]);
    board.setContent(data[2]);
    board.setDate(Date.valueOf(data[3]));
    board.setViewCount(Integer.parseInt(data[4]));
    board.setWriter(data[5]);
    return board;
  }

  public String toCsvString() {
    return String.format("%d,%s,%s,%s,%d,%s", this.getNo(), this.getTitle(), this.getContent(), this.getDate(),
        this.getViewCount(), this.getWriter());
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((content == null) ? 0 : content.hashCode());
    result = prime * result + ((date == null) ? 0 : date.hashCode());
    result = prime * result + no;
    result = prime * result + ((title == null) ? 0 : title.hashCode());
    result = prime * result + viewCount;
    result = prime * result + ((writer == null) ? 0 : writer.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Board other = (Board) obj;
    if (content == null) {
      if (other.content != null)
        return false;
    } else if (!content.equals(other.content))
      return false;
    if (date == null) {
      if (other.date != null)
        return false;
    } else if (!date.equals(other.date))
      return false;
    if (no != other.no)
      return false;
    if (title == null) {
      if (other.title != null)
        return false;
    } else if (!title.equals(other.title))
      return false;
    if (viewCount != other.viewCount)
      return false;
    if (writer == null) {
      if (other.writer != null)
        return false;
    } else if (!writer.equals(other.writer))
      return false;
    return true;
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public int getViewCount() {
    return viewCount;
  }

  public void setViewCount(int viewCount) {
    this.viewCount = viewCount;
  }

  public String getWriter() {
    return writer;
  }

  public void setWriter(String writer) {
    this.writer = writer;
  }

  
  

}
