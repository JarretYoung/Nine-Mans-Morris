import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;

import java.util.HashMap;

public class Engine {
    private int horsepower;
    private Car car;
    public Engine(int horsepower, Car car) {
        this.horsepower = horsepower;
        this.car = car;
    }

    public LinkedTreeMap<String,Object> getData() {
        LinkedTreeMap<String,Object> data = new LinkedTreeMap<>();
        data.put("horsepower",this.horsepower);
        return data;
    }

    public void setData(LinkedTreeMap<String,Object> data) {
        this.horsepower = Integer.parseInt(String.valueOf(Math.round((double) data.get("horsepower"))));
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    @Override
    public String toString() {
        return String.format("Engine<horsepower=%s>",horsepower);
    }
}
