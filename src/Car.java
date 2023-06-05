import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;

import java.util.HashMap;

public class Car {
    private int wheels;
    private Engine engine;
    public Car(int wheels,int horsepower) {
        this.wheels = wheels;
        this.engine = new Engine(horsepower,this);
    }

    public LinkedTreeMap<String,Object> getData() {
        LinkedTreeMap<String,Object> data = new LinkedTreeMap<>();
        data.put("wheels",this.wheels);
        data.put("engine",this.engine.getData());
        return data;
    }

    public void setData(LinkedTreeMap<String,Object> data) {
        this.wheels = Integer.parseInt(String.valueOf(Math.round((double) data.get("wheels"))));
        this.engine = new Engine(0,this);
        this.engine.setData((LinkedTreeMap<String, Object>) data.get("engine"));
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public Engine getEngine() {
        return engine;
    }

    public int getWheels() {
        return wheels;
    }

    @Override
    public String toString() {
        return String.format("Car<wheels=%s, engine=%s>",wheels,engine);
    }
}
