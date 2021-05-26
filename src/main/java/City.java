/**
 * Класс, хранящий информацию о городах
 */
public class City {
    /** Идентификатор */
    private int id;
    /** Наименование */
    private String name;
    /** Регион */
    private String region;
    /** Федеральный округ */
    private String district;
    /** Население */
    private int population;
    /** Дата основания */
    private int foundation;

    /**
     Конструктор - создание нового объекта
     * @param id - идентификатор города
     * @param name - наименование города
     * @param region - регион
     * @param district - федеральный округ
     * @param population - население города
     * @param foundation - дата основания
     * @see City#City(int, String, String, String, int, int)
     */

    City(int id, String name, String region, String district, int population, int foundation) {
        this.id = id;
        this.name = name;
        this.region = region;
        this.district = district;
        this.population = population;
        this.foundation = foundation;
    }

    /**
     * Возвращает идентификатор города
     * @return int
     */
    public int getId() {
        return this.id;
    }

    /**
     * Возвращает наименование города
     * @return String
     */
    public String getName() {
        return this.name;
    }

    /**
     * Возвращает регион города
     * @return String
     */
    public String getRegion() {
        return this.region;
    }

    /**
     * Возвращает федеральный округ города
     * @return String
     */
    public String getDistrict() {
        return this.district;
    }

    /**
     * Возвращает население города
     * @return int
     */
    public int getPopulation() {
        return this.population;
    }

    /**
     * Возвращает дату основания города
     * @return int
     */
    public int getFoundation() {
        return this.foundation;
    }

    /**
     * Текстовое представление объекта - город, в виде перечисления его свойств
     * @return String
     */
    @Override
    public String toString(){
        return "City{name=" + this.name
                + ", region=" + this.region
                + ", district=" + this.district
                + ", population=" + this.population
                + ", foundation=" + this.foundation + "}";
    }
}
