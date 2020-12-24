package xyxgame.gameplane.schoolGif.Teacher;

import xyxgame.gameplane.schoolGif.SchoolGifView;

public abstract  class Teacher {
    SchoolGifView schoolGifView;
    public abstract void PKResult();
    public Teacher(SchoolGifView schoolGifView) {
        this.schoolGifView = schoolGifView;
    }
}
