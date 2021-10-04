import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IndexOfString {

    private class TrieNode {
        Map<Character, TrieNode> node;
        boolean endOfWord;
        TrieNode() {
            node = new HashMap<>();
            endOfWord = false;
        }
    }

    private final TrieNode root;
    public IndexOfString() {
        root = new TrieNode();
    }

    /**
     * Iterative implementation of insert into trie
     */
    public  void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.node.get(ch);
            if (node == null) {
                node = new TrieNode();
                current.node.put(ch, node);
            }
            current = node;
        }
        //mark the current nodes endOfWord as true
        current.endOfWord = true;
    }

    /**
     * Iterative implementation of search into trie.
     */
    public List<Integer> search(String word,int start) {
        List<Integer> end = new ArrayList<>();
        TrieNode current = root;
        for (int i = start; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.node.get(ch);
            //if node does not exist for given char then return false
            if (node == null) {
                break;
            }
            current = node;
            if (current.endOfWord) {
                end.add(i);
            }
        }
        //return true of current's endOfWord is true else return false.
        return end;
    }

    public static int[][] indexPairs(String text, String[] words) {
        List<int[]> list = new ArrayList<>();
        IndexOfString trie = new IndexOfString();

        // Find all the prefixes of text[i:] in the trie, and add the interval endpoints to the list
        for (int i = 0; i < text.length(); i++) {
            for (int end : trie.search(text, i)) {
                list.add(new int[]{i, end});
            }
        }

        // Convert to array and return
        int[][] res = new int[list.size()][];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }

        return res;
    }

    public static void main (String args[]){
        String[] words= {"story","fleet","leetcode"};
        IndexOfString trie=new IndexOfString();
        List<int[]> list = new ArrayList<>();
            for (String word : words) {
                trie.insert(word);
            }

         String text="thestoryofleetcodeandme";
        // Find all the prefixes of text[i:] in the trie, and add the interval endpoints to the list
        for (int i = 0; i < text.length(); i++) {
            for (int end : trie.search(text, i)) {
                list.add(new int[]{i, end});
            }
        }

        // Convert to array and return
        int[][] res = new int[list.size()][];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
      //  res= indexPairs("thestoryofleetcodeandme",words);

        for(int i = 0; i < res.length; i++)
        {
            for(int j = 0; j < res.length; j++)
            {
                System.out.printf("%5d ", res[i][j]);
            }
            System.out.println();
        }
    }

}