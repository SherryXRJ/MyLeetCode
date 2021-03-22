package com.sherry.leetcode._0065_TextJustification.mine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 68. 文本左右对齐
 *
 * 给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
 *
 * 你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
 *
 * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 *
 * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
 *
 * 说明:
 *
 * 单词是指由非空格字符组成的字符序列。
 * 每个单词的长度大于 0，小于等于 maxWidth。
 * 输入单词数组 words 至少包含一个单词。
 *
 */
public class TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {

        int left = 0;
        int right = 0;
        int tempSize = 0;

        Map<Integer, List<String>> map = new HashMap<>(words.length);

        while (right < words.length) {
            while(right < words.length && tempSize + words[right].length() <= maxWidth) {
                List<String> list = map.getOrDefault(left, new ArrayList<>());
                list.add(words[right]);
                map.put(left, list);
                //  FIXME: 这里 +1 出了问题
                tempSize += (words[right].length() + 1);
                right++;
            }
            tempSize = 0;
            left = right;
        }

        List<String> result = new ArrayList<>();


        int index = 0;
        for (Integer key : map.keySet()) {
            List<String> list = map.get(key);

            if (index == map.keySet().size() - 1) {
                //  最后一行 左对齐(最后一行需要左对齐进行处理(且单词之间不插入额外的空格))
                result.add(this.leftJustification(list, maxWidth));
            } else {
                //  非最后一行 左右对齐
                result.add(this.leftRightJustification(list, maxWidth));
            }
            index++;
        }

        return result;
    }

    /**
     * 左右对齐
     */
    private String leftRightJustification(List<String> list, int maxWidth){
        int wordsNum = list.size();

        //  间隙数
        int gaps = wordsNum == 1 ? 1 : wordsNum - 1;
        //  当前行的单词总长度
        int wordsLen = list.stream().mapToInt(String::length).sum();
        //  计算平均空格数
        int spaceNum = (maxWidth - wordsLen) / gaps;
        //  多余的空格数
        int extraSpaceNum = (maxWidth - wordsLen) % gaps;

        String mergeStr = "";
        for (int i = 0; i < wordsNum; i++) {
            if (i == 0)
                mergeStr = "";

            if (i < gaps) {
                mergeStr += rightpad(list.get(i), i + 1 <= extraSpaceNum ? spaceNum + extraSpaceNum + list.get(i).length(): spaceNum + list.get(i).length());
            } else {
                mergeStr += list.get(i);
            }
        }

        return mergeStr;
    }

    /**
     * 左对齐
     */
    private String leftJustification(List<String> list, int maxWidth){
        String joinStr = String.join(" ", list);

        return rightpad(joinStr, maxWidth);
    }

    private String rightpad(String text, int length) {
        return String.format("%-" + length + "." + length + "s", text);
    }

    public static void main(String[] args) {
//        String[] arr = new String[]{"What","must","be","acknowledgment","shall","be"};
        String[] arr = new String[]{"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
        TextJustification demo = new TextJustification();
        demo.fullJustify(arr, 20);
    }

}
