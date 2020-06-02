package algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given set of words, group them as they are anagrams.
 * Eg:
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 */
public class GroupAnagrams {

   //Time complexity - O(wnlog(n)), where w are the words and n is the length of the longest word.
   //Space complexity - O(wn)
   public List<List<String>> anagrams(String[] input){
      final Map<String, List<String>> anagrams = new HashMap<>();
      for(String word : input){
         //sort the word
         char[] chars = word.toCharArray();
         Arrays.sort(chars);
         String sortedString = String.valueOf(chars);
         if(anagrams.containsKey(sortedString))
            anagrams.get(sortedString).add(word);
         else{
            List<String> words = new ArrayList<>();
            words.add(word);
            anagrams.put(sortedString, words);
         }
      }

      return new ArrayList<>(anagrams.values());
   }


   public static void main(String[] args) {
      String[] input = {"yo","act","flop","tac","cat","oy","olfp"};
      GroupAnagrams obj = new GroupAnagrams();
      List<List<String>> anagrams = obj.anagrams(input);
      for(List<String> list : anagrams){
         System.out.print("{");
         for(String str : list)
            System.out.print(str +",");

         System.out.print("}");
         System.out.println();
      }

   }

   //Naive solution
   public List<List<String>> grouping(String[] input){
      if(input == null || input.length == 0)
         return new ArrayList<>();

      Set<String> visited = new HashSet<>();
      List<String> inputList = Arrays.asList(input);
      List<List<String>> anagrams = new ArrayList<>();
      for(int i = 0; i < inputList.size(); i ++){
         String current = inputList.get(i);
         if(visited.contains(current))
            continue;

         List<String> list = new ArrayList<>();
         anagrams.add(list);
         list.add(current);

         Set<Character> chars = new HashSet<>();
         populateSet(chars, current);


         for(int j = i + 1 ; j < inputList.size(); j ++){
            boolean isAnagram = true;
            String next = inputList.get(j);
            if(next.length() == 0 && !current.equals(next))
               isAnagram = false;
            else if(current.length() != next.length())
               isAnagram = false;
            else {
               isAnagram = checkForAnagram(next, chars);

               if(isAnagram){
                  Set<Character> nextChars = new HashSet<>();
                  populateSet(nextChars, next);
                  isAnagram = checkForAnagram(current, nextChars);
               }
            }
            if(isAnagram){
               list.add(next);
               visited.add(next);
            }
         }
      }
      return anagrams;
   }

   private boolean checkForAnagram(String next, Set<Character> chars) {
      for(char ch : next.toCharArray()){
         if(!chars.contains(ch)){
            return false;
         }
      }
      return true;
   }

   private void populateSet(Set<Character> chars, String current) {
      for(char ch : current.toCharArray())
         chars.add(ch);
   }

}
