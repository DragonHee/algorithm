package backjoon.sortion;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Word implements Comparable{
    private String word;
    public Word(String word){
        this.word = word;
    }
    public String getWord(){return word;}
    public void setWord(){this.word = word;}
    @Override
    public int compareTo(Object o) {
        Word w = (Word)o;
        int result = word.length() - w.word.length();
        return (result != 0) ? result : word.compareTo(w.word);
    }
}

public class Backjoon1181 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        List<Word> list = new ArrayList<Word>();

        for(int i = 0 ; i < n; i++){
           list.add(new Word(br.readLine()));
        }
        Collections.sort(list);
        for(int i = 0 ; i < n - 1; i++){
            if(list.get(i).getWord().equals(list.get(i + 1).getWord())) {
                list.remove(i-- + 1);
                n--;
            }
        }

        for(Word w : list){
            bw.write(w.getWord() + "\n");
        }
        bw.close();
        br.close();
    }
}
