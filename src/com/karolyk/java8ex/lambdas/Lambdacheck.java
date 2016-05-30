package com.karolyk.java8ex.lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Lambdacheck {

	private static void print(List<Kitten> kittens, Predicate<Kitten> kittenCheck) {
		for (Kitten k : kittens) {
			if (kittenCheck.test(k)) {
				System.out.println(k);
			}
		}
	}

	private static void printSimple(List<Kitten> kittens, Supplier<Boolean> kittenCheck) {
		for (Kitten k : kittens) {
			if (kittenCheck.get()) {
				System.out.println(k);
			}
		}
	}

	private static void printComplex(List<Kitten> kittens, BiFunction<Kitten, Kitten, Boolean> kittenCheck) {
		for (Kitten k : kittens) {
			for (Kitten g : kittens) {
				if (kittenCheck.apply(k, g)) {
					System.out.println(k);
				}
			}
		}
	}

	public static void main(String[] args) {

		List<Kitten> kittens = createKittens();

		System.out.println("Example for 0 argument");
		printSimple(kittens, () -> true);

		System.out.println("Example for 1 argument");
		print(kittens, c -> c.isHasStripes());

		System.out.println("Example for 2 arguments");
		printComplex(kittens,
				(Kitten a, Kitten b) -> a.getName().startsWith(b.getName().substring(0, 4)) && !a.equals(b));

	}

	private static List<Kitten> createKittens() {

		List<Kitten> cicok = new ArrayList<>();

		Kitten nyavogi = new Kitten(false, "Nyavogi", 2);
		Kitten doromb = new Kitten(true, "Doromb", 5);
		Kitten maxi = new Kitten(true, "Maxi", 1);
		Kitten nyavogihasonmas = new Kitten(false, "Nyavogihasonmas", 2);

		cicok.add(nyavogi);
		cicok.add(doromb);
		cicok.add(maxi);
		cicok.add(nyavogihasonmas);

		return cicok;
	}

}

class Kitten {

	private boolean hasStripes;

	private String name;

	private int age;

	public Kitten(boolean hasStripes, String name, int age) {
		super();
		this.hasStripes = hasStripes;
		this.name = name;
		this.age = age;
	}

	public boolean isHasStripes() {
		return hasStripes;
	}

	public void setHasStripes(boolean hasStripes) {
		this.hasStripes = hasStripes;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Kitten [hasStripes=" + hasStripes + ", name=" + name + ", age=" + age + "]";
	}

}