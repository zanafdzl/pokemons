/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pokemon;

import Pokemon.FileInput;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Yeoh Hong Jing
 */
public class ChoosePokemon {
    public String[] choosePokemon(String[] pokemonChosenB) throws FileNotFoundException{
        FileInput fi=new FileInput();
        Scanner s=new Scanner(System.in);
        String[]pokemonName=new String[12];
        for(int i=0;i<12;i++){
            pokemonName[i]=fi.getPokemon(i).getName();
        }
        for(int i=0;i<12;i++){
            System.out.print(pokemonName[i]+" ");
        }
        System.out.println("");
        System.out.println("Choose 6 Pokemon");
        String input;
        String[]pokemonChosenA=new String[6];
        int pokemonNum=0;
        boolean repeat=false;
        boolean gotThisPokemon=false;
        for(int i=0;pokemonNum<6;i++){
            input=s.nextLine();
            for(int k=0;k<12;k++){
                    if(input.equalsIgnoreCase(pokemonName[k])){
                        gotThisPokemon=true;
                        break;
                    }
                    
                }
            if(gotThisPokemon==false){
                System.out.println("No such Pokemon");
                continue;
            }
            gotThisPokemon=false;
            pokemonChosenA[pokemonNum]=input;
            for(int j=0;j<pokemonNum;j++){
                
                if(pokemonChosenA[pokemonNum].equalsIgnoreCase(pokemonChosenA[j])){
                    System.out.println("This pokemon is already chosen. Please choose another Pokemon");
                    repeat=true;
                    break;
                }
                
            }
            for(int j=0;j<6;j++){
                if(pokemonChosenA[pokemonNum].equalsIgnoreCase(pokemonChosenB[j])){
                    System.out.println("This pokemon is already chosen by another team. Please choose another Pokemon");
                    repeat=true;
                    break;
                }
            }
            if(repeat==false){
                System.out.println("You have chose "+pokemonChosenA[pokemonNum]);
                pokemonNum++;
            }
            repeat=false;
        }
        return pokemonChosenA;
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
             for(int j=0;j<6;j++){
                if(pokemonChosenA[pokemonNum].equalsIgnoreCase(pokemonChosenB[j])){
                    repeat=true;
                    break;
                }
            }
            if(repeat==false){
                System.out.println("NPC chose "+pokemonChosenA[pokemonNum]);
                pokemonNum++;
            }
            repeat=false;
        }
        return pokemonChosenA;
    }
}
