package brodcaster;

import java.util.ArrayList;

public class RadioBrodcast<V> {

    private V value;
    private final ArrayList<OnValueChangedListener<V>> radioListeners;
    private String name;

    public RadioBrodcast(V initValue, String channelName) {
        this.value = initValue;
        this.name = channelName;
        radioListeners = new ArrayList<>();
    }

    public String getChannelName() {
        return name;
    }

    public void startBroadcast(V value) {
        if (this.value == value) return;
        this.value = value;
        radioListeners.forEach(listener -> listener.onBroadcastChange(value));
    }

    public void removeListener(OnValueChangedListener<V> listener) {
        radioListeners.remove(listener);
    }

    public V getBroadcastNow() {
        return value;
    }

    public void listen(OnValueChangedListener<V> listener) {
        radioListeners.add(listener);
        listener.onBroadcastChange(value);
    }

    public interface OnValueChangedListener<V> {
        void onBroadcastChange(V value);
    }

}
