public class GCD {
    static int gcd(int a, int b){
        if(a==0)
            return b;
        if(b==0)
            return a;
        if(a>b)
            return gcd(a-b,b);
        return gcd(a,b-a);
    }

    static int lcm(int a, int b){
        return (a*b)/gcd(a,b);
    }

    public static void main(String[] args) {
        System.out.println(lcm(7,5));
    }
}
