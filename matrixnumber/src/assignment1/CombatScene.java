/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;

import java.io.FileNotFoundException;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author Yeoh Hong Jing
 */
public class CombatScene {
    private StackPane stack=new StackPane();
        public Text setInstruction(Group root, String a){
            Label label=new Label();
            label.setText(a);
            label.setTranslateX(13);
            label.setTranslateY(350);
            label.setMinSize(200, 30);
            label.setFont(Font.font("Pixelated",16));
            Text instruction =new Text(10,360,a);
            instruction.setFont(Font.font("Pixelated", 15));
            root.getChildren().add(label);
            return instruction;
        }

        public void choosePokemon(Group root) throws FileNotFoundException{
            FileInput fi=new FileInput();
            int k=0;
            double x=100;
            double y=50;
            for(int i=0;i<3;i++){
                for(int j=0;j<2;j++){
                    Text pokemon =new Text(x,y,fi.getPokemon(k).getName());
                    x+=200;
                    k++;
                    pokemon.setFont(Font.font("Pixelated",20));
                    root.getChildren().add(pokemon);
                }
                x=100;
                y+=100;
            }
            ImageView poke1=new ImageView("file:images\\bulbasaur.gif");
            poke1.setTranslateX(40);
            poke1.setTranslateY(25);
            poke1.setFitHeight(60);
            poke1.setFitWidth(60);
            poke1.setPreserveRatio(true);
            ImageView poke2=new ImageView("file:images\\charmander.gif");
            poke2.setTranslateX(240);
            poke2.setTranslateY(25);
            poke2.setFitHeight(60);
            poke2.setFitWidth(60);
            poke2.setPreserveRatio(true);
            ImageView poke3=new ImageView("file:images\\squirtle.gif");
            poke3.setTranslateX(40);
            poke3.setTranslateY(125);
            poke3.setFitHeight(60);
            poke3.setFitWidth(60);
            poke3.setPreserveRatio(true);
            ImageView poke4=new ImageView("file:images\\chikorita.gif");
            poke4.setTranslateX(240);
            poke4.setTranslateY(125);
            poke4.setFitHeight(60);
            poke4.setFitWidth(60);
            poke4.setPreserveRatio(true);
            ImageView poke5=new ImageView("file:images\\cyndaquil.gif");
            poke5.setTranslateX(40);
            poke5.setTranslateY(225);
            poke5.setFitHeight(60);
            poke5.setFitWidth(60);
            poke5.setPreserveRatio(true);
            ImageView poke6=new ImageView("file:images\\totodile.gif");
            poke6.setTranslateX(240);
            poke6.setTranslateY(225);
            poke6.setFitHeight(60);
            poke6.setFitWidth(60);
            poke6.setPreserveRatio(true);
            root.getChildren().add(poke1);
            root.getChildren().add(poke2);
            root.getChildren().add(poke3);
            root.getChildren().add(poke4);
            root.getChildren().add(poke5);
            root.getChildren().add(poke6);
        }
        
             public void choosePokemon1(Group root) throws FileNotFoundException{
            FileInput fi=new FileInput();
            int k=6;
            double x=100;
            double y=50;
            for(int i=0;i<3;i++){
                for(int j=0;j<2;j++){
                    Text pokemon =new Text(x,y,fi.getPokemon(k).getName());
                    x+=200;
                    k++;
                    pokemon.setFont(Font.font("Pixelated",20));
                    root.getChildren().add(pokemon);
                }
                x=100;
                y+=100;
            }
            ImageView poke1=new ImageView("file:images\\turtwig.gif");
            poke1.setTranslateX(40);
            poke1.setTranslateY(25);
            poke1.setFitHeight(60);
            poke1.setFitWidth(60);
            poke1.setPreserveRatio(true);
            ImageView poke2=new ImageView("file:images\\chimchar.gif");
            poke2.setTranslateX(240);
            poke2.setTranslateY(25);
            poke2.setFitHeight(60);
            poke2.setFitWidth(60);
            poke2.setPreserveRatio(true);
            ImageView poke3=new ImageView("file:images\\piplup.gif");
            poke3.setTranslateX(40);
            poke3.setTranslateY(125);
            poke3.setFitHeight(60);
            poke3.setFitWidth(60);
            poke3.setPreserveRatio(true);
            ImageView poke4=new ImageView("file:images\\snivy.gif");
            poke4.setTranslateX(240);
            poke4.setTranslateY(125);
            poke4.setFitHeight(60);
            poke4.setFitWidth(60);
            poke4.setPreserveRatio(true);
            ImageView poke5=new ImageView("file:images\\tepig.gif");
            poke5.setTranslateX(40);
            poke5.setTranslateY(225);
            poke5.setFitHeight(60);
            poke5.setFitWidth(60);
            poke5.setPreserveRatio(true);
            ImageView poke6=new ImageView("file:images\\oshawott.gif");
            poke6.setTranslateX(240);
            poke6.setTranslateY(225);
            poke6.setFitHeight(60);
            poke6.setFitWidth(60);
            poke6.setPreserveRatio(true);
            root.getChildren().add(poke1);
            root.getChildren().add(poke2);
            root.getChildren().add(poke3);
            root.getChildren().add(poke4);
            root.getChildren().add(poke5);
            root.getChildren().add(poke6);
            
        }
        public void bigRec(Group root){
            Rectangle rec=new Rectangle();
            rec.setWidth(400);
            rec.setHeight(400);
            rec.setX(0);
            rec.setY(0);
            rec.setFill(Color.WHITE);
            root.getChildren().add(rec);
        }
	public Text setPlayerHP(Group root, int playerHP) {
		Text myPlayerHP = new Text(250, 300, Integer.toString(playerHP) + " HP");
		myPlayerHP.setFont(Font.font("Pixelated", 20));
		root.getChildren().add(myPlayerHP);
		return myPlayerHP;
	}
        public void setPlayerName(Group root, String name){
            Text myName=new Text(250,275,name);
            myName.setFont(Font.font("Pixelated",30));
            root.getChildren().add(myName);
            
        }
        public void setOpponentName(Group root, String name){
            Text myName=new Text(40,30,name);
            myName.setFont(Font.font("Pixelated",30));
            root.getChildren().add(myName);
            
        }
	public Text setOpponentHP(Group root, int opponentHP) {
		Text myOpponentHP = new Text(40, 55, Integer.toString(opponentHP) + " HP");
		myOpponentHP.setFont(Font.font("Pixelated", 20));
		root.getChildren().add(myOpponentHP);
		return myOpponentHP;
	}
        public void rectangle(Group root){
            Image chatBox=new Image("file:images\\chatBox.png");
            ImageView rec=new ImageView(chatBox);
            rec.setFitWidth(415);
            rec.setFitHeight(80);
            rec.setX(0);
            rec.setY(330);
            root.getChildren().add(rec);
        }

	public void addOpponentPokemon(Group root,Image image) {
		Image NPCPokemonImage = image;
		ImageView NPCPokemon = new ImageView(NPCPokemonImage);
		NPCPokemon.setFitHeight(140);
		NPCPokemon.setFitWidth(140);
		NPCPokemon.setPreserveRatio(true);
		NPCPokemon.setX(250.0); // x position of Pokemon relative to window
		NPCPokemon.setY(40.0); // y position of Pokemon relative to window
		root.getChildren().add(NPCPokemon);
	}

	public void addPlayerPokemon(Group root,Image image) {
		Image userPokemonImage =image;
		ImageView userPokemon = new ImageView(userPokemonImage);
		userPokemon.setFitHeight(180);
		userPokemon.setFitWidth(180);
		userPokemon.setPreserveRatio(true);
		userPokemon.setX(20.0); // x position of Pokemon relative to window
		userPokemon.setY(150.0); // y position of Pokemon relative to window
		root.getChildren().add(userPokemon);
	}

        public void yesNo(Group root){
            Text yes=new Text(345,350,"Yes");
            Text no=new Text(345,385,"No");
            yes.setFont(Font.font("Pixelated",15));
            no.setFont(Font.font("Pixelated",15));
            root.getChildren().add(yes);
            root.getChildren().add(no);
        }
	private void setBattleBackground(Group root) {
		Image battleImage = new Image("file:battle.png");
		ImageView battleScene = new ImageView(battleImage);
		battleScene.setFitHeight(330);
		battleScene.setFitWidth(450);
		battleScene.setX(-30.0); // x position of background relative to window
		root.getChildren().add(battleScene);
	}
        public void displayPokemon(Group root, Inventory ia){
            Text poke1=new Text(125,350,ia.getChosenPokemon(0).getName());
            Text poke2=new Text(225,350,ia.getChosenPokemon(1).getName());
            Text poke3=new Text(325,350,ia.getChosenPokemon(2).getName());
//            Text poke4=new Text(100,385,ia.getChosenPokemon(3).getName());
//            Text poke5=new Text(200,385,ia.getChosenPokemon(4).getName());
//            Text poke6=new Text(300,385,ia.getChosenPokemon(5).getName());
            poke1.setFont(Font.font("Pixelated",15));
            poke2.setFont(Font.font("Pixelated",15));
            poke3.setFont(Font.font("Pixelated",15));
            root.getChildren().add(poke1);
            root.getChildren().add(poke2);
            root.getChildren().add(poke3);
//            root.getChildren().add(poke4);
//            root.getChildren().add(poke5);
//            root.getChildren().add(poke6);
            
        }
        public void displaySkill(Group root, Pokemon a){
    Text skill1=new Text(225,350,a.getSkillName(0));
    Text skill2=new Text(325,350,a.getSkillName(1));
    Text skill3=new Text(225,385,a.getSkillName(2));
    Text skill4=new Text(325,385,a.getSkillName(3));
    skill1.setFont(Font.font("Pixelated",15));
    skill2.setFont(Font.font("Pixelated",15));
    skill3.setFont(Font.font("Pixelated",15));
    skill4.setFont(Font.font("Pixelated",15));
    root.getChildren().add(skill1);
    root.getChildren().add(skill2);
    root.getChildren().add(skill3);
    root.getChildren().add(skill4);
}


	public void init(Group root) {
		setBattleBackground(root);
	}
}
