package com.raul.dam;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.utils.Align;

public class TitleScreen extends ScreenAdapter {

    HelloWorldGame game;

    GlyphLayout title;
    private float timeSeconds;
    private float period = 5;


    public TitleScreen(HelloWorldGame game) {
        this.game = game;
    }

    @Override
    public void show(){
        //game.fontIntro.setColor(Color.BLUE);
        title = new GlyphLayout(game.fontIntro1, "Hace mucho tiempo, en una galaxia muy muy lejana...", game.fontIntro1.getColor(), game.WIDTH/2, Align.center, true);
        game.fontIntro1.getData().setScale(0.7f);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();

        game.fontIntro1.draw(game.batch, title, game.WIDTH/6,  game.HEIGHT/2+title.height/2);

        timeSeconds += Gdx.graphics.getDeltaTime();
        System.out.println(timeSeconds);
        if(timeSeconds > period){
            game.setScreen(new CinematicScreen(game));
        }

        game.batch.end();
    }

    @Override
    public void hide(){
        Gdx.input.setInputProcessor(null);
    }
}
