package rl.prog2.training.training230420.training.nestedclasses;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class ComparatorTest {

    public static void main(String[] args) {
        List<ZooTier> tiere = new ArrayList<>();
        tiere.add(new ZooTier("Flatter", "Papageientaucher", "Island"));
        tiere.add(new ZooTier("Heather", "Hochlandrind", "Schottland"));
        tiere.add(new ZooTier("Aki", "Husky", "Finnland"));

        tiere.sort(new NameComparator());
        for (ZooTier tier : tiere)
            System.out.println(tier.name);

        class GattungsComparator implements Comparator<ZooTier> {
            @Override
            public int compare(ZooTier o1, ZooTier o2) {
                return o1.gattung.compareTo(o2.gattung);
            }
        }
        tiere.sort(new GattungsComparator());
        for (ZooTier tier : tiere)
            System.out.println(tier.gattung);

        tiere.sort(new Comparator<ZooTier>() {
            @Override
            public int compare(ZooTier o1, ZooTier o2) {
                return o1.herkunft.compareTo(o2.herkunft);
            }
        });
        for (ZooTier tier : tiere)
            System.out.println(tier.herkunft);

        // with lambda:
        tiere.sort((o1, o2) -> o1.herkunft.compareTo(o2.herkunft));

        tiere.sort((ZooTier o1, ZooTier o2) -> {
            return o1.herkunft.compareTo(o2.herkunft);
        });

        tiere.sort(Comparator.comparing(o -> o.herkunft));


        // klassisch:
        for (ZooTier tier : tiere) {
            System.out.println(tier.getName());
        }

        // mit Streams:
        tiere.stream().forEach(tier -> System.out.println(tier));
        tiere.forEach(tier -> System.out.println(tier));
        tiere.forEach(System.out::println);

        // nicht klausurrelevant!
        // mit Lambda-Ausdruck:             Methodenreferenz
        // (x,y) -> Math.max(x,y)           Math::max
        // tier -> tier.getName()           ZooTier::getName
        // obj -> System.out.println(obj)   System.out::println

        tiere.sort((ZooTier o1, ZooTier o2) -> {return o1.getHerkunft().compareTo(o2.getHerkunft()); });
        tiere.sort((o1, o2) -> o1.getHerkunft().compareTo(o2.getHerkunft()));
        tiere.sort(Comparator.comparing(o -> o.getHerkunft()));

        System.out.println("*********************");
        tiere.stream().map(ZooTier::getHerkunft).distinct().sorted().forEach(System.out::println);


        System.out.println("*********************");
        // so nicht gut:
        tiere.stream().map(ZooTier::getHerkunft).distinct().sorted(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        }).forEach(System.out::println);

        System.out.println("*********************");
        // so gut:
        tiere.stream().map(ZooTier::getHerkunft).distinct().sorted(Comparator.reverseOrder()).forEach(System.out::println);

        System.out.println("*********************");
        // Wann passiert was? Lass mal die Kette verstehen, siehe auch Debugger:
        // zuerst projizieren, dann sortieren:
        Stream<String> stream = tiere.stream().map(ZooTier::getHerkunft).distinct().sorted(
                (o1,o2) -> {System.out.println("+"); return o2.compareTo(o1);});
                // bis jetzt keine Auswertung des Comparators!!!
        stream.forEach(System.out::println);

        System.out.println("*********************");
        // zuerst sortieren, dann projizieren (ungünstigere Lösung)
        tiere.stream().sorted((t1, t2) -> t1.getGattung().compareTo(t2.getGattung())).map(t -> t.getGattung()).distinct().forEach(t -> System.out.println(t));
    }

        public static class NameComparator implements Comparator<ZooTier> {
            @Override
            public int compare(ZooTier o1, ZooTier o2) {
                return o1.name.toLowerCase().compareTo(o2.name.toLowerCase());
            }
        }


    public static class ZooTier {
        final String name;
        final String gattung;
        final String herkunft;

        public ZooTier(String name, String gattung, String herkunft) {
            this.name = name;
            this.gattung = gattung;
            this.herkunft = herkunft;
        }

        public String getName() {
            return null;
        }

        public String getGattung() {
            return gattung;
        }

        public String getHerkunft() {
            return herkunft;
        }
    }
}
