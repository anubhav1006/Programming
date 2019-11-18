import java.io.*;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.logging.Logger;

public class Trying extends AbstraClas {

    public void foo(){
        System.out.println("Foo In parent");
    }
    Logger log = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);


    @Override
    void sdfgkj() {

    }



    @Override
    public void abcdefghg() {

    }

    @Override
    void asdf() {
        
    }
}

abstract class abst{
    abstract void asdf();
}
abstract class AbstraClas extends abst implements cdef{
    abstract void sdfgkj();

    @Override
    public void getImplemented() {
        System.out.println("sdf");
    }
}

interface abcd{
void getImplemented();
}

interface cdef extends abcd{
    void abcdefghg();

    @Override
    void getImplemented();
}

class NotTrying extends Trying{
    public void foo(){
        System.out.println("Foo In child");
    }
}

class Main{
    public static void main(String[] args) {
        /*int I = 1;
        while (I >= 1) {
            I += 10000;
        }
        System.out.println(I + "");*/


        FileInputStream fs;

        try {
            fs = new FileInputStream(new File("Y:\\Work\\Practice\\src\\abc.txt"));
            String[] st = new String[3];
            BufferedReader is = new BufferedReader(new FileReader("Y:\\Work\\Practice\\src\\abc.txt"));
            for(int i =0;i<3;i++){
                st[i] = is.readLine();
                System.out.println(st[i]);
                System.out.println("**");
            }
            //System.out.println();
        } catch (FileNotFoundException fe) {
            fe.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
