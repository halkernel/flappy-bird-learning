package br.com.flappy.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;


import java.util.Random;

/**
 * Created by halkernel on 12/30/15.
 */
public class Tube {
    public static final int TUBE_WIDTH = 52;
    private static final int FLUCTUATION = 130;
    private static final int TUBE_GAP = 140;
    private static final int LOWEST_OPENING = 120;


    private Texture topTube, bottomTube;
    private Vector2 posTopTube, posBotTube;
    private Rectangle boundsTop, boundsBot;
    private Random rand;

    public Tube(float x) {
        this.topTube = new Texture("toptube.png");
        this.bottomTube = new Texture("bottomtube.png");
        this.rand = new Random();

        this.posTopTube = new Vector2(x, rand.nextInt(FLUCTUATION) + TUBE_GAP + LOWEST_OPENING);
        this.posBotTube = new Vector2(x, posTopTube.y - TUBE_GAP - bottomTube.getHeight());

        this.boundsTop = new Rectangle(posTopTube.x,posTopTube.y, topTube.getWidth(), topTube.getHeight());
        this.boundsBot = new Rectangle(posBotTube.x,posBotTube.y, bottomTube.getWidth(), bottomTube.getHeight());

    }

    public Texture getBottomTube() {
        return bottomTube;
    }

    public Texture getTopTube() {
        return topTube;
    }

    public Vector2 getPosBotTube() {
        return posBotTube;
    }

    public Vector2 getPosTopTube() {
        return posTopTube;
    }

    public void reposition(float x){
        this.posTopTube.set(x,rand.nextInt(FLUCTUATION) + TUBE_GAP + LOWEST_OPENING);
        this.posBotTube.set(x, posTopTube.y - TUBE_GAP - bottomTube.getHeight());
        this.boundsTop.setPosition(posTopTube.x, posTopTube.y);
        this.boundsBot.setPosition(posBotTube.x, posBotTube.y);
    }

    public boolean collides(Rectangle player){
        return player.overlaps(boundsTop) || player.overlaps(boundsBot);
    }

    public void dispose(){
        this.bottomTube.dispose();
        this.topTube.dispose();
    }
}
