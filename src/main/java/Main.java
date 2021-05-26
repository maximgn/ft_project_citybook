public class Main {
    public static void main(String[] args) {
        CityService cs = new CityService();
        cs.getFile();

        System.out.println("\nМодуль 1. Загрузка данных справочника городов России\n");
        cs.showCities();

        System.out.println("\nМодуль 2.1. Сортировка списка городов по наименованию в алфавитном порядке по убыванию без учета регистра\n");
        cs.firstSortMethod(CityDao.getAll());

        System.out.println("\nМодуль 2.2. Сортировка списка городов по федеральному округу и наименованию города внутри каждого федерального округа в алфавитном порядке по убыванию с учетом регистра\n");
        cs.secondSortMethod(CityDao.getAll());

        System.out.println("\nМодуль 3. Поиск города с наибольшим количеством жителей\n");
        cs.findMaxPopulation(CityDao.getAll());

        System.out.println("\nМодуль 4. Поиск количества городов в разрезе регионов\n");
        cs.findRegionWithSumCities(CityDao.getAll());
    }
}
