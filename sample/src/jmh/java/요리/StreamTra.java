package 요리;

import java.util.*;

import static java.util.stream.Collectors.*;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTra {
    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH)
        );

        List<String> CalHighThree = menu.stream().filter(m -> m.getCalories() > 300).
                map(Dish::getName).limit(3).collect(Collectors.toList());
        System.out.println(CalHighThree);

        List<Dish> vegetable = menu.stream().filter(Dish::isVegetarian).collect(Collectors.toList());
        System.out.println(vegetable);

        List<Integer> numbers = Arrays.asList(1, 23, 4, 56, 67, 21, 51);
        numbers.stream().filter(i -> i % 2 == 0).distinct()
                .forEach(System.out::println);

        List<Dish> filterMenu = menu.stream().filter(m -> m.getCalories() > 320).collect(Collectors.toList());
        System.out.println(filterMenu);
        List<Dish> filterMenu2 = menu.stream().takeWhile(m -> m.getCalories() == 800).collect(Collectors.toList());
        System.out.println(filterMenu2);

        List<String> dishName = menu.stream().map(Dish::getName).collect(Collectors.toList());
        System.out.println(dishName);

        List<String> words = Arrays.asList("Modern", "java", "in", "action");
        List<Integer> wordsLength = words.stream().map(String::length).collect(Collectors.toList());
        System.out.println(wordsLength);

        List<Integer> dishNamesLengths = menu.stream().map(Dish::getName).map(String::length).collect(Collectors.toList());
        System.out.println(dishNamesLengths);

        boolean isHealthy = menu.stream().anyMatch((dish -> dish.getCalories() < 100));
        System.out.println(isHealthy);

        Optional<Dish> dish = menu.stream().filter(Dish::isVegetarian).findAny();
        System.out.println(dish);
        Optional<Dish> dish1 = menu.stream().filter(Dish::isVegetarian).findAny();
        System.out.println(dish1);

        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> first = someNumbers.stream().map(n -> n * n).filter(n -> n % 3 == 0).collect(Collectors.toList());
        System.out.println(first);

        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        int sum = numbers1.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum);
        Optional<Integer> max = numbers1.stream().reduce(Integer::max);
        System.out.println(max);

        Optional<Integer> su2 = menu.stream().map(m -> m.getCalories()).reduce(Integer::sum);
        System.out.println(su2);

        int calories = menu.stream().mapToInt(Dish::getCalories).sum();
        System.out.println(calories);

        Stream<String> stream = Stream.of("Modern", "java", "in", "action");
        stream.map(String::toUpperCase).forEach(System.out::println);

        long howManyDishes = menu.stream().collect(Collectors.counting());
        long howManyDishes1 = menu.stream().count();
        System.out.println(howManyDishes);
        System.out.println(howManyDishes1);

        Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
        System.out.println(dishCaloriesComparator);
        Optional<Dish> most = menu.stream().collect(maxBy(dishCaloriesComparator));
        System.out.println(most);

        double avgCalories = menu.stream().collect(averagingInt(Dish::getCalories));
        System.out.println(avgCalories);
        String shortmenu = menu.stream().map(Dish::getName).collect(joining(", "));
        System.out.println(shortmenu);

        Optional<Dish> mostCalorieDish = menu.stream().collect(reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2));
        System.out.println(mostCalorieDish);

        Map<Dish.Type, List<Dish>> dishesByType = menu.stream().collect(groupingBy(Dish::getType));
        System.out.println(dishesByType);

        Map<Dish.Type, List<Dish>> caloricDishesByType = menu.stream().filter(m -> m.getCalories() > 500).
                collect(groupingBy(Dish::getType));
        Map<Dish.Type, List<Dish>> cal = menu.stream().collect(groupingBy(Dish::getType,
                filtering(m -> m.getCalories() > 500, toList())));
        System.out.println(cal);

        Map<Dish.Type, List<String>> dishNames = menu.stream().collect(groupingBy(
                Dish::getType, mapping(Dish::getName, toList())
        ));
        System.out.println(dishNames);

        List<String>list=Arrays.asList("a","b","c");
        List<String>list2=List.of("a","b","c");
        System.out.println(list);
        System.out.println(list2);


    }

    public long sqe(long n){
        return Stream.iterate(1L,i->i+1).limit(n).reduce(0L,Long::sum);
    }

}
