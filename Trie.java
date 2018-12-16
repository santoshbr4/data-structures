import java.util.Scanner;

public class Trie {

    class TrieNode {
        char ch;
        boolean isWordEnd;
        int count = 0;
        TrieNode head[] = new TrieNode[26];

        TrieNode() {
            isWordEnd = false;
            for(int i=0;i<head.length; i++) {
                head[i] = null;
            }
        }
    }

    private static TrieNode root;

    TrieNode insertIntoTrie(char ch, TrieNode cur) {
        if(ch == '\0') {
            if(cur != null) {
                cur.isWordEnd = true;
                cur.count++;
            }
            return cur;
        }

        if(cur.head[ch - 'a'] == null) {
                cur.head[ch - 'a'] = new TrieNode();
                cur.head[ch - 'a'].ch = ch;
                cur = cur.head[ch - 'a'];
            }
        else {
            cur = cur.head[ch - 'a'];
        }
        return cur;
    }

    void insert(String text) {
        int index = 0;
        if(root == null)
            root = new TrieNode();
        TrieNode cur = root;
        char ch = text.charAt(index);
        System.out.println(text.length());
        while( index < text.length()) {
            ch = text.charAt(index);
            cur = insertIntoTrie(ch, cur);
            index++;
        }
        insertIntoTrie('\0', cur);
    }

    int getWordCount(String text) {
        TrieNode cur = root;
        int index = 0;
        char ch = '\0';
        while( index < text.length()) {
            ch = text.charAt(index);
            if(cur.head[ch-'a'] == null) {
                    return 0;
            }
            else {
                cur = cur.head[ch - 'a'];
                if(cur == null)
                    return 0;
            }
            index++;
        }
        return cur.count;
    }
}
