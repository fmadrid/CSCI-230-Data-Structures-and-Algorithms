package LabSolutions.ObjectOrientedProgramming;

import java.util.ArrayList;
import java.util.Collection;

public class Polynomial<T extends Number> {

	ArrayList<T> coefficients;
	
	Polynomial() {
		coefficients = new ArrayList<>();
	}
	
	Polynomial(Collection<T> c) {
		coefficients = new ArrayList<>();
		coefficients.addAll(c);
	}
	
	Polynomial(Polynomial<T> p) {
		coefficients = new ArrayList<>();
		coefficients.addAll(p.coefficients);
	}

	
	Polynomial<T> add(Polynomial<T> p) {
		return null;
	}
	
	public static <T extends Number> Polynomial<T> add(Polynomial<T> p1, Polynomial<T> p2) {
		if(p1.coefficients.isEmpty()) return p2;
		else if(p2.coefficients.isEmpty()) return p1;
		else {
			Polynomial<T> temp = new Polynomial<>(p1);
			temp.coefficients.ensureCapacity(Math.min(p1.coefficients.size(), p2.coefficients.size()));
			for(int i = 0; i < p1.coefficients.size() && i < p2.coefficients.size(); ++i) {
				if(i < p1.coefficients.size())
					p1.coefficients.set(i, p1.coefficients.get(i).doubleValue() + p2.coefficients.get(i).doubleValue());
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
