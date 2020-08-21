/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ABC;

import java.io.FileNotFoundException;

/**
 *
 * @author Yeoh Hong Jing
 */
public class Inventory {
    private boolean allFainted=true;
    Pokemon [] pokemon=new Pokemon[3];
    public Inventory(String[]pokemon) throws FileNotFoundException{
        FileInput fi=new FileInput();
        for(int i=0;i<3;i++){
            switch(pokemon[i].toLowerCase()){
                case "bulbasaur":
                    this.pokemon[i]=fi.getPokemon(0);
                    this.pokemon[i].setFrontImage("bulbasaur.gif");
                    this.pokemon[i].setbackImage("bulbasaurBack.gif");
                    break;
                case "charmander":
                    this.pokemon[i]=fi.getPokemon(1);
                    this.pokemon[i].setFrontImage("charmander.gif");
                    this.pokemon[i].setbackImage("charmanderBack.gif");
                    break;
                case "squirtle":
                    this.pokemon[i]=fi.getPokemon(2);
                    this.pokemon[i].setFrontImage("squirtle.gif");
                    this.pokemon[i].setbackImage("squirtleBack.gif");
                    break;
                case "chikorita":
                    this.pokemon[i]=fi.getPokemon(3);
                    this.pokemon[i].setFrontImage("chikorita.gif");
                    this.pokemon[i].setbackImage("chikoritaBack.gif");
                    break;
                case "cyndaquil":
                    this.pokemon[i]=fi.getPokemon(4);
                    this.pokemon[i].setFrontImage("cyndaquil.gif");
                    this.pokemon[i].setbackImage("cyndaquilBack.gif");
                    break;
                case "totodile":
                    this.pokemon[i]=fi.getPokemon(5);
                    this.pokemon[i].setFrontImage("totodile.gif");
                    this.pokemon[i].setbackImage("totodileBack.gif");
                    break;
                case "turtwig":
                    this.pokemon[i]=fi.getPokemon(6);
                    this.pokemon[i].setFrontImage("turtwig.gif");
                    this.pokemon[i].setbackImage("turtwigBack.gif");
                    break;
                case "chimchar":
                    this.pokemon[i]=fi.getPokemon(7);
                    this.pokemon[i].setFrontImage("chimchar.gif");
                    this.pokemon[i].setbackImage("chimcharBack.gif");
                    break;
                case "piplup":
                    this.pokemon[i]=fi.getPokemon(8);
                    this.pokemon[i].setFrontImage("piplup.gif");
                    this.pokemon[i].setbackImage("piplupBack.gif");
                    break;
                case "snivy":
                    this.pokemon[i]=fi.getPokemon(9);
                    this.pokemon[i].setFrontImage("snivy.gif");
                    this.pokemon[i].setbackImage("snivyBack.gif");
                    break;
                case "tepig":
                    this.pokemon[i]=fi.getPokemon(10);
                    this.pokemon[i].setFrontImage("tepig.gif");
                    this.pokemon[i].setbackImage("tepigBack.gif");
                    break;
                case "oshawott":
                    this.pokemon[i]=fi.getPokemon(11);
                    this.pokemon[i].setFrontImage("oshawott.gif");
                    this.pokemon[i].setbackImage("oshawottBack.gif");
                    break;
                    
                    
                    
            }
        }
    }
   
    
    public Pokemon getChosenPokemon(int i){
        return pokemon[i];
    }
    public void displayInventoryPokemon(){
        for(int i=0;i<3;i++){
            if(pokemon[i].getFainted())
                System.out.print(i+". ["+ pokemon[i].getName() + " (Fainted)] ");
            else
                System.out.print(i+". ["+ pokemon[i].getName() + "] ");
        }
    }
    public void setAllFainted(){
        allFainted=true;
    }
    public boolean allFainted(){
        for(int i=0;i<3;i++){
            if(!pokemon[i].getFainted()){
                allFainted=false;
            }
        }
        if(!allFainted)
            return false;
        else
            return true;
            
    }
}
