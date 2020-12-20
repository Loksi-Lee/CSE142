
import java.util.*;
import java.io.*;

public class Final {

  // public static final int MAX = 100;

   public static void main (String[] args) {
   
      int[] array = {3, 8, 5, 7, 12, -8, 3, 1, 4, 0, 6};
      
      findIndexes (10, array);
   }
  
   public static int[] findIndexes (int p, int[] arr) {
   
      int[] end = new int[p];
   
      int next = 0;
   
      for (int i=0; i<p; i++) {
         int initial = arr[i];
      
         if (arr[i]==i) {
            next = i;
         } else {
            next = -1;
         }
         end[i]=next;
      }
      System.out.println(Arrays.toString(end));
      return end;
   }
  
}
