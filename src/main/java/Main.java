import brodcaster.Broadcast;
import brodcaster.RadioBrodcast;
import radio.Radio;

public class Main {
    public static void main(String[] args) {
        RadioBrodcast<Broadcast> deltaFM = new RadioBrodcast<>(Broadcast.NO_BROADCAST, "Delta FM");
        RadioBrodcast<Broadcast> pramborsFM = new RadioBrodcast<>(Broadcast.NO_BROADCAST, "Prambors FM");

        Radio radio1 = new Radio(deltaFM, "Radio 1");
        Radio radio2 = new Radio(pramborsFM, "Radio 2");

        deltaFM.startBroadcast(Broadcast.NEWS);
        pramborsFM.startBroadcast(Broadcast.MUSIC);

        radio1.changeStation(pramborsFM);
        radio2.changeStation(deltaFM);
    }
}
