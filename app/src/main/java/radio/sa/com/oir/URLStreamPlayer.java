package radio.sa.com.oir;
import android.media.AudioManager;
import android.media.MediaPlayer;

import java.io.IOException;

public class URLStreamPlayer {

    private MediaPlayer mediaPlayer = new MediaPlayer();


    public void URLStreamPlayer(String link){

        if (mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            mediaPlayer.reset();
        }
        else{
            playRadio(link);
        }
    }

    private void playRadio(String url){
        try {
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mediaPlayer.setDataSource(url);
            mediaPlayer.prepare(); // might take long! (for buffering, etc)
            mediaPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
