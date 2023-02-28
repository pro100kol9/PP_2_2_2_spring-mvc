package web.dao;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarDaoImpl implements CarDao {
    public List<Car> createCarList() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("Mazda", "3", 180));
        carList.add(new Car("Nissan", "R34", 280));
        carList.add(new Car("BMW", "X5M", 290));
        carList.add(new Car("Lada", "2101", 120));
        carList.add(new Car("Toyota", "MarkII", 180));
        return carList;
    }

    @Override
    public List<Car> getCarsList(int count) {
        List<Car> countCarList = createCarList();
        if (count <= 5) {
            countCarList = createCarList().stream().limit(count).collect(Collectors.toCollection(ArrayList::new));
        }
        return countCarList;
    }

}



