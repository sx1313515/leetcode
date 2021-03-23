package realinterviewquestions.jinritoutiao;

import java.util.Stack;

/**
 * 描述:
 * 给定一个文档 (Unix-style) 的完全路径，请进行路径简化。
 * 例如，
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 *
 * 边界情况:
 *
 * 你是否考虑了 路径 = "/../" 的情况？
 * 在这种情况下，你需返回 "/" 。
 * 此外，路径中也可能包含多个斜杠 '/' ，如 "/home//foo/" 。
 * 在这种情况下，你可忽略多余的斜杠，返回 "/home/foo" 。
 * @Author: g
 * @CreateDate: 2019/1/4 13:48
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        if(path.equals("/../")){
            return "/";
        }else if(path.equals("/..")){
            return "/";
        }
        //去除多余的/
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();
        sb.append(path.charAt(0));
        for(int i=1;i<path.length();i++){
            if(path.charAt(i)=='/'&&path.charAt(i)==path.charAt(i-1)){
                continue;
            }
            sb.append(path.charAt(i));
        }
        String str = sb.toString();
        String[] strs = str.split("/");
        for (int i = 0; i < strs.length; i++) {
            if(strs[i].equals(".")){
                continue;
            }else if(strs[i].equals("..")){
                if(stack.size()==0)
                    continue;
                stack.pop();
            }else if(strs[i].equals("")){

            }else{
                stack.push(strs[i]);
            }
        }
        StringBuilder result = new StringBuilder();
        result.append('/');
        if(stack.size()==0)
            return "/";
        for (String s:stack) {
            result.append(s);
            result.append('/');
        }
        if(result.charAt(result.length()-1)=='/'&&result.length()>1)
            result.deleteCharAt(result.length() - 1);
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new SimplifyPath().simplifyPath("/a/./b///../c/../././../d/..//../e/./f/./g/././//.//h///././/..///"));
    }
}
