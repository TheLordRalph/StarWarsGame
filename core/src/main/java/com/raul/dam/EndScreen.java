package com.raul.dam;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Array;

public class EndScreen extends ScreenAdapter {

    HelloWorldGame game;

    GlyphLayout tiempo;
    GlyphLayout puntos;
    GlyphLayout reinicio;

    public EndScreen(HelloWorldGame game) {
        this.game = game;
    }

    @Override
    public void show() {

        tiempo = new GlyphLayout(game.fontIntro1, String.format("Tiempo transcurrido:  %s", game.fileTime.readString()), game.fontIntro1.getColor(), game.WIDTH/2, Align.center, true);
        puntos = new GlyphLayout(game.fontIntro1, String.format("Puntos Conseguidos:  %s", game.filePuntos.readString()), game.fontIntro1.getColor(), game.WIDTH/2, Align.center, true);
        reinicio = new GlyphLayout(game.fontIntro1, "Pulsa Enter para reiniciar.", game.fontIntro1.getColor(), game.WIDTH/2, Align.center, true);

        Gdx.input.setInputProcessor(new InputAdapter() {

            @Override
            public boolean keyDown(int keyCode) {
                if (keyCode == Input.Keys.ENTER) {
                    game.muerte.stop();
                    game.setScreen(new CinematicScreen(game));
                }
                return true;
            }
        });
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.begin();

        game.fontIntro1.draw(game.batch, tiempo, game.WIDTH/4,  game.HEIGHT-tiempo.height*2);
        game.fontIntro1.draw(game.batch, puntos, game.WIDTH/4,  game.HEIGHT-puntos.height*4);
        game.fontIntro1.draw(game.batch, reinicio, game.WIDTH/4,  reinicio.height);

        game.batch.end();

    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
    }
}
