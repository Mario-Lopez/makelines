package com.mm.tetris.controller.input.action.gameplay;

import com.mm.tetris.controller.NewTetrominoCreator;
import com.mm.tetris.controller.NewTetrominoObserver;
import org.apache.commons.configuration.Configuration;

import javax.inject.Inject;

public class SlowDropAction extends GameplayAction implements NewTetrominoObserver {

    @Inject
    private Configuration config;

    @Inject
    private NewTetrominoCreator newTetrominoCreator;

    @Override
    public void init() {
        int delay = config.getInt("movement/input/drop/@normal");
        ticker.setTickListener(this).setInterval(delay);

        newTetrominoCreator.addNewTetrominoObserver(this);
    }

    @Override
    public void tick() {
        inputController.dropOneRow();
    }

    @Override
    public void newTetrominoCreated() {
        super.ticker.stop();
    }
}
