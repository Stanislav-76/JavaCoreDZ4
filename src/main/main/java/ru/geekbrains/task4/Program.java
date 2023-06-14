package ru.geekbrains.task4;

import static java.lang.Integer.parseInt;

public class Program {
    public static void main(String[] args) {
        String[][] array = {{"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}};
        try {
            System.out.println(sumElementArray(array));
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int sumElementArray(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        if (arr.length != 4) {
            throw new MyArraySizeException("Массив не размером 4х4");
        }
        for (int i = 0; i < 4; i++) {
            if (arr[i].length != 4) {
                throw new MyArraySizeException("Массив не размером 4х4");
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                try{
                    sum += parseInt(arr[i][j]);
                } catch (RuntimeException e) {
                    throw new MyArrayDataException("Ошибка преобразования в ячейке " + i + " " +  j);
                }
            }
        }
        return sum;
    }
}
