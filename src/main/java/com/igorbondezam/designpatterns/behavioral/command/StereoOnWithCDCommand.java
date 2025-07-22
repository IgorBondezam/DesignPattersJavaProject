package com.igorbondezam.designpatterns.behavioral.command;

public class StereoOnWithCDCommand implements Command {
    private Stereo stereo;
    private int previousVolume;

    public StereoOnWithCDCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        previousVolume = stereo.getVolume();
        stereo.on();
        stereo.setCd();
        stereo.setVolume(11);
    }

    @Override
    public void undo() {
        stereo.off();
    }
}

