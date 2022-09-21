package question2project;

public class MerchantCharacter extends DefaultCharacter{
    
    public MerchantCharacter(CHARACTER_TYPES character, int choice) {
        super(character, choice);
    }
    
    @Override
    public void triggerPlayerAttack(Monster M){
        M.updateHP(getATK());
        System.out.println("You insulted the enemy on his bartering skills, he took " + getATK() + " damage");
    }
    @Override
    public void triggerPlayerDefence(Monster M){
        int shield = getDEF()*2;
        M.updateATK(shield);
        System.out.println("You cowered behind a large rock, shielding you for" + shield + " damage");
    }
    @Override
    public void triggerPlayerSkill(Monster M){
        int debate = 0 + (int)(Math.random()*4);
        if (debate>1){
            M.updateHP(100);
            System.out.println("After a lengthy debate with the monster, he decided to leave");
        }
        else {
            System.out.println("After a lengthy debate with the monster, he looked at you 'funny' and brandished his weapon");
        }
        decreaseSkillCount();
    }
    
    public static MerchantCharacter setMerchantCharacter(DefaultCharacter d){
        MerchantCharacter MC = new MerchantCharacter(d.getCharacter(),d.getChoice());
        MC.setHP(25);
        MC.setDEF(7);
        MC.setATK(8);
        MC.setSkillCount(10);
        return MC;
    }

    
}
