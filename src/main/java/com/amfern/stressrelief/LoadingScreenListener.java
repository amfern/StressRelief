package com.amfern.stressrelief;

import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.Texture;

public interface LoadingScreenListener {
    public void doneLoading(Model assModel, Texture background);
}