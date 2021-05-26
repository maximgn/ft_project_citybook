import java.util.List;

public class CityDao {

    /** Вернет true при успешном добавлении элемента, в противном false
     * @param c
     * @return boolean
     */
    public static boolean add(City c) {
        if (CityList.cities.add(c)) return true;
        return false;
    }

    /** Вернет коллекцию городов
     * @return List<City>
     */
    public static List<City> getAll() {
        return CityList.cities;
    }
}
