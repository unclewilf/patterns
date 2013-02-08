package state;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class MusicPlayerContextTest {

    private PlayingService playingService = mock(PlayingService.class);

    @Test
    public void pressPlayWhenPlaying_musicStandsBy() throws Exception {
        MusicPlayerContext musicPlayerContext = new MusicPlayerContext(new PlayingState());
        musicPlayerContext.setPlayingService(playingService);

        musicPlayerContext.play();
        verify(playingService).pause();
        verifyNoMoreInteractions(playingService);
    }

    @Test
    public void pressPlayWhenInStandBy_playsMusic() throws Exception {
        MusicPlayerContext musicPlayerContext = new MusicPlayerContext();
        musicPlayerContext.setPlayingService(playingService);

        musicPlayerContext.play();
        verify(playingService).play();
        verifyNoMoreInteractions(playingService);
    }

}
