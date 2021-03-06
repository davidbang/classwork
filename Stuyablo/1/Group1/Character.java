import java.io.*;
import java.util.*;

public class Character {
    protected int health, maxhealth;
    protected int dexterity, strength, intelligence;
    protected int experience;
    protected int gold;
    protected double x,y,distance;
    protected String name;
    protected String charClass;


    public void setAttributes(){
	int dex;
	int stren;
	int intell;
	Random r=new Random();
	try{
	    dex=r.nextInt(8)+1;
	    stren=r.nextInt(8-dex)+1;
	    intell=8-dex-stren;
	}
	catch (Exception e){
	    dex=3;
	    stren=3;
	    intell=2;
	}
	health=50;
	maxhealth=50;
	dexterity=dex+8;
	strength=stren+8;
	intelligence=intell+8;
    }
 
    public int getHealth() {
        return health;
    }

    /* You have to provide other needed get/set methods */
    


    public void talk(Character other){
	/*not the real thing; just an outline*/
	//1="Say something charming";
	//2="Say something intimidating";
	//3="Say something funny";
	/*so on and so forth*/
	/*RESPONSES*/
	/*NPC's strength increases, deceases, player's strength increases, decreases, blahblahblah. RANDOM RESPONSE*/
    }
    public int roll(){
	
	Random x = new Random();
	dice1 = x.nextInt(6) + 1;
	dice2 = x.nextInt(6) + 1;
	dice3 =  x.nextInt(6) + 1;
        return dice1+dice2+dice2;
    }
    public void takedamage(int k){
	health = health - k;
    }
    public void say(String s){
	System.out.println(s);
    }
    public void takegold( Character other){
	gold = gold + other.gold;
    }
    public void loosegold( Character other) {
	gold = 0;
    }

    public void attack(Character other) {
	while (this.health > 5 || other.health > 5){
	    if (dexterity <= roll()){
		other.takedamage(this.strength);
		say (other + " has lost " + strength + " health points");
	    }
	    if (other.dexterity <= other.roll()){
		this.takedamage(other.strength);
		say(name + " has lost " + other.strength + " health points");
	    }
	}
	if (this.health <= 5)
	    this.flee();
	else
	    other.flee();
    }
	    
        /* do the attack:
           print out the attempt and the result and update
           all relavent variables
        */
    }

    // returns true if you succesfully flee, false otherwise
    public boolean flee(Character other) {

	return false;
    }


    /*
      this routine will decide first ask if other tries to flee. If
      so, and if it's succesful it should adjust experience and or
      gold as needed and return a 0.

      Then, it should decide if this character tries to flee. 
      If so and it's succesful, return a 1;
      
      Otherwise, call attack on both sides:
      this.attack(other);
      if (other.health>0) 
        other.attack(this);

      and then return 2 if this is dead, 3 if other is dead, 4 if both dead, 5 if none dead.

    */
    public int encounter(Character other) {
        return 0;
    }



    public String getStatus() {
	setAttributes();
        String attrib1=String.format("Str: %d Dex: %d Int: %d",
                                     strength, dexterity, intelligence);
        String attrib2=String.format("Exp: %d Health: %d of %d",
                                     experience,health,maxhealth);
        String locale = String.format("x: %5.2f y: %5.2f",x,y);
        String whole=String.format("%s\n%s\n%s\n%s\n",
                                   name,attrib1,attrib2,locale);
        return whole;
    }


    public String toString() {
        return name;
    }

    
}
