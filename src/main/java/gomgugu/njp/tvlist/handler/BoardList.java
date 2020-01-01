package gomgugu.njp.tvlist.handler;

import java.util.Arrays;
import gomgugu.njp.tvlist.domain.Board;

public class BoardList {
  
  static final int DEFAULT_CAPACITY = 3;
  
  Board[] list;
  int size = 0;
  
  //기본생성자 자동생성됨
  
  //생성자
  public BoardList() {
    this.list = new Board[DEFAULT_CAPACITY];
  }
  
  //생성자
  public BoardList(int capacity) {
    if(capacity < DEFAULT_CAPACITY || capacity >10000)
      this.list = new Board[DEFAULT_CAPACITY];
    else
      this.list = new Board[capacity];
  }
  
  //메서드 보드 꺼내기
  public Board[] toArray() {
    return Arrays.copyOf(this.list, this.size);
  }
  
  //메서드 add배열에 담는일
  public void add(Board board) {
    if(this.size == this.list.length) {
      int oldCapacity = this.list.length;
      int newCapacity = oldCapacity + (oldCapacity >> 1);
      this.list = Arrays.copyOf(this.list, newCapacity);
    }
    this.list[this.size++] = board;
  }
  
  //메서드 디테일
  public Board get(int no) {
    for(int i = 0; i < this.size; i++) {
      if (this.list[i].getNo() == no) {
        return this.list[i];
      }
    }
    return null;
  }
  
  
}
