/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pokemon;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Yeoh Hong Jing
 */
public class test {
    public static void main(String[]args) throws FileNotFoundException{

        ChoosePokemon p=new ChoosePokemon();
        Scanner s=new Scanner(System.in);
        String[] teamA = new String[6];
        String[] teamB = new String[6];
        teamA=p.choosePokemon(teamB);
        teamB=p.choosePokemonNPC(teamA);
        Inventory inventoryA=new Inventory(teamA);
        Inventory inventoryB=new Inventory(teamB);
        System.out.println("Which Pokemon do you wan to use");
        inventoryA.displayInventoryPokemon();
        int input=s.nextInt();
        Combat bla=new Combat();
        bla.combat(inventoryA.getChosenPokemon(input), inventoryB.getChosenPokemon(input), inventoryA, inventoryB);
        
        
        
        
    }
}
