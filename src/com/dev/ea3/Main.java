package com.dev.ea3;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<String> someBingNumbers = Arrays.asList(

                "N40", "N36",
                "B12", "B6",
                "G53", "G46", "G60", "G50", "g54",
                "I26", "I17", "!29",
                "O71");

        someBingNumbers
                .stream()
                .map(String::toUpperCase)  //Method references
                .filter(s -> s.startsWith("G"))
                .sorted()
                .forEach(System.out::println);


        Stream<String> ioNUmberStream = Stream.of("I26", "I54", "I98", "I87", "I17", "O72" );
        Stream<String> inNumberStream = Stream.of("N40", "N35", "N94", "I54", "I17", "I29", "O72");
        Stream<String> concatStream = Stream.concat(ioNUmberStream, inNumberStream);
        System.out.println("++++++++++++++++++++++++++++++++++");
        System.out.println(concatStream
                .distinct()
                .peek(System.out::println)
                .count());

        Employee john = new Employee("John Doe", 30);
        Employee jack = new Employee("Jack Daniels", 25);
        Employee emilio = new Employee("Emilio Araos", 35);
        Employee mariela = new Employee("Mariela Araos", 4);
        Employee silvia = new Employee("Silvia Araos", 41);

        Department hr = new Department("Human Resources");
        hr.addEmployee(john);
        hr.addEmployee(jack);
        hr.addEmployee(emilio);

        Department accounting = new Department("Accounting");
        accounting.addEmployee(mariela);
        accounting.addEmployee(silvia);

        List<Department> departments = new ArrayList<>();
        departments.add(hr);
        departments.add(accounting);

        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .forEach(System.out::println);

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
        List<String> sortedGNumbers = someBingNumbers
                .stream()
                .map(String::toUpperCase)
                .filter(s-> s.startsWith("G"))
                .sorted()
                .collect(Collectors.toList());

        for(String s : sortedGNumbers){
            System.out.println(s);
        }

    }
}
