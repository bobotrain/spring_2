package hello.core.singleton;

public class StatefulService {

    // private int price; //상태를 유지하는 필드 (공유필드)

    //공유필드를 지우고 공유되지 않는 지역변수로 활용하자
    public int order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        //this.price = price; //여기가 문제!
        return price;
    }
    //public int getPrice() {
     //   return price;
    //}
}
