import java.util.LinkedList;
import java.util.Queue;

/**
 * A bounded buffer to be shared by concurrent threads.<br/>
 * The methods for inserting into and removing from the buffer run
 * (upon threads) in mutual exclusion.
 *
 * @author <a href="mailto:everton.cavalcante@ufrn.br">Everton Cavalcante</a>
 */
public class SharedBuffer {
	/** Buffer's capacity */
	private final int capacity;

	/** Buffer (implemented as a queue to comply with the problem's constraints) */
	private final Queue<Integer> buffer;

	/**
	 * Parameterized constructor
 	 * @param capacity Buffer's capacity
	 */
	public SharedBuffer(int capacity) {
		this.capacity = capacity;
		buffer = new LinkedList<Integer>();
	}


	/**
	 * Inserts an item at the end of the buffer.<br/>
	 * If the buffer achieved its maximum capacity, then the running producer thread
	 * is suspended, otherwise it is notified for resuming execution.
	 * @param item Item to be inserted
	 */
	public synchronized void insert(int item) {
		while (buffer.size() == capacity) {
			System.out.print("Buffer is full. ");
			System.out.println(Thread.currentThread().getName() + " suspended.\n");
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		buffer.add(item);
		System.out.println(Thread.currentThread().getName() + " inserted " + item);
		notify();
	}

	/**
	 * Removes the item at the front of the buffer.<br/>
	 * If the buffer is currently empty, then the running consumer thread is suspended,
	 * otherwise it is notified for resuming execution.
 	 */
	public synchronized void remove() {
		while (buffer.isEmpty()) {
			System.out.print("Buffer is empty. ");
			System.out.print(Thread.currentThread().getName() + " suspended.\n");
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		int item = buffer.remove();
		System.out.println(Thread.currentThread().getName() + " removed " + item);
		notify();
	}
}
