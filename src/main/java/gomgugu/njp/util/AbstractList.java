package gomgugu.njp.util;

public abstract class AbstractList<E> implements List<E> {


  protected int size;

  @Override
  public int size() {
    return size;
  }


  @Override
  public Iterator<E> iterator() {
    // this 인스턴스 주소
    // List객체에서 값을 꺼내주는 일을 할 Iterator 구현체를 준비하여 리턴한다.
    return this.new ListIterator<E>();
    // 여기서 this는 호출시 넘겨준 애 this가 생략하면 자동으로 컴파일러가 붙임.
    // 스태틱일떄는 this붙이면 오류
  }



  // non-static nested class = inner class // 이너클래스를 생성하려면 바깥클래스의 인스턴스 주소가 있어야 한다.
  class ListIterator<T> implements Iterator<T> { // 바깥클래스와 다른 알파벳으로 제네릭 해라

    // List 객체에서 Iterator 규칙에 따라 값을 꺼내주는 클래스를 정의

    List<T> list;
    int cursor;

    // 생성자
    public ListIterator() { // 바깥클래스에 주소(AbstractList.this)가 들어와서 생성됨.,
      this.list = (List<T>) AbstractList.this;
    }


    @Override
    public boolean hasNext() {
      return cursor < list.size();

    }

    @Override
    public T next() {
      return list.get(cursor++);

    }


  }


}

/*
 * 패키지 멤버 클래스
 *
 * 리스트이터레이터 : 오브스트랙트 리스트에서만 쓰임 굳이 일반 패키지 멤버 클래스를 할 필요가 없음. 해당 클래스 안에 선언해서 유지보수에 도움되도록 묶어라 네스티드 클래스.
 * 스태틱 : 이 경우로 해본다. 논스태틱
 *
 * 클래스안에서만 사용하는 클래스라면 바깥에 정의하지 않고 해당 클래스 안에 저장한다. =네스티드 클래스
 *
 */
