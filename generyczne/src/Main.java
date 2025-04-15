import java.util.List;

public class Main {
    public static void main(String[] args) {
        CustomList<Object> list = new CustomList<>();
//        list.getFirst();
//        list.getLast();
        list.addFirst(1);
        list.addLast(2);
        list.addFirst(0);
        list.add(3);

        list.addFirst(1000);
        list.addLast(-10);
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        System.out.println("usuwam: "+list.removeFirst());
        System.out.println("usuwam: "+list.removeLast());
        System.out.println("first: "+list.getFirst());
        System.out.println("last: "+list.getLast());
        System.out.println("rozmiar: "+list.size());
        System.out.println("list[0] = "+list.get(0));
        System.out.println("list[3] = "+list.get(3));
//        System.out.println("list[4] = "+list.get(4));
        System.out.println("list[2] = "+list.get(2));
//        System.out.println("list[-1] = "+list.get(-1));

        for(Object i : list) {
            System.out.println(i);
        }
        list.stream().forEach(System.out::println);

        list.add("hello");
        list.add(1234.15);
        list.addFirst("inny napis");
        System.out.println(list);
        List<Object> strings = Utils.filterByClass(list, String.class);
        List<Object> numbers = Utils.filterByClass(list, Number.class);
        System.out.println("strings: "+strings);
        System.out.println("numbers: "+numbers);

        List<Integer> ints = List.of(1, 3, 4, 7, 14, 0, 2);
        List<Double> dubs = List.of(0.0, 1.3, 15.1, 14.6);
        System.out.println("In range: "+Utils.countInRange(ints, 0, 4));
        System.out.println("In range: "+Utils.countInRange(dubs, 0.0, 4.0));


    }
}