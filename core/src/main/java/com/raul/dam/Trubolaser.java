package com.raul.dam;

import com.badlogic.gdx.math.Vector2;

public class Trubolaser {

    private Vector2 position;
    private boolean superado;

    public Trubolaser(Vector2 position) {
        this.position = position;
        this.superado = false;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public boolean isSuperado() {
        return superado;
    }

    public void setSuperado(boolean superado) {
        this.superado = superado;
    }
}
