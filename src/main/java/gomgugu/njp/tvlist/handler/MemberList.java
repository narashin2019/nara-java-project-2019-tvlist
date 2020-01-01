package gomgugu.njp.tvlist.handler;

import java.util.Arrays;
import gomgugu.njp.tvlist.domain.Member;

public class MemberList {

  static final int DEFAULT_CAPACITY = 3; 
  
  Member[] list;
  int size = 0;
  
  public MemberList() {
    this.list = new Member[DEFAULT_CAPACITY];
  }
  
  public MemberList(int capacity) {
    if(capacity < DEFAULT_CAPACITY || capacity > 10000)
      this.list = new Member[DEFAULT_CAPACITY];
    else
      this.list = new Member[capacity];
  }
  
  public Member[] toArray() {
    /*
    Member[] arr = new Member[this.size];
    for (int i = 0; i < this.size; i++) {
      arr[i] = this.list[i];
    }
    return arr;
    */
    return Arrays.copyOf(this.list, this.size);
  }

  public void add(Member member) {
    if(this.size == this.list.length) {
      // 현재 배열에 멤버 객체가 꽉 찼으면 배열을 늘린다.
      int oldCapacity = this.list.length;
      int newCapacity = oldCapacity + (oldCapacity >> 1); //oldCapacity / 2;보다 속도가 빠르다
      this.list = Arrays.copyOf(this.list, newCapacity); //새배열의 주소를 list에 넣는다
    }
    this.list[this.size++] = member;
  }

  public Member get(int no) {
    for (int i = 0; i < this.size; i++) {
      if (this.list[i].getNo() == no) {
        return this.list[i];
      }
    }
    return null;
  }
  
  
}
