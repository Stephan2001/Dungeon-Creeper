package question2project;

import java.util.Scanner;

public class Dungeon {
    String eventType;
    
    // sets the event to occur
    public int setRandomEvent(){
        return 0 + (int)(Math.random()*4);
    }
    
    // sets the event type
    public void setEventType(int x){
        String[] events = {"Tresure", "Monster", "Scary Monster", "Boss Monster"};
        eventType = events[x];
    }
    
    // getter for event type
    public String getEventType(){
        return this.eventType;
    }
    
    public void triggerTresureEvent(DefaultCharacter d){
        System.out.println("You find some shiny new armour, weapons and potions!"
                + "\nAttak+2\nDefence+2\nHitpoints+5\nskill Count+5");
        d.increaseATK(2);
        d.increaseDEF(2);
        d.increaseSkillCount(5);
        d.increaseHP(5);
    }
    
    public void triggerMonsterEvent(DefaultCharacter d, int level){
        Scanner scan = new Scanner(System.in);
        Monster M = new Monster();
        int playerOption, monsterIntent;
        M.setHP(level);
        for (int i=0;d.getHP()>0 || M.getHP()>0;i++){
            do{
                M.setATK(level);
                monsterIntent = M.getATK();
                System.out.println("\nTurn " + (i+1) + " of combat"
                        + "\nYou have " + d.getHP() + "HP left"
                        + "\nYou have " + d.getSkillCount() + " skills left"
                        + "\nThe monster has " + M.getHP() + " HP left");
                System.out.println("The monster intends to attack you for " + monsterIntent);
                System.out.println("What will you do?\nPress (1) to attack\nPress (2) to Defend\nPress (3) to use skill");
                playerOption = scan.nextInt();
                scan.nextLine();
                switch (playerOption) {
                    case 1:
                        d.triggerPlayerAttack(M);
                        d.takeDamage(monsterIntent);
                        System.out.println("The creature clawed you for " + d.getDamageTaken() +" damage");
                        break;
                    case 2:
                        d.triggerPlayerDefence(M);
                        d.takeDamage(monsterIntent);
                        System.out.println("The creature clawed you for " + d.getDamageTaken() +" damage");
                        break;
                    case 3:
                        if (d.getSkillCount()>0){
                            d.triggerPlayerSkill(M);
                            d.takeDamage(monsterIntent);
                            System.out.println("The creature clawed you for " + d.getDamageTaken() +" damage");
                        }
                        else {
                            System.out.print("You try very hard to consentrate, but fial to do anything");
                            d.takeDamage(monsterIntent);
                            System.out.println("The creature clawed you for " + d.getDamageTaken() +" damage");
                        }   break;
                    default:
                        System.out.println("Invalid input, try again");
                        break;
                }
            }
            while (playerOption>3 || playerOption<1);
        }
    }
}
