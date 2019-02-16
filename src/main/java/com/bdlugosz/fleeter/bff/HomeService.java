package com.bdlugosz.fleeter.bff;

import com.bdlugosz.fleeter.bff.model.Car;
import com.bdlugosz.fleeter.bff.model.CarBasicInfo;
import com.bdlugosz.fleeter.bff.model.CarsSection;
import com.bdlugosz.fleeter.bff.model.Teaser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class HomeService {

    @Autowired
    private TeaserRepository teaserRepository;

    @Autowired
    private CarRepository carRepository;

    public TeasersListSection getTeasersListsSection() {
        Teaser save = new Teaser();
        save.setHeadline(UUID.randomUUID().toString());
        save.setDescription("Opis");
        save.setIconUrl("https://raw.githubusercontent.com/snwh/paper-icon-theme/master/Paper/512x512/categories/preferences-system-power.png");
        teaserRepository.save(save);
        List<Teaser> list = Arrays.asList(save);
        TeasersListSection teasersListSection = new TeasersListSection("Nagłowek sekcji tiserów", list);
        return teasersListSection;
    }

    public CarsSection getCarsSection(String uid) {
        CarsSection carsSection = new CarsSection();
        carsSection.setHeadline("Hieder carsów");
        List<CarBasicInfo> list = new ArrayList<>();
        CarBasicInfo car = new CarBasicInfo();
        car.setName("Opis auta");
        list.add(car);
        carsSection.setCarList(list);
        return carsSection;
    }

    public CarDetails getCarDetails(String id) {
        Optional<Car> byId = carRepository.findById(id);
        if (!byId.isPresent()) {
            return null;
        }
        return new CarDetails(byId.get());
    }

    public AvailableCars getAvailableCars() {
        return null;
    }
}
