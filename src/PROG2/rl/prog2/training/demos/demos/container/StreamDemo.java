package rl.prog2.demos.container;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamDemo {

	static class SmartPhone {
		String type;
		String manufacturer;
		int price;

		public SmartPhone(String type, String manufacturer, int price) {
			super();
			this.type = type;
			this.manufacturer = manufacturer;
			this.price = price;
		}

		public String getType() {
			return type;
		}

		public String getManufacturer() {
			return manufacturer;
		}

		public int getPrice() {
			return price;
		}

	}

	public static void main(String[] args) {
		List<SmartPhone> sPhones;
		sPhones = Arrays.asList(new SmartPhone("S7", "Samsung", 700), new SmartPhone("S6", "Samsung", 400),
				new SmartPhone("J5", "Samsung", 160), new SmartPhone("G4", "LG", 300),
				new SmartPhone("G4s", "LG", 200));

		// Print all manufacturers which sell smart phones for less than 350
		// Euros!

		// SQL: select distinct manufacturer
		// from sPhones
		// where price < 350
		// order by manufacturer

		System.out.println("Manufacturers - V1");
		List<String> result = new ArrayList<String>();
		for (SmartPhone sPhone : sPhones) {
			if (sPhone.getPrice() < 350 && !result.contains(sPhone.getManufacturer()))
				result.add(sPhone.getManufacturer());
		}
		Collections.sort(result);
		for (String manufacturer : result)
			System.out.println(manufacturer);

		System.out.println("Manufacturers - V2");
		sPhones.stream().filter(sp -> sp.getPrice() < 350).map(SmartPhone::getManufacturer).distinct().sorted()
				.forEach(m -> System.out.println(m));

		// Get most expensive smart phone
		Optional<SmartPhone> phone = sPhones.parallelStream().max(Comparator.comparing(SmartPhone::getPrice));
		if (phone.isPresent())
			System.out.println("Most expensive: " + phone.get().getType());

		// Get all Samsung smart phones
		System.out.println("Samsung smart phones:");
		List<SmartPhone> selected = sPhones.stream().filter(sp -> sp.getManufacturer().equals("Samsung"))
				.sorted(Comparator.comparing(SmartPhone::getType)).collect(Collectors.toList());
		selected.stream().forEach(m -> System.out.println(m.getType()));

		// Training:

		// Get all smart phone for more than 600 Euros
		System.out.println("Expensive smart phones:");
		List<SmartPhone> expSmarties = sPhones.stream().filter(sp -> sp.getPrice() > 600).sorted()
				.collect(Collectors.toList());
		expSmarties.stream().forEach(m -> System.out.println(m.getType()));

		// Order by price
		System.out.println("Ordered by price:");
		List<SmartPhone> phones = sPhones.stream().sorted(Comparator.comparing(SmartPhone::getPrice))
				.collect(Collectors.toList());
		phones.stream().forEach(m -> System.out.println(m.getType()));

	}

}
