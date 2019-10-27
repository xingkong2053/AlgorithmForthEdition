package Chapter3Search;

import Chapter3Search.SymbolTable.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.io.*;
import java.util.Scanner;

/**
 * 测试符号表
 */
public class FrequencyCounter {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("文件名：");
        String fileName=in.next();
        System.out.print("最小单词长度: ");
        int minLen = Integer.parseInt(in.next());

        //构造符号表用于单词出现频率统计key:某个单词，val:其出现的频率
        ST<String, Integer> st = new ST<>();

        InputStreamReader fr=null;

        try{
             fr= new FileReader(new File(fileName));
            char[] chars=new char[1024];
            while(fr.read(chars)!=-1){
                String word=new String(chars);
                if(word.length()<minLen) continue;      //忽略长度较短的单词
                //统计出现频率
                if(!st.contains(word)) st.put(word,1);
                else st.put(word,st.get(word)+1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("st.size() = " + st.size());

        String max="";
        st.put(max,0);
        for (String key : st.keys()) {
            if(st.get(max)<st.get(key)){
                max=key;
            }
        }
        StdOut.println(max+" "+st.get(max));
    }
}
