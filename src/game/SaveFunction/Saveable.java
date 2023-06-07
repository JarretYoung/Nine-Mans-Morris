package game.SaveFunction;

import com.google.gson.internal.LinkedTreeMap;

/**
 * Interface for Saveable objects
 */
public interface Saveable {
    /**
     * This method is used to package the certain classes into savable format
     *
     * @return a LinkedTreeMap of items in a savable format
     */
    LinkedTreeMap<String,Object> shelve();

    /**
     * This method is used to retrieve an object from the save file and return it to a functional state
     *
     * @param data of the data that was parsed back from the save file
     */
    void restore(LinkedTreeMap<String,Object> data);
}
