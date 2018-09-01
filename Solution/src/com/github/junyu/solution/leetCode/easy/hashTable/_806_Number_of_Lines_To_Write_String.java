package com.github.junyu.solution.leetCode.easy.hashTable;

import java.util.Arrays;

public class _806_Number_of_Lines_To_Write_String {


/*    We are to write the letters of a given string S, from left to right into lines. 
    Each line has maximum width 100 units, and if writing a letter would cause the 
    width of the line to exceed 100 units, it is written on the next line. We are 
    given an array widths, an array where widths[0] is the width of 'a', widths[1] 
    is the width of 'b', ..., and widths[25] is the width of 'z'.

    Now answer two questions: how many lines have at least one character from S, and 
    what is the width used by the last such line? Return your answer as an integer list of length 2.



    Example :
    Input:
    widths = [10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10]
    S = "abcdefghijklmnopqrstuvwxyz"
    Output: [3, 60]
    Explanation:
    All letters have the same length of 10. To write all 26 letters,
    we need two full lines and one line with 60 units.
            Example :
    Input:
    widths = [4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10]
    S = "bbbcccdddaaa"
    Output: [2, 4]
    Explanation:
    All letters except 'a' have the same length of 10, and 
"bbbcccdddaa" will cover 9 * 10 + 2 * 4 = 98 units.
    For the last 'a', it is written on the second line because
    there is only 2 units left in the first line.
    So the answer is 2 lines, plus 4 units in the second line.


            Note:

    The length of S will be in the range [1, 1000].
    S will only contain lowercase letters.
    widths is an array of length 26.
    widths[i] will be in the range of [2, 10].*/

    /**
     * 求写字符串所需要的行数及最后一行使用的长度
     * widths就是可以作为hash表直接使用，遍历每一个字符时，获取这个字符所需要的长度，如果当前行的总长超过
     * 100，那么就需要换行，对row+1，然后width从当前的字符长度开始重新累计。
     * @param widths
     * @param S
     * @return
     */
    public int[] numberOfLines(int[] widths, String S) {
        int row = 1;
        int width = 0;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            int curWidth = widths[c - 'a'];
            if (curWidth + width > 100) {
                row++;
                width = curWidth;
            } else {
                width += curWidth;
            }
        }
        return new int[]{row, width};
    }

    public static void main(String[] args) {
//        int widths [] = {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
//        String S = "abcdefghijklmnopqrstuvwxyz";
        int widths [] = {4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
        String S = "bbbcccdddaaa";
        System.out.println(Arrays.toString(new _806_Number_of_Lines_To_Write_String().numberOfLines(widths,S)));

    }
}
