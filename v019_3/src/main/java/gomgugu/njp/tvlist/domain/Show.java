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
  
  
  
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((comments == null) ? 0 : comments.hashCode());
    result = prime * result + ((country == null) ? 0 : country.hashCode());
    result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
    result = prime * result + ((genres == null) ? 0 : genres.hashCode());
    result = prime * result + ((keywords == null) ? 0 : keywords.hashCode());
    result = prime * result + no;
    result = prime * result + point;
    result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
    result = prime * result + ((titleEng == null) ? 0 : titleEng.hashCode());
    result = prime * result + ((titleKor == null) ? 0 : titleKor.hashCode());
    result = prime * result + watchedEpisode;
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
    Show other = (Show) obj;
    if (comments == null) {
      if (other.comments != null)
        return false;
    } else if (!comments.equals(other.comments))
      return false;
    if (country == null) {
      if (other.country != null)
        return false;
    } else if (!country.equals(other.country))
      return false;
    if (endDate == null) {
      if (other.endDate != null)
        return false;
    } else if (!endDate.equals(other.endDate))
      return false;
    if (genres == null) {
      if (other.genres != null)
        return false;
    } else if (!genres.equals(other.genres))
      return false;
    if (keywords == null) {
      if (other.keywords != null)
        return false;
    } else if (!keywords.equals(other.keywords))
      return false;
    if (no != other.no)
      return false;
    if (point != other.point)
      return false;
    if (startDate == null) {
      if (other.startDate != null)
        return false;
    } else if (!startDate.equals(other.startDate))
      return false;
    if (titleEng == null) {
      if (other.titleEng != null)
        return false;
    } else if (!titleEng.equals(other.titleEng))
      return false;
    if (titleKor == null) {
      if (other.titleKor != null)
        return false;
    } else if (!titleKor.equals(other.titleKor))
      return false;
    if (watchedEpisode != other.watchedEpisode)
      return false;
    return true;
  }
  
  
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
