package algoexpert;

public class CaesarCipherEncryptor {

   private static final int ALPHABET_SIZE = 26;

   public String encrypt(String input, int key){
      key = key % 26;
      StringBuilder builder = new StringBuilder();
      for(char ch : input.toCharArray()){
         if(ch + key > 'z')
            builder.append((char)(ch + key - ALPHABET_SIZE));
         else
            builder.append((char)(ch + key));
      }
      return builder.toString();
   }

   public static void main(String[] args) {
      CaesarCipherEncryptor obj = new CaesarCipherEncryptor();
      System.out.println(obj.encrypt("xyz", 3));
   }

}
