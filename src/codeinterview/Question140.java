package codeinterview;

/**
 * 描述:字典树的实现
 *
 * @Author: xiang_song
 * @CreateDate: 2021/3/23 10:45 下午
 */
public class Question140 {
    public class TrieNode {
        public int path;  //表示有多少个单词共用这个节点
        public int end;  //表示有多少个单词以这个节点结尾
        public TrieNode[] map;  //map 是长度为 26 的数组，存储26个字母的节点，
        public TrieNode() {
            path = 0;
            end = 0;
            map = new TrieNode[26];  //这里有点浪费空间，可以使用collection
        }
    }
    //树
    public class Trie {
        private TrieNode root;  //树的根节点
        public Trie() {
            root = new TrieNode();
        }
        public void insert(String word) {
            if (word == null) {
                return;
            }
            char[] chs = word.toCharArray();
            TrieNode node = root;
            node.path++;  //总单词数+1
            int index = 0;
            for (int i = 0; i < chs.length; i++) {  //循环把单词的字母挂到树上去
                index = chs[i] - 'a';
                if (node.map[index] == null) {
                    node.map[index] = new TrieNode();
                }
                node = node.map[index];
                node.path++;  //这个节点共用的单词+
            }
            node.end++;  //以这个节点结尾的单词+1
        }
        public void delete(String word) {
            if (search(word)) {  //是否存在这个单词
                char[] chs = word.toCharArray();
                TrieNode node = root;
                node.path--;  //单词数减一
                int index = 0;
                for (int i = 0; i < chs.length; i++) {
                    index = chs[i] - 'a';
                    if (node.map[index].path-- == 1) {   //如果没有了以这个节点开头的单词就把这个节点置空
                        node.map[index] = null;
                        return;
                    }
                    node = node.map[index];
                }
                node.end--;
            }
        }
                //查询单词是否存在
        public boolean search(String word) {
            if (word == null) {
                return false;
            }
            char[] chs = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (node.map[index] == null) {
                    return false;
                }
                node = node.map[index];
            }
            return node.end != 0;  //是否有单词以这个结尾
        }
        //有几个以单词为前缀的单词
        public int prefixNumber(String pre) {
            if (pre == null) {
                return 0;
            }
            char[] chs = pre.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (node.map[index] == null) {
                    return 0;
                }
                node = node.map[index];
            }
            return node.path; //有多少个单词共用这个节点
        }
    }
}
