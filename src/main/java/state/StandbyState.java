package state;

public class StandbyState implements State {

    @Override
    public void pressPlay(MusicPlayerContext context) {
        System.out.println("Playing started");
        context.getPlayingService().play();
        context.setState(new PlayingState());
    }

}
