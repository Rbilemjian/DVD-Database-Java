public interface ListInterface
{
  public boolean isEmpty();
  public int size();
  public void add(int index, Object item); //throws ListOutOfBoundsException;
  public void remove(int index); //throws ListOutOfBoundsException;
  public Object get(int index); //throws ListOutOfBoundsException;
  public void removeAll();
}