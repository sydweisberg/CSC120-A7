/**
 * Represents a Cafe that is a type of Building
 */
public class Cafe extends Building {

    private int nCoffeeOunces; 
    private int nSugarPackets; 
    private int nCreams; 
    private int nCups;

    /**
    * Creates a Cafe that has a name, address, floor number, and certain amounts of coffee, sugar, cream, and cups
    */
    public Cafe(String n, String a, int coffee, int sugar, int cream, int cups) {
        super(n, a); // Calls the super constructor
        this.nCoffeeOunces = coffee;
        this.nSugarPackets = sugar;
        this.nCreams = cream;
        this.nCups = cups;
        //System.out.println("You have built a cafe: ☕");
    }

    /**
    * Creates a Cafe that has a name, address, and floor number which gives a set amount of ingredients
    */
    public Cafe(String n, String a) {
        super(n, a);
        System.out.println("No ingredients provided, stocked everything.");
        this.nCoffeeOunces = 20;
        this.nSugarPackets = 20;
        this.nCreams = 20;
        this.nCups = 20;
    }

    /**
    * Sells a coffee by removing coffee, sugar, cream, and cups and restocks the items
    * @param size          The amount of coffee a customer wants
    * @param nSugarPackets The amount of sugar a customer wants
    * @param nCreams       The amount of cream a customer wants
    */
    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        if(this.nCoffeeOunces < size || this.nSugarPackets < nSugarPackets || this.nCreams < nCreams || this.nCups < 1) {
            restock(size, nSugarPackets, nCreams, 0); // Calls the restock method if there aren't enough items to successfully make a customer's coffee
        }
            System.out.println("Coffee Sold!");
            this.nCoffeeOunces -= size;
            this.nSugarPackets -= nSugarPackets;
            this.nCreams -= nCreams;
            this.nCups -= 1; // Removes stock from the Cafe's inventory
    }

    /**
    * Sells a coffee by removing coffee, sugar, cream, and cups and restocks the items
    */
    public void sellCoffee() {
        if(this.nCoffeeOunces < 8 || this.nSugarPackets < 1 || this.nCreams < 1 || this.nCups < 1) {
            restock(); // Calls the restock method if there aren't enough items to successfully make a customer's coffee
        }
            System.out.println("Coffee Sold!");
            this.nCoffeeOunces -= 8;
            this.nSugarPackets -= 1;
            this.nCreams -= 1;
            this.nCups -= 1; // Removes stock from the Cafe's inventory
    }
    

    /**
    * Restocks a coffee by adding an item to the cafe's inventory if something has run out
    * @param nCoffeeOunces The amount of coffee a customer wants
    * @param nSugarPackets The amount of sugar a customer wants
    * @param nCreams       The amount of cream a customer wants
    * @param nCups         The amount of cups avaliable
    */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        if(this.nCoffeeOunces < nCoffeeOunces) {
            this.nCoffeeOunces += 100;
            System.out.println("Restocked Coffee!");
        }
        if(this.nSugarPackets < nSugarPackets) {
            this.nSugarPackets += 30;
            System.out.println("Restocked Sugar!");
        }
        if(this.nCreams < nCreams) {
            this.nCreams += 30;
            System.out.println("Restocked Cream!");
        }
        if(this.nCups < 1) {
            this.nCups += 20;
            System.out.println("Restocked Cups!");
        }
    }

    /**
    * Restocks a coffee by adding an item to the cafe's inventory if something has run out
    */
    private void restock() {
        if(this.nCoffeeOunces < 8) {
            this.nCoffeeOunces += 100;
            System.out.println("Restocked Coffee!");
        }
        if(this.nSugarPackets < 1) {
            this.nSugarPackets += 30;
            System.out.println("Restocked Sugar!");
        }
        if(this.nCreams < 1) {
            this.nCreams += 30;
            System.out.println("Restocked Cream!");
        }
        if(this.nCups < 1) {
            this.nCups += 20;
            System.out.println("Restocked Cups!");
        }
    }

    /*
    * Prints out a list of commands that are applicable to the Cafe class
    */
    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + sellCoffee()");
    }
    
    /*
     * Prints out a message stating that the Building has no other floors to go to
     */
    public void goToFloor(int floorNum) {
        System.out.println("This building has no other floors accessible to customers.");
    }

    /**
    * Creates a Cafe
    * @param args[] An empty array of Strings
    */
    public static void main(String[] args) {
        new Cafe("Campus Cafe", "Central Campus", 20, 10, 10, 3);
        //Cafe CampusCafe = new Cafe("Campus Cafe", "Central Campus", 20, 10, 10, 3);
        /* CampusCafe.sellCoffee(9, 2, 3);
        CampusCafe.sellCoffee(12, 5, 0);
        CampusCafe.sellCoffee(16, 5, 7); 
        CampusCafe.sellCoffee(5, 1, 2);*/
    }
    
}
