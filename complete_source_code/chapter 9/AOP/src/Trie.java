import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Trie {
    private TrieNode root;

    class TrieNode {
        char c;
        HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
        boolean isLeaf;

        public TrieNode(){}

        public TrieNode(char c){
            this.c = c;
        }
    }

    public Trie(){
        root = new TrieNode();
    }

    //insert word into the trie
    public void insert(String word){
        HashMap<Character, TrieNode> children = root.children;
        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i);

            TrieNode t;
            if (children.containsKey(c)){
                t = children.get(c);
            }
            else{
                t = new TrieNode(c);
                children.put(c, t);
            }

            children = t.children;
            //set leaf node
            if (i == word.length() - 1)
                t.isLeaf = true;
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word){
        TrieNode t = searchNode(word);

        if (t != null && t.isLeaf){
            return true;
        }
        else
            return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix){
        if (searchNode(prefix) == null)
            return false;
        else
            return true;
    }

    public int getCharacterNum(String word){
        int charNum = 0;
        String prefix = "";
        prefix += String.valueOf(word.charAt(0));
        TrieNode node = searchNode(prefix);
        if (node.children.size() == 1)
            charNum = 1;
        Map <Character, TrieNode> children = node.children;
        for (int i = 1; i < word.length(); i++){
            if (children.containsKey(word.charAt(i))) {
                node = children.get(word.charAt(i));
                children = node.children;
                if (children.size() == 1 && charNum == 0)
                    charNum = i + 1;
                if (children.size() > 1 && (charNum != 0))
                    charNum = 0;
                if (children.size() > 1 && i == word.length() - 2)
                    return word.length();
            }
        }
        return charNum;
    }


    public TrieNode searchNode(String str){
        Map<Character, TrieNode> children = root.children;
        TrieNode t = null;
        for (int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if (children.containsKey(c)){
                t = children.get(c);
                children = t.children;
            }
            else
                return null;
        }
        return t;
    }

    public static void main(String[] args) {

        Trie trie = new Trie();
        Scanner scanner = new Scanner(System.in);
        int numOfWords = Integer.parseInt(scanner.nextLine());
        String lineWithWords = scanner.nextLine();
        String[] arrayOfWords = lineWithWords.split(" ");
        int result = 0;
        for (String word: arrayOfWords){
            if (!trie.search(word))
            {
                trie.insert(word);
                result += word.length();
                continue;
            }
            else
                result += trie.getCharacterNum(word);
        }
        System.out.println(result);
    }
}
