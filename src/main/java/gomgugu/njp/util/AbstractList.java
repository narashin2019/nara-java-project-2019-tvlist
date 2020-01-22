package gomgugu.njp.util;

public abstract class AbstractList<E> implements List<E> {


  protected int size;

  @Override
  public int size() {
    return size;
  }


  /* 다음은 로컬 클래스에 대한 
   * '의미 전달을 위해서 간략하게 작성한 코드(pseudo; 의사코드=가짜코드)'이다.
    class 클래스 {
      필드
      블록
      생성자
      메서드 {
        this 사용
        로컬 변수 (인스턴스멤버아님)
        로컬(중첩) 클래스  (로컬변수와 같은 위치라 인스턴스 멤버아니게됨) {
        바깥클래스.this 사용 
        로컬변수 접근 가능.
        }
      }
      중첩클래스 {
        바깥클래스.this 사용(바깥클래스의this사용 바깥 클래스의 인스턴스 멤버임)
      }
    }
  */

  @Override
  public Iterator<E> iterator() {
    // this 인스턴스 주소

    // anonymous class : 인스턴스를 한 개만 생성할 거면 익명 클래스로 정의하라
    // 로컬 클래스는 인스턴스 멤버가 아니기 때문에
    // 앞쪽에 인스턴스 주소를 전달해서는 아노딘다.
    // 즉 this.을 붙여서는 안된다.
    return new Iterator<E>() { // 이터레이터 인터페이스를 구현한 익명 클래스, 정의하자마자 즉시 인스턴스 생성, 수퍼클래스의 생성자 호출()
      // Iterator<E>대신 Object써도 됨.

      List<E> list;
      int cursor;

      // 생성자대신 인스턴스 블록으로!
      // 익명 클래스는 생성자를 만들 수 없기 때문에
      // 인스턴스 필드를 초기화시키기 위해서는
      // 다음과 같이 인스턴스 블록을 사용해야 한다.
      // 물론 단순히 값을 할당하는 경우에는 인스턴스 블록에 넣지 않고,
      // 필드 선언에 바로 할당 연산자를 사용할 수 있다.
      {
        // 로컬 클래스는 인스턴스 멤버가 아니기 때문에
        this.list = AbstractList.this;
      }


      @Override
      public boolean hasNext() {
        return cursor < list.size();

      }

      @Override
      public E next() {
        return list.get(cursor++);

      }
    }; // 클래스정의 및 인스턴스를 생성하는 문장이기 때문에 ; 붙여준다. ;
  }



}
