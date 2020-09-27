package projectCode20280;

public class LinkedStack<E> implements Stack<E> {
 private SinglyLinkedList<E> list= new SinglyLinkedList<E>();
 
 public LinkedStack() {
 }
	public static void main(String[] args) {
		LinkedStack<Integer> ls= new LinkedStack<Integer>();
		System.out.println("Is the stack empty :"+ls.isEmpty());
			for(int i=0;i<5;i++)
				ls.push(i);
		
		System.out.println("Is the stack empty :"+ls.isEmpty());
		System.out.println("Size: "+ls.size());
		System.out.println("Top :"+ls.top());
		System.out.println("Pop: "+ls.pop());
		System.out.println("Top :"+ls.top());
		System.out.println("New size :"+ls.size());
		System.out.println("Add to top ");
		ls.push(9);
		System.out.println("Size: "+ls.size());
		System.out.println("Top :"+ls.top());
		

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
	public void push(E e) {
		list.addLast(e);
	}

	@Override
	public E top() {
		return list.get(list.size()-1);
		
	}

	@Override
	public E pop() {
		return list.removeLast();
	}

}
