package game.SaveFunction;

import com.google.gson.internal.LinkedTreeMap;

/**
 * Interface for Saveable objects
 */
public interface Saveable {
    LinkedTreeMap<String,Object> shelve();

    void restore(LinkedTreeMap<String,Object> data);
}
