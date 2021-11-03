package algoexpert;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

//Given a string having directory path "/foo/../test/../test/../foo//bar/./baz"
public class UnixDirShortenPath {

   public String getShortenPath(String path){
      if(path == null || path.length() == 0)
         return path;

      boolean isRootDirAvailable = path.charAt(0) == '/' ? true : false;

      //split the string based on "/"
      final String[] split = path.split("/");

      //remove blank string.
      final List<String> strings = Arrays.stream(split).filter(string -> !"".equals(string) && !".".equals(string)).collect(Collectors.toList());

      //take a stack.
      Stack<String> stack = new Stack<>();
      StringBuilder finalPath = new StringBuilder();
      for(String token : strings){
         if(token.equals("..")){
            //remove if we have any element in the stack, otherwise push this into stack.
            if(stack.isEmpty() || "..".equals(stack.peek())){
               stack.push(token);
            }else{
               stack.pop();
            }
         }else{
            stack.push(token);
         }
      }
      while(!stack.isEmpty()){
         finalPath.insert(0, stack.pop());
         if(!stack.isEmpty())
            finalPath.insert(0, "/");
      }
      if(isRootDirAvailable)
         finalPath.insert(0, "/");

      return finalPath.toString();
   }

   public static void main(String[] args) {
      String path = "../../test/../foo//bar/./baz";
      System.out.println(new UnixDirShortenPath().getShortenPath(path));
   }

}
