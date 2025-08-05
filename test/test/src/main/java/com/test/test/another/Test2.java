package com.test.test.another;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Test2 {

	public static void main(String[] args) {


		List<String> listOfStrings = Arrays.asList("Alice", "Amit", "Bob","Ram", "Amit","Bob");
		
		//  list of strings Values all in upperCase, sorted and No Duplicates
		
		Set<String> uniqueNameSet= new TreeSet<>();
		
		Set<String> duplicatesNames = listOfStrings.stream()
		.filter(name->!uniqueNameSet.add(name))
		.map(String::toUpperCase)
		.collect(Collectors.toSet());
		
		Set<String> collect = duplicatesNames.stream().map(String::toUpperCase).collect(Collectors.toCollection(TreeSet::new));
		
	//	Collections.sort(listOfStrings);
		
		//System.out.println(listOfStrings);
		
//		listOfStrings.stream().filter(name->uniqueNameSet.add(name))
//		.map(String::toUpperCase)
//		.collect(Collectors.toSet());
		
		LinkedHashSet<String> uniqueNameSet1 = listOfStrings.stream().map(String::toUpperCase)
		.collect(Collectors.toCollection(LinkedHashSet::new));
		
		
//		
		
		
		
		Map<String, Integer> collect2 = listOfStrings.stream()
		.collect(Collectors.toMap(name->name, name->name.length(),(existing, replacement)->replacement,LinkedHashMap:: new));

		System.out.println("Output : "+uniqueNameSet);
		

	}

}
