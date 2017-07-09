public interface ListInterface
{
  public boolean isEmpty();
  public int size();
  public void add(Object item);
  public void remove(int index); 
  public Object get(int index); 
  public void removeAll();
  public void addSorted(Comparable item);
  public Object findByName(Comparable item);
  public void removeByName(Comparable item);
  public void saveToFile();
  public ListReferenceBased loadFromFile();
}