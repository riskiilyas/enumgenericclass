package radio;

import brodcaster.Broadcast;
import brodcaster.RadioBrodcast;

public class Radio implements RadioBrodcast.OnValueChangedListener<Broadcast> {

    private final String radioName;
    private RadioBrodcast<Broadcast> radioBrodcast;

    public Radio(RadioBrodcast<Broadcast> radioBrodcast, String radioName) {
        this.radioBrodcast = radioBrodcast;
        this.radioName = radioName;
        this.radioBrodcast.listen(this);
    }

    public void changeStation(RadioBrodcast<Broadcast> radioBrodcast) {
        this.radioBrodcast.removeListener(this);
        this.radioBrodcast = radioBrodcast;
        this.radioBrodcast.listen(this);
    }

    @Override
    public void onBroadcastChange(Broadcast value) {
        System.out.println(radioName + " is now listening to " + value.name() + " on " + radioBrodcast.getChannelName());
    }
}
