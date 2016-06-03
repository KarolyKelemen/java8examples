package com.karolyk.java8ex.lambdas;

import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamCheck {

	private static void generateStream() {

		// create a stream with Stream.generate passing a supplier method
		Stream<Double> randoms = Stream.generate(Math::random);
		randoms.limit(5).forEach(System.out::println);

		// create a stream with Stream.iterate providing a starting value and a
		// lambda expression that generates the following values
		Stream<Integer> oddNumbers = Stream.iterate(1, n -> n + 2);
		oddNumbers.limit(5).forEach(System.out::println);

	}

	private static void streamOperations() {

		// Counting the number of elements in a stream
		Stream<Integer> countOddNumbers = Stream.iterate(1, n -> n + 2);
		System.out.println("Count the first seven elements: " + countOddNumbers.limit(7).count());

		// Getting the minimum with min()
		Stream<String> macskak = createMacskak();
		Optional<String> kisMacska = macskak.min((c1, c2) -> c1.length() - c2.length());
		kisMacska.ifPresent(System.out::println);

		// Using findAny()
		Optional<String> anyElement = createMacskak().findAny();
		anyElement.ifPresent(System.out::println);

		// Using allMatch, anyMatch, noneMatch
		Predicate<String> cicaPredicate = x -> x.startsWith("N");
		System.out.println(createMacskak().allMatch(cicaPredicate));
		System.out.println(createMacskak().anyMatch(cicaPredicate));
		System.out.println(createMacskak().noneMatch(cicaPredicate));

		// Using reduce() with using initial value
		System.out.println(createMacskak().reduce("", String::concat));
		
		// Using reduce() without using initial value
		Optional<String> reducedCats = createMacskak().reduce(String::concat);
		reducedCats.ifPresent(System.out::println);
		
		BinaryOperator<String> bop = (a, b) -> a + b.substring(1,2);
		createMacskak().reduce(bop).ifPresent(System.out::println);

		bop = (a, b) -> a + b.substring(0,1);
		System.out.println(createMacskak().reduce("", bop, bop));
		
	}

	private static Stream<String> createMacskak() {
		return Stream.of("Nyavogi", "Gombicica", "Maxi");
	}

	public static void main(String[] args) {
		generateStream();
		streamOperations();
	}

}
