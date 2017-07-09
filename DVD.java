import java.io.*;
public class DVD implements Comparable, Serializable
{
  String title;
  int want;
  int have;
  ListReferenceBased waitingList = new ListReferenceBased();
  DVD(String t, int w, int h)
  {
    title = t;
    want = w;
    have = h;
  }
  DVD(String t)
  {
    title = t;
    want = have = 0;
  }
  
  public void addToWaitingList(String name, String phone)
  {
    waitingList.add(new Customer(name,phone));
    want++;
  }
  public void removeFromWaitingList()
  {
    if(want>0)
    {
      waitingList.remove(0);
      want--;
    }
    else
      System.out.println("Waiting list is empty");
  }
  public void displayWaitingList()
  {
    if(want == 0)
    {
      System.out.println("Waiting list is empty");
      return;
    }
    System.out.println("Waiting List for " + title + ":");
    for(int i = 0;i<want;i++)
    {
      System.out.println(waitingList.get(i));
    }
  }
  public String toString()
  {
   if(have<want) return title + ": " + have + " in stock, " + want + " in waiting list. Need to order"+(want-have);
   else return title + ": " + have + " in stock, " + want + " in waiting list. Need to order none";
  }
  public int compareTo(Object a)
  {
    return title.compareTo(((DVD)a).title);
  }
}
