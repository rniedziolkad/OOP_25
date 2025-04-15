public class Main {
    public static void main(String[] args) {
        CustomList<Integer> list = new CustomList<>();
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

        for(Integer i : list) {
            System.out.println(i);
        }

    }
}