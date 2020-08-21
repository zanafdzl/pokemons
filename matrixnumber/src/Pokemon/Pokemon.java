/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pokemon;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Yeoh Hong Jing
 */
public class Pokemon {
    private String type,name;
    private int atk,def,hp,spd;
    private boolean isFainted =false;
   
    
    ArrayList <String[]> skills =new ArrayList<>();
    
    public Pokemon(String name, String type, String atk, String def, String hp, String spd) {
           this.name=name;
           this.type=type;
           this.atk=Integer.parseInt(atk);
           this.def=Integer.parseInt(def);
           this.hp=Integer.parseInt(hp);
           this.spd=Integer.parseInt(spd);
    }
    
    public void getSkill(String skillName, String skillType, String power,String accuracy){
        skills.add(new String[]{skillName,skillType,power,accuracy});
    }
    public int getSkillPow(int i){
        String[]skill=getSkillNum(i);
        int pow;
        return pow=Integer.parseInt(skill[2]);
    }
    public int getSkillAcc(int i){
        String[]skill=getSkillNum(i);
        int acc;
        return acc=Integer.parseInt(skill[3]);
    }
    public String getSkillType(int i){
        String[]skill=getSkillNum(i);
        String type;
        return type=skill[1];
    }
    public String getSkillName(int i){
        String[]skill=getSkillNum(i);
        String name;
        return name=skill[0];
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getAtk() {
        return atk;
    }

    public int getDef() {
        return def;
    }

    public int getHp() {
        return hp;
    }

    public int getSpd() {
        return spd;
    }
    public void setHp(int i){
        hp=i;
    }
    public String[] getSkillNum(int i){
        String[]skill;
        skill=skills.get(i);
        return skill;
    }
    public void displaySkill(){
        for(int i=0;i<4;i++){
            System.out.print(i+". ["+getSkillName(i)+"] ");
        }
    
    }
    public void setFainted(){
        isFainted=true;
    }
    public boolean getFainted(){
        return isFainted;
    }
    


    

    
}