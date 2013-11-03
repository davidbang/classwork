public class Warrior  extends Character {

    private int health;

    public Warrior(String name) {
	super(name);
	health = 100;
    }

    public Warrior (String name, int h){
	super(name);
	health = h;
    }	

    public String toString (){
	return super.toString();
    }
    public int attack (int type){
	if (type == 1)
	    return 8;
	else if (type == 2)
    	    return 10;
	else if (type == 3)
	    return 5;
	else
		return 0;
	//These are different types of attacks that a player would input based on selection (scanner). a nonplayer is randomized
    }

}
