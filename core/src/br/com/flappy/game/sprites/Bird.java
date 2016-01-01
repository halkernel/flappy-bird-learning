package br.com.flappy.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

import br.com.flappy.game.FlappyLearningGame;

/**
 * Created by halkernel on 12/30/15.
 */
public class Bird {
    private static final int GRAVITY = -45;
    private static final int MOVEMENT = 100;

    private Vector3 position;
    private Vector3 velocity;
    private Texture bird;
    private Rectangle bounds;

    public Bird(int x, int y) {
        this.position = new Vector3(x,y,0);
        this.velocity = new Vector3(0,0,0);
        this.bird = new Texture("bird.png");
        this.bounds = new Rectangle(x,y,this.bird.getWidth(), this.bird.getHeight());
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
        bounds.setPosition(position.x,position.y);
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

    public Rectangle getBounds(){
        return  this.bounds;
    }

    public void dispose(){
        bird.dispose();
    }
}
