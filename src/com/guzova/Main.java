package com.guzova;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите 2 комплексных числа(отдельно действительную и мнимую часть).");
        Complex a = getComplexFromInput(input);
        Complex b = getComplexFromInput(input);
        previewOperators(a, b);
    }

    static Complex getComplexFromInput(Scanner input) {
        System.out.println("Действительная часть: ");
        double a = skipWaste(input).nextDouble();
        System.out.println("Мнимая часть: ");
        double b = skipWaste(input).nextDouble();
        return new Complex(a, b);
    }

    static Scanner skipWaste(Scanner input) {
        while (!input.hasNextDouble())
            input.next();
        return input;
    }

    static void previewOperators(Complex a, Complex b) {
        System.out.println("Тригонометрическая запись комплексного числа:");
        System.out.println("a: " + a.toPolar());
        System.out.println("b: " + b.toPolar());
        System.out.println("Алгебраическая запись комплексного числа:");
        System.out.println("a: " + a);
        System.out.println("b: " + b);
        System.out.println();
        System.out.println("a + b = " + Complex.add(a,b));
        System.out.println("a * b = " + Complex.mul(a,b));
        System.out.println("b / a = " + Complex.div(b,a));
        System.out.println("b - a = " + Complex.sub(b,a));
    }
}
