package game.SaveFunction;

import com.google.gson.internal.LinkedTreeMap;

public interface Saveable {
    LinkedTreeMap<String,Object> shelve();

    void restore(LinkedTreeMap<String,Object> data);
}
