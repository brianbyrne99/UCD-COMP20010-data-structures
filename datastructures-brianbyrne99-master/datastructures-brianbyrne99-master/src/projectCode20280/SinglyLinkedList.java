package projectCode20280;

import java.util.Iterator;



public class SinglyLinkedList<E> implements List<E> {
	
 public SinglyLinkedList<E>.Node<E> head;
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
	public void add(int i, E e) {    //adds element e to the array index i
        if(e==null){                   
            return;
        }
        if(i>size-1)
        	return;
        
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
		
		if(i==0)                //base case
		{
			ret=head;
			head=curr.next;
			return ret.getElement();
		}
		else {
		for(int j=0;j<i-1;j++)          //removes the ith element
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
	
	private class ListIterator implements Iterator<E> {  //iterates through the list from first to last
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
	public E removeFirst() {     //2nd element becomes the new head
		Node<E> top=head;
		head=top.next;
		return top.getElement();
	}

	@Override
	public E removeLast() {         //2nd last element becomes the last
		if(head==null)
			return null;
			
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
  public void addLast(E e) {               //adds the element to the end of the list
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
	
 
	public static void main(String[] args) {
		String[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");

		SinglyLinkedList<String> sll = new SinglyLinkedList<String>();
		for (String s : alphabet) {
			sll.addFirst(s);
			sll.addLast(s);
		}
		System.out.println(sll.toString());

		sll.removeFirst();
		System.out.println(sll.toString());
		
		sll.removeLast();
		System.out.println(sll.toString());

		sll.remove(2);
		System.out.println(sll.toString());
		
		for (String s : sll) {
			System.out.print(s + ", ");
		}
		
	}


}
