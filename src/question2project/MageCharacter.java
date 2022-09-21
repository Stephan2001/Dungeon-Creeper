package question2project;

public class MageCharacter extends DefaultCharacter{
    
    public MageCharacter(CHARACTER_TYPES character, int choice) {
        super(character, choice);
    }
    
    @Override
    public void triggerPlayerAttack(Monster M){
        M.updateHP(getATK());
        System.out.println("You knocked the creature on it's head, using your trusty staff, dealing " + getATK() + " damage");
    }
    @Override
    public void triggerPlayerDefence(Monster M){
        int shield = getDEF()*3;
        M.updateATK(shield);
        System.out.println("You raised your staff to the heavens creating a magical barrier, shielding " + shield + " damage");
    }
    @Override
    public void triggerPlayerSkill(Monster M){
        int fireball = getATK()*5;
        M.updateHP(fireball);
        System.out.println("You raised your staff to the heavens to bring forth a mighty fireball, dealing " + fireball + " damage");
        decreaseSkillCount();
    }
    
    public static MageCharacter setMageCharacter(DefaultCharacter d){
        MageCharacter MGC = new MageCharacter(d.getCharacter(),d.getChoice());
        MGC.setHP(30);
        MGC.setDEF(4);
        MGC.setATK(3);
        MGC.setSkillCount(8);
        return MGC;
    }
}
