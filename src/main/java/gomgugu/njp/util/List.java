package gomgugu.njp.util;


// Generalization 1단계:
// => ArrayList 와 LinkedList 사이의 공통 분모를 추출하여 수퍼 클래스를 정의한다.
// => ArrayList 와 LinkedList는 이렇게 정의한 수퍼 클래스를 상속 받는다.
//
public class List<E> {

  protected int size;

  public int size() {
    return size; // 이제 this. 생략한다. 컴파일러가 자동으로 붙인다
  }


  public void add(E e) {
    // ArayList나 LinkedList는 동작 방법이 다르기 때문에
    // 여기서 구현할 필요가 없다.
    // 서브클래스가 add로 이름 짓게끔 강요
  }

  public void add(int index, E value) {
    // ArayList나 LinkedList는 동작 방법이 다르기 때문에
    // 여기서 구현할 필요가 없다.
  }


  public E get(int index) {
    // ArayList나 LinkedList는 동작 방법이 다르기 때문에
    // 여기서 구현할 필요가 없다.
    return null;
  }


  public E set(int index, E e) {
    // ArayList나 LinkedList는 동작 방법이 다르기 때문에
    // 여기서 구현할 필요가 없다.
    return null;
  }

  public E remove(int index) {
    // ArayList나 LinkedList는 동작 방법이 다르기 때문에
    // 여기서 구현할 필요가 없다.
    return null;
  }

  public Object[] toArray() {
    // ArayList나 LinkedList는 동작 방법이 다르기 때문에
    // 여기서 구현할 필요가 없다.
    return null;
  }

  public E[] toArray(E[] arr) {
    // ArayList나 LinkedList는 동작 방법이 다르기 때문에
    // 여기서 구현할 필요가 없다.
    return null;
  }

}
