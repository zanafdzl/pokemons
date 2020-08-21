/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pokemon;

import java.io.FileNotFoundException;

/**
 *
 * @author Yeoh Hong Jing
 */
public class Inventory {
    private boolean allFainted=true;
    Pokemon [] pokemon=new Pokemon[6];
    public Inventory(String[]pokemon) throws FileNotFoundException{
        FileInput fi=new FileInput();
        for(int i=0;i<6;i++){
            switch(pokemon[i].toLowerCase()){
                case "bulbasaur":
                    this.pokemon[i]=fi.getPokemon(0);
                    break;
                case "charmander":
                    this.pokemon[i]=fi.getPokemon(1);
                    break;
                case "squirtle":
                    this.pokemon[i]=fi.getPokemon(2);
                    break;
                case "chikorita":
                    this.pokemon[i]=fi.getPokemon(3);
                    break;
                case "cyndaquil":
                    this.pokemon[i]=fi.getPokemon(4);
                    break;
                case "totodile":
                    this.pokemon[i]=fi.getPokemon(5);
                    break;
                case "turtwig":
                    this.pokemon[i]=fi.getPokemon(6);
                    break;
                case "chimchar":
                    this.pokemon[i]=fi.getPokemon(7);
                    break;
                case "piplup":
                    this.pokemon[i]=fi.getPokemon(8);
                    break;
                case "snivy":
                    this.pokemon[i]=fi.getPokemon(9);
                    break;
                case "tepig":
                    this.pokemon[i]=fi.getPokemon(10);
                    break;
                case "oshawott":
                    this.pokemon[i]=fi.getPokemon(11);
                    break;
                    
                    
                    
            }
        }
    }
    public Pokemon getChosenPokemon(int i){
        return pokemon[i];
    }
    public void displayInventoryPokemon(){
        for(int i=0;i<6;i++){
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
        for(int i=0;i<6;i++){
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
