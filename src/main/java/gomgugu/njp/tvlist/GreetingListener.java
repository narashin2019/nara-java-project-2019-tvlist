package gomgugu.njp.tvlist;

import java.util.Map;
import gomgugu.njp.tvlist.context.ApplicationContextListener;

public class GreetingListener implements ApplicationContextListener {

  @Override
  public void contextInitialized(Map<String, Object> context) {
    System.out.println("[드라마 관리 시스템]에 오신 것을 환영합니다!");
  }

  @Override
  public void contextDestroyed(Map<String, Object> context) {
    System.out.println("안녕히 가세요!");
  }


}
