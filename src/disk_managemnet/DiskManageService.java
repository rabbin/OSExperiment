package disk_managemnet;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Union;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class DiskManageService {

   enum Type{
       SSTF,SCAN
   }
   Type type;
   LinkedList<Integer> requestQueue;
   long count = 0;

   public DiskManageService(Type type, LinkedList<Integer> requestQueue){
       this.type = type;
       this.requestQueue = requestQueue;
   }

   public void start(int start){

       requestQueue.add(start);
       Collections.sort(requestQueue);
       switch (type){
           case SSTF:sstf(start);
           case SCAN:scan(start);
       }
       System.out.println("\n总移臂量： " + count);

   }
   private void scan(int next){
       for(int flag = 0, index = requestQueue.indexOf(next); requestQueue.size() > 0 ;){

           try{
               if(flag == 0){
                   next = requestQueue.get(index+1);
               }else{
                   next = requestQueue.get(index-1);
               }
           }catch (IndexOutOfBoundsException exception){
               flag= (flag+1)%2;
               try{
                   if (flag ==0){
                       next = requestQueue.get(index+1);
                   }else{
                       next = requestQueue.get(index-1);
                   }
               }catch (IndexOutOfBoundsException e){
                   next = requestQueue.get(index);
               }
           }
//           System.out.println("\n总移臂量： " + count);
//           System.out.println(next-requestQueue.get(index));
           count += Math.abs(next-requestQueue.get(index));
           System.out.print(requestQueue.get(index)+ "\t");
           requestQueue.remove(index);
           index = requestQueue.indexOf(next);

       }
   }
   private void sstf(int start){
       for(int index = requestQueue.indexOf(start); requestQueue.size() > 0 ;){
           int left , right;
           int flag = 0;
           try {
               left = requestQueue.get(index-1);
           }catch (IndexOutOfBoundsException exception){
               left = Integer.MIN_VALUE/2;
               flag++;
           }
           try {
               right = requestQueue.get(index+1);
           }catch (IndexOutOfBoundsException exception){
               right = Integer.MAX_VALUE/2;
               flag++;
           }

           start = start - left < right - start ?left :right;
           if(flag!=2){
               count += Math.abs(start-requestQueue.get(index));
           }

           System.out.print(requestQueue.get(index)+ "\t");
           requestQueue.remove(index);
           index = requestQueue.indexOf(start);

       }

   }
}
