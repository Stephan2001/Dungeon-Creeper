package question2project;

public class Monster {
    int HP;
    int ATK;
    
    // sets monster HP depending on what level monster it is
    public void setHP(int level){
        switch (level) {
            case 1:
                this.HP = 15;
                break;
            case 2:
                this.HP = 25;
                break;
            case 3:
                this.HP = 35;
                break;
            default:
                break;
        }
    }
    
    // sets monster ATK depending on what level monster it is
    public void setATK(int level){
        switch (level) {
            case 1:
                this.ATK = 6 + (int)(Math.random()*9);
                break;
            case 2:
                this.ATK = 10 + (int)(Math.random()*13);
                break;
            case 3:
                this.ATK = 10 + (int)(Math.random()*20);
                break;
            default:
                break;
        }
    }
    
    // method used to inflict damage on monster
    public void updateHP(int damage){
        this.HP = HP - damage;
    }
    
    // method used to reduce monster damage, this is used when players "shield" themselves
    public void updateATK(int damage){
        this.ATK = ATK - damage;
    }
    
    // get methods
    public int getATK(){
        return this.ATK;
    }
    
    public int getHP(){
        return this.HP;
    }
}
