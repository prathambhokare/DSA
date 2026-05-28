package LEETCODEPOTD;

public class Solution24 {
    
    // class Solution {
//     public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
//         int[] ans=new int[wordsQuery.length];

//         //__stores suffix and [index,length]
//         Map<String,Integer[]> mp=new HashMap<>();
        
//         for (int i=0;i<wordsContainer.length;i++) {
//             String word=wordsContainer[i];
//             for (int j=word.length();j>=0;j--) {
//                 String ansval="";
//                 if (j!=word.length()) {
//                     ansval=word.substring(j,word.length());
//                 }
//                 // System.out.println(ansval);
//                 if (!mp.containsKey(ansval)) {
//                     mp.put(ansval,new Integer[]{i,word.length()});
//                 }
//                 else {
//                     Integer[] value=mp.get(ansval);
//                     int index=value[0];
//                     int length=value[1];
//                     if (length>word.length()) {
//                         mp.put(ansval,new Integer[]{i,word.length()});
//                     }
//                     else if (length==word.length() && index>i) {
//                         mp.put(ansval,new Integer[]{i,word.length()});
//                     }
//                 }
//             }
//         }

//         for (int i=0;i<wordsQuery.length;i++) {
//             String word=wordsQuery[i];
//             boolean isFound=false;
//             for (int j=word.length()-1;j>=0;j--) {
//                 String ansval=word.substring(j,word.length());
//                 if (mp.containsKey(ansval)) {
//                     ans[i]=mp.get(ansval)[0];
//                     isFound=true;
//                 }
//             }
//             if (!isFound && mp.containsKey("")) {
//                 ans[i]=mp.get("")[0];
//             }
//         }
//         return ans;
//     }
// }


    public static class TrieNode {
        TrieNode[] child = new TrieNode[26];
        int index;
        int length;

        TrieNode() {
            index = Integer.MAX_VALUE;
            length = Integer.MAX_VALUE;
        }
    }

    public static TrieNode root = new TrieNode();
    public static void insert(String word, int idx) {
        TrieNode node = root;
        // update root answer
        if (word.length() < node.length ||
           (word.length() == node.length && idx < node.index)) {
            node.length = word.length();
            node.index = idx;
        }

        for (int i = word.length() - 1; i >= 0; i--) {
            char ch = word.charAt(i);
            if (node.child[ch - 'a'] == null) {
                node.child[ch - 'a'] = new TrieNode();
            }
            node = node.child[ch - 'a'];
            if (word.length() < node.length ||
               (word.length() == node.length && idx < node.index)) {
                node.length = word.length();
                node.index = idx;
            }
        }
    }

    public static int search(String word) {
        TrieNode node = root;
        for (int i = word.length() - 1; i >= 0; i--) {
            char ch = word.charAt(i);
            if (node.child[ch - 'a'] == null) {
                break;
            }
            node = node.child[ch - 'a'];
        }
        return node.index;
    }

    public static int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        for (int i = 0; i < wordsContainer.length; i++) {
            insert(wordsContainer[i], i);
        }
        int[] ans = new int[wordsQuery.length];
        for (int i = 0; i < wordsQuery.length; i++) {
            ans[i] = search(wordsQuery[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] ans=stringIndices(new String[]{"abcd","bcd","xbcd"}, new String[]{"cd","bcd","xyz"});
        for (int i=0;i<ans.length;i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }
}
