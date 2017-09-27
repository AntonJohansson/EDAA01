package queue_delegate;
import java.util.*;

public class FifoQueue<E> extends AbstractQueue<E> implements Queue<E> {
	private Queue<E> list;

	/*
	 * Man skulle kunna använda en arraylist istället för en linked list,
	 * genom ex.: 
	 * 
	 * -	ArrayList<E>.add(...) för offer(),
	 * -	ArrayList<E>.get(0) för peek(),
	 * -	ArrayList<E>.iterator() för iterator(),
	 * - 	ArrayList<E>.get() och ArrayList<E>.remove(0) för poll().
	 * 
	 * Eftersom vi implementerar en FifoKö så behöver vi inte tillgång till
	 * alla element i listan, vilket arraylist ger. Därutöver blir det väldigt kostsamt
	 * prestandamässigt om elementen är många, då en arraylist måste kopiera stora
	 * delar av minnet.
	 * 
	 * Förderlarna med en linked list är att insättningstiden är konstant och man
	 * inte vet storleken av listan.
	 * 
	 */
	
	/*
	 * Fördelar med att implementera en fifoKö genom att använda den färdiskrivna klassen
	 * är att vi inte behöver omimplementera en linkedlist, utan vi kan förlita oss på en
	 * implementering som redan är testad.
	 * 
	 * Den färdiga implementationen kanske ger lite mer än vad vi behöver, men detta spelar
	 * i det flesta fall ingen roll. Ännu en nackdel är att vi inte har kontroll över prestandan
	 * av javas linked list om vi skriver prestandakritisk kod.
	 * 
	 * Det kan även vara bra att implementera en egen klass för utbildningssyfte, även om ens egen
	 * implementation är sämra i prestanda.
	 * 
	 * Om man av någon anledning behöver mer kontroll över implementation än den som ges av java
	 * så är det lämpligt att implementera en egen.
	 */
	
	public FifoQueue() {
		super();
		list = new LinkedList<E>();
	}
	
	/**	
	 * Inserts the specified element into this queue, if possible
	 * post:	The specified element is added to the rear of this queue
	 * @param	e the element to insert
	 * @return	true if it was possible to add the element 
	 * 			to this queue, else false
	 */
	public boolean offer(E e) {
		return list.offer(e);
	}

	/**	
	 * Returns the number of elements in this queue
	 * @return the number of elements in this queue
	 */
	public int size() {		
		return list.size();
	}
	
	/**	
	 * Retrieves, but does not remove, the head of this queue, 
	 * returning null if this queue is empty
	 * @return 	the head element of this queue, or null 
	 * 			if this queue is empty
	 */
	public E peek() {
		return list.peek();
	}

	/**	
	 * Retrieves and removes the head of this queue, 
	 * or null if this queue is empty.
	 * post:	the head of the queue is removed if it was not empty
	 * @return 	the head of this queue, or null if the queue is empty 
	 */
	public E poll() {
		return list.poll();
	}

	/**	
	 * Returns an iterator over the elements in this queue
	 * @return an iterator over the elements in this queue
	 */	
	public Iterator<E> iterator() {
		return list.iterator();
	}

}
