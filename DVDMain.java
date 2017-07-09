public class DVDMain
{
  public static void main(String[] args)
  {
    Customer c = new Customer("John","8184884348");
    DVD s = new DVD("Die Hard",1,1);
    s.waitingList.add(0,c);
    ListReferenceBased DVDs = new ListReferenceBased();
    DVDs.add(0,s);
    System.out.println(s);
  }
}