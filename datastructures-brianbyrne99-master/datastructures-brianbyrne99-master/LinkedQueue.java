package projectCode20280;



public class LinkedQueue<E> implements Queue<E> {
	//Linked list representation of a queue
	SinglyLinkedList<E> list= new SinglyLinkedList<E>();
	
	public LinkedQueue() {
	}
	public static void main(String[] args) {
		LinkedQueue<Integer> que= new LinkedQueue<Integer>();
		for(int i=0;i<5;i++)
			que.enqueue(i);
			
		    System.out.println(que);
			System.out.println("Size : "+que.size());
			System.out.println(que);
			System.out.println("Top of queue : "+que.first());
			System.out.println(que);
			System.out.println("Dequeue : "+que.dequeue());
			System.out.println(que);
			System.out.println("Dequeue again : "+que.dequeue());
			System.out.println(que);
			System.out.println("Size : "+que.size());
			
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
		return list.isEmpty() ;
	}

	@Override
	public void enqueue(E e) {  //adds to the end of the queue
		list.addLast(e);
		
	}

	@Override
	public E first() {         //returns first element
		return list.get(0);
	}

	@Override
	public E dequeue() {               
		return list.removeFirst();    //removes first element in queue
	}

}
