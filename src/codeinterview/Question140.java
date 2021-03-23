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
        public TrieNode[] map;  //map 是一个哈希表结构，key 代表该节点的一条字符路径，value 表示字符路径指向的节点，根据题目的说明，map 是长度为 26 的数组，
        // 在字符种类较多的情况下，可以选择用真实的哈希表结构实现 map
        public TrieNode() {
            path = 0;
            end = 0;
            map = new TrieNode[26];
        } }
    public class Trie {
        private TrieNode root;
        public Trie() {
            root = new TrieNode();
        }
        public void insert(String word) {
            if (word == null) {
                return;
            }
            char[] chs = word.toCharArray();
            TrieNode node = root;
            node.path++;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (node.map[index] == null) {
                    node.map[index] = new TrieNode();
                }
                node = node.map[index];
                node.path++;
            }
            node.end++;
        }
        public void delete(String word) {
            if (search(word)) {
                char[] chs = word.toCharArray();
                TrieNode node = root;
                node.path++;
                int index = 0;
                for (int i = 0; i < chs.length; i++) {
                    index = chs[i] - 'a';
                    if (node.map[index].path-- == 1) {
                        node.map[index] = null;
                        return;
                    }
                    node = node.map[index];
                }
                node.end--; } }
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
            return node.end != 0;
        }
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
            return node.path;
        } }
}
