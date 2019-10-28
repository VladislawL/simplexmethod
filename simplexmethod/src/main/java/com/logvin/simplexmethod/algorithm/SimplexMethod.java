package com.logvin.simplexmethod.algorithm;

import java.util.ArrayList;
import java.util.List;

public class SimplexMethod {
	
	private double[] expression;
	private double[][] limitation;
	private int type;
	
	public SimplexMethod(double[] expression, double[][] limitation, int type) {
		this.expression = expression;
		this.limitation = limitation;
		this.type = type;
	}
	
	public SimplexTable createSimplexTable() {
		double[][] table = new double[limitation.length + 1][expression.length + limitation.length + 1];
		for(int i = 0; i < limitation.length; i++) {
			table[i][expression.length + 1 + i] = 1;
			for(int j = 0; j < limitation[0].length; j++) {
				table[i][j] = limitation[i][j];
			}
		}
		
		table[table.length-1][0] = 0;
		for(int i = 0; i < expression.length; i++) {
			table[table.length - 1][i + 1] = expression[i] * (-1); 
		}
		
		List<Integer> basisVariables = new ArrayList<>();
		for(int i = expression.length + 1; i < table[0].length; i++) {
			basisVariables.add(i);
		}
		
		return new SimplexTable(table, type, basisVariables);
	}
	
	public List<SimplexTable> solveSimplexMethod(){
		
		List<SimplexTable> listOfTables = new ArrayList<>();
		SimplexTable simplexTable = createSimplexTable();
		listOfTables.add(simplexTable);
		
		while(!simplexTable.isOptimal()) {
			simplexTable = simplexTable.newTable();
			listOfTables.add(simplexTable);
		}
		
		return listOfTables;
	} 
}