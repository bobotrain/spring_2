package hello.core.singleton;

public class SingletonService {

    //private static으로 해당 패키지에서 딱 하나만 존재하도록 제한 -> static으로 하면 클래스 레벨 단위로 올라가기 때문에...
    private static final SingletonService instance = new SingletonService();

    //instance를 미리 하나 생성해서 올려두고 오직 getInstance() 메서드를 통해서마 조회할 수 있다.
    // 이 인스턴스는 항상 같은 인스턴스를 반환 -> 싱글톤
    public static SingletonService getInstance() {
        return instance;
    }

    //private로 생성자를 막아서 외부(다른 패키지)에서 new키워드로 생성되는 것을 막는다.
    private SingletonService() {

    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }

    public static void main(String[] args) {
        SingletonService singletonService1 = new SingletonService();
        SingletonService singletonService2 = new SingletonService();

    }
}
