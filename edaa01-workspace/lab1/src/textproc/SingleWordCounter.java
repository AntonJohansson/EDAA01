package textproc;

public class SingleWordCounter implements TextProcessor {
	private String word;
	private int n;

	public SingleWordCounter(String word) {
		this.word = word;
		n = 0;
	}

	public void process(String w) {
		//if (w == word) { Jämför referenser, dvs. om objekten är samma.
		if(w.equals(word)){
			n++;
		}
	}

	public void report() {
		System.out.println(word + ": " + n + "\n");
	}

}
