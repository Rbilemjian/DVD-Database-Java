import java.io.*;
public class Customer implements Comparable, Serializable

{
  String name;
  String phoneNumber;
  Customer(String n, String p)
  {
    name = n;
    phoneNumber = p;
  }
  public String toString()
  {
    return name + ", " + phoneNumber;
  }
  public int compareTo(Object a)
  {
    return name.compareTo(((Customer)a).name);
  }
}