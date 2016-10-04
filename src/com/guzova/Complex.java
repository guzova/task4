package com.guzova;

public class Complex {
    double real;
    double imag;

    public Complex(Complex c) {
        this.real = c.real;
        this.imag = c.imag;
    }

    public Complex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public Complex add(Complex numb) {
        this.real += numb.real;
        this.imag += numb.imag;
        return this;
    }

    public static Complex add(Complex c1, Complex c2) {
        Complex c = new Complex(c1);
        return c.add(c2);
    }

    public Complex sub(Complex numb) {
        this.real -= numb.real;
        this.imag -= numb.imag;
        return this;
    }

    public static Complex sub(Complex c1, Complex c2) {
        Complex c = new Complex(c1);
        return c.sub(c2);
    }

    /**
     * (a + bi)*(c + di) = (ac - bd) + i(bc + da)
     *
     * @param numb - c + di
     */
    public Complex mul(Complex numb) {
        this.real = this.real * numb.real - this.imag * numb.imag;
        this.imag = this.imag * numb.real + numb.imag * this.real;
        return this;
    }

    public static Complex mul(Complex c1, Complex c2) {
        Complex c = new Complex(c1);
        return c.mul(c2);
    }

    /**
     * (a + bi)/(c + di) = (a + bi)*(c - di)/(c^2 - d^2) = (ac + bd)/(c^2+d^2) + i(bc - ad)/(c^2+d^2)
     *
     * @param numb - c + di
     */
    public Complex div(Complex numb) {
        double denominator = Math.pow(numb.real, 2) + Math.pow(numb.imag, 2);
        this.real = (this.real * numb.real + this.imag * numb.imag) / denominator;
        this.imag = (this.imag * numb.real - numb.imag * this.real) / denominator;
        return this;
    }

    public static Complex div(Complex c1, Complex c2) {
        Complex c = new Complex(c1);
        return c.div(c2);
    }

    @Override
    public String toString() {
        return String.format("%.3f %s %.3fi", real, imag >= 0 ? "+" : "-", Math.abs(imag));
    }

    public String toPolar() {
        double radius = Math.sqrt(Math.pow(real, 2) + Math.pow(imag, 2));
        double angle = Math.atan(imag / real);
        return String.format("%.3f + (cos(%.3f) + i*sin(%.3f))", radius, angle, angle);
    }
}
