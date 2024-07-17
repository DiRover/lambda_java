import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StreamMain {

    static List<Integer> list = new ArrayList();

    public StreamMain(List<Integer> list) {
        this.list = list;
    }

    public void main() {
        list.stream().filter(number -> number > 0)
                .filter(number -> number % 2 == 0)
                .sorted(Comparator.naturalOrder())
                .forEach(number -> System.out.print(number + " "));

    }
}
