package string;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 *
 * @Author: xiang_song
 * @CreateDate: 2019/3/8 14:19
 */
public class CompareVersion {

    public int compareVersion(String version1, String version2) {
        String[] versions1 = version1.split("\\.");
        String[] versions2 = version2.split("\\.");
        int length1 = versions1.length;
        int length2 = versions2.length;
        for (int i = 0; i < length1; i++) {
            versions1[i] = trimZero(versions1[i]);
        }
        for (int i = 0; i < length2; i++) {
            versions2[i] = trimZero(versions2[i]);
        }
        if(length1>length2){
            for(int i=0;i<length2;i++){
                if (Integer.valueOf(versions1[i]) > Integer.valueOf(versions2[i])) {
                    return 1;
                }else if (Integer.valueOf(versions1[i]) < Integer.valueOf(versions2[i])){
                    return -1;
                }
            }
            for (int i = length2; i <length1 ; i++) {
                if(Integer.valueOf(versions1[i])!=0){
                    return 1;
                }
            }
            return 0;
        } else if(length1<length2){
            for(int i=0;i<length1;i++){
                if (Integer.valueOf(versions1[i]) > Integer.valueOf(versions2[i])) {
                    return 1;
                }else if (Integer.valueOf(versions1[i]) < Integer.valueOf(versions2[i])){
                    return -1;
                }
            }
            for (int i = length1; i <length2 ; i++) {
                if(Integer.valueOf(versions2[i])!=0){
                    return -1;
                }
            }
            return 0;
        }else {
            for(int i=0;i<length1;i++){
                if (Integer.valueOf(versions1[i]) > Integer.valueOf(versions2[i])) {
                    return 1;
                }else if (Integer.valueOf(versions1[i]) < Integer.valueOf(versions2[i])){
                    return -1;
                }
            }
            return 0;
        }


    }

    private String trimZero(String s) {
        int i;
        for (i = 0; i < s.length(); i++) {
            if (s.charAt(i)!='0'){
                break;
            }
        }
        if (i==s.length()&&s.charAt(s.length()-1)=='0'){
            return "0";
        }else {
            return s.substring(i);
        }
    }

    public static void main(String[] args) {
        System.out.println(new CompareVersion().compareVersion("1.1", "1"));;
    }
}
