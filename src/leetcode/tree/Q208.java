package leetcode.tree;

/**
 * 描述:实现 Trie (前缀树)
 *  Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
 *
 请你实现 Trie 类：
 Trie() 初始化前缀树对象。
 void insert(String word) 向前缀树中插入字符串 word 。
 boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
 boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: xiang_song
 * @CreateDate: 2022/3/20 22:53
 */
public class Q208 {

    class TireNode {
        private boolean isEnd;
        TireNode[] next;

        public TireNode() {
            isEnd = false;
            next = new TireNode[26];
        }
    }

    private TireNode root;

    public Q208() {
        root = new TireNode();
    }

    public void insert(String word) {
        TireNode node = root;
        for (char c : word.toCharArray()) {
            if (node.next[c - 'a'] == null) {
                node.next[c - 'a'] = new TireNode();
            }
            node = node.next[c - 'a'];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        TireNode node = root;
        for (char c : word.toCharArray()) {
            node = node.next[c - 'a'];
            if (node == null) {
                return false;
            }
        }
        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        TireNode node = root;
        for (char c : prefix.toCharArray()) {
            node = node.next[c - 'a'];
            if (node == null) {
                return false;
            }
        }
        return true;
    }
}
