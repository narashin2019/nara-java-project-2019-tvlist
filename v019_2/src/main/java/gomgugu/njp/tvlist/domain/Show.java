package gomgugu.njp.tvlist.domain;

import java.sql.Date;

public class Show {
  private int no;
  private String country;
  private String genres;
  private String titleKor;
  private String titleEng;
  private int point;
  private String comments;
  private String keywords;
  private Date startDate;
  private Date endDate;
  private int watchedEpisode;
  
  
  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getCountry() {
    return country;
  }
  public void setCountry(String country) {
    this.country = country;
  }
  public String getGenres() {
    return genres;
  }
  public void setGenres(String genres) {
    this.genres = genres;
  }
  public String getTitleKor() {
    return titleKor;
  }
  public void setTitleKor(String titleKor) {
    this.titleKor = titleKor;
  }
  public String getTitleEng() {
    return titleEng;
  }
  public void setTitleEng(String titleEng) {
    this.titleEng = titleEng;
  }
  public int getPoint() {
    return point;
  }
  public void setPoint(int point) {
    this.point = point;
  }
  public String getComments() {
    return comments;
  }
  public void setComments(String comments) {
    this.comments = comments;
  }
  public String getKeywords() {
    return keywords;
  }
  public void setKeywords(String keywords) {
    this.keywords = keywords;
  }
  public Date getStartDate() {
    return startDate;
  }
  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }
  public Date getEndDate() {
    return endDate;
  }
  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }
  public int getWatchedEpisode() {
    return watchedEpisode;
  }
  public void setWatchedEpisode(int watchedEpisode) {
    this.watchedEpisode = watchedEpisode;
  }
  
  
  
}
