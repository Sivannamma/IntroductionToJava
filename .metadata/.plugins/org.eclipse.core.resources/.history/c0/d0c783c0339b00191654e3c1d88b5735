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

	public static void kDivOrder(LinkedList list, int k) {
		Node tempHead = list.head; // temp head
		Node tempNext = tempHead.next;

		int size = 0; // size to know how long is my list

		while (tempHead != null) {
			tempHead = tempHead.next;
			size++;
		}

		// returning my temphead to the start of the list
		String[] arr = new String[size];
		int i = 0;

		tempHead = list.head; // returning my head to be the start of the list

		// filling the array with the data of the linked list
		for (int times = 0; times < k; times++)// going over k times
		{
			while (tempHead != null) {
				arr[i] = tempHead.data;
				for (int j = 0; j < k && tempHead != null; j++) {
					tempHead = tempHead.next;
				}
				i++;
			}
			tempHead = tempNext;
			tempNext = tempNext.next;
		}

		i = 0; // for going over the array
		tempHead = list.head; // returning my head to be the start of the list

		while (tempHead != null) { // going over the list
			tempHead.data = arr[i];
			i++;
			tempHead = tempHead.next;
		}

	}
}