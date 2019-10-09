package backjoon.sortion;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Member implements Comparable{
    private int age;
    private String name;
    private int joinDate;
    public Member(int age, String name, int joinDate){
        this.age = age;
        this.name = name;
        this.joinDate = joinDate;
    }
    public int getAge(){return age; }
    public String getName(){return name;}
    @Override
    public int compareTo(Object o) {
        Member m = (Member)o;
        int result = age - m.age;

        return (result != 0) ? result : joinDate - m.joinDate;
    }
}
public class Backjoon10814 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        Member []memberArr = new Member[n];
        StringTokenizer st;
        int joinDate = 0;

        for(int i = 0 ; i < n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            memberArr[i] = new Member(Integer.parseInt(st.nextToken()), st.nextToken(), joinDate++);
        }
        Arrays.sort(memberArr);
        for(Member m : memberArr){
            bw.write(m.getAge() + " " + m.getName() + "\n");
        }
        bw.close();
        br.close();
    }
}
