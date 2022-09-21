package question2project;

public class BeserkerCharacter extends DefaultCharacter{
    
    public BeserkerCharacter(CHARACTER_TYPES character, int choice) {
        super(character, choice);
    }
    
    @Override
    public void triggerPlayerAttack(Monster M){
        M.updateHP(getATK());
        System.out.println("You swing your mighty axe, dealing " + getATK() + " damage");
    }
    @Override
    public void triggerPlayerDefence(Monster M){
        int shield = getDEF()*2;
        M.updateATK(shield);
        System.out.println("You hid behind your mighty shield, taking " + shield + " damage");
    }
    @Override
    public void triggerPlayerSkill(Monster M){
        int frenzy = getDEF()*3;
        M.updateATK(frenzy);
        System.out.println("You go beserk, and in your frenzy cleaved the enemy for " + frenzy + " damage\n(You got +1 ATK)");
        increaseATK(1);
        decreaseSkillCount();
    }
    
    public static BeserkerCharacter setBeserkerCharacter(DefaultCharacter d){
        BeserkerCharacter BC = new BeserkerCharacter(d.getCharacter(),d.getChoice());
        BC.setHP(45);
        BC.setDEF(7);
        BC.setATK(4);
        BC.setSkillCount(4);
        return BC;
    }
    
}
