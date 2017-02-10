package confs;

import java.util.*;

public class Solution {
    
    public static void main(String[] args) {
        HashSet<String> wordDict = new HashSet<>();
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("dogs");
        Solution s = new Solution();
        s.wordBreak("", wordDict);
    }

    public List<String> wordBreak(String s, Set<String> wordDict) {
        Trie trie = buildTrie(wordDict);
        //trie.printTrie(trie.root);
        List<String> l = new ArrayList<>();
        
        return l;
    }
    
    public Trie buildTrie(Set<String> wordDict) {
        Trie trie = new Trie();
        for (String w : wordDict) {
            trie.addWord(w);
        }
        return trie;
    }
    
    public void getNode() {
        
    }
    
    public class TrieNode {
        private char c;
        public boolean isLeaf;
        private int numChild;
        private HashMap<Character, TrieNode> child;
        
        public TrieNode(char ch) {
            c = ch;
            isLeaf = false;
            numChild = 0;
            child = new HashMap<>();
        }
        
        public TrieNode(char ch, boolean isLeaf) {
            this(ch);
            isLeaf = true;
        }
                
        public TrieNode addChild(char n) {
            if (child.containsKey(n)) {
                // TODO throw exception
                return child.get(n);
            }
            TrieNode newChild = new TrieNode(n);
            child.put(n, newChild);
            numChild++;
            return newChild;
        }
        
        public TrieNode getChild(char n) {
            return child.get(n);
        }
    }
    
    public class Trie {
        public TrieNode root;
        
        public Trie() {
            root = new TrieNode('*');
        }
        
        public void addWord(String w) {
            if (w == null || w.length() == 0) {
                return;
            }
            TrieNode curr = root;
            
            for (int i = 0; i < w.length(); i++) {
                char c = w.charAt(i);
                TrieNode next = curr.getChild(c);
                if (next == null) {
                    next = curr.addChild(c);
                }
                curr = next;
            }
            curr.isLeaf = true;
        }
        
        public void printTrie(TrieNode curr) {
            printTrie(curr, ""); 
        }
        
        public void printTrie(TrieNode curr, String s) {
            if (curr.child.size() == 0) {
                System.out.println(s+curr.c);
                return;
            }
            if (curr.isLeaf) {
                System.out.println(s+curr.c);
            }
            for (TrieNode t : curr.child.values()) {
                printTrie(t, new String(s)+curr.c);
            }
        }
    }
}
