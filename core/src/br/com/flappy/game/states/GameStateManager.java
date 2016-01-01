package br.com.flappy.game.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

/**
 * Created by halkernel on 12/30/15.
 */
public class GameStateManager {
    private Stack<State> states;

    public GameStateManager() {
        this.states = new Stack<State>();
    }
    public void push(State state){
        this.states.push(state);
    }

    public void pop(){
        this.states.pop().dispose();
    }

    public void set(State state){
        this.states.pop();
        this.states.push(state);
    }
    public void update(float dt){
        this.states.peek().update(dt);
    }

    public void render(SpriteBatch sb){
        states.peek().render(sb);
    }

}
