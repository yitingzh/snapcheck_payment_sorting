package snapcheck_payment_sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SortUtil {
	
	   public static List<PaymentObject> bubbleSort(List<PaymentObject> lists){
	        int len = lists.size();
	        for(int i = 0; i < len -1; i++){
	            for (int j = 0; j < len - i - 1; j++){
	                if (lists.get(j).date < lists.get(j+1).date){
	                    Collections.swap(lists, j, j+1);
	                }
	            }
	        }
	        return lists;
	   }
	   
	   public static List<PaymentObject> mergeSort(List<PaymentObject> lists, int st, int end){
	        if (st >= end) return lists;
	        int mid = st + (end - st)/2;
	        mergeSort(lists, st, mid);
	        mergeSort(lists, mid+1, end);
	        
	        merge(lists, st, mid, end);
	        return lists;
	   }
	   
	   private static void merge(List<PaymentObject> lists, int st, int mid, int end){
	       List<PaymentObject> left = new ArrayList<>(lists.subList(st, mid+1));
	       List<PaymentObject> right = new ArrayList<>(lists.subList(mid+1, end+1));
	       
	       int len1 = left.size(), len2 = right.size();
	       int i = 0, j = 0, k =st;
	       
	       while(i < len1 && j < len2){
	           if (left.get(i).date > right.get(j).date){
	               lists.set(k++, left.get(i++));
	           }else{
	               lists.set(k++, right.get(j++));
	           }
	       }
	       while (i < len1){
	           lists.set(k++, left.get(i++));
	       }
	       while (j < len2){
	           lists.set(k++, right.get(j++));
	       }
	   }
	   
	   public static boolean verify(List<PaymentObject> lists){
	       int id = 0;
	       long prev = lists.get(id++).date;
	       while (id < lists.size()){
	           if (lists.get(id).date > prev )  return false;
	           prev = lists.get(id++).date;
	       }
	       return true;
	   }
	   
	   public static void shuffle(List<PaymentObject> lists){
	       Random rand = new Random();
	       int len = lists.size();
	       for (int i = 0; i < len; i++){
	           Collections.swap(lists, i, rand.nextInt(len));
	       }
	   }
	   
	   public static void print(List<PaymentObject> lists){
		   for (PaymentObject payment : lists){
			   System.out.println(payment.date);
		   }
	   }
}

