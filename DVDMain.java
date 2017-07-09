import java.io.*;
import java.util.Scanner;
public class DVDMain implements Serializable
{
  public static void main(String[] args)
  {
    String s;
    ListReferenceBased DVDs = new ListReferenceBased();
    if(DVDs.loadFromFile()!=null)
    {
      DVDs = DVDs.loadFromFile();
      System.out.println("Inventory successfully loaded from file.");
    }
    boolean continueloop = true;
    while(continueloop)
    {
      Scanner keyboard = new Scanner(System.in);
      System.out.println("Please choose an action:");
      System.out.println("L: List the inventory in alphabetical order by title");
      System.out.println("F: Find the inventory item associated with a title");
      System.out.println("R: Remove the inventory item associated with a title");
      System.out.println("I: Insert a new inventory item");
      System.out.println("A: Add someone to the wait list for a title");
      System.out.println("D: Delete first person in wait list for a title");
      System.out.println("W: Waiting list names display for a title");
      System.out.println("Q: Quit (Inventory is saved to file first)");
      
      s = keyboard.nextLine();
      if(s.equals("L"))
      {
        DVDs.displayList();
      }
      else if(s.equals("F"))
      {
        DVDs.displayList();
        System.out.println("Enter name of DVD you would like to find:");
        String d = keyboard.nextLine();
        System.out.println(DVDs.findByName(new DVD(d,0,0)));
      }
      else if(s.equals("R"))
      {
        DVDs.displayList();
        System.out.println("Enter name of DVD which you would like to remove:");
        String n = keyboard.nextLine();
        DVDs.removeByName(new DVD(n,0,0));
      }
      else if(s.equals("I"))
      {
        DVDs.displayList();
        System.out.println("Enter name of DVD you would like to add:");
        String d = keyboard.nextLine();
        System.out.println("Enter number of units in stock:");
        int h = keyboard.nextInt();
        DVDs.addSorted(new DVD(d,0,h));
        keyboard.nextLine();
      }
      else if(s.equals("A"))
      {
        DVDs.displayList();
        System.out.println("Enter title of DVD.");
        String t = keyboard.nextLine();
        DVD d = (DVD)DVDs.findByName(new DVD(t,0,0));
        if(d!=null)
        {
          System.out.println("Enter name of person to add:");
          String n = keyboard.nextLine();
          System.out.println("Enter phone number of person to add:");
          String p = keyboard.nextLine();
          d.addToWaitingList(n,p);
        }
      }
      else if(s.equals("D"))
      {
        DVDs.displayList();
        System.out.println("Enter title of DVD.");
        String t = keyboard.nextLine();
        DVD d = (DVD)DVDs.findByName(new DVD(t,0,0));
        if(d!=null)
        {
          d.removeFromWaitingList();
        }
      }
      else if(s.equals("W"))
      {
        DVDs.displayList();
        System.out.println("Enter title of DVD:");
        String t = keyboard.nextLine();
        DVD d = (DVD)DVDs.findByName(new DVD(t,0,0));
        d.displayWaitingList();
      }
      else if(s.equals("Q"))
      {
        DVDs.saveToFile();
        System.out.println("Inventory was saved to file.");
        continueloop = false;
      }
    }
    System.out.println("Goodbye");
  }
}