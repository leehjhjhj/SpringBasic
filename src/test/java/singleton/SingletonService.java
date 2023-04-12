package singleton;

public class SingletonService {
    //스태틱 하면 클래스에 하나만 생긴다.
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }
    // new 키워드로 객체를 생성하는 것을 막는다.
    private SingletonService() {
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
