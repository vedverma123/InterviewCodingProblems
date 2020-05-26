package algoexpert;

import java.util.HashSet;
import java.util.Set;

public class YoungestCommonAncestor {

   private static class Ancestor{
      char label;
      Ancestor ancestor;

      public Ancestor(char label) {
         this.label = label;
      }
   }

   //Space complexity - O(number of ancestor) i.e O(n) or O(d), where d is the depth of the lowest descendent.
   //Time complexity - O(number of ancestor) i.e O(n), where d is the depth of the lowest descendent.
   public Ancestor findYoungestCommon(Ancestor root, Ancestor descen1, Ancestor descen2){
      if(descen1 == null || descen2 == null || root == null)
         throw new IllegalArgumentException();

      Set<Ancestor> ancestors = new HashSet<>();
      while(descen1 != null){
         ancestors.add(descen1);
         descen1 = descen1.ancestor;
      }

      while(descen2 != null){
         if(ancestors.contains(descen2))
            return descen2;
         descen2 = descen2.ancestor;
      }

      return null;
   }

   public static void main(String[] args) {
      Ancestor[] ancestors = getInput();
      YoungestCommonAncestor obj = new YoungestCommonAncestor();
      System.out.println(obj.findYoungestCommon(ancestors[0], ancestors[5], ancestors[24]).label);


   }

   private static Ancestor[] getInput() {
      Ancestor[] ancestors = new Ancestor[26];
      int count = 0;
      for(int i = 65; i <=90; i ++){
         char ch = (char)i;
         Ancestor ancestor = new Ancestor(ch);
         ancestors[count ++] = ancestor;
      }
      ancestors[1].ancestor = ancestors[0];
      ancestors[2].ancestor = ancestors[0];
      ancestors[3].ancestor = ancestors[0];
      ancestors[4].ancestor = ancestors[0];

      ancestors[5].ancestor = ancestors[1];
      ancestors[6].ancestor = ancestors[1];
      ancestors[7].ancestor = ancestors[2];

      ancestors[8].ancestor = ancestors[3];
      ancestors[9].ancestor = ancestors[3];

      ancestors[10].ancestor = ancestors[4];
      ancestors[11].ancestor = ancestors[4];

      ancestors[12].ancestor = ancestors[7];
      ancestors[13].ancestor = ancestors[12];

      ancestors[14].ancestor = ancestors[8];

      ancestors[15].ancestor = ancestors[9];
      ancestors[16].ancestor = ancestors[9];

      ancestors[17].ancestor = ancestors[15];
      ancestors[18].ancestor = ancestors[15];

      ancestors[19].ancestor = ancestors[16];

      ancestors[20].ancestor = ancestors[17];
      ancestors[21].ancestor = ancestors[17];

      ancestors[22].ancestor = ancestors[20];
      ancestors[23].ancestor = ancestors[20];

      ancestors[24].ancestor = ancestors[21];

      ancestors[25].ancestor = ancestors[22];
      return ancestors;
   }

}
