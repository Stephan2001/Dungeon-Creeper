package question2project;

public class RogueCharacter extends DefaultCharacter{
    
    public RogueCharacter(CHARACTER_TYPES character, int choice) {
        super(character, choice);
    }
    
    @Override
    public void triggerPlayerAttack(Monster M){
        M.updateHP(getATK());
        System.out.println("You dashed and stabbed the creature, dealing " + getATK() + " damage");
    }
    @Override
    public void triggerPlayerDefence(Monster M){
        int shield = getDEF()*3;
        M.updateATK(shield);
        System.out.println("You dodged to the side, shielding you for " + shield + " damage");
    }
    @Override
    public void triggerPlayerSkill(Monster M){
        int stealth = getATK()*3;
        M.updateHP(stealth);
        System.out.println("You went stealthy and got the enemy from behind, dealing " + stealth + " damage");
        decreaseSkillCount();
    }
    
    public static RogueCharacter setRogueCharacter(DefaultCharacter d){
        RogueCharacter RC = new RogueCharacter(d.getCharacter(),d.getChoice());
        RC.setHP(35);
        RC.setDEF(4);
        RC.setATK(7);
        RC.setSkillCount(7);
        return RC;
    }
}
