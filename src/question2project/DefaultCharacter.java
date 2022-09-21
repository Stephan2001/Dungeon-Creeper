package question2project;

public class DefaultCharacter {
    private CHARACTER_TYPES character;
    private int HP;
    private int DEF;// this stat acts as a deduction to player damage taken
    private int ATK;
    private int skillCount;
    private int choice;
    private int damageTaken;
    
    DefaultCharacter(CHARACTER_TYPES character, int choice){
        this.character = character;
        this.choice = choice;
    }
    
    // player attack event
    public void triggerPlayerAttack(Monster M){
        
    }
    
    // player defence event
    public void triggerPlayerDefence(Monster M){
        
    }
    
    // player skill event
    public void triggerPlayerSkill(Monster M){
        
    }
    
    // message displayed on player death
    public void PlayerDeath(int floor){
        System.out.println("You fell during a hard fought battle on floor " + floor +" You fought bravely...");
    }

    /*
    all getters and setter used
    */
    public CHARACTER_TYPES getCharacter() {
        return character;
    }

    public void setCharacter(CHARACTER_TYPES character) {
        this.character = character;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getDEF() {
        return DEF;
    }

    public void setDEF(int DEF) {
        this.DEF = DEF;
    }

    public int getATK() {
        return ATK;
    }

    public void setATK(int ATK) {
        this.ATK = ATK;
    }

    public int getChoice() {
        return choice;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }
    
    public void setSkillCount(int x){
        this.skillCount = x;
    }
    
    public int getSkillCount(){
        return this.skillCount;
    }
    
    /*
    increase methods are used to update player stats during combat
    */
    public void increaseHP(int x){
        this.HP = HP + x;
    }
    
    public void increaseDEF(int x){
        this.DEF = DEF + x;
    }
    
    public void increaseATK(int x){
        this.ATK = ATK + x;
    }
    
    public void increaseSkillCount(int x){
        this.skillCount = skillCount + x;
    }
    
    // decreases skill count
    public void decreaseSkillCount(){
        this.skillCount = skillCount -1;
    }
    
    /*
    method used to inflict damage onto player
    the defence stat acts as a reduction to damage taken
    */
    public void takeDamage(int damage){
        damage = damage - this.DEF;
        this.damageTaken = damage;
        if (damage>0){
            this.HP = HP - damage;
        }
    }
    
    // return amount of damage taken by player
    public int getDamageTaken(){
        if (this.damageTaken>0){
            return this.damageTaken;
        }
        return 0;
    }
}
