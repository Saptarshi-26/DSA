import java.util.HashMap;
import java.util.HashSet;

public class Implement_Trie_Prefix_Tree {
    class Trie {
        HashMap<Character, Trie> map  ;
        Trie head ;
        HashSet<String> wordSet;
        public Trie() {
            head = this;
            map= new HashMap<>();
            wordSet= new HashSet<>();
        }

        public void insert(Trie node, int i , String word) {
            if(i<word.length()){
                HashMap<Character, Trie> currentMap = node.map;
                if(!currentMap.containsKey(word.charAt(i))){
                    Trie newNode = new Trie();
                    currentMap.put(word.charAt(i), newNode);
                    insert(newNode,i+1,word);
                }
                else{
                    insert(currentMap.get(word.charAt(i)),i+1,word);
                }
            }
        }
        public void insert(String word) {
            wordSet.add(word);
           insert(this,0,word);
        }

        public boolean search(String word) {
            return wordSet.contains(word);
        }

        public boolean startWith(String prefix, int i , Trie node) {
            if(i<prefix.length()){
                if(node.map.containsKey(prefix.charAt(i))){
                    return startWith(prefix,i+1,node.map.get(prefix.charAt(i)));
                }
                else return false;
            }
            else return true;
        }

        public boolean startsWith(String prefix) {
            return startWith(prefix,0,this);
        }
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
}
