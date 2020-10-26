import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<Book> javaBooks = List.of(
                new Book("Java EE 7 Essentials", 2013, List.of("Arun Gupta")),
                new Book("Algorithms", 2011, List.of("Robert Sedgewick", "Kevin Wayne")),
                new Book("Clean code", 2014, List.of("Robert Martin"))
        );


        List<String> authors = javaBooks.stream()
                .flatMap(book -> book.getAuthors.stream())
                .collect(Collectors.toList());





//        Job job1 = new Job("IT specialist", "Programming");
//        Job job2 = new Job("Doctor", "Healing");
//        Job job3 = new Job("Captain", "Ruling");
//
//        List<Job> jobs = new ArrayList<>(List.of(job1, job2, job3));
//
//        jobs.stream()
//                .map(Job::getTitle)
//                .forEach(a -> System.out.println(a));




//        jobs.stream()
//                .map(Job -> {
//                    Job.getTitle();
//                    Job.getDescription();
//                    return job2.getTitle();
//                })
////                .map(Job -> Job.getDescription())
//                .forEach(a -> System.out.println(a));

/*
        List<Integer> list = new ArrayList<>(List.of(1, 3, 4, 5, 6));
        List<Integer> list1 = new ArrayList<>(List.of(12, 32, 33, 98, 45));

        List<List<Integer>> listOfLists = new ArrayList<>();
        listOfLists.add(list);
        listOfLists.add(list1);

        System.out.println(listOfLists);*/


//        List<Integer> collect = listOfLists.stream()
//                .flatMap(a -> a.stream().map(b -> b * 2))
//                .collect(Collectors.toList());
//
//        System.out.println(collect);
//
//        listOfLists.stream()
//                .map(listOfLists => listOfLists.get(listOfLists))
//                .forEach(b -> System.out.println(b));

//        for (int i = 0; i < list.size(); i++) {
//            list.set(i, list.get(i) * 2);
//        }

//        System.out.println(list);


//        for (int i = 0; i < listOfLists.size(); i++) {
//            for (int j = 0; j < listOfLists.get(i).size(); j++) {
//                listOfLists.get(i).set(j, listOfLists.get(i).get(j) * 2);
//            }
//        }
//        System.out.println(listOfLists);
    }
}


