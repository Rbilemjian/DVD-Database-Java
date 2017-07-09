public class DVD
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
  public String toString()
  {
    return title + ": " + have + " in stock, " + want + " in waiting list.";
  }
}