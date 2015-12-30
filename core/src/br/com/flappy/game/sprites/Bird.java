package br.com.flappy.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;

import br.com.flappy.game.FlappyLearningGame;

/**
 * Created by halkernel on 12/30/15.
 */
public class Bird {
    private static final int GRAVITY = -50;
    private static final int MOVEMENT = 100;

    private Vector3 position;
    private Vector3 velocity;
    private Texture bird;

    public Bird(int x, int y) {
        this.position = new Vector3(x,y,0);
        this.velocity = new Vector3(0,0,0);
        this.bird = new Texture("bird.png");
    }

    public void update(float dt){
        if(position.y > 0)
            velocity.add(0,GRAVITY,0);
        velocity.scl(dt);
        position.add(MOVEMENT * dt, velocity.y, 0);
        if(position.y < 0){
            position.y = 0;
        }
        velocity.scl(1/dt);
    }

    public Vector3 getPosition() {
        return position;
    }

    public void setPosition(Vector3 position) {
        this.position = position;
    }

    public Texture getTexture() {
        return bird;
    }

    public void setBird(Texture bird) {
        this.bird = bird;
    }

    public void jump(){
        velocity.y = 620;
    }
}
