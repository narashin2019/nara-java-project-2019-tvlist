package gomgugu.njp.tvlist.handler;

import java.util.Arrays;
import gomgugu.njp.tvlist.domain.Show;

public class ShowList {
  
  static final int DEFAULT_CAPACITY = 3;
  
  Show[] list;
  int size = 0;
  
  public ShowList() {
    this.list = new Show[DEFAULT_CAPACITY];
  }
  
  public ShowList(int capacity) {
    if (capacity < DEFAULT_CAPACITY || capacity > 1000)
      this.list = new Show[DEFAULT_CAPACITY];
    else
      this.list = new Show[capacity];
  }
  
  public Show[] toArray() {
    return Arrays.copyOf(this.list, this.size);
  }  
  
  public void add(Show show) {
    if(this.size == this.list.length) {
      // 현재 배열에 레슨정보 객체가 꽉 찼으면 배열을 늘린다.
      int oldCapacity = this.list.length;
      int newCapacity = oldCapacity + (oldCapacity >> 1); //oldCapacity / 2;보다 속도가 빠르다
      this.list = Arrays.copyOf(this.list, newCapacity); //새배열의 주소를 list에 넣는다
    }
    this.list[this.size++] = show;
  }
  
  public Show get(int no) {
    for (int i = 0; i < this.size; i++) {
      if (this.list[i].getNo() == no) {
        return this.list[i];
      }
    }
    return null;
  }
  

}
