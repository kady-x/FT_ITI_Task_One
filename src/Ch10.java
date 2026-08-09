import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class City {
    private int id;
    private String name;
    private int population;
    private String countryCode;

    public City(int id, String name, int population, String countryCode) {
        this.id = id;
        this.name = name;
        this.population = population;
        this.countryCode = countryCode;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public String getCountryCode() {
        return countryCode;
    }
}

class Country {
    private String code;
    private String name;
    private String continent;
    private double surfaceArea;
    private int population;
    private double gnp;
    private int capital;
    private List<City> cities = new ArrayList<>();

    public Country(String code, String name, String continent, double surfaceArea, int population, double gnp,
            int capital) {
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.surfaceArea = surfaceArea;
        this.population = population;
        this.gnp = gnp;
        this.capital = capital;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getContinent() {
        return continent;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

    public int getPopulation() {
        return population;
    }

    public double getGnp() {
        return gnp;
    }

    public int getCapital() {
        return capital;
    }

    public void addCity(City city) {
        this.cities.add(city);
    }

    public List<City> getCities() {
        return cities;
    }
}

public class Ch10 {
    public static void main(String[] args) {

        Country egypt = new Country("EGY", "Egypt", "Africa", 1, 100, 10, 1);
        City cairo = new City(1, "Cairo", 20, "EGY");
        City alex = new City(2, "Alexandria", 5, "EGY");
        egypt.addCity(cairo);
        egypt.addCity(alex);

        Country japan = new Country("JAP", "Japan", "Asia", 1, 100, 10, 3);
        City tokyo = new City(3, "Tokyo", 37, "JAP");
        City osaka = new City(4, "Osaka", 19, "JAP");
        japan.addCity(tokyo);
        japan.addCity(osaka);

        List<Country> world = new ArrayList<>();
        world.add(egypt);
        world.add(japan);

        System.out.println("--- Biggest city in each country ---");
        for (Country country : world) {
            City maxCity = country.getCities().get(0);
            for (City city : country.getCities()) {
                if (city.getPopulation() > maxCity.getPopulation()) {
                    maxCity = city;
                }
            }
            System.out.println(country.getName() + " -> " + maxCity.getName());
        }

        System.out.println("\n--- Biggest city in each continent ---");
        Map<String, City> maxInContinent = new HashMap<>();

        for (Country country : world) {
            for (City city : country.getCities()) {
                String cont = country.getContinent();
                if (!maxInContinent.containsKey(cont)
                        || city.getPopulation() > maxInContinent.get(cont).getPopulation()) {
                    maxInContinent.put(cont, city);
                }
            }
        }
        for (String cont : maxInContinent.keySet()) {
            System.out.println(cont + " -> " + maxInContinent.get(cont).getName());
        }

        System.out.println("\n--- Biggest capital city ---");
        City maxCapital = null;
        for (Country country : world) {
            City capital = null;
            for (City city : country.getCities()) {
                if (city.getId() == country.getCapital()) {
                    capital = city;
                    break;
                }
            }

            if (capital != null) {
                if (maxCapital == null || capital.getPopulation() > maxCapital.getPopulation()) {
                    maxCapital = capital;
                }
            }
        }
        System.out.println("The biggest capital city is : " + maxCapital.getName());
    }
}