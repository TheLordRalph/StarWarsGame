package com.raul.dam;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class HelloWorldGame extends Game {

    // Statics Finals
    protected static final int WIDTH = 800;
    protected static final int HEIGHT = 480;
    protected static final float TERREIN_SPEED_PPS = 200f;
    protected static final float BACKGROUND_SPEED_PPS = 20f;
    protected static final float PLANE_TAP_VELOCITY = 300f;
    protected static final int TURBOLASER_DISTANCE_RANGE = WIDTH/2;
    protected static final int MIN_TURBOLASER_DISTANCE = WIDTH/2;
    protected static final float NEW_TURBOLASER_POSITION_THRESHOLD = WIDTH/2f;

    SpriteBatch batch;
    public BitmapFont fontGame;
    public BitmapFont fontIntro1;
    public BitmapFont fontIntro2;

    // FileHandle
    protected FileHandle fileTime;
    protected FileHandle filePuntos;

    //Music
    protected Music introStarWars;
    protected Music musicGame;
    protected Music muerte;

    @Override
    public void create () {
        // Batch
        batch = new SpriteBatch();
        fontGame = new BitmapFont(Gdx.files.internal("fonts/fontGame.fnt"));
        fontIntro1 = new BitmapFont(Gdx.files.internal("fonts/fontIntro1.fnt"));
        fontIntro2 = new BitmapFont(Gdx.files.internal("fonts/fontIntro2.fnt"));

        // FileHandle
        fileTime = new FileHandle("FileTime");
        filePuntos = new FileHandle("FilePuntos");

        setScreen(new TitleScreen(this));
    }

    @Override
    public void dispose () {
        batch.dispose();
        fontGame.dispose();
        fontIntro1.dispose();
        fontIntro2.dispose();
        introStarWars.dispose();
        musicGame.dispose();
        muerte.dispose();
        //creashSound.dispose();
    }
}
