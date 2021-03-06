import java.util.*;
import java.io.*;

public class Character {
    protected int health;
    protected int maxHealth;
    protected int intelligence;
    protected int dexterity;
    protected int strength;
    protected int experience;
    protected String name;
    protected double x;
    protected double y;

    private Random r = new Random();

    protected void init(String n, int h, int m, int i, int d, int s, int e, double x, double y) {
	name = n;
	health = h;
	maxHealth = m;
	intelligence = i + 8;
	dexterity = d + 8;
	strength = s + 8;
	experience = e;
	this.x = x;
	this.y = y;
    }

    public Character(String name, int limit) {
	Random r = new Random();
	int str = r.nextInt(limit + 1);
	int dex = r.nextInt(limit + 1 -str);
	int inte = limit-str-dex;
	init(name,50,100,str,dex,inte,0,0.0,0.0);
    }
    
    public Character() {        //For player character
	boolean valid, sure;
	int str = 0, dex = 0, inte = 0;
	String yn;

	Scanner scan = new Scanner(System.in);
	sure = false;

	while (!sure) {
	    System.out.print("What is your name? ");
	    name = scan.next();
	    System.out.println("Now time to enter your stats. Remember that you get 8 points in every stat and can put 8 extra points wherever.");
	    System.out.println();
		
	    valid = false;
	    while (!valid) {
		System.out.print("Enter desired extra strength points: ");
		str = scan.nextInt();

		System.out.print("Enter desired extra dexterity points: ");
		dex = scan.nextInt();

		System.out.print("Enter desired extra intelligence points: ");
		inte  = scan.nextInt();
		
		if (inte + dex + str == 8)
		    valid = true;
		else {
		    System.out.println("You did not enter 8 extra points, please try again.");
		    System.out.println();
		}
	    }

	    System.out.println();
	    System.out.println("Name: " + name + " Str: " + str + " Dex: " + dex + " Int: " + inte);
	    valid = false;
	    while (!valid) {
		System.out.print("Are these okay y/n: ");
		yn = scan.next();
		if (yn.equals("y")) {
		    valid = true;
		    sure = true;
		}
		else if (yn.equals("n")) {
		    valid = true;
		    System.out.println("Restarting character creation...");
		    System.out.println();
		}
		else
		    System.out.println("That is not a valid option. Please say <y> or <n>.");
	    }
	}
	    
	System.out.println("Your Character " + name + " has been created!");
	init(name,50,100,str,dex,inte,0,0.0,0.0);
    }

    public double distance(Character other) {
	return Math.sqrt(((other.x - x)*(other.x - x))+((other.y - y)*(other.y - y)));
    }

    public void battle(Character other) {
	if (this.dexterity >= other.dexterity) {
	    other.health = other.health - this.attack(other);
	    this.health = this.health - other.attack(this);
	    System.out.println(this.name + "'s hp: " + this.health);
	    System.out.println(other.name + "'s hp: " + other.health); }
	else {
	    this.health = this.health - other.attack(this);
	    other.health = other.health - this.attack(other);
	    System.out.println(other.name + "'s hp: " + other.health);
	    System.out.println(this.name + "'s hp: " + this.health); }
    }

    //fight called in battle
    public void fight(int weapon, double dist){

    }

    //flee called in battle
    public boolean flee(Character other){
	if ((r.nextInt(6)+1)*distance(other)>10){
	    return true;
	}
	return false;
    }

    public String talk(){
	return "Generic talk";
    }

    public String toString() {
	return name;
    }

    public void getInfo() {
	System.out.println("Name: " + name);
	System.out.println("Health: " + health);
	System.out.println("Max Health: " + maxHealth);
	System.out.println("Strength: " + strength);
	System.out.println("Dexterity: " + dexterity);
	System.out.println("Intelligence: " + intelligence);
	System.out.println("Experience: " + experience);
	System.out.println("Location: (" + x + "," + y + ")");
    }
    public int attack(Character other) {
	System.out.println(this.name + " attacked " + other.name);

	Random r = new Random();
	int rolls = ((1 + r.nextInt(6)) + (1 + r.nextInt(6)) + (1 + r.nextInt(6)));

	if (rolls >= 16) {
	    System.out.println(this.name + " missed terribly."); 
	    return 0;
	}
	else if (rolls > this.dexterity) {
	    System.out.println(this.name + " missed.");
	    return 0;
	}
	else if (rolls == 4) {
	    int damage = this.strength * 2;
	    System.out.println(this.name + " critically hit " + other.name + " for " + damage + " points of damage!"); 
	    return damage;
	}
	else if (rolls == 3) {
	    int damage = this.strength * 3;
	    System.out.println(this.name + " devastated " + other.name + " for " + damage + " points of damage!"); 
	    return damage;
	}
	else {
	    int damage = this.strength;
	    System.out.println(this.name + " hit " + other.name + " for " + damage + " points of damage!"); 
	    return damage;
	}
    }
}
