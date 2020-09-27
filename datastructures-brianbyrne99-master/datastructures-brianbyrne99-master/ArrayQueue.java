package projectCode20280;

public class ArrayQueue<E> implements Queue<E> {
	public E[] data;
	public int front=0;
	public int size=0;
	public int len=100;
	
	
	public ArrayQueue() {
		data=(E[]) new Object[len];  //setting new queue in constructor
	}

	public static void main(String[] args) {
		//tests to display functionality
		ArrayQueue<Integer> que = new ArrayQueue<Integer>();
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
		return size;
	}

	@Override
	public boolean isEmpty() {
		return (size==0);
	}

	@Override
	public void enqueue(E e) {            //adds to the end of queue
        if(size==len) System.out.println("Queue is full");
        
		data[size]=e;
		size++;
		
	}

	@Override
	public E first() {          //returns first element in queue
		if(size<1) return null;
		return data[0];
	}

	@Override
	public E dequeue() {       //removes first element of the queue
        if(isEmpty()) return null;
		E ret= data[front];
		data[front]=null;
		size--;
		front=front+1;
		return ret;
	}

}
