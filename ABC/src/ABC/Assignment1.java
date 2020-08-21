/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ABC;

import java.io.File;
import java.io.FileNotFoundException;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;


/**
 *
 * @author Yeoh Hong Jing
 */
public class Assignment1 extends Application{
    
    private Scene scene;
    private AnimationTimer choosePokemon;
    public static MediaPlayer myMediaPlayer;
    public static final int SIZE = 400;


    
    private void playMusic(String filename) {
		String musicFile = "music/" + filename;
		Media sound = new Media(new File(musicFile).toURI().toString());
		myMediaPlayer = new MediaPlayer(sound);
		myMediaPlayer.play();
	}

    public void start(Stage primaryStage) throws FileNotFoundException {
        Group root=new Group();
        Combat pc=new Combat(primaryStage);
        Scene bla=pc.init(SIZE,SIZE);
        playMusic("battle.mp3");
        myMediaPlayer.setVolume(0.75);
        primaryStage.setTitle("Pokemon ABC");
        Image icon=new Image("file:images\\icon.png");
        primaryStage.getIcons().add(icon);
        primaryStage.setResizable(false);
        primaryStage.setScene(bla);
        
                }
    public static void main(String[] args) {
        launch(args);
    }   
}
       


       
       
    





