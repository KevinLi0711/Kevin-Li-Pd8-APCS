/**
 Protagonist class methods
 * 		- isAlive() returns a boolean
 * 		- specialize() returns void
 * 		- normalize() returns void
 * 		- attack() returns an int (is this a getter method?, monster input)
 * 		- getName() returns a String
**/
public class Protagonist{
	private String name;
	int HP=150;
	int attack=70;
    int defense=40;
    int atkboost = attack;
    int defboost = defense/2;
    double accuracy = .9;
    boolean specialized = false;

	public Protagonist(String inputName){
		name = inputName;
	}
	public boolean isAlive() {
		return HP > 0;
	}
	public void specialize(){
        if (!specialized) {
            specialized = true;
            attack += atkboost;
            defense -= defboost;
        }
        System.out.println(attack);
        System.out.println(defense);
	}
	public void normalize(){
        if (specialized) {
            specialized = false;
            attack -= atkboost;
            defense += defboost;
        }
        System.out.println(attack);
        System.out.println(defense);
	}
	public int attack(Monster mon){
		if (Math.random()<accuracy){
			mon.HP -= (attack - mon.defense);
			return (attack - mon.defense);
		} else{
			return 0;
		}		
	}
	public String getName(){
		return name;
	}
}