import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CityService {

    /**
     * Получает доступ к файлу
     */
    public void getFile() {
        Path path;
        Scanner scanFile = null;
        String fileName = "src/main/resources/cities.txt";
        try {
            path = Paths.get(fileName);
            scanFile = new Scanner(path);
            parseString(scanFile);
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
        finally {
            if (scanFile != null) scanFile.close();
        }
    }

    /** Парсит строку, считанную из файла
     * @param scanFile
     */
    public void parseString(Scanner scanFile) {
        while(scanFile.hasNext()) {
            String inStr = scanFile.nextLine();
            String[] splitStr = inStr.split(";");
            try {
                CityDao.add(new City(Integer.parseInt(splitStr[0]), splitStr[1], splitStr[2], splitStr[3], Integer.parseInt(splitStr[4]), Integer.parseInt(splitStr[5])));
            } catch(NumberFormatException nfe){
                nfe.printStackTrace();
            }
        }
    }

    public void showCities() {
        for(City c : CityDao.getAll()) {
            System.out.println(c);
        }
    }

    /**
     * Принимает коллекцию городов и выводит в консоль список, отсортированный по наименованию в алфавитном порядке по убыванию без учета регистра
     * @param cities
     */
    public void firstSortMethod(List<City> cities) {
        Collections.sort(cities, (c1, c2) -> c2.getName().toLowerCase().compareTo(c1.getName().toLowerCase()));
        for(City c : cities) {
            System.out.println(c);
        }
    }

    /**
     * Принимает коллекцию городов и выводит в консоль список, отсортированный по федеральному округу и наименованию в алфавитном порядке по убыванию с учетом регистра
     * @param cities
     */
    public void secondSortMethod(List<City> cities) {
        Comparator<City> comp = new Comparator<City>(){
            public int compare(City c1, City c2) {
                int rCompare1 = c2.getDistrict().toLowerCase().compareTo(c1.getDistrict().toLowerCase());
                if (rCompare1 == 0) {
                    return c2.getName().toLowerCase().compareTo(c1.getName().toLowerCase());
                }
                return rCompare1;
            }
        };
        Collections.sort(cities, comp);
        for(City c : cities) {
            System.out.println(c);
        }
    }

    /**
     * Принимает коллекцию городов и выводит в консоль индекс города с наибольшей численностью населения
     * @param cities
     */
    public void findMaxPopulation(List<City> cities) {
        City[] citiesArray = cities.toArray(new City[cities.size()]);
        int indexMaxPopulation = 0;
        int maxPopulation = 0;
        for(int i = 0; i < citiesArray.length; i++) {
            if (citiesArray[i].getPopulation() > maxPopulation) {
                indexMaxPopulation = i;
                maxPopulation = citiesArray[i].getPopulation();
            }
        }
        System.out.println("[" + indexMaxPopulation + "] = " + maxPopulation);
    }

    /**
     * Принимает коллекцию городов и выводит в консоль регионы с общим числом городов по ним
     * @param cities
     */
    public void findRegionWithSumCities(List<City> cities) {
        Stream<City> citiesStream = cities.stream();
        Map<String, List<City>> citiesMap = citiesStream.collect(Collectors.groupingBy(City::getRegion));
        int sumCities = 0;
        for (Map.Entry<String, List<City>> item : citiesMap.entrySet()) {
            for (City c : item.getValue()) {
                sumCities++;
            }
            System.out.println(item.getKey() + " - " + sumCities);
            sumCities = 0;
        }
    }

}
