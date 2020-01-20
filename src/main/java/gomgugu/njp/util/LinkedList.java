package gomgugu.njp.util;

import java.lang.reflect.Array;

public class LinkedList<E> extends AbstractList<E> {

  Node<E> first;

  Node<E> last; // 엘리먼트를 저장하는 노드 T자리에 E가 들어간다.


  @Override
  public void add(E value) {
    Node<E> newNode = new Node<>();
    newNode.value = value;

    if (first == null) { // this생략된 인스턴스변수 = 파랑색
      last = first = newNode;
    } else {
      last.next = newNode;
      last = newNode;
    }

    this.size++;
  }

  @Override
  public E get(int index) {
    if (index < 0 || index >= size)
      return null;

    Node<E> cursor = first;
    for (int i = 0; i < index; i++) {
      cursor = cursor.next;
    }

    return cursor.value;
  }


  @Override
  public void add(int index, E value) {
    if (index < 0 || index >= size)
      return; // 유효하지 않는 인덱스는 즉시 빠져나간다.

    Node<E> newNode = new Node<>();

    newNode.value = value;

    Node<E> cursor = first;
    for (int i = 0; i < index - 1; i++) {
      cursor = cursor.next;
    }

    if (index == 0) {
      newNode.next = first;
      first = newNode;
    } else {
      newNode.next = cursor.next;
      cursor.next = newNode;
    }

    this.size++;
  }


  @Override
  public E remove(int index) {
    if (index < 0 || index >= size)
      return null; // 유효하지 않는 인덱스는 즉시 빠져나간다.

    Node<E> cursor = first; // 2가 저장된 노드를 가리키는 레퍼런스가 커서
    for (int i = 0; i < index - 1; i++) {
      cursor = cursor.next; // 지우고 싶은거의 바로 전꺼 찾는 코드. 커서얘가리키는데 삭제할 놈은 커서의 넥스트
    }

    Node<E> deletedNode = null;
    if (index == 0) {
      deletedNode = first;
      first = deletedNode.next;
    } else {
      deletedNode = cursor.next;
      cursor.next = deletedNode.next;
    }

    deletedNode.next = null; // 오리알을 null로 초기화 가비지가 되려면 주소를 누구도 갖지 않아야한다.
    size--;

    return deletedNode.value; // 리턴값은 딜리트노드의 값. 혹시나 누가 필요할까봐
  }

  @Override
  public E set(int index, E value) {
    if (index < 0 || index >= size)
      return null;

    Node<E> cursor = first;
    for (int i = 0; i < index; i++) {
      cursor = cursor.next;
    }

    E oldValue = cursor.value;
    cursor.value = value;

    return oldValue;
  }

  @Override
  public Object[] toArray() {
    Object[] arr = new Object[size];

    Node<E> cursor = first;
    for (int i = 0; i < size; i++) {
      arr[i] = cursor.value;
      cursor = cursor.next;
    }

    return arr;
  }

  @Override
  @SuppressWarnings("unchecked")
  public E[] toArray(E[] arr) { //바깥에서 배열이 들어옴 파라미터로 받은 배열

    if (arr.length < size) {
      arr = (E[]) Array.newInstance(arr.getClass().getComponentType(), size);
    }

    Node<E> cursor = first;
    for (int i = 0; i < size; i++) {
      arr[i] = cursor.value;
      cursor = cursor.next;
    }

    return arr;
  }
  

  //  자바.랭.리플렉트.어레이.뉴인스턴스 메서드 있음.
  //  componentType: 배열을 구성하는 하나의 항목의 타입이 뭐냐는 질문 > E(E는 클래스를 가리키는 레퍼런스 격이라 E.class안됨)
  //  length 몇개 만들꺼냐 
  //  arr.getClass().getComponenetType(), size
  //  arr의 배열자체타입 그 배열의 한 항목의 타입이 뭔지 찾는 코드
  //  마지막으로 (E[]) 까지!
  

  @Override
  public int size() {
    return this.size;
  }

  static class Node<T> { //t에 e가 넘어오는 것 /스태틱 네스티드 클래스는 그대로 둠 
    T value;
    Node<T> next; // 노드 클래스에 저장하는 값 타입을 T타입이라고 하자. E하고 충돌안일어나게
  }
}
