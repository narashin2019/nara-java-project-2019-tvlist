package gomgugu.njp.util;

import java.util.Arrays;

public class ArrayList<E> {

  private static final int DEFAULT_CAPACITY = 2;

  //뉴 했을떄 만들어지는 메모리의 설계도 = 인스턴스 필드. 초기화 필요없다.
  Object[] elementData;
  int size;

  //생성자
  public ArrayList() {
    this.elementData = new Object[DEFAULT_CAPACITY];
  }

  //생성자
  public ArrayList(int initialCapacity) {
    if(initialCapacity < DEFAULT_CAPACITY)
      this.elementData = new Object[DEFAULT_CAPACITY];
    else
      this.elementData = new Object[initialCapacity];
  }





  //목록의 특정 위치에 저장된 항목을 꺼내주는 get()
  @SuppressWarnings("unchecked")
  public E get(int index) {
    if (index < 0 || index >= this.size) {
      return null;
    } else {
      return (E) this.elementData[index]; 
      //타입캐스팅(E) 실행할 때 저장되는 값의 리턴타입이 결정된다. 
      //스트링이면 스트링인지 아닌지 컴파일러가 다 검사함.
    }
  }


  //목록의 특정 위치에 저장된 항목을 바꾸는 set() // 리턴값은 예전 항목이다. // 원치않으면 리턴 안받으면 된다.
  @SuppressWarnings("unchecked")
  public E set(int index, E e) {
    if (index < 0 || index >= this.size) {
      return null;
    }
    // 바꾸기전 항목을 따로 보관해 둔다. 필요할 수 있다. 
    E oldValue = (E) this.elementData[index];
    this.elementData[index] = e;
    return oldValue;
  }


  //목록의 특정 위치에 저장된 항목을 삭제하는 remove() // 리턴값은 예전 항목이다. // 원치않으면 리턴 안받으면 된다.
  @SuppressWarnings("unchecked")
  public E remove(int index) {
    if (index < 0 || index >= this.size) {
      return null;
    }
    
    //삭제할 항목을 따로 보관해 둔다. 필요할 수 있다.
    E oldValue = (E) this.elementData[index];
    
    System.arraycopy(this.elementData, index + 1, 
        this.elementData, index, this.size - (index + 1));
    /*
    for (int i = index + 1; i < this.size; i++) {
      this.elementData[i - 1] = this.elementData[i];
    }
    */
    
    this.size--;
    return oldValue;
  }
  
  
  public int size() {
    return this.size; //this는 생략가능. this변수에 들어있는 size
  }
  
  
  public Object[] toArray() {
    return Arrays.copyOf(this.elementData, this.size);
    /*
    Object[] arr = new Object[this.size];
    for (int i = 0; i < this.size; i++) {
      arr[i] = this.elementData[i];
    }
    return arr;
    */
  }
  
  
  @SuppressWarnings("unchecked")
  public E[] toArray(E[] arr) { 
 // 제네릭은  E[] arr = new E[100]; 이거 안됨  배열을 뉴로 못만듬
    
    if (arr.length < this.size) {
      // 파라미터로 받은 배열이 작을 때는 현재 사이즈 크기의 새 배열을 만들어 리턴
      return (E[]) Arrays.copyOf(this.elementData, this.size, arr.getClass()); //arr.getClass() 클래스타입이 무엇인지 정보 가져옴
    }
    // 파라미터로 받은 배열 넉넉할 때는 파라미터로 받은 배열을 그대로 리턴. 
    System.arraycopy(this.elementData, 0, arr, 0, this.size); 
    //this.elementData를 0번방부터 arr에 0번방부터 this.size만큼 복사한다
    return arr;
  }
  

  public void add(E e) {
    if(this.size == this.elementData.length) {
      int oldSize = this.elementData.length;
      int newSize = oldSize + (oldSize >> 1);

      this.elementData = Arrays.copyOf(this.elementData, newSize);
      /*
      Object[] newArr = new Object[newSize];
       //새 배열에 기존 값을 반복문으로 넣는다
      for (int i = 0; i < this.size; i++) {
        newArr[i] = this.elementData[i];
      }
      this.elementData = newArr;
      // 새 배열의 주소를 엘레멘트데이터에 준다
       */

    }
    this.elementData[this.size++] = e;
  }
  
  
  public void add(int index, E value) {
    if (index < 0 || index >= this.size)
      return;

    if (this.size == this.elementData.length) {
      int oldSize = this.elementData.length;
      int newSize = oldSize + (oldSize >> 1);
      
      this.elementData = Arrays.copyOf(this.elementData, newSize);
    }

    for (int i = size - 1; i >= index; i--)
      this.elementData[i + 1] = this.elementData[i];

    this.elementData[index] = value;
    this.size++;
  }
  
  
//  public static void main(String[] args) {
//    ArrayList<String> list = new ArrayList<>();
//    list.add("aaaa");
//    list.add("bbbb");
//    list.add("cccc");
//    list.add("dddd");
//    list.add("eeee");
//    list.add("ffff");
//
//    //list.remove(6);
//    //    list.set(0, "0000");
//    //    list.set(3, "3333");
//    //    list.set(5, "5555");
//    //    list.set(-1, "ㅋㅋㅋㅋ");
//    //    list.set(6, "^^^^^^");
//
//
//    String[] arr = list.toArray(new String[] {});
//    for (String s : arr) {
//      System.out.println(s);
//    }
//  }

}



