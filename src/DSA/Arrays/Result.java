package DSA.Arrays;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class Result {

    /*
     * Complete the 'programmerStrings' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int programmerStrings(String s) {
        int programmer_count=0;
        boolean flag = false;
        int programmer_count2 =0;
        int start=-1, end = -1;
        char[] programmer = {'p','r','o','g','r','a','m','m','e','r'};
        Map<Character,Boolean> map1 = new HashMap<>();
        //Map<Character,Boolean> map2 = new HashMap<>();
        for(int i=0;i<10;i++){
            map1.put(programmer[i],false);
            //map2.put(programmer[i],false);
        }
        int r_count=1;
        int m_count=1;

        for(int i=0;i<s.length();i++){
            if(!flag){
                if(map1.containsKey(s.charAt(i))){
                    if(!map1.get(s.charAt(i))){
                        map1.put(s.charAt(i),true);
                        programmer_count++;
                        if(programmer_count==10){
                            flag = true;
                            start = i+1;
                        }
                    }else{
                        if(s.charAt(i)=='r' && r_count<3){
                            r_count++;
                            programmer_count++;
                            if(programmer_count==10){
                                flag = true;
                                start = i+1;
                            }
                        }else if(s.charAt(i)=='m' && m_count<2){
                            m_count++;
                            programmer_count++;
                            if(programmer_count==10){
                                flag = true;
                                start = i+1;
                            }
                        }
                    }
                }
            }else{
                if(map1.containsKey(s.charAt(i))){
                    return i-start;
                    /*map2.put(s.charAt(i),true);
                    programmer_count2++;*/
                }
            }
        }
        return -1;

    }
    public static void main(String[] args) throws IOException {
        /*BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();*/

        int result = Result.programmerStrings("progxrammerrxproxgrammer");

        /*bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();*/
    }
}
