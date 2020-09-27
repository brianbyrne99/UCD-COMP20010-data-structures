package projectCode20280;

public class LinkedDeque<E> implements Deque<E> {
	private DoublyLinkedList<E> list = new DoublyLinkedList<E>();

	public LinkedDeque() {
	}
	
	public static void main(String[] args) {
        LinkedDeque<Integer> queue = new LinkedDeque<Integer>();
        queue.addFirst(3);
        queue.addFirst(2);
        queue.addFirst(1);
        queue.addLast(4);
        queue.addLast(5);
        
        System.out.println("Is the deque empty? "+queue.isEmpty());
        System.out.println("First in the queue : "+queue.first());
        System.out.println("Last in the queue : "+queue.last());
        System.out.println("Size of the queue : "+queue.size());
        System.out.println("Remove first element : "+queue.removeFirst());
        System.out.println("Remove last element : "+queue.removeLast());
        System.out.println("Updated size of the queue : "+queue.size());
        System.out.println("First element : "+queue.first());
        System.out.println("Last element : "+queue.last());
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
	public E first() {
		return list.get(0);
	}

	@Override
	public E last() {
		return list.get(list.size()-1);
	}

	@Override
	public void addFirst(E e) { //the queue can be entered and exited from either end
       list.addFirst(e);
	}

	@Override
	public void addLast(E e) {
		list.addLast(e);
		
	}

	@Override
	public E removeFirst() {
		return list.remove(0);
	}

	@Override
	public E removeLast() {
		return list.remove(size()-1);
	}

}
