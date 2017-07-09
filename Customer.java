public class Customer
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
}