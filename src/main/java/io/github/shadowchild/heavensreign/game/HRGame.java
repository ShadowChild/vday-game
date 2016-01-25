package io.github.shadowchild.heavensreign.game;


import com.shc.silenceengine.core.Display;
import com.shc.silenceengine.core.Game;
import com.shc.silenceengine.core.SilenceEngine;
import com.shc.silenceengine.graphics.Batcher;
import com.shc.silenceengine.input.Keyboard;
import io.github.shadowchild.heavensreign.handler.ConfigurationHandler;
import io.github.shadowchild.heavensreign.states.InGameState;
import io.github.shadowchild.heavensreign.states.PauseableState;
import io.github.shadowchild.heavensreign.utils.Settings;

import javax.swing.*;

/**
 * Created by Zach Piddock on 16/01/2016.
 */
public class HRGame extends Game {

    public static final int HEIGHT = 768;
    public static final int WIDTH = (HEIGHT * 16) / 9;

    // Initialise this before so that the start method wont resize the display
    public void preInit() {

        Display.setSize(WIDTH, HEIGHT);
        Display.setResizable(Settings.resizable);
        Display.setVSync(Settings.vsync);
        Display.setFullScreen(Settings.fullscreen);
    }

    // Initialize the resources
    public void init() {

        // set the game state
//        setGameState(new TitleScreenState());
        setGameState(new InGameState());
    }

    // Update game logic
    public void update(float delta) {

        if(Keyboard.isClicked(Keyboard.KEY_ESCAPE)) {

            disposeSafely();
        }

        if(Keyboard.isClicked(Keyboard.KEY_INSERT)) ConfigurationHandler.reloadConfig();

        Display.setTitle("UPS: " + Game.getUPS() +
                " | FPS: " + Game.getFPS() +
                " | RC: " + SilenceEngine.graphics.renderCallsPerFrame);
    }

    // Render to screen
    public void render(float delta, Batcher batcher) {

    }

    // Handle window resize event
    public void resize() {

    }

    // Dispose the resources
    public void dispose() {

    }

    public void disposeSafely() {

        int end = JOptionPane.showConfirmDialog(null, "End the game?", "Confirm Close",
                JOptionPane.YES_NO_OPTION
        );
        if(end == 0) Game.end();
    }

    public static PauseableState getGameState() {

        return (PauseableState)Game.getGameState();
    }

    public static void setGameState(PauseableState state) {

        Game.setGameState(state);
    }
}
