package com.test.test;

import java.security.PublicKey;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PrimitiveIterator.OfDouble;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.springframework.beans.factory.parsing.EmptyReaderEventListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.objenesis.instantiator.basic.NewInstanceInstantiator;

import com.test.test.Person.Person;


@SpringBootApplication 
public class TestApplication {
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
		
		List<String> nameStrings= List.of("Amit","Sumit","Kajal", "Shruti");
		List<Integer> numberList = List.of(1,2,4,4,4,45,45,67,66,78,88,100,101,111);
		String word="AmitMahto";
		String sentence="amit Kumar is a is good good boy Boy";
		
		
		   List<Person> people = new ArrayList<>();

	        people.add(new Person("Alice", 101, 75000.0, "CityA"));
	        people.add(new Person("Bob", 102, 95000.75, "CityB"));
	        people.add(new Person("Charlie", 103, 95000.75, "CityA"));
	        people.add(new Person("David", 104, 95000.75, "CityC"));
	        people.add(new Person("Eve", 105, 70000.0, "CityB"));
	        people.add(new Person("Frank", 106, 95000.75, "CityA")); 
	        people.add(new Person("Grace", 107, 910.0, "CityD"));
	        people.add(new Person("Amit", 109, 100000.0, "CityD"));
	        people.add(new Person("Heidi", 108, 72500.0, "CityC"));

	        
	       
	      

	        
	        
	        
	        
	        
	        
	        
	        
	        
			
	        


	       
	        
			
	}
	
		

}
