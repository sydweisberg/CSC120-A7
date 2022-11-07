import java.util.ArrayList; // Imports the relevant ArrayList methods

/**
 * Represents a House that is a type of Building
 */
public class House extends Building {

  private ArrayList<String> residents;
  private boolean hasDiningRoom;
  private boolean elevator;

  /**
  * Creates a House that has a name, address, floor number, and possibly a dining room
  */
  public House(String n, String a, int f, boolean dr, boolean e) {

    super(n, a, f); // Calls the super constructor
    this.hasDiningRoom = dr;
    this.residents = new ArrayList<>();
    this.elevator = e;
  }

  /**
  * Takes a name of a resident and adds them to the residents array of the House object which represents a resident moving into a House
  * @param name A string representing a resident's name
  */
  public void moveIn(String name) {
    residents.add(name);
    System.out.println(name + " has moved in!");
  }

  /**
  * Takes an array of names and adds them to the residents array of the House object which represents residents moving into a House
  * @param names An array representing a series of residents names
  */
  public void moveIn(String[] names) {
    for(int i = 0; i < names.length; i++) {
      residents.add(names[i]);
      System.out.println(names[i] + " has moved in!");
    }
  }

  /**
  * Takes a name of a resident and removes them from the residents array of the House object which represents a resident leaving a House
  * @param name A string representing a resident's name
  */
  public String moveOut(String name) {
    if(residents.contains(name) == true) {
      residents.remove(residents.indexOf(name));
    }
    System.out.println(name + " has moved out.");
    return(name);
  }

  /**
  * Takes an array of names of residents and removes them from the residents array of the House object which represents residents leaving a House
  * @param names An array representing a series of residents names
  */
  public void moveOut(String[] names) {
    for(int i = 0; i < names.length; i++) {
      if(residents.contains(name) == true) {
        residents.remove(names[i]);
        System.out.println(names[i] + " has moved out!");
      }
    }
  }
  
  /**
  * Checks to see if a resident is in the residents array which represents a person living in a House
  * @param person A string representing a person's name
  * @return       A boolean that represents whether or not a person lives in a House
  */
  public boolean isResident(String person) {
    if(residents.contains(person) == true) {
      System.out.println(person + " is in the house.");
      return true;
    }
    else {
      System.out.println(person + " is not in the house.");
      return false;
    }
  }

  /**
  * Checks to see if two resident is in the residents array which represents a person living in a House
  * @param firstPerson  A string representing a person's name
  * @param secondPerson A string representing a person's name
  * @return       A boolean that represents whether or not two people live in a House
  */
  public boolean isResident(String firstPerson, String secondPerson) {
    if(residents.contains(firstPerson) == true && residents.contains(secondPerson) == true) {
      System.out.println(firstPerson + " and " + secondPerson + " are in the house.");
      return true;
    }
    else if(residents.contains(firstPerson) == true && residents.contains(secondPerson) != true) {
      System.out.println(firstPerson + " lives in the house but " + secondPerson + " does not.");
      return false;
    }
    else if(residents.contains(firstPerson) != true && residents.contains(secondPerson) == true) {
      System.out.println(secondPerson + " lives in the house but " + firstPerson + " does not.");
      return false;
    }
    else {
      System.out.println(firstPerson + " and " + secondPerson + " do not live in the house.");
      return false;
    }
  }

  /**
  * Checks to see if a House has a dining room
  * @return       A boolean that represents whether or not a house has a dining room
  */
  public boolean hasDiningRoom() {
    String name = this.getName();
    if(this.hasDiningRoom == true) {
      System.out.println(name + " has a dining room!");
      return true;
    }
    else {
      System.out.println(name + " has no dining room!");
      return false;
    }
  }

  /**
  * Determines how many residents are in the residents array which represents the amount of people living in a House
  * @return       A integer that represents the amount of people living in a House
  */
  public int nResidents() {
    System.out.println("There are " + residents.size() + "in the house!");
    return(residents.size());
  }

  /**
  * Goes to a specific floor in a Building
  * @param floorNum An integer representing the floor a person wants to go to
  */
  public void goToFloor(int floorNum) {
    if(this.elevator == true) {
      this.goToFloor(floorNum);
    }
    else {
      System.out.println(this.name + " does not have an elevator.");
    }
  }

  /*
   * Prints out a list of commands that are applicable to the House class
   */
  public void showOptions() {
    if(this.elevator == true) {
      System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown() \n + goToFloor(n) \n + moveIn(n) \n + moveOut(n) \n + isResident(n) \n + nResidents() \n + hasDiningHall()");
    }
    else {
      System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n) \n + moveIn(n) \n + moveOut(n) \n + isResident(n) \n + nResidents() \n + hasDiningHall()");
    }
  }

  /**
  * Creates a House
  * @param args[] An empty array of Strings
  */
  public static void main(String[] args) {
    new House("Albright", "123 Main", 4, true, false);
    /*House Albright = new House("Albright", "123 Main", 4, true);
    Albright.moveIn("Sydney");
    Albright.isResident("Sydney");
    Albright.nResidents();
    Albright.moveOut("Sydney");
    Albright.hasDiningRoom();
    Albright.nResidents();*/
  }

}