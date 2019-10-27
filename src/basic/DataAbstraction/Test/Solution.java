package basic.DataAbstraction.Test;

import java.util.Scanner;

/**
 * 寻找最长无重复字符子字符串长度
 */
class Solution {
    public static int  lengthOfLongestSubstring(String s) {
        char[] chars=new char[s.length()];      //新建字符数组用于逐个添加s中的字符
        chars[0]=s.charAt(0);
        int subStrLen=1;                        //用于储存所有子字符串的长度
        int maxLen=1;                           //用于存储最长子字符串的长度
        int start=0;                          //p为游标,start表示开始位置
        int p=start;
        for(int i=1;i<s.length();i++){          //遍历s[1]...s[N-1]
            char chr=s.charAt(i);
            while(p<i&&chars[p]!=chr) p++;          //将chars中的字符逐个与s[i]对比，若发现其中有一个字符与s[i]相同则终止循环
            if(p!=i) {                            //比较游标的位置
                subStrLen=i-start;                //此时意味着chars[start...i-1]中有一个字符与s[i]相等（位置在chars[p]）,
                start=p+1;
            }
            else{
                subStrLen=i+1-start;
            }
            maxLen=Math.max(maxLen,subStrLen);
            p=start;                                //游标置位，进入下一轮循环
            chars[i]=chr;                           //此时将s[i]追加到chars末尾
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);

        String str;
        while (!(str=in.next()).equals("exit")) {
            System.out.println("子字符串最长为： "+lengthOfLongestSubstring(str));
        }
    }

}




