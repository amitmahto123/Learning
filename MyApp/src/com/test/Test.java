package com.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Test {
	
	public static void main(String[] args) {
		
		System.out.println("Hello world");
		
		final int [] a= {1,2,3,4,3,4,11,1,1,1,1};
		
		 List<Integer> collect = IntStream.concat(Arrays.stream(a).filter(n->n!=1),
		 Arrays.stream(a).filter(n->n==1)).boxed().collect(Collectors.toList());
		 
		 int [] array={1,4,6};
		 List<Integer> numList=Arrays.stream(array).boxed().collect(Collectors.toList());
		 int min=Arrays.stream(array).min().orElse(0);
		 int max =Arrays.stream(array).max().orElse(0);
		  List<Integer> collect2 = IntStream.range(min, max)
		 .boxed().filter(num->!numList.contains(num)).collect(Collectors.toList());

		 
                  System.err.println(collect2); 
                  
                  System.out.println("Adding line\n");
                  System.out.println("Addddddddddddddd2\n");
		 
		 
	}

}





























