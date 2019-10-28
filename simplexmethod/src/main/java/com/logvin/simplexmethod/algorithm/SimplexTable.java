package com.logvin.simplexmethod.algorithm;

import java.util.ArrayList;
import java.util.List;

public class SimplexTable {
	private double [][] table;
	private List<Integer> basisVariables;
	private int type;
	String s;
	
	public SimplexTable(double [][] table, int type, List<Integer> basisVariables) {
		this.table = table;
		this.type = type < 0 ? -1 : 1;
		this.basisVariables = basisVariables;
	}
	
	public SimplexTable newTable() {
		int resolvingCol = findResolvingColumn();
		int resolvingRow = findResolvingRow();
		double resolvingElement = table[resolvingRow][resolvingCol];
		
		double [][] newTable = new double[table.length][table[0].length];
		
		for(int i = 0; i < table[0].length; i++) {
			newTable[resolvingRow][i] = table[resolvingRow][i] / resolvingElement;
		}
		
		for (int i = 0; i < table.length; i++){
            if (i == resolvingRow)
                continue;
            for (int j = 0; j < table[0].length; j++) {
            	if(j == resolvingCol) {
            		newTable[i][j] = 0;
            	}
                newTable[i][j] = (table[i][j] * resolvingElement - table[i][resolvingCol] * table[resolvingRow][j]) / resolvingElement;
            }
        }
		
		newTable[resolvingRow][resolvingCol] = 1;
		basisVariables.set(resolvingRow, resolvingCol);
		
		return new SimplexTable(newTable, type, basisVariables);
		
	}
	
	public boolean isOptimal() {
		for(int i = 1; i < table[0].length; i++) {
			if(table[table.length - 1][i] * type < 0) {
				return false;
			}
		}
		return true;
	}
	
	public int findResolvingColumn() {
		
		double max = Integer.MIN_VALUE;
		int maxIndex = 0;
		
		for(int i = 1; i < table[0].length; i++) {
			if(table[table.length - 1][i] * type < 0) {
				if(Math.abs(table[table.length - 1][i]) > max) {
					max = Math.abs(table[table.length - 1][i] );
					maxIndex = i;
				}
			}
		}
		
		return maxIndex;
	}
	
	public int findResolvingRow() {
		double min = Double.MAX_VALUE;
		int minIndex = 0;
		int resolvingColumn = findResolvingColumn();
		
		for(int i = 0; i < table.length - 1; i++) {
			if(table[i][resolvingColumn] <= 0) { continue; }
			if(table[i][0] / table[i][resolvingColumn] < min) {
				min = table[i][0]/table[i][resolvingColumn];
				minIndex = i;
			}
		}
		return minIndex;
	}

	@Override
	public String toString() {
		s = "Table: \n";
		
		for(double [] d: table) {
			for(double number: d) {
				s += number + ", ";
			}
			s+= "\n";
		}
		
		basisVariables.forEach(bv -> s += bv + ", ");
		s += "\n";
		s += type < 0 ? "min" : "max";
		
		return s;
	}
	
	
	
}
