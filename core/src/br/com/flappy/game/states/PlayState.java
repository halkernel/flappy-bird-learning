package br.com.flappy.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

import br.com.flappy.game.FlappyLearningGame;
import br.com.flappy.game.sprites.Bird;
import br.com.flappy.game.sprites.Tube;

/**
 * Created by halkernel on 12/30/15.
 */

public class PlayState extends State{
    private static final int TUBE_SPACING = 125;
    private static final int TUBE_COUNT = 5;

    private Bird bird;
    private Texture bg;


    private Array<Tube> tubes;


    protected PlayState(GameStateManager gsm) {
        super(gsm);
        bird = new Bird(50,300);
        cam.setToOrtho(false, FlappyLearningGame.WIDTH /2 , FlappyLearningGame.HEIGHT / 2);
        bg = new Texture("bg.png");
        tubes = new Array<Tube>();

        for (int i = 1; i < TUBE_COUNT; i++) {
            tubes.add(new Tube(i * (TUBE_SPACING + Tube.TUBE_WIDTH)));
        }

    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()){
            bird.jump();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
        bird.update(dt);
        cam.position.x = bird.getPosition().x + 80;

        for(Tube tube: tubes){
            if(cam.position.x - (cam.viewportWidth/2) > tube.getPosTopTube().x + tube.getTopTube().getWidth()){
                tube.reposition(tube.getPosTopTube().x + ((Tube.TUBE_WIDTH + TUBE_SPACING) * (TUBE_COUNT-1)));
            }
            if(tube.collides(bird.getBounds())){
                //this is the pause state
                gsm.set(new PlayState(gsm));
            }
        }

        cam.update();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(bg, cam.position.x - cam.viewportWidth / 2, 0);
        sb.draw(bird.getTexture(), bird.getPosition().x, bird.getPosition().y);
        for (Tube tube : tubes) {
            sb.draw(tube.getTopTube(), tube.getPosTopTube().x, tube.getPosTopTube().y);
            sb.draw(tube.getBottomTube(), tube.getPosBotTube().x, tube.getPosBotTube().y);
        }
        sb.end();
    }

    @Override
    public void dispose() {

    }
}
