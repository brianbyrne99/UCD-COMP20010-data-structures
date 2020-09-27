package projectCode20280;

public class LinkedQueue<E> implements Queue<E> {
	SinglyLinkedList<E> list= new SinglyLinkedList<E>();
	
	public LinkedQueue() {
	}
	public static void main(String[] args) {
		LinkedQueue<Integer> que= new LinkedQueue<Integer>();
		for(int i=0;i<5;i++)
			que.enqueue(i);
			
			System.out.println("Size : "+que.size());
			System.out.println("Top of queue : "+que.first());
			System.out.println("Dequeue : "+que.dequeue());
			System.out.println("Dequeue again : "+que.dequeue());
			System.out.println("Size : "+que.size());
			
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty() ;
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

}
