

public class Trying {

    public void foo(){
        System.out.println("Foo In parent");
    }

}

class NotTrying extends Trying{
    public void foo(){
        System.out.println("Foo In child");
    }
}

class Main{
    public static void main(String[] args) {
        int I=1;
      while(I>=1){
          I+=10000;
      }
        System.out.println(I+"");
    }

}
