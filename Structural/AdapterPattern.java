// Adapter pattern is used to provide a bridge between two incompatible interfaces. 
// This pattern involves a single class called adapter which is responsible for 
// joining functionalities of independent or incompatible interfaces. 

// A real-life example could be a case of card reader which acts as an adapter between memory card and a laptop. 
// You plugin the memory card into card reader and card reader into the laptop so that memory card can be read via laptop.

// In this example, we have an AudioPlayer class that plays audio files.
// We have a MediaPlayer interface that provides the functionality to play audio files.
// We have an AdvancedMediaPlayer interface that provides the functionality to play VLC and MP4 files.
// We have Mp3Player, VlcPlayer, and Mp4Player classes that implement the MediaPlayer and AdvancedMediaPlayer interfaces.

// Here, the AudioPlayer class is the adapter that plays audio files using the MediaPlayer interface.
// If the audio file is in VLC or MP4 format, the AudioPlayer class uses the MediaAdapter class to play the file.

package Structural;

// Here, MediaPlayer is an interface that provides the functionality to play audio files.
interface MediaPlayer {
    void play(String audioType, String fileName);
}

// Mp3Player is a class that implements the MediaPlayer interface and plays MP3
// files.
class Mp3Player implements MediaPlayer {
    public void play(String audioType, String fileName) {
        System.out.println("Playing MP3 file: " + fileName);
    }
}

// MediaAdapter is a class that implements the MediaPlayer interface and plays
// VLC and MP4 files.
class MediaAdapter implements MediaPlayer {
    private AdvancedMediaPlayer advancedMediaPlayer;

    public MediaAdapter(String audioType) {
        if (audioType.equalsIgnoreCase("vlc")) {
            advancedMediaPlayer = new VlcPlayer();
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advancedMediaPlayer = new Mp4Player();
        }
    }

    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("vlc")) {
            advancedMediaPlayer.playVlc(fileName);
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advancedMediaPlayer.playMp4(fileName);
        }
    }
}

// AdvancedMediaPlayer is an interface that provides the functionality to play
// VLC and MP4 files.
interface AdvancedMediaPlayer {
    void playVlc(String fileName);

    void playMp4(String fileName);
}

// VlcPlayer is a class that implements the AdvancedMediaPlayer interface and
// plays VLC files.
class VlcPlayer implements AdvancedMediaPlayer {
    public void playVlc(String fileName) {
        System.out.println("Playing VLC file: " + fileName);
    }

    public void playMp4(String fileName) {
    }
}

// Mp4Player is a class that implements the AdvancedMediaPlayer interface and
// plays MP4 files.
class Mp4Player implements AdvancedMediaPlayer {
    public void playVlc(String fileName) {
    }

    public void playMp4(String fileName) {
        System.out.println("Playing MP4 file: " + fileName);
    }
}

// AudioPlayer is a class that implements the MediaPlayer interface and plays
// audio files.
class AudioPlayer implements MediaPlayer {
    private MediaAdapter mediaAdapter;

    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("mp3")) {
            System.out.println("Playing MP3 file: " + fileName);
        } else if (audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")) {
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        } else {
            System.out.println("Invalid media format: " + audioType);
        }
    }
}

public class AdapterPattern {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play("mp3", "song.mp3");
        audioPlayer.play("mp4", "video.mp4");
        audioPlayer.play("vlc", "movie.vlc");
    }
}
