package gomgugu.njp.tvlist.domain;

public class Show {
  private int no;
  private String country;
  private String genre;
  private String titleKor;
  private String titleEng;
  private int point;
  private String comments;
  private int watchedEpisode;

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((comments == null) ? 0 : comments.hashCode());
    result = prime * result + ((country == null) ? 0 : country.hashCode());
    result = prime * result + ((genre == null) ? 0 : genre.hashCode());
    result = prime * result + no;
    result = prime * result + point;
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
    if (genre == null) {
      if (other.genre != null)
        return false;
    } else if (!genre.equals(other.genre))
      return false;
    if (no != other.no)
      return false;
    if (point != other.point)
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

  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
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

  public int getWatchedEpisode() {
    return watchedEpisode;
  }

  public void setWatchedEpisode(int watchedEpisode) {
    this.watchedEpisode = watchedEpisode;
  }



}
