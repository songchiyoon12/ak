package Sample;


import java.util.*;
import java.util.stream.Collectors;
import static java.util.Map.entry;

public class MainClass {
    public static void main(String[] args) {
        MainClass mainClass = new MainClass();


        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );


        System.out.println("2011년에 일어난 모든 거래를 오름차순으로 ");
       List<Transaction> trader2011=transactions.stream().filter(m->m.getYear()==2011)
               .collect(Collectors.toList());
        System.out.println(trader2011);


        System.out.println("거래재가 근무하는 모든 도시를 중복없이 나열하시오");
        List<String> cities = transactions.stream().map(m -> m.getTrader().getCity()).distinct().collect(Collectors.toList());
        System.out.println(cities);


        System.out.println("케임브리지에서 근무하는 모든 거래자를 찾으시오");
        List<Trader> trader = transactions.stream().map(Transaction::getTrader)
                .filter(m -> m.getCity().equals("Cambridge")).distinct()
                .sorted(Comparator.comparing(Trader::getName)).collect(Collectors.toList());
        System.out.println(trader);


        System.out.println("모든 거래자의 이름을 알파벳 순으로 나열");



        System.out.println("밀라노의 거래자가 있는가?");
        boolean milan=transactions.stream().anyMatch(m->m.getTrader().getCity().equals("Milan"));
        System.out.println(milan);


        System.out.println("최댓값은?");
        Optional<Integer> highvalue=transactions.stream().map(Transaction::getValue).reduce(Integer::max);
        System.out.println(highvalue);


        System.out.println("최소값은?");
        Optional<Integer> lowvalue=transactions.stream().map(Transaction::getValue).reduce(Integer::min);
        System.out.println(lowvalue);

        List<String>list=Arrays.asList("a","b","c");
        list.set(0,"A");
        System.out.println(list);
        Map<String,Integer> ageOfFriends=Map.of("라파엘",10,"올리비아",20);
        Map<String,Integer> ageOf=Map.ofEntries(Map.entry("a",20));
        Map<String,String> map1=Map.ofEntries(entry("라파엘","안녕"));

        ageOfFriends.forEach((f,a)-> System.out.println(f+"is"+a));

        Map<String,String> map2=Map.ofEntries(entry("안녕","하세요"));
        System.out.println(map2.getOrDefault("안녕","없네"));
        System.out.println(map2.getOrDefault("잘가","없네"));

        Runnable r1=new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        };
        Runnable r2=()-> System.out.println("hello2");



    }
}

