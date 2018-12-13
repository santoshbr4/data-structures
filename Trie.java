import java.util.Scanner;

public class Trie {

    class TrieNode {
        char ch;
        boolean isWordEnd;
        int count = 0;
        TrieNode head[] = new TrieNode[26];
    }

    private TrieNode trie[] = new TrieNode[26];

    void insertIntoTrie(char ch, TrieNode cur) {
        if(ch == '\0') {
            if(cur != null) {
                cur.isWordEnd = true;
                cur.count++;
            }
            return;
        }

        if(cur == null) {
            if(trie[ch - 'a'] != null) {
                cur = trie[ch - 'a'];
            }
            else {
                trie[ch - 'a'] = new TrieNode();
                trie[ch - 'a'].ch = ch;
                cur = trie[ch - 'a'];
            }
        }
        else {
            if(cur.head[ch - 'a'] == null) {
                cur.head[ch - 'a'] = new TrieNode();
                cur.head[ch - 'a'].ch = ch;
            }
            cur = cur.head[ch - 'a'];
        }
    }

    void insert(String text) {
        int index = 0;
        TrieNode cur = null;
        char ch = text.charAt(index);
        System.out.println(text.length());
        while( index < text.length()) {
            ch = text.charAt(index);
            insertIntoTrie(ch, cur);
            index++;
        }
        insertIntoTrie('\0', cur);
    }

    int getWordCount(String text) {
        TrieNode cur = null;
        int index = 0;
        char ch = '\0';
        while( index < text.length()) {
            ch = text.charAt(index);
            if(cur == null) {
                cur = trie[ch - 'a'];
                if(cur == null)
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
