package state;

public class MusicPlayerContext {

    private PlayingService playingService;

    private State state;

    public MusicPlayerContext() {
        this.state = new StandbyState();
    }

    public MusicPlayerContext(State state) {
        this.state = state;
    }

    public void play() {
        state.pressPlay(this);
    }

    public void setState(State state) {
        this.state = state;
    }

    public PlayingService getPlayingService() {
        return playingService;
    }

    public void setPlayingService(PlayingService playingService) {
        this.playingService = playingService;
    }

}
