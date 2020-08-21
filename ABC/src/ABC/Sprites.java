/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ABC;

import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Yeoh Hong Jing
 */
public class Sprites {
    private Image image;
    private double positionX;
    private double positionY;    
    private double velocityX;
    private double velocityY;
    private double width;
    private double height;

    public Sprites()
    {
        positionX = 0;
        positionY = 0;    
        velocityX = 0;
        velocityY = 0;
    }



    public void setImage(Image i)
    {
        image = i;
    }
    public void setWidth(double width){
        this.width=width;
    }
    public void setHeight(double height){
        this.height=height;
    }



    public void setImage(String filename)
    {
        Image i = new Image(filename);
        setImage(i);
    }


    public double getX(){
        return positionX;
    }
    public double getY(){
        return positionY;
    }
    public void setPosition(double x, double y)
    {
        positionX = x;
        positionY = y;
    }
    public void changePosition(double x,double y){
        positionX=x+positionX;
        positionY=y+positionY;
    }

    public void setVelocity(double x, double y)
    {
        velocityX = x;
        velocityY = y;
    }

    public void addVelocity(double x, double y)
    {
        velocityX += x;
        velocityY += y;
    }

    public void update(double time)
    {
        positionX += velocityX * time;
        positionY += velocityY * time;
    }
    
    public ImageView viewImage(){
        ImageView iv=new ImageView(image);
        iv.setX(positionX);
        iv.setY(positionY);
        iv.setFitHeight(height);
        iv.setFitWidth(width);
        return iv;
    }


    public Bounds getBoundary()
    {
        return new Rectangle((int)positionX,(int)positionY,(int)width,(int)height).getBoundsInLocal();
    }


    public String toString()
    {
        return " Position: [" + positionX + "," + positionY + "]" 
        + " Velocity: [" + velocityX + "," + velocityY + "]";
    }
    }


