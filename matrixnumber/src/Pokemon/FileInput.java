/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pokemon;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Yeoh Hong Jing
 */
public class FileInput {
    Pokemon []pokemons=new Pokemon[12];
    
    public FileInput() throws FileNotFoundException {
        int i=0;
        Scanner s=new Scanner(new FileInputStream("pokemon.txt"));
        while(s.hasNext()){
          pokemons[i]=new Pokemon(s.nextLine(), s.nextLine(), s.nextLine(),s.nextLine(),s.nextLine(),s.nextLine());
          for(int j=0;j<4;j++){
              pokemons[i].getSkill(s.nextLine(), s.nextLine(), s.nextLine(), s.nextLine());
          }
            s.nextLine();
            i++;
        }
    }
    
    public Pokemon getPokemon(int i){
        return pokemons[i];
    }
    public Pokemon[] getPokemonList(){
        return pokemons;
    }

   



}
