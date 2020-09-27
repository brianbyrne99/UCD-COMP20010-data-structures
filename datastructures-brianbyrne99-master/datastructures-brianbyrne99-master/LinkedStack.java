package projectCode20280;

public class LinkedStack<E> implements Stack<E> {
 private SinglyLinkedList<E> list= new SinglyLinkedList<E>();
 
 public LinkedStack() {
 }
 //stack implemented by a linked list
	public static void main(String[] args) {
		LinkedStack<Integer> ls= new LinkedStack<Integer>();
		System.out.println("Is the stack empty :"+ls.isEmpty());
			for(int i=0;i<5;i++)
				ls.push(i);
		
		System.out.println(ls);
		System.out.println("Is the stack empty :"+ls.isEmpty());
		System.out.println("Size: "+ls.size());
		System.out.println("Top :"+ls.top());
		System.out.println("Pop: "+ls.pop());
		System.out.println(ls);
		System.out.println("Top :"+ls.top());
		System.out.println("New size :"+ls.size());
		System.out.println("Add to top ");
		ls.push(9);
		System.out.println(ls);
		System.out.println("Size: "+ls.size());
		System.out.println("Top :"+ls.top());
		

	}
	
	public String toString() //This function acts a "toString" for objects.
	{
		String str="[";
		for(int i=0;i<list.size();i++) {
			str+=list.get(i);
			if(i<list.size()-1)
				str+=", ";
		}
		
		return str+"]";
			
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
	public void push(E e) {      //adds to the top of the stack
		list.addFirst(e);
	}

	@Override
	public E top() {  //returns top element
		return list.first();
		
	}

	@Override
	public E pop() {     //removes top element
		return list.removeFirst();
	}

}
