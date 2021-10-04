import java.util.ArrayList;
import java.util.List;

public class Index {

    static class Trie {
        class Node {
            boolean isWord;
            Node[] next;

            Node() {
                next = new Node[26];
            }
        }

        private Node root;

        Trie(String[] words) {
            root = new Node();
            for (String word : words) {
                insert(word);
            }
        }

        private void insert(String word) {
            Node cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (cur.next[c - 'a'] == null) {
                    cur.next[c - 'a'] = new Node();
                }
                cur = cur.next[c - 'a'];
            }

            cur.isWord = true;
        }

        // Find the prefix of all word[start:] in Trie, and return the subscript of the ending character of the prefix
        public List<Integer> hasPrefix(String word, int start) {
            List<Integer> end = new ArrayList<>();
            Node cur = root;
            for (int i = start; i < word.length(); i++) {
                char c = word.charAt(i);
                // When it reaches null, it means that a longer prefix is ​​impossible, exit the loop
                if (cur.next[c - 'a'] == null) {
                    break;
                }

                cur = cur.next[c - 'a'];
                // Find a prefix, add its ending subscript to the list
                if (cur.isWord) {
                    end.add(i);
                }
            }

            return end;
        }
    }

    public static int[][] indexPairs(String text, String[] words) {
        List<int[]> list = new ArrayList<>();
        Trie trie = new Trie(words);

        // Find all the prefixes of text[i:] in the trie, and add the interval endpoints to the list
        for (int i = 0; i < text.length(); i++) {
            for (int end : trie.hasPrefix(text, i)) {
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

        int[][] res= indexPairs("thestoryofleetcodeandme",words);

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
