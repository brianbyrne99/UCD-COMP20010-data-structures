package projectCode20280;

/**
 * Realization of a circular FIFO queue as an adaptation of a
 * CircularlyLinkedList. This provides one additional method not part of the
 * general Queue interface. A call to rotate() is a more efficient simulation of
 * the combination enqueue(dequeue()). All operations are performed in constant
 * time.
 */

public class LinkedCircularQueue<E> implements Queue<E> {
	CircularlyLinkedList<E> list= new CircularlyLinkedList<E> ();
	
	public LinkedCircularQueue() {
	}

	public static void main(String[] args) {
		LinkedCircularQueue<Integer> que = new LinkedCircularQueue<Integer>();
		for(int i=0;i<5;i++)
			que.enqueue(i);
			
			System.out.println("Size : "+que.size());
			System.out.println("Top of queue : "+que.first());
			System.out.println("Dequeue : "+que.dequeue());
			System.out.println("Dequeue again : "+que.dequeue());
			System.out.println("Size : "+que.size());
			System.out.println("Top of queue : "+que.first());
			System.out.println("Size before rotation : "+que.size());
			que.rotate();
			System.out.println("Top of queue after rotation : "+que.first());
			System.out.println("Size after rotation : "+que.size());
			

	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public void enqueue(E e) {
		list.addLast(e);

	}

	@Override
	public E first() {
		return list.get(0);
	}

	@Override
	public E dequeue() {

		return list.removeFirst();
	}
	
	public void rotate() {
		list.rotate();
	}

}
