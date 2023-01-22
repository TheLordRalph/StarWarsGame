package com.raul.dam;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.utils.Align;

public class CinematicScreen extends ScreenAdapter {

    HelloWorldGame game;

    private static final float INCREMENTO_VELOCIDAD = 0.5f;

    private GlyphLayout episodio;
    private GlyphLayout titulo;
    private GlyphLayout parrafo1;
    private GlyphLayout parrafo2;
    private GlyphLayout parrafo3;

    private GlyphLayout start;
    private float tiempo = 3;

    private float velocidad = -20;

    public CinematicScreen(HelloWorldGame game) {
        this.game = game;
    }

    @Override
    public void show(){

        game.introStarWars = Gdx.audio.newMusic(Gdx.files.internal("sound/StarWarsIntro.mp3"));

        game.fontIntro2.getData().setScale(1f);
        episodio = new GlyphLayout(game.fontIntro2, "Episodio XXX", game.fontIntro2.getColor(), game.WIDTH/2, Align.center, true);
        game.fontIntro2.getData().setScale(1.5f);
        titulo = new GlyphLayout(game.fontIntro2, "Disney Contraataca", game.fontIntro2.getColor(), game.WIDTH/2, Align.center, true);
        game.fontIntro2.getData().setScale(0.8f);
        parrafo1 = new GlyphLayout(game.fontIntro2, "El gran y temido Disney continua su imperio robando nuestro Dinero y haciendose cada vez mas grande en esta Galaxia, pero no por mucho tiempo.", game.fontIntro2.getColor(), game.WIDTH/2, Align.center, true);
        parrafo2 = new GlyphLayout(game.fontIntro2, "Una resistencia de Desarrolladores se hace fuerte para destruir a Disney y acabar con su cutre contenido y asi salvar la galaxia.", game.fontIntro2.getColor(), game.WIDTH/2, Align.center, true);
        parrafo3 = new GlyphLayout(game.fontIntro2, "Como no Disney ha creado una Estrella de la Muerte, por quintuple vez. Conseguiras superar este obstaculo y liberar a la Galaxia del yugo de Disney", game.fontIntro2.getColor(), game.WIDTH/2, Align.center, true);

        start = new GlyphLayout(game.fontIntro2, "Pulsa cualquier tecla para empezar", game.fontIntro2.getColor(), game.WIDTH/2, Align.center, true);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        game.introStarWars.play();

        velocidad += INCREMENTO_VELOCIDAD;

        game.fontIntro2.draw(game.batch, episodio, game.WIDTH/6,  velocidad);
        game.fontIntro2.draw(game.batch, titulo, game.WIDTH/6,  velocidad-episodio.height*2);
        game.fontIntro2.draw(game.batch, parrafo1, game.WIDTH/6,  velocidad-episodio.height*2-titulo.height*2);
        game.fontIntro2.draw(game.batch, parrafo2, game.WIDTH/6,  velocidad-episodio.height*2-titulo.height*2-parrafo1.height-30);
        game.fontIntro2.draw(game.batch, parrafo3, game.WIDTH/6,  velocidad-episodio.height*2-titulo.height*2-parrafo1.height-parrafo2.height-60);

        if (velocidad > game.HEIGHT+episodio.height*2+titulo.height*2+parrafo1.height+parrafo2.height+parrafo3.height+60) {
            game.fontIntro2.draw(game.batch, start, game.WIDTH/6,  game.HEIGHT/6);
        }

        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean keyDown(int keyCode) {
                game.introStarWars.stop();
                game.setScreen(new ThrustcopterGame(game));
                return true;
            }
        });

        game.batch.end();
    }

    @Override
    public void hide(){
        Gdx.input.setInputProcessor(null);
    }
}
