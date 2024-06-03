import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.net.URL;

public class Sound {
    Clip clip;
    float pVolume = 0;
    float cVolume = 0;
    FloatControl fc;
    public void setFile(URL url){
        try{
            AudioInputStream sound = AudioSystem.getAudioInputStream(url);
            clip = AudioSystem.getClip();
            clip.open(sound);
            fc = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
        }catch (Exception e){

        }
    }
    public void play(URL url){
        clip.setFramePosition(0);
        clip.start();
    }
    public void loop(URL url){
        clip.loop(clip.LOOP_CONTINUOUSLY);
    }
    public void stop(URL url){
        clip.stop();
    }
    public void setVolume(float volume) {
        if (volume < -1f)
            throw new IllegalArgumentException("Volume not valid: " + volume);
        FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        if(volume<0f){
            gainControl.setValue(gainControl.getMinimum());
        }else {
            gainControl.setValue(20f * (float) Math.log10(volume));
        }

    }

}
