package assignment1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Combat {
    Pokemon a,b;
    private String [] pokemonChosenA=new String[3];
    private String [] pokemonChosenB=new String[3];
    private Inventory ia;
    private Inventory ib;
    private boolean repeat=false;
    private String previousPokemon,previousPokemonB;
    private int accA = 0, accB = 0;
    private AnimationTimer end;
    private AnimationTimer selectPokemon1;
    private AnimationTimer playerAttack;
    private AnimationTimer selectSkill;
    private AnimationTimer selectPokemon;
    private AnimationTimer opponentAttack;
    private AnimationTimer switchtoPokemon;
    private AnimationTimer opponentChoosePokemon;
    private AnimationTimer choosePokemon;
    private AnimationTimer choosePokemon1;
    private AnimationTimer repeatPokemon;
    private AnimationTimer repeatPokemon1;
    private AnimationTimer successPokemon;
    private AnimationTimer successPokemon1;
    private int pokemonNum;
    private int chosenNum;
    private int skillNum;
    private int hpA,hpB;
    private boolean counter=false;
    private boolean countered=false;
    private Stage stage=new Stage();
    private String instruction;
    private MediaPlayer myMediaPlayer;
    private void playMusic(String filename) {
		String musicFile = "music/" + filename;
		Media sound = new Media(new File(musicFile).toURI().toString());
		myMediaPlayer = new MediaPlayer(sound);
		myMediaPlayer.play();
	}
    public Combat(Stage s){
    stage=s;
    }
    
    public int damage(Pokemon a,Pokemon b,int skillNum){ //a damage b
        int damage;
        damage = ((a.getAtk() * a.getSkillPow(skillNum) / b.getDef() / 20) + 2);

    //when pokemon A attack B
    if ((a.getSkillType(skillNum).equalsIgnoreCase("fire")) && (b.getType().equalsIgnoreCase("grass")) || (a.getSkillType(skillNum).equalsIgnoreCase("grass")) && (b.getType().equalsIgnoreCase("water")) || (a.getSkillType(skillNum).equalsIgnoreCase("water")) && (b.getType().equalsIgnoreCase("fire"))){
        counter=true;
        return damage*=2;
        
        
    }else if((a.getSkillType(skillNum).equalsIgnoreCase("fire")) && (b.getType().equalsIgnoreCase("water")) || (a.getSkillType(skillNum).equalsIgnoreCase("grass")) && (b.getType().equalsIgnoreCase("fire")) || (a.getSkillType(skillNum).equalsIgnoreCase("water")) && (b.getType().equalsIgnoreCase("grass"))){
        countered=true;
        return damage/=2;
              
    }else{
        return damage;
        
    }
    }

    public Pokemon npcChooseInCombat(Pokemon a,Pokemon b,Inventory ib){
        if(a.getType().equalsIgnoreCase("water")){
            for(int i=0;i<3;i++){
                if(!ib.getChosenPokemon(i).getFainted()&&ib.getChosenPokemon(i).getType().equalsIgnoreCase("grass")){
                    b=ib.getChosenPokemon(i);
                    break;
                }
                else if(!ib.getChosenPokemon(i).getFainted()&&ib.getChosenPokemon(i).getType().equalsIgnoreCase("water")){
                    b=ib.getChosenPokemon(i);
                    break;
                }
                else if(!ib.getChosenPokemon(i).getFainted()){
                    b=ib.getChosenPokemon(i);
                }
            }           
    }
        else if(a.getType().equalsIgnoreCase("grass")){
            for(int i=0;i<3;i++){
                if(!ib.getChosenPokemon(i).getFainted()&&ib.getChosenPokemon(i).getType().equalsIgnoreCase("fire")){
                    b=ib.getChosenPokemon(i);
                    break;
                }
                else if(!ib.getChosenPokemon(i).getFainted()&&ib.getChosenPokemon(i).getType().equalsIgnoreCase("grass")){
                    b=ib.getChosenPokemon(i);
                    break;
                }
                else if(!ib.getChosenPokemon(i).getFainted()){
                    b=ib.getChosenPokemon(i);
                }
            }
        }
        else if(a.getType().equalsIgnoreCase("fire")){
            for(int i=0;i<3;i++){
                if(!ib.getChosenPokemon(i).getFainted()&&ib.getChosenPokemon(i).getType().equalsIgnoreCase("water")){
                    b=ib.getChosenPokemon(i);
                    break;
                }
                else if(!ib.getChosenPokemon(i).getFainted()&&ib.getChosenPokemon(i).getType().equalsIgnoreCase("fire")){
                    b=ib.getChosenPokemon(i);
                    break;
                }
                else if(!ib.getChosenPokemon(i).getFainted()){
                    b=ib.getChosenPokemon(i);
                }
            }
        }
        return b;
    }
    
    public String[] choosePokemonNPC(String[] pokemonChosenB) throws FileNotFoundException{
        Random random=new Random();
        FileInput fi=new FileInput();
        String[]pokemonName=new String[12];
        for(int i=0;i<12;i++){
            pokemonName[i]=fi.getPokemon(i).getName();
        }
        String input;
        String[]pokemonChosenA=new String[6];
        int pokemonNum=0;
        boolean repeat=false;
        for(int i=0;pokemonNum<6;i++){
            input=pokemonName[random.nextInt(12)];                       
            pokemonChosenA[pokemonNum]=input;
            for(int j=0;j<pokemonNum;j++){
                
                if(pokemonChosenA[pokemonNum].equalsIgnoreCase(pokemonChosenA[j])){
                    repeat=true;
                    break;
                }
               
            }
             for(int j=0;j<3;j++){
                if(pokemonChosenA[pokemonNum].equalsIgnoreCase(pokemonChosenB[j])){
                    repeat=true;
                    break;
                }
            }
            if(repeat==false){
                pokemonNum++;
            }
            repeat=false;
        }
        return pokemonChosenA;
    }
  
    public Scene init(double width,double height) throws FileNotFoundException{
        Random random=new Random();
        Group root=new Group();
        Scene combatScene=new Scene(root, width, height, Color.WHITE);

        CombatScene cs=new CombatScene();

                
        long startNanoTime=System.nanoTime();


        stage.setScene(combatScene);
        //set Cursor
        double x=200,y=365;
        Sprites cursor=new Sprites();
        cursor.setImage("file:select.png");
        cursor.setPosition(x, y);
        cursor.setWidth(100);
        cursor.setHeight(35);
        
        Sprites cursor1=new Sprites();
        cursor1.setImage("file:select.png");
        cursor1.setWidth(100);
        cursor1.setHeight(35);
        cursor1.setPosition(300, 330);
        
         Sprites cursor2=new Sprites();
        cursor2.setImage("file:select.png");
        cursor2.setWidth(100);
        cursor2.setHeight(35);
        cursor2.setPosition(100, 330);
        
        Sprites cursor3=new Sprites();
        cursor3.setImage("file:select.png");
        cursor3.setWidth(200);
        cursor3.setHeight(100);
        cursor3.setPosition(0, 0);
        //successfully choose Pokemon 1
        successPokemon1=new AnimationTimer()
    {
        public void handle(long currentNanoTime)
        {
            double t = (currentNanoTime - startNanoTime) / 1000000000.0; 
                
                cs.rectangle(root);
                instruction="You have chose"+pokemonChosenA[chosenNum-1];
                cs.setInstruction(root, instruction);
                combatScene.setOnKeyPressed(new EventHandler<KeyEvent>(){
                public void handle(KeyEvent event) {
                    KeyCode kc = event.getCode();
                    switch(kc){
                        case Z:
                           playMusic("click.mp3");
                           successPokemon1.stop();
                       if(chosenNum==3){
                        choosePokemon.stop();
                         try {
                            ia=new Inventory(pokemonChosenA);
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(Combat.class.getName()).log(Level.SEVERE, null, ex);
                        }
                         a=ia.getChosenPokemon(0);
                         previousPokemon=a.getName();
                        try {
                            pokemonChosenB=choosePokemonNPC(pokemonChosenA);
                            ib=new Inventory(pokemonChosenB);
                            b=ib.getChosenPokemon(0);
                            previousPokemonB=b.getName();
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(Combat.class.getName()).log(Level.SEVERE, null, ex);
                        }
                             while(!(accA>=100 || accB>=100)){
                                accA+=a.getSpd();
                                accB+=b.getSpd();
                            }
                             if(accA>=100){
                                 selectPokemon.start();
                             }
                             else if(accB>=100){
                                 opponentAttack.start();
                             }
                    }
                       else{                       
                            choosePokemon1.start();
                       }
                        
                    }
                }
                    }
        );                  
                    }            
        };       
       
        //successfully choose Pokemon
        successPokemon=new AnimationTimer()
    {
        public void handle(long currentNanoTime)
        {
            double t = (currentNanoTime - startNanoTime) / 1000000000.0; 
                
                cs.rectangle(root);
                instruction="You have chose"+pokemonChosenA[chosenNum-1];
                cs.setInstruction(root, instruction);
                combatScene.setOnKeyPressed(new EventHandler<KeyEvent>(){
                public void handle(KeyEvent event) {
                    KeyCode kc = event.getCode();
                    switch(kc){
                        case Z:
                            playMusic("click.mp3");
                            successPokemon.stop();
                       if(chosenNum==3){
                        choosePokemon.stop();
                         try {
                            ia=new Inventory(pokemonChosenA);
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(Combat.class.getName()).log(Level.SEVERE, null, ex);
                        }
                         a=ia.getChosenPokemon(0);
                         previousPokemon=a.getName();
                         
                        try {
                            pokemonChosenB=choosePokemonNPC(pokemonChosenA);
                            ib=new Inventory(pokemonChosenB);
                            b=ib.getChosenPokemon(0);
                            previousPokemonB=b.getName();
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(Combat.class.getName()).log(Level.SEVERE, null, ex);
                        }
                             while(!(accA>=100 || accB>=100)){
                                accA+=a.getSpd();
                                accB+=b.getSpd();
                            }
                             if(accA>=100){
                                 selectPokemon.start();
                             }
                             else if(accB>=100){
                                 opponentAttack.start();
                             }
                    }
                       else{                       
                            choosePokemon.start();
                       }
                        
                    }
                }
                    }
        );                  
                    }            
        };       
        //repeated pokemon chose 2
        repeatPokemon1=new AnimationTimer()
    {
                public void handle(long currentNanoTime)
                {
                    double t = (currentNanoTime - startNanoTime) / 1000000000.0; 
                        

                        cs.rectangle(root);
                        instruction="This pokemon is already chosen\nPlease choose another Pokemon";
                        cs.setInstruction(root, instruction);
                        combatScene.setOnKeyPressed(
                        new EventHandler<KeyEvent>(){
                        public void handle(KeyEvent event) {
                            KeyCode kc = event.getCode();
                            switch(kc){
                                case Z:
                                    playMusic("click.mp3");
                                    repeatPokemon1.stop();
                                    choosePokemon1.start();

                            }
                        }
                            }
                );                  
                            }            
        };       

        //repeated pokemon chose
        repeatPokemon=new AnimationTimer()
    {
        public void handle(long currentNanoTime)
        {
            double t = (currentNanoTime - startNanoTime) / 1000000000.0; 
                

                cs.rectangle(root);
                instruction="This pokemon is already chosen\nPlease choose another Pokemon";
                cs.setInstruction(root, instruction);
                combatScene.setOnKeyPressed(
                new EventHandler<KeyEvent>(){
                public void handle(KeyEvent event) {
                    KeyCode kc = event.getCode();
                    switch(kc){
                        case Z:
                            playMusic("click.mp3");
                            repeatPokemon.stop();
                            choosePokemon.start();
                        
                    }
                }
                    }
        );                  
                    }            
};       

        //choosePokemon 1
        choosePokemon1=new AnimationTimer()
    {
        public void handle(long currentNanoTime)
        {
            double t = (currentNanoTime - startNanoTime) / 1000000000.0; 
                root.getChildren().clear();
                 cs.bigRec(root);
                 cs.rectangle(root);
                 instruction="Please choose 3 pokemon";
                 cs.setInstruction(root, instruction);
            try {
                cs.choosePokemon1(root);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Combat.class.getName()).log(Level.SEVERE, null, ex);
            }
           
                root.getChildren().add(cursor3.viewImage());
                
                combatScene.setOnKeyPressed(
                new EventHandler<KeyEvent>(){
                public void handle(KeyEvent event) {
                    KeyCode kc = event.getCode();
                    switch(kc){
                        case UP:
                            if(cursor3.getY()==0){
                                choosePokemon1.stop();
                                choosePokemon.start();
                            }
                            if(cursor3.getY()==100){
                                cursor3.setPosition(cursor3.getX(), 0);
                            }
                            if(cursor3.getY()==200){
                                cursor3.setPosition(cursor3.getX(), 100);
                            }
                            break;
                        case DOWN:
                            if(cursor3.getY()==0){
                                cursor3.setPosition(cursor3.getX(),100);
                            }
                            else if(cursor3.getY()==100){
                                cursor3.setPosition(cursor3.getX(), 200);
                            }
                            else if(cursor3.getY()==200){
                                
                            }
                            break;
                        case LEFT:
                            if(cursor3.getX()==200){
                                cursor3.setPosition(0, cursor3.getY());
                            }
                            break;
                        case RIGHT:
                            if(cursor3.getX()==0){
                                cursor3.setPosition(200, cursor3.getY());
                            }
                            break;
                        case Z:
                            playMusic("click.mp3");
                            String pokemon="";
                            if(cursor3.getX()==0){
                                switch((int)cursor3.getY()){
                                    case 0:
                                        pokemon="Turtwig";
                                        break;
                                    case 100:
                                        pokemon="Piplup";
                                        break;
                                    case 200:
                                        pokemon="Tepig";
                                        break;
                                }
                            }
                            else if(cursor3.getX()==200){
                                switch((int)cursor3.getY()){
                                    case 0:
                                        pokemon="Chimchar";
                                        break;
                                    case 100:
                                        pokemon="Snivy";
                                        break;
                                    case 200:
                                        pokemon="Oshawott";
                                        break;
                                }
                            }
                            pokemonChosenA[chosenNum]=pokemon;
                            for(int j=0;j<chosenNum;j++){
                
                                if(pokemonChosenA[chosenNum].equalsIgnoreCase(pokemonChosenA[j])){                                   
                                    repeat=true;
                                    choosePokemon1.stop();
                                    repeatPokemon1.start();
                                    break;
                                }

                            }
                            for(int j=0;j<3;j++){
                                if(pokemonChosenA[chosenNum].equalsIgnoreCase(pokemonChosenB[j])){
                                    repeat=true;
                                    choosePokemon1.stop();
                                    repeatPokemon1.start();
                                    break;
                                }
                            }
                            if(repeat==false){
                                chosenNum++;
                                choosePokemon1.stop();
                                successPokemon1.start();
                            }
                            repeat=false;
        }
                    
                        
                    }
                
                    }
        );                  
                    }            
        }; 
        
        //Choose pokemon
        choosePokemon=new AnimationTimer()
    {
        public void handle(long currentNanoTime)
        {
            double t = (currentNanoTime - startNanoTime) / 1000000000.0;
                root.getChildren().clear();
                 cs.bigRec(root);
                 cs.rectangle(root);
                 instruction="Please choose 3 pokemon";
                 cs.setInstruction(root, instruction);
            try {
                cs.choosePokemon(root);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Combat.class.getName()).log(Level.SEVERE, null, ex);
            }
           
                root.getChildren().add(cursor3.viewImage());
                

                combatScene.setOnKeyPressed(
                new EventHandler<KeyEvent>(){
                public void handle(KeyEvent event) {
                    KeyCode kc = event.getCode();
                    switch(kc){
                        case UP:
                            if(cursor3.getY()==100){
                                cursor3.setPosition(cursor3.getX(), 0);
                            }
                            if(cursor3.getY()==200){
                                cursor3.setPosition(cursor3.getX(), 100);
                            }
                            break;
                        case DOWN:
                            if(cursor3.getY()==0){
                                cursor3.setPosition(cursor3.getX(),100);
                            }
                            else if(cursor3.getY()==100){
                                cursor3.setPosition(cursor3.getX(), 200);
                            }
                            else if(cursor3.getY()==200){
                                choosePokemon.stop();
                                choosePokemon1.start();
                            }
                            break;
                        case LEFT:
                            if(cursor3.getX()==200){
                                cursor3.setPosition(0, cursor3.getY());
                            }
                            break;
                        case RIGHT:
                            if(cursor3.getX()==0){
                                cursor3.setPosition(200, cursor3.getY());
                            }
                            break;
                        case Z:
                            playMusic("click.mp3");
                            String pokemon="";
                            if(cursor3.getX()==0){
                                switch((int)cursor3.getY()){
                                    case 0:
                                        pokemon="Bulbasaur";
                                        break;
                                    case 100:
                                        pokemon="Squirtle";
                                        break;
                                    case 200:
                                        pokemon="Cyndaquil";
                                        break;
                                }
                            }
                            else if(cursor3.getX()==200){
                                switch((int)cursor3.getY()){
                                    case 0:
                                        pokemon="Charmander";
                                        break;
                                    case 100:
                                        pokemon="Chikorita";
                                        break;
                                    case 200:
                                        pokemon="Totodile";
                                        break;
                                }
                            }
                            pokemonChosenA[chosenNum]=pokemon;
                            for(int j=0;j<chosenNum;j++){
                
                                if(pokemonChosenA[chosenNum].equalsIgnoreCase(pokemonChosenA[j])){                                                                     
                                    repeat=true;
                                    choosePokemon.stop();
                                    repeatPokemon.start();
                                    break;
                                }

                            }
                            for(int j=0;j<3;j++){
                                if(pokemonChosenA[chosenNum].equalsIgnoreCase(pokemonChosenB[j])){
                                    repeat=true;
                                    choosePokemon.stop();
                                    repeatPokemon.start();
                                    break;
                                }
                            }
                            if(repeat==false){                                
                                chosenNum++;
                                choosePokemon.stop();
                                successPokemon.start();
                            }
                            repeat=false;
        }
                    }
                
                    }
        );                  
                    }            
        }; 

        //end
        end=new AnimationTimer()
    {
        public void handle(long currentNanoTime)
        {
            double t = (currentNanoTime - startNanoTime) / 1000000000.0; 
                root.getChildren().clear();
                cs.init(root);
                if(ia.allFainted()){
                    cs.rectangle(root);
                    cs.addOpponentPokemon(root, b.getFront());
                    instruction="You lose";
                    cs.setInstruction(root, instruction);
                    end.stop();
                }
                else if(ib.allFainted()){
                    Assignment1.myMediaPlayer.stop();
                    playMusic("victory.mp3");
                    cs.rectangle(root);
                    cs.addPlayerPokemon(root, a.getBack());
                    instruction="You win";
                    cs.setInstruction(root, instruction);
                    end.stop();
                }
                combatScene.setOnKeyPressed(
                new EventHandler<KeyEvent>(){
                public void handle(KeyEvent event) {
                    KeyCode kc = event.getCode();
                    switch(kc){
                        case Z:
                            playMusic("click.mp3");
                            end.stop();
                            myMediaPlayer.stop();
                            stage.close();
                        
                    }
                }
                    }
        );                  
                    }            
};       

        //Opponent Choose Pokemon
        opponentChoosePokemon=new AnimationTimer()
        {
            public void handle(long currentNanoTime)
            {
                double t = (currentNanoTime - startNanoTime) / 1000000000.0; 

                    b=npcChooseInCombat(a,b,ib);
                    if(!b.getName().equals(previousPokemonB)){
                    root.getChildren().clear();    
                    cs.init(root);
                    cs.addPlayerPokemon(root, a.getBack());
                    cs.addOpponentPokemon(root, b.getFront());
                    cs.setOpponentName(root, b.getName());
                    cs.setPlayerName(root, a.getName());
                    cs.rectangle(root);
                    cs.setPlayerHP(root, a.getHp());
                    cs.setOpponentHP(root,b.getHp());                    
                    accB=0;
                    instruction="Enemy chose "+b.getName();
                    cs.setInstruction(root, instruction);
                    previousPokemonB=b.getName();
                    while(!(accA>=100 || accB>=100)){
                        accA+=a.getSpd();
                        accB+=b.getSpd();
                    }

                    opponentChoosePokemon.stop();
                    combatScene.setOnKeyPressed(
                    new EventHandler<KeyEvent>(){
                    public void handle(KeyEvent event) {
                        KeyCode kc = event.getCode();
                        switch(kc){
                            case Z:
                                playMusic("click.mp3");
                                opponentChoosePokemon.stop();
                                if(accA>=100 && accA>accB){
                                    accA-=100;
                                    selectPokemon.start();
                                }
                                else{
                                    accB-=100;
                                    opponentAttack.start();
                                }
                                break;                             
                        }
                    }
                        }
            );        
                    }
                    else{
                        opponentChoosePokemon.stop();
                                if(accA>=100 && accA>accB){
                                    accA-=100;
                                    selectPokemon.start();
                                }
                                else{
                                    accB-=100;
                                    opponentAttack.start();
                                }
                    }
                        }            
    };       
        
        //switch to 
        switchtoPokemon=new AnimationTimer()
        {
        public void handle(long currentNanoTime)
        {
            double t = (currentNanoTime - startNanoTime) / 1000000000.0; 
                root.getChildren().clear();
                cs.init(root);
                cs.setOpponentHP(root, b.getHp());
                cs.setOpponentName(root, b.getName());
                cs.addOpponentPokemon(root, b.getFront());
                
                cs.rectangle(root);
                // chosen pokemon is fainted
                 if(ia.getChosenPokemon(pokemonNum).getFainted()){
                    instruction=ia.getChosenPokemon(pokemonNum).getName()+" is fainted";
                    cs.setInstruction(root, instruction);
                    switchtoPokemon.stop();
                    combatScene.setOnKeyPressed(
                    new EventHandler<KeyEvent>(){
                    public void handle(KeyEvent event) {
                    KeyCode kc = event.getCode();
                    switch(kc){
                        case Z:
                            // reselect pokemon
                            playMusic("click.mp3");
                            selectPokemon1.start();
                            break;                            
                    }

                }
                    }
        );    
                }
                 //chosen pokemon is already in battle
                 else if(ia.getChosenPokemon(pokemonNum).getName().equals(previousPokemon)){
                    cs.addPlayerPokemon(root, a.getBack());
                    instruction=a.getName()+" is already in Battle";
                    cs.setInstruction(root, instruction);
                     switchtoPokemon.stop();
                    combatScene.setOnKeyPressed(
                    new EventHandler<KeyEvent>(){
                    public void handle(KeyEvent event) {
                    KeyCode kc = event.getCode();
                    switch(kc){
                        case Z:
                            playMusic("click.mp3");
                            selectPokemon1.start();
                            break;                            
                    }

                }
                    }
        );    
                }
               // successfully choose pokemon
                else{
                //new pokemon accumulator =0
                accA=0;
                a=ia.getChosenPokemon(pokemonNum);
                cs.init(root);
                //show new pokemon image
                cs.addPlayerPokemon(root, a.getBack());
                cs.addOpponentPokemon(root, b.getFront());
                cs.setPlayerName(root, a.getName());
                cs.setOpponentName(root, b.getName());
                //initialize previous Pokemon
                previousPokemon=a.getName();
                cs.rectangle(root);
                cs.setPlayerHP(root, a.getHp());
                cs.setOpponentHP(root,b.getHp());
                instruction="Player 1 switch to "+a.getName();
                cs.setInstruction(root, instruction);
                while(!(accA>=100 || accB>=100)){
                    accA+=a.getSpd();
                    accB+=b.getSpd();
                }
                switchtoPokemon.stop();
                combatScene.setOnKeyPressed(
                new EventHandler<KeyEvent>(){
                public void handle(KeyEvent event) {
                    
                    KeyCode kc = event.getCode();
                    switch(kc){
                        case Z:
                            playMusic("click.mp3");
                            switchtoPokemon.stop();
                            if(accA>=100 && accA>accB){
                                accA-=100;
                                selectSkill.start();
                            }
                            else{
                                accB-=100;
                                opponentAttack.start();
                            }
                            break;                            
                    }

                }
                    }
        );    
                }
                


                           

                    }            
};       

        //Opponent Attack
        opponentAttack=new AnimationTimer()
         {
                public void handle(long currentNanoTime)
                {
                    double t = (currentNanoTime - startNanoTime) / 1000000000.0;     
                        root.getChildren().clear();
                        cs.init(root);

                        cs.addPlayerPokemon(root, a.getBack());
                        cs.addOpponentPokemon(root, b.getFront());
                        cs.setPlayerName(root, a.getName());
                        cs.setOpponentName(root, b.getName());
                        int skillNum=random.nextInt(4);
                        int miss=random.nextInt(100)+1;
                        if(miss<=b.getSkillAcc(skillNum)){
                            hpA=a.getHp()-damage(b,a,skillNum);
                            cs.rectangle(root);
                            playMusic("attack.mp3");
                            instruction=b.getName()+" used "+b.getSkillName(skillNum);
                            cs.setInstruction(root, instruction);
                            if(counter){
                                cs.rectangle(root);
                                instruction=b.getName()+" used "+b.getSkillName(skillNum)+"\nIt is very effective!";
                                cs.setInstruction(root, instruction);
                            }
                            else if(countered){
                                cs.rectangle(root);
                                instruction=b.getName()+" used "+b.getSkillName(skillNum)+"\nIt is not very effective...";
                                cs.setInstruction(root, instruction);
                            }
                            counter=false;
                            countered=false;
                        }
                        else{
                            hpA=a.getHp();
                            cs.rectangle(root);
                            instruction=b.getName()+" missed";
                            cs.setInstruction(root, instruction);                            
                        }
                        a.setHp(hpA);

                        cs.setOpponentHP(root,b.getHp());

                        if(a.getHp()<=0)
                            cs.setPlayerHP(root, 0);                
                        else
                            cs.setPlayerHP(root, a.getHp());
         
                        if(a.getHp()<=0){
                            a.setFainted();
                            cs.rectangle(root);
                            instruction=a.getName()+" is fainted";
                            cs.setInstruction(root, instruction);
                            accA=0;
                            opponentAttack.stop();
                            combatScene.setOnKeyPressed(
                        new EventHandler<KeyEvent>(){
                        public void handle(KeyEvent event) {
                            KeyCode kc = event.getCode();
                            switch(kc){
                                case Z:
                                    playMusic("click.mp3");
                                    opponentAttack.stop();
                                    ia.setAllFainted();
                                    if(ia.allFainted())                        
                                        end.start();
                                    else 
                                        selectPokemon1.start();

                                    break;                      
                            }
                        }
                            }
                );    
                        }
                        
                        else{
                        while(!(accA>=100 || accB>=100)){
                            accA+=a.getSpd();
                            accB+=b.getSpd();
                        }
                        opponentAttack.stop();
                        combatScene.setOnKeyPressed(
                        new EventHandler<KeyEvent>(){
                        public void handle(KeyEvent event) {
                            KeyCode kc = event.getCode();
                            switch(kc){
                                case Z:                 
                                    playMusic("click.mp3");
                                    opponentAttack.stop();
                                    if(accA>=100 && accA>accB){
                                        accA-=100;
                                        selectPokemon.start();
                                    }
                                    else{
                                        accB-=100;
                                        if(b.getHp()<=15 && !b.getSwitchedOnce()){
                                            opponentChoosePokemon.start();
                                            b.setSwitchedOnce();
                                        }
                                        else
                                            opponentAttack.start();
                                    }
                                    break;     



                            }

                        }
                            }
                );    
                        }
                            }            
        };       
       
        //player Attack
        playerAttack=new AnimationTimer()
        {
        public void handle(long currentNanoTime)
        {
            double t = (currentNanoTime - startNanoTime) / 1000000000.0; 
                root.getChildren().clear();
                
                cs.init(root);
                //show Pokemon Image
                cs.setPlayerName(root, a.getName());
                cs.setOpponentName(root, b.getName());
                cs.addPlayerPokemon(root, a.getBack());
                cs.addOpponentPokemon(root, b.getFront());
                cs.rectangle(root);
                //accuracy
                int miss=random.nextInt(100)+1;                
                if(miss<=a.getSkillAcc(skillNum)){
                hpB=b.getHp()-damage(a,b,skillNum);
                //show text box
                //show skill used
                instruction=a.getName()+" used "+a.getSkillName(skillNum);
                cs.setInstruction(root, instruction);
                playerAttack.stop();
                if(counter){
                    cs.rectangle(root);
                    instruction=a.getName()+" used "+a.getSkillName(skillNum)+"\nIt is very effective!";
                    cs.setInstruction(root, instruction);
                }
                else if(countered){
                    cs.rectangle(root);
                    instruction=a.getName()+" used "+a.getSkillName(skillNum)+"\nIt is not very effective...";
                    cs.setInstruction(root, instruction);
                }
                counter=false;
                countered=false;
                
                //play attack sound
                playMusic("attack.mp3");
                }
                else{
                    // miss
                    hpB=b.getHp();
                    instruction=a.getName()+" missed";
                    cs.setInstruction(root, instruction);
                }

                //update hp
                b.setHp(hpB);

                //show hp
                cs.setPlayerHP(root, a.getHp());
                //wont show negative number if fainted
                if(b.getHp()<=0)
                    cs.setOpponentHP(root, 0);
                else
                    cs.setOpponentHP(root,b.getHp());
                
                
                //Fainted
                if(b.getHp()<=0){
                    b.setFainted();
                    cs.rectangle(root);
                    //show pokemon fainted
                    instruction=b.getName()+" is fainted";
                    cs.setInstruction(root, instruction);
                    //accumulator bcome 0 after fainted
                    accB=0;
                    //prevent continuos attack
                    playerAttack.stop();
                    //Key setting
                    combatScene.setOnKeyPressed(
                new EventHandler<KeyEvent>(){
                public void handle(KeyEvent event) {
                    KeyCode kc = event.getCode();
                    switch(kc){
                        case Z:
                            playerAttack.stop();
                            playMusic("click.mp3");
                            //check all fainted
                            ib.setAllFainted();
                            if(ib.allFainted())
                                end.start();
                            else
                                opponentChoosePokemon.start();
                            break;                      
                    }
                }
                    }
        );    
                }
                else{
                    //run accumulator
                while(!(accA>=100 || accB>=100)){
                    accA+=a.getSpd();
                    accB+=b.getSpd();
                }
                playerAttack.stop();
                //key setting
                combatScene.setOnKeyPressed(
                new EventHandler<KeyEvent>(){
                public void handle(KeyEvent event){
                    KeyCode kc = event.getCode();
                    switch(kc){
                        case Z:
                            playerAttack.stop();
                            playMusic("click.mp3");
                            if(accA>=100 && accA>accB){
                                accA-=100;
                                selectPokemon.start();
                            }
                            else{
                                accB-=100;
                                if(b.getHp()<=15 && !b.getSwitchedOnce()){
                                    opponentChoosePokemon.start();
                                    b.setSwitchedOnce();
                                }
                                else
                                    opponentAttack.start();
                            }
                            break;  

                            
                    }

                }
                    }
        );    
                }
                    }            
};       

 
        //player Choose Skill        
        selectSkill=new AnimationTimer()
    {
        public void handle(long currentNanoTime)
        {
            double t = (currentNanoTime - startNanoTime) / 1000000000.0; 
     
            cs.rectangle(root);
            cs.setPlayerHP(root, a.getHp());
            cs.setOpponentHP(root,b.getHp());
            cs.displaySkill(root, a);
            instruction="What skill will "+a.getName()+"\nuse?";
            cs.setInstruction(root, instruction);    
            
        root.getChildren().add(cursor.viewImage());
        combatScene.setOnKeyPressed(
                new EventHandler<KeyEvent>(){
                public void handle(KeyEvent event) {
                    KeyCode kc = event.getCode();
                    switch(kc){
                        case UP :                            
                            playMusic("click.mp3");
                            if(cursor.getY()==365){
                                cursor.setPosition(cursor.getX(),330);
                            }
                            else{
                                cursor.setPosition(cursor.getX(),cursor.getY());
                            }
                            break;
                        case DOWN :
                            playMusic("click.mp3");
                            if(cursor.getY()==330){
                                cursor.setPosition(cursor.getX(),365);
                            }
                            else{
                                cursor.setPosition(cursor.getX(),cursor.getY());
                            }
                            
                            break;
                        case LEFT :
                            playMusic("click.mp3");
                            if(cursor.getX()==300){
                                cursor.setPosition(200,cursor.getY());
                            }
                            else{
                                cursor.setPosition(cursor.getX(),cursor.getY());
                            }
                            
                            break;
                        case RIGHT :
                            playMusic("click.mp3");
                            if(cursor.getX()==200){
                                cursor.setPosition(300,cursor.getY());
                            }
                            else{
                                cursor.setPosition(cursor.getX(),cursor.getY());
                            }
                            
                            break;
                        case Z:
                            playMusic("click.mp3");
                            if(cursor.getX()==200 && cursor.getY() ==330)
                                skillNum=0;
                            else if(cursor.getX()==300 && cursor.getY()==330)
                                skillNum=1;
                            else if(cursor.getX()==200 && cursor.getY()==365)
                                skillNum=2;
                            else if(cursor.getX()==300 && cursor.getY()==365)
                                skillNum=3;
                            selectSkill.stop();
                            playerAttack.start();
                            break;
                        case X:
                            playMusic("click.mp3");
                            selectSkill.stop();
                            selectPokemon.start();
                         

                            
                    }

                }
                    }
        );    
        

    }            
} ;      

        //Chose Pokemon
        selectPokemon1=new AnimationTimer()
    {
        public void handle(long currentNanoTime)
        {
            double t = (currentNanoTime - startNanoTime) / 1000000000.0; 
                root.getChildren().clear();
                cs.init(root);
                cs.setOpponentName(root, b.getName());
                cs.addOpponentPokemon(root, b.getFront());
                cs.setOpponentHP(root, b.getHp());
                cs.rectangle(root);
                cs.displayPokemon(root, ia);
                root.getChildren().add(cursor2.viewImage());
                combatScene.setOnKeyPressed(
                new EventHandler<KeyEvent>(){
                public void handle(KeyEvent event) {
                    KeyCode kc = event.getCode();
                    switch(kc){
//                        case UP :                            
//                           
//                            if(cursor2.getY()==365){
//                                cursor2.setPosition(cursor2.getX(),330);
//                            }
//
//                            break;
//                        case DOWN :
//                            if(cursor2.getY()==330){
//                                cursor2.setPosition(cursor2.getX(),365);
//                            }
//                            break;
                        case LEFT:
                            playMusic("click.mp3");
                            if(cursor2.getX()==200)
                                cursor2.setPosition(100, cursor2.getY());
                            else if(cursor2.getX()==300)
                                cursor2.setPosition(200, cursor2.getY());
                           
                            break;
                        case RIGHT:
                            playMusic("click.mp3");
                            if(cursor2.getX()==200)
                                cursor2.setPosition(300, cursor2.getY());
                            else if(cursor2.getX()==100)
                                cursor2.setPosition(200, cursor2.getY());

                            break;
                        case Z:
                            playMusic("click.mp3");
                            if(cursor2.getY()==330){
                                if(cursor2.getX()==100)
                                    pokemonNum=0;
                                else if(cursor2.getX()==200)
                                    pokemonNum=1;
                                else if(cursor2.getX()==300)
                                    pokemonNum=2;
                            }
//                            else if(cursor2.getY()==365){
//                                if(cursor2.getX()==100)
//                                    pokemonNum=3;
//                                else if(cursor2.getX()==200)
//                                    pokemonNum=4;
//                                else if(cursor2.getX()==300)
//                                    pokemonNum=5;
//                            }
                            selectPokemon1.stop();
                            switchtoPokemon.start();
                            break;
                        case X:
                            playMusic("click.mp3");
                            selectPokemon1.stop();
                            selectPokemon.start();

                            
                    }

                }
                    }
        );    
                }            
};

        //Choose Pokemon
        selectPokemon=new AnimationTimer()
    {
        public void handle(long currentNanoTime)
        {
            double t = (currentNanoTime - startNanoTime) / 1000000000.0; 
                root.getChildren().clear();
                cs.init(root);
                cs.setPlayerName(root, a.getName());
                cs.setOpponentName(root, b.getName());
                cs.addPlayerPokemon(root, a.getBack());
                cs.addOpponentPokemon(root, b.getFront());
                cs.setPlayerHP(root, a.getHp());
                cs.setOpponentHP(root, b.getHp());
                cs.rectangle(root);
                instruction="Do you want to choose Pokemon?";
                cs.setInstruction(root, instruction);
                cs.yesNo(root);
                root.getChildren().add(cursor1.viewImage());
                combatScene.setOnKeyPressed(
                new EventHandler<KeyEvent>(){
                public void handle(KeyEvent event) {
                    KeyCode kc = event.getCode();
                    switch(kc){
                        case UP :                            
                           playMusic("click.mp3");
                            if(cursor1.getY()==365){
                                cursor1.setPosition(cursor1.getX(),330);
                            }

                            break;
                        case DOWN :
                            playMusic("click.mp3");
                            if(cursor1.getY()==330){
                                cursor1.setPosition(cursor1.getX(),365);
                            }
                            
                            break;
                        case Z:
                            playMusic("click.mp3");
                            if(cursor1.getY()==330){
                                selectPokemon.stop();
                                selectPokemon1.start();
                            }
                            else if(cursor1.getY()==365){
                                selectPokemon.stop();
                                selectSkill.start();
                            }                                                    
                            break;
                            

                            
                    }

                }
                    }
        );    
                    }            
};

choosePokemon.start();







                   
            


 

     stage.show();

        
       

        return combatScene;
    }
    

}
