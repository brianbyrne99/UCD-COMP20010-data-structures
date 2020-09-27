package projectCode20280;

import java.util.Iterator;



public class DoublyLinkedList<E> implements List<E> {
	private Node<E> header;
	private Node<E> trailer;  //trailer is a pointer to the previous section
	private int size=0;
	
	public DoublyLinkedList() {
		header = new Node<>(null, null, null); 
		trailer = new Node<>(null, header, null);  
		header.setNext(trailer);
	}

	private class Node<E> {
		private E element;
		private Node<E> prev;
		private Node<E> next;
		
		public Node(E e, Node<E> p, Node<E> n)
		{
			element=e;
			prev=p;
			next=n;
		}

		public void setElement(E element) {
			this.element = element;
		}

		public void setPrev(Node<E> prev) {
			this.prev = prev;
		}

		public void setNext(Node<E> next) {
			this.next = next;
		}

		public E getElement() {
			return element;
		}

		public Node<E> getPrev() {
			return prev;
		}

		public Node<E> getNext() {
			return next;
		}
	 
	}
	
	private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
		Node<E> newest= new Node<>(e, predecessor,successor);
		predecessor.setNext(newest);
		successor.setPrev(newest);   //places a node between two existing nodes
		size++;
		
	}
	
	@Override
	public int size() {
		Node<E> first = header.next;
		size=0;
		while(first.next!=null)
		{
			size++;
			first=first.next;
		}
		return size;
	}

	@Override
	public boolean isEmpty() {
		if(size >0)
			return false;
		else
			return true;
		
	}

	@Override
	public E get(int i) {
	 Node<E> index=header;
	 for(int j=0;j<=i;j++)
		 index=index.next;
	 
	 return index.getElement();
	}

	@Override
	public void add(int i, E e) {
		Node<E> index=header;
		 for(int j=0;j<=i;j++)
			 index=index.next;
		 
		 addBetween(e,index.prev,index);
		
	}

	@Override
	public E remove(int i) {
		 Node<E> index=header;
		 for(int j=0;j<=i;j++)
			 index=index.next;
		 
		 Node<E>ret=index;
		 index.prev.next=index.next;
		 index.next.prev=index.prev;
		
		 return ret.getElement();
	}

	@Override
	public Iterator<E> iterator() {  //iterator is slightly different to singly LL
		return new ListIterator();
		}
		
		private class ListIterator implements Iterator<E> {
			Node<E> curr;
			public ListIterator() {
				curr = header.next;
			}
			public boolean hasNext() {
				return curr.next != null;
			}
			
			@Override
			public E next() {
				E ret = (E) curr.getElement();
				curr = curr.getNext();
				return ret;
			}
	}



	@Override
	public E removeFirst() {
		Node<E> first=header;
		header=header.next;
		header.prev=null;
		
		size--;
		
			return first.getElement();
	}

	@Override
	public E removeLast() {
		Node<E> last=trailer;
		trailer=trailer.prev;
		trailer.next=null;
		return last.prev.getElement();
	}
	

	@Override
	public void addFirst(E e) {
		addBetween(e, header, header.getNext());  
		
	}

	@Override
	public void addLast(E e) {
		addBetween(e, trailer.getPrev(), trailer);
		
	}
	
	public E first() {
		if(header==null)
			return null;
		
		return header.next.getElement();
	}
	
	public E last()
	{
		if(header==null)
			return null;
			
		
		return trailer.prev.getElement();
	}
	
	@Override
	public String toString() //This function acts a "toString" for objects.
	{
		  Node<E> node = header.next;
		  String s1= "["; 
		          while(node.next!=null) {
		        	  s1+=node.getElement();
		        	  node=node.next;
		        	  if(node.next!=null)
		        		  s1+=", ";
		          }
		          s1+="]";
		          
	
		          return s1;
	}
	
	public static void main(String[] args) {
		   DoublyLinkedList<Integer> ll = new DoublyLinkedList<Integer>();
          
		   System.out.println(ll.size);
		   ll.addFirst(0);
           ll.addFirst(1);
           ll.addFirst(2);
           ll.addLast(-1);
           System.out.println(ll.size);
           System.out.println(ll);
           
           
          ll.removeFirst();
           System.out.println(ll);

           ll.removeLast();
           System.out.println(ll);
           
           for(Integer e: ll) {
             System.out.println("value: " + e);
             }

	}
}
	
