package string;

import org.jetbrains.annotations.Contract;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 描述:
 * 输入:
 * words = ["This", "is", "an", "example", "of", "text", "justification."]
 * maxWidth = 16
 * 输出:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 * @Author: xiang_song
 * @CreateDate: 2019/3/5 14:29
 */
public class FullJustify {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int length = words.length;
        List<String> list = new ArrayList<>();
        List<String> tools = new ArrayList<>();
        int sen_length = maxWidth;
        int i = 0;
        while (i<length){
            if (words[i].length()+1<=sen_length){
                tools.add(words[i]+" ");
                sen_length = sen_length-words[i].length()-1;
                i++;
                if (i==length){
                    String str = listToString(new ArrayList<>(tools));
                    list.add(str+produceSpace(maxWidth-str.length()));
                }
            }else if(words[i].length()==sen_length){
                tools.add(words[i]);
                list.add(listToString(new ArrayList<>(tools)));
                sen_length = maxWidth;
                tools = new ArrayList<>();
                i++;
            }else if(words[i].length()>sen_length){
                if(tools.size()==1){
                    tools.set(0, tools.get(0) + produceSpace(maxWidth - tools.get(0).length()));
                }else {
                    tools.set(tools.size()-1,tools.get(tools.size()-1).trim());
                    sen_length = sen_length+1;
                    int[] space = distributeSpace(tools.size()-1, sen_length);
                    for (int j = 0; j < tools.size()-1; j++) {
                        tools.set(j,tools.get(j)+produceSpace(space[j]));
                    }
                }
                list.add(listToString(new ArrayList<>(tools)));
                sen_length = maxWidth;
                tools = new ArrayList<>();

            }
        }
        return list;
    }

    @Contract(pure = true)
    private String produceSpace(int i) {
        String str = "";
        for (int j = 0; j < i; j++) {
            str = str + " ";
        }
        return str;
    }

    private int[] distributeSpace(int size, int sen_length) {
        int[] result = new int[size];
        int zheng = sen_length/size;
        int yu = sen_length%size;
        Arrays.fill(result,zheng);
        for (int i = 0; i < yu; i++) {
            result[i] = result[i]+1;
        }
        return result;
    }

    private String listToString(List<String> tools) {
        String result = "";
        for (int i = 0; i <tools.size() ; i++) {
            result = result+tools.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> list = new FullJustify().fullJustify(new String[]{"What","must","be","acknowledgment","shall","be"}, 16);
        list.size();
    }
}
