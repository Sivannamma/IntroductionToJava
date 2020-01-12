
public class ContactsManager {
	Contact[] Contacts;
	final int capacity = 500;
	int lastIndex;// last index we have added to
	public ContactsManager () {
		Contacts=new Contact[capacity];
		lastIndex=-1;
	}
	public boolean AddContact(Contact c) {
		if(lastIndex==capacity-1)
		{
			System.out.println("Sorry, the list is full :(!");
			return false;
		}
		lastIndex++;
		Contacts[lastIndex]=new Contact(c);
		System.out.println(c+" has been added successfully!");
		return true;
	}
	public Contact Search(String name) {
		for(int i=0;i<=lastIndex;i++) {	
			String currName=Contacts[i].name;
			currName=currName.toLowerCase();
			if(currName.equals(name.toLowerCase())) {
				return Contacts[i];
			}
		}
		return null;
	}
	public int Find(String name) {
		for(int i=0;i<=lastIndex;i++) {	
			String currName=Contacts[i].name;
			currName=currName.toLowerCase();
			if(currName.equals(name.toLowerCase())) {
				return i;
			}
		}
		return -1;
	}
	public Contact Remove(String name) {
		int indx = Find(name);
		if(indx!=-1) {
			System.out.println("Removing "+Contacts[indx]+"...");
			Contact c=Contacts[indx];
			for(int i=indx;i<lastIndex;i++) {
				Contacts[i]=Contacts[i+1];
			}
			lastIndex--;
			return c;
		}
		System.out.println(name+" does not exist");
		return null;
	}
	public String toString() {
		if(lastIndex!=-1) {
		String st="The Contacts are:\n";
		for(int i=0;i<=lastIndex;i++) {
			st+=(i+1)+") " +Contacts[i]+"\n";
		}
		return st;
		}else {
			return "List is empty!";
		}
	}
}
