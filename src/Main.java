import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Car car = new Car(60,80);
        Gson gson = new Gson();
        System.out.println(gson.toJson(car.getData()));
        String strVal = gson.toJson(car.getData());
        System.out.println(gson.fromJson(strVal, LinkedTreeMap.class));
        Car newCar = new Car(0,0);
//        System.out.println(gson.fromJson(strVal, HashMap.class).get("engine"));
        newCar.setData(gson.fromJson(strVal, LinkedTreeMap.class));
        System.out.println(newCar);
    }
}
