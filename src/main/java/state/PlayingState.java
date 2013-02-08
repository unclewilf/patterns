package state;

public class PlayingState implements State {

    @Override
    public void pressPlay(MusicPlayerContext context) {
        System.out.println("Playing paused");
        context.getPlayingService().pause();
        context.setState(new StandbyState());
    }

}
