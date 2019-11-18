import java.awt.*;

public class abcdef {
    public static void main(String[] args){
        point po = new point(2,3);
        po.distance(po);
    }
}

class point{
    int x, y;

    public point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    int distance(point p){
        int result = 0;
        int a = p.x - x;
        int b = p.y - y;
        result = (int)Math.sqrt(a*a + b*b);
        String a2 = "ihlk";
        if(a2=="ihlk"){
            System.out.println("sdf");
        }

        return result;
    }


}
