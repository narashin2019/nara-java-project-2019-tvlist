package gomgugu.njp.util;

import java.util.Arrays;

public class ArrayList<E> {
  //ArrayList에서 다룰 <클래스이름>을 받는변수, E = 변수명이나 일반적인 변수명아님
  //E만약 E자리에 다른 클래스 이름이 온다면 E를 쓰던 자리는 다 바꾸어야 한다.

  static final int DEFAULT_CAPACITY = 3;

  Object[] list;
  int size = 0; // 뉴 했을떄 만들어지는 메모리의 설계도


  public ArrayList() {
    this.list = new Object[DEFAULT_CAPACITY];
  }


  public ArrayList(int capacity) {
    if(capacity < DEFAULT_CAPACITY || capacity >10000)
      this.list = new Object[DEFAULT_CAPACITY];
    else
      this.list = new Object[capacity];
  }


  @SuppressWarnings("unchecked")
  public E[] toArray(E[] arr) { // 제네릭은  E[] arr = new = E[100]; 이거 안됨  배열을 뉴로 못만듬

    if (arr.length < this.size) {
      return (E[]) Arrays.copyOf(this.list, this.size, arr.getClass());
    }

    System.arraycopy(this.list, 0, arr, 0, this.size); 
    //this.list를 0번방부터 arr에 0번방부터 this.size만큼 복사한다

    // 위는 클래스메서드 = 스태틱메서드. 주어진 파라미터 가지고 일을하는 메서드는 스태틱메서드. 특정 인스턴스변수 쓰지않음.
    // 위의 arraycopy()는 다음 코드와 같다.
    // for (int i = 0; i <arr.length; i++) {
    //   arr[i] = (E) this.list[i];
    // }

    return arr;
  }


  public void add(E obj) {
    if(this.size == this.list.length) {
      int oldCapacity = this.list.length;
      int newCapacity = oldCapacity + (oldCapacity >> 1);
      this.list = Arrays.copyOf(this.list, newCapacity);
    }
    this.list[this.size++] = obj;
  }


  //목록의 특정 위치에 저장된 항목을 꺼내주는 get()
  @SuppressWarnings("unchecked")
  public E get(int index) {
    if (index >= 0 && index < this.size) {
      return (E) this.list[index]; //타입캐스팅
    } else {
      return null;
    }
  }


  //목록의 특정 위치에 저장된 항목을 바꾸는 set()
  @SuppressWarnings("unchecked")
  public E set(int index, E obj) {
    if (index < 0 || index >= this.size)
      return null;

    E old = (E) this.list[index];
    this.list[index] = obj;

    return old;
  }


  //목록의 특정 위치에 저장된 항목을 삭제하는 remove()
  @SuppressWarnings("unchecked")
  public E remove(int index) {
    if (index < 0 || index >= this.size)
      return null;

    //삭제할 항목을 따로 보관해 둔다. 왜...?
    E old = (E) this.list[index];

    for (int i = index + 1; i < this.size; i++) {
      this.list[i - 1] = this.list[i];
    }

    this.size--;

    this.list[this.size] = null;

    // 삭제한 항목을 리턴한다. 왜????
    return old;

  }


  public int size() {
    return this.size; //this는 생략가능. this변수에 들어있는 size
  }

  
  public static void main(String[] args) {
    ArrayList<String> list = new ArrayList<>();
    list.add("aaaa");
    list.add("bbbb");
    list.add("cccc");
    list.add("dddd");
    list.add("eeee");
    list.add("ffff");
    
    //list.remove(6);
//    list.set(0, "0000");
//    list.set(3, "3333");
//    list.set(5, "5555");
//    list.set(-1, "ㅋㅋㅋㅋ");
//    list.set(6, "^^^^^^");
    
    
    String[] arr = list.toArray(new String[] {});
    for (String s : arr) {
      System.out.println(s);
    }
    
    
  }
  
}

//copyOf () 메서드야
//arrayType에 지정된 배열을 size만큼 만들어라.
//그리고 List배열에 저장죈 주소를 새로 만든 배열에 복사하라.
//마지막으로 새로만든 배열의 주소를 리턴한다,

