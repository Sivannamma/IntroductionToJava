class Node {
	String data;
	Node next;

	public Node(String data) {
		this.data = data;
		this.next = null;
	}

	public String toString() {
		return data;
	}
}

public class LinkedList {
	Node head;
	int size;

	public LinkedList() {
		head = null;
		size = 0;
	}

	public void add(String data) {
		if (head == null) {
			head = new Node(data);
		} else {
			Node n = head;
			while (n.next != null) {
				n = n.next;
			}
			n.next = new Node(data);
		}
		size++;
	}

	public String toString() {
		String ans = "[";
		if (head == null)
			ans = "[]";
		else {
			Node n = head;
			while (n.next != null) {
				ans = ans + n.data + ", ";
				n = n.next;
			}
			ans = ans + n.data + "]";
		}
		return ans;
	}

	public void sort() {
		Node tempH = this.head;
		String temp = "";
		int count = 0;

		while (tempH != null) { // counting how long is my list
			count++;
			tempH = tempH.next;
		}

		String[] array = new String[count]; // creating an array, size of the count of the linked list
		tempH = this.head; // returning the head to be the start

		for (int i = 0; i < array.length; i++) { // setting the values of the linked list into the array
			array[i] = tempH.data;
			tempH = tempH.next;
		}
		for (int i = array.length - 1; i > 0; i--) { // bubble sort to the array
			for (int j = 0; j < i; j++) {
				if (Integer.parseInt(array[j]) > Integer.parseInt(array[j + 1])) {
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}

		}
		tempH = this.head;
		int j = 0;
		while (tempH != null) {
			tempH.data = array[j++];
			tempH = tempH.next;
		}

	}

	public boolean swap(int i, int j) {
		int count = 0;
		Node tempH = this.head;

		while (tempH != null) {
			tempH = tempH.next;
			count++;
		}
		tempH = this.head;
		if (i < 0 || j < 0)
			return false;
		if(i>count || j>=count)
			return false;

		int k = 0;
		Node tempI = this.head;
		Node tempJ = this.head;

		while (tempH != null) {
			if (k == i)
				tempI = tempH;
			if (k == j)
				tempJ = tempH;
			k++;
			tempH = tempH.next;
		}
		String tempDataI = tempI.data;
		tempI.data = tempJ.data;
		tempJ.data = tempDataI;
		return true;

	}
	
	public int LinkedSize(LinkedList link, Node head) {
		if(head==null)
			return 0;

		head=head.next;
		return LinkedSize(link, head)+1;
		
	}
	
	public boolean ifSymmetrical () {
		Node tempH= this.head;
		Node tempS= this.head;
		int count =0;
		
		while(tempH!=null) {
			count++;
			tempH=tempH.next;
		}
		tempH=this.head;
		int counter=count;
		int counterSave=count;
		
		for(int i=0; i<=count/2; i++) {
			while(counter!=1) {
				tempH=tempH.next;
				counter--;
			}
			if(!tempS.data.equals(tempH.data))
				return false;
			
			tempS=tempS.next;
			tempH=this.head;
			counterSave--;
			counter=counterSave;		
		}
		return true;
	}
	
	
	
	
}
