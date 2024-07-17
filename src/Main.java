import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Calculator calc = Calculator.instance.get();

        int a = calc.plus.apply(1, 2);
        int b = calc.minus.apply(1, 1);

        //в переменной b храниться 0, деление на 0 невозможно

        if (calc.isPositive.test(b)) {
            int c = calc.devide.apply(a, b);

            calc.println.accept(c);
        }

        System.out.println("Деление на 0 невозможно");

        Worker.OnTaskDoneListener listener = System.out::println;

        Worker worker = new Worker(listener);
        worker.start();

        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);

        Collections.sort(intList);


        for (int number : intList) {
            if (number > 0 && number % 2 == 0) {
                System.out.print(number + " ");
            }

        }

        System.out.println();

        StreamMain streamMain = new StreamMain(intList);

        streamMain.main();

        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }

        long underAge = persons.stream()
                .filter(person -> person.getAge() > 18)
                .count();

        System.out.println(underAge);

        List<String> recruit = persons.stream()
                .filter(person -> person.getAge() >= 18)
                .filter(person -> person.getAge() <= 27)
                .map(person -> person.getFamily())
                .collect(Collectors.toList());

        System.out.println(recruit);


        List<Person> workers = persons.stream()
                .filter(person -> person.getEducation() == Education.HIGHER)
                .filter(person -> person.getAge() >= 18)
                .filter(person -> (person.getSex() == Sex.MAN && person.getAge() < 65) || (person.getSex() == Sex.WOMAN && person.getAge() < 60))
                .sorted(Comparator.comparing(person -> person.getFamily()))
                .collect(Collectors.toList());

        System.out.println(workers);

    }
}
