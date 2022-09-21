package question2project;
import java.util.Scanner;
public class Question2Project {
    
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        
        boolean exit = false;
        int input;
        while (!exit){
            showStartMenu();
            input = scan.nextInt();
            scan.nextLine();
            if (input == 1){
                // details of playable characters
                showCharacterDetails();
                // assigns user character choice to c
                DefaultCharacter c = InputCharacer();
                if (c!=null){
                    switch(c.getChoice()){
                        case (0):{
                            MageCharacter MGC = MageCharacter.setMageCharacter(c);
                            System.out.println("You have chosen, " + MGC.getCharacter());
                            TriggerPlayerEvents(MGC);
                            break;
                        }
                        case (1):{
                            RogueCharacter RC = RogueCharacter.setRogueCharacter(c);
                            System.out.println("You have chosen, " + RC.getCharacter());
                            TriggerPlayerEvents(RC);
                            break;
                        }
                        case (2):{
                            MerchantCharacter MC = MerchantCharacter.setMerchantCharacter(c);
                            System.out.println("You have chosen, " + MC.getCharacter());
                            TriggerPlayerEvents(MC);
                            break;
                        }
                        case (3):{
                            BeserkerCharacter BC = BeserkerCharacter.setBeserkerCharacter(c);
                            System.out.println("You have chosen, " + BC.getCharacter());
                            TriggerPlayerEvents(BC);
                            break;
                        }
                        default:{
                            break;
                        }
                    }
                }
            }
            else{
                exit = true;
            }
        }
        
    }
    
    public static void showStartMenu(){
        System.out.println("Welcome to dungeon creeper\nTo play press (1)\nTo exit press (2) or any other key");
    }
    
    public static void showCharacterDetails(){
        System.out.println("Mage: Low defensive character, uses a staff to create bariers to protect \nhimself and shoot fireballs from the sky"
                + "\n\nRogue: is a stealthy and offencive character, he uses his agility to dodge \ndamage and goes stealthy to catch his foes"
                + "\n\nMerchant: a highly intelegent character that uses his intelict to baffel \nhis foes"
                + "\n\nBerserker: a might warrior that chaces the thrill of battle, he dashed \nenemies with his shield and axe in a crazed frenzy\n");
    }
    
    public static DefaultCharacter InputCharacer(){
        int characterChoice;
        System.out.println("Choose your character: ");
        // displayes choices and asks player to enter option
        for(CHARACTER_TYPES types : CHARACTER_TYPES.values())
            System.out.print("Enter " + types.ordinal() + " for " + types + "\n");
        characterChoice = scan.nextInt(); 
        scan.nextLine();
        CHARACTER_TYPES type = null;
        //checking if entered value is valid
        if(characterChoice > -1 && characterChoice < CHARACTER_TYPES.values().length){
            // converting user input to type
            type = CHARACTER_TYPES.values()[characterChoice];
        }
        else{
            // if incorrect it returns null
            System.out.println("Incorrect input");
            return null;
        }
        return new DefaultCharacter(type, characterChoice);
    }
    
    public static void TriggerPlayerEvents(MageCharacter MGC){
        Dungeon dungeon = new Dungeon();
        // condition to exit
        boolean playerDefeated = false;
        String exitRun;
        System.out.println("You enter the dungeon");
        for (int i=0;!playerDefeated;i++){
            int event = dungeon.setRandomEvent();
            dungeon.setEventType(event);
            System.out.println("You enter a room and encounter a " + dungeon.getEventType());
            if (event == 0){
            dungeon.triggerTresureEvent(MGC);
            }
            else if (event == 1 || event == 2 || event == 3){
            dungeon.triggerMonsterEvent(MGC, event);
            }
            // checks if player is still alive after exiting triggerMonsterEvent()
            if (MGC.getHP()<1){
                MGC.PlayerDeath(i);
                playerDefeated = true;
            }
            // asks player to exit if he want to
            System.out.println("Would you like to continue or give up? press (y) or (n)");
            exitRun = scan.nextLine();
            if (exitRun.equalsIgnoreCase("n")){
                MGC.PlayerDeath(i);
                playerDefeated = true;
            }
        }
    }
    
    public static void TriggerPlayerEvents(RogueCharacter RC){
        Dungeon dungeon = new Dungeon();
        // condition to exit
        boolean playerDefeated = false;
        String exitRun;
        System.out.println("You enter the dungeon");
        for (int i=0;!playerDefeated;i++){
            int event = dungeon.setRandomEvent();
            dungeon.setEventType(event);
            System.out.println("You enter a room and encounter a " + dungeon.getEventType());
            if (event == 0){
            dungeon.triggerTresureEvent(RC);
            }
            else if (event == 1 || event == 2 || event == 3){
            dungeon.triggerMonsterEvent(RC, event);
            }
            // checks if player is still alive after exiting triggerMonsterEvent()
            if (RC.getHP()<1){
                RC.PlayerDeath(i);
                playerDefeated = true;
            }
            // asks player to exit if he want to
            System.out.println("Would you like to continue or give up? press (y) or (n)");
            exitRun = scan.nextLine();
            if (exitRun.equalsIgnoreCase("n")){
                playerDefeated = true;
            }
        }
    }
    
    public static void TriggerPlayerEvents(MerchantCharacter MC){
        Dungeon dungeon = new Dungeon();
        // condition to exit
        boolean playerDefeated = false;
        String exitRun;
        System.out.println("You enter the dungeon");
        for (int i=0;!playerDefeated;i++){
            int event = dungeon.setRandomEvent();
            dungeon.setEventType(event);
            System.out.println("You enter a room and encounter a " + dungeon.getEventType());
            if (event == 0){
            dungeon.triggerTresureEvent(MC);
            }
            else if (event == 1 || event == 2 || event == 3){
            dungeon.triggerMonsterEvent(MC, event);
            }
            // checks if player is still alive after exiting triggerMonsterEvent()
            if (MC.getHP()<1){
                MC.PlayerDeath(i);
                playerDefeated = true;
            }
            // asks player to exit if he want to
            System.out.println("Would you like to continue or give up? press (y) or (n)");
            exitRun = scan.nextLine();
            if (exitRun.equalsIgnoreCase("n")){
                playerDefeated = true;
            }
        }
    }
    
    public static void TriggerPlayerEvents(BeserkerCharacter BC){
        Dungeon dungeon = new Dungeon();
        // condition to exit
        boolean playerDefeated = false;
        String exitRun;
        System.out.println("You enter the dungeon");
        for (int i=0;!playerDefeated;i++){
            int event = dungeon.setRandomEvent();
            dungeon.setEventType(event);
            System.out.println("You enter a room and encounter a " + dungeon.getEventType());
            if (event == 0){
            dungeon.triggerTresureEvent(BC);
            }
            else if (event == 1 || event == 2 || event == 3){
            dungeon.triggerMonsterEvent(BC, event);
            }
            // checks if player is still alive after exiting triggerMonsterEvent()
            if (BC.getHP()<1){
                BC.PlayerDeath(i);
                playerDefeated = true;
            }
            // asks player to exit if he want to
            System.out.println("Would you like to continue or give up? press (y) or (n)");
            exitRun = scan.nextLine();
            if (exitRun.equalsIgnoreCase("n")){
                playerDefeated = true;
            }
        }
    }
}
