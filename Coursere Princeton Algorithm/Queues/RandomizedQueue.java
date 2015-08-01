import java.util.Iterator;
import java.util.NoSuchElementException;
public class RandomizedQueue<Item> implements Iterable<Item> {
   private Item[] a;
   private int N;
   public RandomizedQueue() {
	   a = (Item[]) new Object[2];
	   // construct an empty randomized queue
   }
   public boolean isEmpty() {
	   // is the queue empty?
	   return N==0;
   }
   private void resize(int capacity) {
       assert capacity >= N;
       Item[] temp = (Item[]) new Object[capacity];
       for (int i = 0; i < N; i++) {
           temp[i] = a[i];
       }
       a = temp;
   }
   public int size() {
	   // return the number of items on the queue
	   return N;
   }
   public void enqueue(Item item) {
	   if (item == null) throw new NullPointerException();
	   // add the item
	   if (N == a.length) resize(2*a.length);    // double size of array if necessary
       a[N++] = item; 
   }
   public Item dequeue() {
	   // remove and return a random item
	   if (isEmpty()) throw new NoSuchElementException();
	   int pos = StdRandom.uniform(N);
	   Item swap = a[pos];
	   a[pos] = a[N - 1];
	   a[N - 1] = swap;
	   Item item = a[N-1];
	   a[N-1] = null;
	   N--;
	   if (N > 0 && N == a.length/4) resize(a.length/2);
	   return item;
   }
   public Item sample() {
	   // return (but do not remove) a random item
	   if (isEmpty()) throw new NoSuchElementException();
	   int pos = StdRandom.uniform(N);
	   return a[pos];
   }
   public Iterator<Item> iterator() {
	   return new ReverseArrayIterator();
	   // return an independent iterator over items in random order
   }
   
  private class ReverseArrayIterator implements Iterator<Item> {
	  private int i;
	  private Item[] b= (Item[]) new Object[N];
	  public ReverseArrayIterator() {
          i = N-1;
          for (int j = 0; j < N; j++)
        	  b[j] = a[j];
          StdRandom.shuffle(b);
      }
	  public boolean hasNext() {
		  
		  return i >= 0;
	  }
	  public void remove() {
		  throw new UnsupportedOperationException();
	  }
	  public Item next() {
		  if (!hasNext()) throw new NoSuchElementException();
          return b[i--];
		  
	  }
  }
   public static void main(String[] args) {
	   // unit testing
	   RandomizedQueue<String> q = new RandomizedQueue<String>();
	   q.enqueue("I");
	   q.enqueue("am");
	   q.enqueue("dung");
	   System.out.println(q.size());
	   System.out.println(q.dequeue());
	   System.out.println(q.size());
	   System.out.println(q.dequeue());
	   System.out.println(q.size());
	   System.out.println(q.dequeue());
	   System.out.println(q.size());
   }
}

