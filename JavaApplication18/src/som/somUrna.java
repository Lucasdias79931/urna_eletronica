/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package som;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

/**
 *
 * @author Lucas
 */
public class somUrna {
       public void Play (String nomeDoAudio){
        URL url = getClass().getResource(nomeDoAudio+".wav");
        AudioClip audio = Applet.newAudioClip(url);
        audio.play();
    }
}
