package com.bdlugosz.fleeter.bff.service;

import com.bdlugosz.fleeter.bff.model.*;
import com.bdlugosz.fleeter.bff.repository.CarRepository;
import com.bdlugosz.fleeter.bff.repository.TeaserRepository;
import com.bdlugosz.fleeter.bff.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class HomeService {

    @Autowired
    private TeaserRepository teaserRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private UserRepository userRepository;

    public TeasersListSection getTeasersListsSection() {
        List<Teaser> all = teaserRepository.findAll();
        return new TeasersListSection("Co Nowego?", all);
    }

    public CarsSection getCarsSection(String uid) {
        List<CarBasicInfo> all = carRepository.findAllByTakenBy(uid).stream().map(CarBasicInfo::new).collect(Collectors.toList());
        CarsSection carsSection = new CarsSection();
        carsSection.setHeadline("Hieder carsów");
        carsSection.setCarList(all);
        return carsSection;
    }

    @Deprecated
    private void createCar() {
        Feature build1 = Feature.builder()
                .description("Klimatyzacja automatyczna dwustrefowa")
                .iconTitle("")
                .iconUrl("")
                .name("Klimatyzacja")
                .prettyName("Climatronic")
                .build();

        Feature build2 = Feature.builder()
                .description("Radio obsługujące płyty cd, posiadające złącze usb oraz aux")
                .iconTitle("")
                .iconUrl("")
                .name("Radio")
                .prettyName("RADIO CD MP3")
                .build();


        List<Feature> list = Arrays.asList(build1, build2);

        Car build = Car.builder()
                .brand("Opel")
                .colour("red")
                .description("Opel Corsa 1.4 TDI z klimatyzacją")
                .endOfInsurance(LocalDate.now().plusMonths(27))
                .endOfTechnicalInspection(LocalDate.now().plusMonths(27))
                .engine("1.4")
                .features(list)
                .fuelType("Diesel")
                .iconTitle("opelAuto")
                .iconUrl("https://www.autoscout24.pl/assets/auto/images/model/opel/opel-corsa/opel-corsa-l-01.jpg")
                .model("Corsa")
                .name("Opel Corsa")
                .prettyName("Opel Corsa 1.4 TDI")
                .taken(false)
                .takenBy(null)
                .totalMileage(232342L)
                .working(true)
                .build();

        Car builda = Car.builder()
                .brand("Volkswagen")
                .colour("silver")
                .description("Volkswagen Passat B7 2.0 TDI 170 KM z klimatyzacją")
                .endOfInsurance(LocalDate.now().plusMonths(34))
                .endOfTechnicalInspection(LocalDate.now().plusMonths(22))
                .engine("1.4")
                .features(list)
                .fuelType("Diesel")
                .iconTitle("passatAuto")
                .iconUrl("https://apollo-ireland.akamaized.net/v1/files/eyJmbiI6IjRoaWFqYTdxMzA2bTEtT1RPTU9UT1BMIiwidyI6W3siZm4iOiJ3ZzRnbnFwNnkxZi1PVE9NT1RPUEwiLCJzIjoiMTYiLCJwIjoiMTAsLTEwIiwiYSI6IjAifV19.vcfjjSHy8ZQyv_3iCuZbQVtntL8a9mjlJAhSn_gJrJ0/image;s=1080x720;cars_;/926966625_;slot=4;filename=eyJmbiI6IjRoaWFqYTdxMzA2bTEtT1RPTU9UT1BMIiwidyI6W3siZm4iOiJ3ZzRnbnFwNnkxZi1PVE9NT1RPUEwiLCJzIjoiMTYiLCJwIjoiMTAsLTEwIiwiYSI6IjAifV19.vcfjjSHy8ZQyv+3iCuZbQVtntL8a9mjlJAhSn+gJrJ0_rev001.jpg")
                .model("Passat")
                .name("Volkswagen Passat B7")
                .prettyName("Volkswagen Passat B7 2.0 TDI 170 KM")
                .taken(false)
                .takenBy(null)
                .totalMileage(320675L)
                .working(true)
                .build();

        Car buildb = Car.builder()
                .brand("Tesla")
                .colour("grey")
                .description("Tesla Model S 780 KM z klimatyzacją")
                .endOfInsurance(LocalDate.now().plusMonths(37))
                .endOfTechnicalInspection(LocalDate.now().plusMonths(23))
                .engine(null)
                .features(list)
                .fuelType("electric")
                .iconTitle("teslaAuto")
                .iconUrl("https://apollo-ireland.akamaized.net/v1/files/eyJmbiI6IjV0OWV3c2k4ZDRheS1PVE9NT1RPUEwiLCJ3IjpbeyJmbiI6IndnNGducXA2eTFmLU9UT01PVE9QTCIsInMiOiIxNiIsInAiOiIxMCwtMTAiLCJhIjoiMCJ9XX0.tshpCniycwMFRv_ZIjdPpU51Xq2hgDn7-EcobdLn3hU/image;s=1080x720;cars_;/896869567_;slot=4;filename=eyJmbiI6IjV0OWV3c2k4ZDRheS1PVE9NT1RPUEwiLCJ3IjpbeyJmbiI6IndnNGducXA2eTFmLU9UT01PVE9QTCIsInMiOiIxNiIsInAiOiIxMCwtMTAiLCJhIjoiMCJ9XX0.tshpCniycwMFRv+ZIjdPpU51Xq2hgDn7-EcobdLn3hU_rev001.jpg")
                .model("S")
                .name("Tesla Model S")
                .prettyName("Tesla Model S 780 KM")
                .taken(false)
                .takenBy(null)
                .totalMileage(10675L)
                .working(true)
                .build();

        Car save = carRepository.save(build);
        Car sav1e = carRepository.save(builda);
        Car sa2ve = carRepository.save(buildb);

    }

    public CarDetails getCarDetails(String id) {
        Optional<Car> byId = carRepository.findById(id);
        return byId.map(CarDetails::new).orElse(null);
    }

    public AvailableCars getAvailableCars() {
        List<CarBasicInfo> all = carRepository.findAllByTakenIsFalse().stream().map(CarBasicInfo::new).collect(Collectors.toList());
        AvailableCars availableCars = new AvailableCars(all);
        return availableCars;
    }

    public PersonalDataSection getPersonalDataSection(String userId) {
        Optional<User> user = userRepository.findById(userId);

        if (!user.isPresent()) {
            throw new IllegalArgumentException("User not found");
        }

        return createPersonalDataSection(user.get());
    }

    private PersonalDataSection createPersonalDataSection(User user) {
        PersonalDataSection build = PersonalDataSection.builder()
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .billingData(user.getBillingData())
                .contactAddress(user.getContactAddress())
                .userAddress(user.getUserAddress())
                .licence(user.getLicence())
                .build();
        return build;
    }

    public CarBasicInfo getCarBasicInfo(String id) {
        return carRepository.findById(id).map(CarBasicInfo::new).orElse(null);
    }

    public String leaseCar(String id, String uid) {
        return carRepository.findById(id).map((Car car) -> leaseCar(car, uid)).orElse("NOK");
    }

    private String leaseCar(Car car, String uid) {
        car.setTakenBy(uid);
        car.setTaken(true);
        carRepository.save(car);
        return "OK";
    }
}
