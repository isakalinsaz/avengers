package org.game.avengers.helper.utility;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.io.IOException;
import java.io.InputStream;

import static org.game.avengers.constant.GlobalConstant.GAME_SOUND_PATH;

public final class GameSound {

    private AudioStream audioStream;

    public GameSound() {
        InputStream inputStream = GameSound.class.getResourceAsStream(GAME_SOUND_PATH);
        try {
            audioStream = new AudioStream(inputStream);
        } catch (IOException e) {
            System.out.println("Failed. (" + e.getMessage() + ")");
        }
    }

    public void play() {
        AudioPlayer.player.start(audioStream);
    }

    public void stop() {
        if (audioStream != null) {
            AudioPlayer.player.stop(audioStream);
        }
    }
}
