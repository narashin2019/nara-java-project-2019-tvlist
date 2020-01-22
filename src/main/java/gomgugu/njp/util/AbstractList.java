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

    // local class : 특정 메서드 안에서만 사용하는 중첩 클래스라면 그 메서드 안에 둔다. 로컬클래스에는 스태틱 없다.
    class ListIterator<T> implements Iterator<T> {


      List<T> list;
      int cursor;

      // 생성자
      @SuppressWarnings("unchecked")
      public ListIterator() {
        // 로컬 클래스는 인스턴스 멤버가 아니기 때문에
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

    // 로컬 클래스는 인스턴스 멤버가 아니기 때문에
    // 앞쪽에 인스턴스 주소를 전달해서는 안된다.
    // 즉 this.을 붙여서는 안된다.
    return new ListIterator<E>();
  }
}

