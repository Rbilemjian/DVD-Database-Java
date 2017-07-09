import java.io.*;
public class ListReferenceBased implements ListInterface, Serializable
{
  private Node head;
  int numItems;
  public ListReferenceBased()
  {
    numItems = 0;
    head = null;
  }
  public boolean isEmpty()
  {
    return numItems == 0;
  }
  public int size()
  {
    return numItems;
  }
  private Node find(int index)
  {
    Node curr = head;
    for(int skip = 0;skip<index;skip++)
    {
      curr = curr.next;
    }
    return curr;
  }
  public Object get(int index)
  {
    if(index>=0 && index<numItems)
    {
      Node curr = find(index);
      Object dataItem = curr.item;
      return dataItem;
    }
    return null;
  }
  public void add(Object c) //throws ListIndexOutOfBoundsException
  {
    Node newNode=new Node(c);
    Node current;
    if (isEmpty())
    {
      head=newNode; 
    }
    else
    { 
      current=head;
      while(current.next!=null) current=current.next;
      current.next=newNode;
    }
    numItems++;
   }
  public void remove(int index)
  {
    if(index >= 0 && index < numItems)
    {
      if(index == 0)
      {
        head = head.next;
      }
      else
      {
      Node prev = find(index-1);
      Node curr = prev.next;
      prev.next = curr.next;
      }
      numItems--;
    }
  }
  public void removeAll()
  {
    head = null;
    numItems = 0;
  }
  public void addSorted(Comparable item)
  {
    Node newNode = new Node(item);
    if(isEmpty())
    {
      head = newNode;
    }
    else if(item.compareTo(head.item)<0)
    {
      newNode.next = head;
      head = newNode;
    }
    else
    {
      Node curr = head.next;
      Node prev = head;
      while(curr != null)
      {
        if(item.compareTo(curr.item)<0)
          break;
        prev = curr;
        curr = prev.next;
      }
      newNode.next = prev.next;
      prev.next = newNode;
    }
    numItems++;
  }
  public Object findByName(Comparable item)
  {
    if(isEmpty())
    {
      System.out.println("List is empty.");
      return null;
    }
    Node curr = head;
    while(curr != null)
    {
      if(item.compareTo(curr.item) == 0)
        return curr.item;
      curr = curr.next;
    }
    System.out.println("That DVD is not in the inventory");
    return null;
  }
  public void removeByName(Comparable item)
  {
    if(isEmpty())
    {
      System.out.println("List is empty.");
      return;
    }
    if(item.compareTo(head.item) == 0)
    {
      head = head.next;
      numItems--;
      return;
    }
     Node curr = head.next;
     Node prev = head;
    while(curr != null)
    {
      if(item.compareTo(curr.item) == 0)
      {
        prev.next = curr.next;
        numItems--;
      }
      curr = curr.next;
      prev = prev.next;
    }
  }
  public void saveToFile()
  {
    try
    {
         FileOutputStream fileOut =
         new FileOutputStream("inventory.dat");
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(this);
         out.close();
         fileOut.close();
         System.out.printf("Serialized data is saved in inventory.ser");
    }
    catch(IOException i)
    {
      i.printStackTrace();
    }
  }
  public ListReferenceBased loadFromFile()
  {
    ListReferenceBased restoredInventory;
    try
    {
      FileInputStream fileIn = new FileInputStream("inventory.dat");
      ObjectInputStream in = new ObjectInputStream(fileIn);
      Object o = in.readObject();
      restoredInventory = (ListReferenceBased) o;
      return restoredInventory;
    }
    catch(Exception e)
    {
      System.out.println(e);
    }
    return null;
  }
  public void displayList()
  {
    if(isEmpty())
    {
      System.out.println("List is empty");
      return;
    }
    System.out.println("Current inventory:");
    for(int i = 0;i<numItems;i++)
    {
      System.out.println(this.get(i));
    }
  }
    
      
    
}
    
      
    
    