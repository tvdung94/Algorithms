import java.util.NoSuchElementException;
import java.util.Iterator;
	public class Deque<Item> implements Iterable<Item> {
		   private class Node {
			   Item item;
			   Node next;
			   Node previous;
		   }
		   private Node first;
		   private Node last;
		   private int N;
		   public Deque() {
			   // construct an empty deque
			   first = null;
			   last = null;
			   N = 0;
		   }
		   public boolean isEmpty() {
			   return N==0;
			   // is the deque empty?
		   }
		   public int size() {
			   // return the number of items on the deque
			   return N;
		   }
		   public void addFirst(Item item) {
			   if (item == null) throw new NullPointerException();
			   // add the item to the front
			   Node old_first = first;
			   first = new Node();
			   first.item = item;
			   first.previous = null;
			   first.next = old_first;
			   if (old_first != null) old_first.previous = first;
			   N++;
			   if (N==1) last = first;
			   
		   }
		   public void addLast(Item item) {
			   // add the item to the end
			   if (item == null) throw new NullPointerException();
			   if (N==0)
				   addFirst(item);
			   else {
				   Node new_node = new Node();
				   new_node.item = item;
				   new_node.next = null;
				   new_node.previous = last;
				   last.next = new_node;
				   last = new_node;
				   N++;
			   }
			   
		   }
		   public Item removeFirst() {
			   // remove and return the item from the front
			   if (isEmpty()) throw new NoSuchElementException();
			   Node rmv_item = first;
			   first = first.next;
			   //rmv_item.previous = null;
			   rmv_item.next = null;
			   if (first != null) first.previous = null;
			   N--;
			   return rmv_item.item;
		   }
		   public Item removeLast() {
			   if (isEmpty()) throw new NoSuchElementException();
			   Node rmv_item = last;
			   last = last.previous;
			   rmv_item.previous = null;
			   if (last != null) last.next = null;
			   N--;
			   return rmv_item.item;
			   // remove and return the item from the end
		   }
		   public Iterator<Item> iterator() {
			   return new ListIterator();
			   // return an iterator over items in order from front to end
		   }
		   
		   private class ListIterator implements Iterator<Item> {
			   private Node current = first;
			   public boolean hasNext() {return current != null; }
			   public void remove() {
				   throw new UnsupportedOperationException();
			   }
			   public Item next() {
				   if (!hasNext()) throw new NoSuchElementException();
				   Item item = current.item;
				   current = current.next;
				   return item;
			   }
			  
		   }
		   
		   public static void main(String[] args) {
			   // unit testing
			   Deque<String> s = new Deque<String>();
		        while (!StdIn.isEmpty()) {
		            String item = StdIn.readString();
		            if (!item.equals("-")) s.addLast(item);
		            else if (!s.isEmpty()) {
		            	StdOut.print(s.removeLast() + " ");
		            	StdOut.println("(" + s.size() + " left on stack)");
		            }
		        }
		        StdOut.println("(" + s.size() + " left on stack)");
		   }
		}

	
