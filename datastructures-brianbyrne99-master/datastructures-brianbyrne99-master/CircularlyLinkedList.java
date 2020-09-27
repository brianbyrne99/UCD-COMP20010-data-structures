package projectCode20280;

import java.util.Iterator;
/*
 * Circularly linkedList class is very similar to the single linked list class
 * with the addition of a rotate method.
 */

public class CircularlyLinkedList<E> implements List<E> {
	
 private CircularlyLinkedList<E>.Node<E> head;
 public int size=0;
 
	private class Node<E> {
	 private E element;
	 private Node<E> next;
	 
	 public Node(E e, Node<E> n)
	 {
		 element = e;
		 next = n;
	 }
	 
	 
	 
	 public E getElement() {
			return element;
		}

   public Node<E> getNext() {
			return next;
		}

	public void setNext(Node<E> n) {
		this.next = n;
	}  //end of nested node class

}
	
	
	
	@Override
	public boolean isEmpty() {
		if(this.head == null) {
			return true;
		}
		else
		return false;
	}

	@Override
	public E get(int i) {
		   if(this.head!=null&&i>=0){
	            int count=0;
	            Node<E> p=this.head;
	            while(p!=null&&count<i){
	                p=p.next;
	                count++;
	            }

	            if(p!=null){
	                return p.element;
	            }
	        }
	        return null;
	}

	@Override
	public void add(int i, E e) {
     if(e==null){
         return;
     }
     
     if (this.head==null||i<=1){
         this.head = new Node<E>(e, this.head);
     }else {
        
         int count=0;
         Node<E> front=this.head;
         while (front.next!=null&&count<i-1){
             front=front.next;
             count++;
         }
    
         front.next=new Node<E>(e,front.next);
     }

  }

	@Override
	public E remove(int i) {
		Node<E> curr=head;
		Node<E> ret=new Node<E>(null,null);
		if(head==null)
		return null;
		
		if(i==0)
		{
			ret=head;
			head=curr.next;
			return ret.getElement();
		}
		else {
		for(int j=0;j<i-1;j++)
		{
			curr=curr.next;
			ret=curr.next;
		}	
			if(curr == null )
			{
				return null;
			}
		Node<E> next=curr.next.next;
		curr.next=next;
		return ret.getElement();
   }
	}

	
	@Override
	public Iterator<E> iterator() {
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<E> {
		Node<E> curr;
		public ListIterator() {
			curr = head;
		}
		public boolean hasNext() {
			return curr != null;
		}
		
		@Override
		public E next() {
			E ret = (E) curr.getElement();
			curr = curr.getNext();
			return ret;
		}		
	}

	@Override
	public int size() {
		   int length=0;
	        Node<E> p=head;
	        while (p!=null){
	            length++;
	            p=p.next;
	        }
	        return length;
	}	
	

	@Override
	public E removeFirst() {
		Node<E> top=head;
		head=top.next;
		return top.getElement();
	}

	@Override
	public E removeLast() {
		Node <E> last = this.head;
			while(last.next.next != null) {
				last=last.next;
			}
			Node<E> ret=last.next;
			last.next=null;

		return ret.getElement();
	}

	@Override
	public void addFirst(E e) {
		head= new Node<E>(e, head);
		size++; 
		
		
	}

	@Override
	public void addLast(E e) {
	if(head==null)
		head=new Node<E>(e,head);
	else {
	Node<E> newest=head;
	
	 while(newest.next != null) {
		newest=newest.next;
	 }
	 
	newest.next=new Node<E>(e,newest.next);		
	}
}
	
	public String toString() //This function acts a "toString" for objects.
	{
		  Node<E> node = head;
		  String s1= "["; 
		          while (node != null){
		  		  s1+=node.getElement();
		          node = node.next;
		          if(node != null)
		        	  s1+=", ";
		          }
	     s1+="]";
		          return s1;
	}
	
	//This method makes the 2nd element the head and the first the last
	public void rotate() {
		Node <E> last = head;
		Node<E> update=head;
		while(last.next != null) {
			last=last.next;
		}
		head=update.next;
		last.next=new Node<E>(update.getElement(),last.next);
	}
	
	
	public static void main(String[] args) {
		CircularlyLinkedList<Integer> ll = new CircularlyLinkedList<Integer>();
		for(int i = 10; i < 20; ++i) {
			ll.addLast(i);
	    }

		System.out.println(ll);
		ll.removeFirst();
		System.out.println(ll);

		ll.removeLast();

		ll.rotate();
		System.out.println(ll);

		ll.removeFirst();
		ll.rotate();
		System.out.println(ll);

		ll.removeLast();
		ll.rotate();
		System.out.println(ll);

		for (Integer e : ll) {
			System.out.println("value: " + e);
		}
	}
}