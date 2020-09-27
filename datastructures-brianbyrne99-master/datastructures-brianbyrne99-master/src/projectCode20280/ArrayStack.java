package projectCode20280;

public class ArrayStack<E> implements Stack<E> {
	public static final int CAPACITY=1000;
	private E[] data;
	private int t=-1;
	
	public ArrayStack() {
		this(CAPACITY);
	}
	
	@SuppressWarnings({"unchecked"})
	ArrayStack(int capacity)
	{
		data=(E[]) new Object[capacity];
	}

	public static void main(String[] args) {
		ArrayStack<Integer> array= new ArrayStack<Integer>();
		 System.out.println("Is stack empty: "+array.isEmpty());
		
		for(int i=0;i<=10;i+=2)
			array.push(i);
	
	 System.out.println("Top: "+array.top());
	 System.out.println("Size: "+array.size());
	 System.out.println("Removed: "+array.pop());
	 System.out.println("Size: "+array.size());
	 System.out.println("Updated top: "+array.top());
	 System.out.println("Is stack empty: "+array.isEmpty());
	 array.push(1);
	 System.out.println("Integer "+1+" added to stack");
	 System.out.println("Updated top of stack: "+array.top());
	 System.out.println("Size: "+array.size());

	}
	

	@Override
	public int size() {
		return t;
	}

	@Override
	public boolean isEmpty() {
		return (t<0);
	}

	@Override
	public void push(E e) {
		if(t>= CAPACITY-1) {
			throw new IllegalArgumentException("Stack is full");
		}
		else
			data[++t]=e;
	}

	@Override
	public E top() {
		if(t<0)
			throw new IllegalArgumentException("Stack is empty");
		else {
			E ret=data[t];
			return ret;
		}
	}

	@Override
	public E pop() {
		if(t<0) {
			throw new IllegalArgumentException("Insufficient elements");
	     }
		else {
			E ret=data[t];
			t--;
			return ret;
			
		}
	}
}
