public class Monster {
    int HP;
	int attack;
    int defense;

    public Monster() {
        HP=((int)(Math.random() * 50)) + 50;
        attack=((int)(Math.random() * 20)) + 40;
        defense=((int)(Math.random() * 20)) + 40;
    }

	public boolean isAlive() {
		return HP > 0;
	}
	public int attack(Protagonist pro){
        if (attack < pro.defense) {
            return 0;
        }
		else {
            pro.HP -= (attack - pro.defense);
            return (attack - pro.defense);
        }
	}
}
