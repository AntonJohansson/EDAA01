package textproc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class GeneralWordCounter implements TextProcessor{
	Map<String, Integer> word_counter;
	Set<String> bad_words;
	int lower_bound;
	
	public GeneralWordCounter(Scanner scanner, int lower_bound){
		this.lower_bound = lower_bound;
		
		// Skiljer typ 100 ms mellan HashMap och TreeMap (hashmap snabbare)
		
		// HashMap tar inte hänsyn till ordningen
		//word_counter = new HashMap<String, Integer>();
		
		// TreeMap sorteras enligt compareTo(...) för
		// nycklarna.
		// Hur påverkas exekveringstiden.
		word_counter = new TreeMap<String, Integer>();
		bad_words = new HashSet<String>();
		
		while(scanner.hasNext()){
			String word = scanner.next();
			bad_words.add(word);
		}
	}
	
	@Override
	public void process(String w) {
		if(!bad_words.contains(w)){
			Integer count = word_counter.get(w);
			
			if(count == null){
				count = 0;
			}
			
			word_counter.put(w, count + 1);	
		}
	}

	@Override
	public void report() {
		// Gå igenom alla ord i mapen
		for(String word : word_counter.keySet()){
			Integer count = word_counter.get(word);
			if(count >= lower_bound){
				System.out.printf("%s: %d\n", word, count);	
			}
		}
		System.out.printf("\n");
	}

	/*
	 * Returnerar ett set av Map.Entry innehållande alla ord-nummer
	 * som skapades under körningen av wordcountern.
	 */
	public Set<Map.Entry<String, Integer>> getWords(){
		return word_counter.entrySet();
	}
}
