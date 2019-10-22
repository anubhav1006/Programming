import java.util.ArrayList;

public class Student extends cd
{
    static int last_roll = 15;
    int roll_no;

    // Constructor
    Student()
    {
        roll_no = last_roll;
        last_roll++;
    }

    // Overriding hashCode()
    @Override
    public int hashCode()
    {
        return roll_no;
    }

    // Driver code
    public static void main(String args[])
    {
        Student s = new Student();
        Student s2 = new Student();

        // Below two statements are equivalent
        //System.out.println(s);
        //System.out.println(s2.toString());
        ArrayList ar = new ArrayList<>();
        ar.add(1);
        ar.add(12);
        ar.add(123);
        ar.add(1234);
        //ar.add("skjhg");
        for(Object a : ar){

        }
        if("123" == ("1234")){

        }
    }

}