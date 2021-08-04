package com.solvd.bubbleSorting.runner;

public class Runner {
    public final static void main(String[] args){

        int[] sortingArray = {25, 13,20,14,2,8,1,-2,0};
        // auxiliary variable for the bubbling process
        int aux;

        // Bubble sorting from lower to higher
        for (int i=0; i < sortingArray.length; i++) {
            for (int j = 0; j < sortingArray.length - 1; j++) {
                if (sortingArray[j] > sortingArray[j + 1]) {
                    aux = sortingArray[j];
                    sortingArray[j] = sortingArray[j + 1];
                    sortingArray[j + 1] = aux;
                }
            }
        }
        // Displaying the result
        for (int i=0; i < sortingArray.length; i++) {
            System.out.print (sortingArray[i] + " ");
        }
    }
}
