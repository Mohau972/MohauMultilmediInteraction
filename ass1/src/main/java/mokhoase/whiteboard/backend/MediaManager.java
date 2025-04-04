package mokhoase.whiteboard.backend;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MediaManager {
    private MediaPlayer mediaPlayer;

    public void playMusic(String path) {
        Media media = new Media(path);
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
    }

    public void pauseMusic() {
        if (mediaPlayer != null) {
            mediaPlayer.pause();
        }
    }

    public void nextTrack() {
        // Logic for next track (if you have a playlist)
    }

    public void playVideo(String path) {
        // Implement video playback logic here
    }

    public void pauseVideo() {
        // Implement video pause logic here
    }
}