package com.logvin.simplexmethod.algorithm;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		
		double[] expression = {-2, -3};
		double[][] limitation = {{6, 1, 2},
								 {8, 2, 1},
								 {2, 1, 0},
								 {1, 1, -1}};
		int type = -1;
		
		SimplexMethod simplexMethod = new SimplexMethod(expression, limitation, type);
		System.out.println(simplexMethod.createSimplexTable());
		List<SimplexTable> tablesList = new ArrayList<>();
		tablesList = simplexMethod.solveSimplexMethod();
		tablesList.forEach(tl -> System.out.println(tl));
	}

}
