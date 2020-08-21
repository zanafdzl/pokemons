/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pokemon;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Yeoh Hong Jing
 */
public class Combat {
    public void combat(Pokemon a,Pokemon b,Inventory ia, Inventory ib)throws ArrayIndexOutOfBoundsException{
        Scanner s=new Scanner(System.in);
        int speedA = a.getSpd(), speedB = b.getSpd(); //speed differs depending on pokemon chosen.
        int accA = 0, accB = 0, hpA = a.getHp(), hpB = b.getHp();
    
        System.out.println("Pokemon A speed: " + speedA);
        System.out.println("Pokemon B speed: " + speedB);
        System.out.println("Speed accumulator for Pokemon A: " + accA);
        System.out.println("Speed accumulator for Pokemon B: " + accB);
        System.out.println("");
    
    do{ System.out.println("Team A pokemon:"+ a.getName()+" HP: "+a.getHp());
        System.out.println("Team B pokemon:"+ b.getName()+" HP: "+b.getHp());
        System.out.println("Speed accumulator for A: " + accA + " + " + a.getSpd() + " = " + (accA + a.getSpd()));
        accA = accA + a.getSpd();
        System.out.println("Speed accumulator for B: " + accB + " + " + b.getSpd() + " = " + (accB + b.getSpd()));
        accB = accB + b.getSpd();
        
        if (accA < 100 && accB < 100)
            System.out.println("No pokemon will attack");
        
        if(accA >= 100){
            String previosPokemon=a.getName();
            char input;
            boolean yes;
            do{
                do{
            System.out.println("Do you want to change Pokemon?: [Y/N]");
            input=s.next().charAt(0);
            if(!(input=='Y'||input=='y'||input=='n'||input=='N')){
                System.out.println("Invalid Input");
            }
                }while(!(input=='Y'||input=='y'||input=='n'||input=='N'));
            if(input=='Y'||input=='y'){
               a=chooseInCombat(a,ia);       
            }
            else{
                a.displaySkill();
                System.out.println("\nWhich move will "+a.getName()+" use? Press any other number to go back");
                int input1=s.nextInt();
                if(input1<0||input1>3){
                    input='Y';
                    continue;
                }
                hpB = b.getHp() - damage(a,b,input1);
                b.setHp(hpB);    //-health(); - class for damage & health (-10 for test only)//decrement health due to hit attack by A depending on damage from type.
                System.out.println("Pokemon A will attack (Speed accumulator for Pokemon A minus 100 because of attacking)");
                if(b.getHp()<=0){
                    b.setFainted();
                    b=npcChooseInCombat(a,b,ib);
                }
            }
            }while(a.getName().equalsIgnoreCase(previosPokemon) && (input!='N'&&input!='n'));
            accA -=100;
        }
        
        if(accB >= 100){
            Random random=new Random();
            hpA = a.getHp()- damage(b,a,random.nextInt(4));
            a.setHp(hpA);//-health(); - class for damage & health (-10 for test only)//decrement health due to hit attack by B depending on damage from type.
            accB -= 100;
            System.out.println("Pokemon B will attack (Speed accumulator for Pokemon B minus 100 because of attacking)");
            if(a.getHp()<=0){
                a.setFainted();
                a=chooseInCombat(a,ia);
            }
        }
        System.out.println("");
        ia.setAllFainted();
        ib.setAllFainted();
    }while(!(ia.allFainted()||ib.allFainted()));
    
    if (hpA ==0)
        System.out.println("Pokemon B wins. \n Enter next Pokemon");
    else
        System.out.println("Pokemon A wins. \n Enter next Pokemon");
        }
    public int damage(Pokemon a,Pokemon b,int skillNum){ //a damage b
        int damage;
        damage = ((a.getAtk() * a.getSkillPow(skillNum) / b.getDef() / 20) + 2);

    //when pokemon A attack B
    if ((a.getType().equalsIgnoreCase("fire")) && (b.getType().equalsIgnoreCase("grass")) || (a.getType().equalsIgnoreCase("grass")) && (b.getType().equalsIgnoreCase("water")) || (a.getType().equalsIgnoreCase("water")) && (b.getType().equalsIgnoreCase("fire"))){
        System.out.println("It is super effective!");
        return damage*=2;
        
    }else if((a.getType().equalsIgnoreCase("fire")) && (b.getType().equalsIgnoreCase("water")) || (a.getType().equalsIgnoreCase("grass")) && (b.getType().equalsIgnoreCase("fire")) || (a.getType().equalsIgnoreCase("water")) && (b.getType().equalsIgnoreCase("grass"))){
        return damage/=2;
              
    }else{
        return damage;
        
    }
    }
    public Pokemon chooseInCombat(Pokemon a,Inventory ia){
        Scanner s=new Scanner(System.in);
        try{
            int input1;
            do{
                   ia.displayInventoryPokemon();  
                   System.out.println("Press any other number to go back");
                   input1=s.nextInt();
                   
                   if(ia.getChosenPokemon(input1).getFainted()){
                       System.out.println("This pokemon is fainted");
                   }
                  
                   if(a.getName().equalsIgnoreCase(ia.getChosenPokemon(input1).getName())){
                       System.out.println("This pokemon is already in battle");
                   }
                   
            }while(a.getName().equalsIgnoreCase(ia.getChosenPokemon(input1).getName()) ||ia.getChosenPokemon(input1).getFainted());
            return ia.getChosenPokemon(input1);

        }catch(ArrayIndexOutOfBoundsException e){
            return a;
        }
    }
    public Pokemon npcChooseInCombat(Pokemon a,Pokemon b,Inventory ib){
//        if(a.getType().equalsIgnoreCase("water")){
            for(int i=0;i<6;i++){
                if(!ib.getChosenPokemon(i).getFainted()){
                    b=ib.getChosenPokemon(i);
                    break;
                }
                else{
                    b=ib.getChosenPokemon(i);
                }
            }
       // }
        return b;
    }
    
    }
    

