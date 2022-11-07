import java.util.Hashtable;
import java.util.Set; // Imports the relevant Hashtable and Set methods

/**
 * Represents a Library that is a type of Building
 */
public class Library extends Building {

    private Hashtable<String, Boolean> collection;
    
    /**
    * Creates a Library that has a name, address, and floor number
    */
    public Library(String n, String a, int f) {
      super(n, a, f); // Calls the super constructor
      collection = new Hashtable<String, Boolean>();
      //System.out.println("You have built a library: 📖");
    }
    
    /**
    * Adds a book to the collection hashtable
    * @param title The name of a novel's title
    */
    public void addTitle(String title) {
      this.collection.put(title, true);
    }

    /**
    * Removes a book from the collection hashtable
    * @param title The name of a novel's title
    */
    public String removeTitle(String title) {
      this.collection.remove(title, true);
      return(title + " has been removed!");
    }

    /**
    * Alters the hashtable's value at <key> to return false which represents a book being checked out of a Library's collection
    * @param title The name of a novel's title
    */
    public void checkOut(String title) {
      if(isAvailable(title) == true) {
        this.collection.replace(title, false);
        System.out.println(title + " has been checked out!");
      }
      else {
        System.out.println(title + " is currently checked out.");
      }
    }

    /**
    * Alters the hashtable's value at <key> to return false which represents a series of book being checked out of a Library's collection
    * @param titles An array of novel's titles
    */
    public void checkOut(String[] titles) {
      for(int i = 0; i < titles.length; i++) {
        if(isAvailable(titles[i]) == true) {
          this.collection.replace(titles[i], false);
          System.out.println(titles[i] + " has been checked out!");
        }
        else {
          System.out.println(titles[i] + " is currently checked out.");
        }
      }
    }

    /**
    * Alters the hashtable's value at <key> to return true which represents a book being checked into a Library's collection
    * @param title The name of a novel's title
    */
    public void returnBook(String title) {
      if(isAvailable(title) == false) {
        this.collection.replace(title, true);
        System.out.println(title + " has been returned!");
      }
    }

    /**
    * Alters the hashtable's value at <key> to return true which represents a series of book being checked into a Library's collection
    * @param titles An array of different novel's titles
    */
    public void returnBook(String[] titles) {
      for(int i = 0; i < titles.length; i++) {
        if(isAvailable(titles[i]) == false) {
          this.collection.replace(titles[i], true);
          System.out.println(titles[i] + " has been returned!");
        }
      }
    }

    /**
    * Checks to see if a book is in a specified Library's collection
    * @param title The name of a novel's title
    * @return      A boolean of whether or not a book is in a collection
    */
    public boolean containsTitle(String title) {
      return(this.collection.containsKey(title));
    }

    /**
    * Checks to see if a book is avaliable in a specified Library's collection
    * @param title The name of a novel's title
    * @return      A boolean of whether or not a book is avaliable
    */
    public boolean isAvailable(String title) {
      return(this.collection.get(title));
    }

    /**
    * Prints out a library's book collection and states whether or not the book is avaliable
    */
    public void printCollection() {
      Set<String> list = collection.keySet();
      for(String key: list) {
        if(this.collection.get(key)){
          System.out.println(key + " is avaliable!");
        }
        else {
          System.out.println(key + " is not avaliable!");
        }
      }
    }

     /*
    * Prints out a list of commands that are applicable to the Library class
    */
    public void showOptions() {
      System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown() \n + addTitle(n) \n + removeTitle(n) \n + checkOut(n) \n + returnBook(n) \n + containsTitle(n) \n + isAvaliable(n) /n + printCollection(n)");
    }

    /**
    * Goes to a specific floor in a Building
    * @param floorNum An integer representing the floor a person wants to go to
    */
    public void goToFloor(int floorNum) {
      if (this.activeFloor == -1) {
          throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
      }
      if (floorNum < 1 || floorNum > this.nFloors) {
          throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
      }
      System.out.println("You are now on floor #" + floorNum + " of " + this.name);
      this.activeFloor = floorNum;
    }

    /**
    * Creates a Library
    * @param args[] An empty array of Strings
    */
    public static void main(String[] args) {
      /*Hashtable<String, Boolean> NielsonCollection = new Hashtable<>();
      NielsonCollection.addTitle("One Fish Two Fish Red Fish Blue Fish by Dr. Seuss");
      NielsonCollection.addTitle("Twilight by Stephenie Meyer");
      NielsonCollection.addTitle("Warriors by Erin Hunter");
      NielsonCollection.addTitle("The Little Prince by Antoine de Saint-Exupéry");
      NielsonCollection.addTitle("Percy Jackson by Rick Riordan");
      NielsonCollection.addTitle("Anna Karenina by Leo Tolstoy");*/
      //new Library("Nielson", "Central Campus", 4, true);
      Library Nielson = new Library("Nielson", "Central Campus", 4);
      Nielson.enter();
      //Nielson.goToFloor(3);

    }
  
  }