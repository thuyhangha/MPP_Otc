package EXCERSICE;

import java.util.stream.Stream;

public class CountOccurenceGenericLession {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String target = null;
		String[] arr = new String[]{null, null};
		System.out.println(countOccurences(arr, target));
	}
	
	public static int countOccurences(String[] arr, String target){
		int count =0;
		if(target == null){
			for (int i = 0; i < arr.length; i++) {
				if(arr[i] == null)
					count ++;
			}
		}else {
			for (int i = 0; i < arr.length; i++) {
				if(target.equals(arr[i]))
					count++;
			}
		}
		
		return count;
		
	}
	
	public static <T> int countOccurences3(T[] arr, T target){
		int count =0;
		if(target == null){
			for (int i = 0; i < arr.length; i++) {
				if(arr[i] == null)
					count ++;
			}
		}else {
			for (int i = 0; i < arr.length; i++) {
				if(target.equals(arr[i]))
					count++;
			}
		}
		
		return count;
		
	}
	
	public static int countOccurences1(String[] arr, String target){
		int count = (int)Stream.of(arr).filter(x -> {
				if(target == null)
					return x.equals(target);
				else {
					return target.equals(x);
				}
			}
		).count();		
		return count;
		
	}
}
