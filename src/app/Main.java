package app;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = new int[4][4];
        fillMatrix(matrix);

        printMatrix(matrix);

        int sumEvenRows = 0, sumOddRows = 0;
        int productEvenColumns = 1, productOddColumns = 1;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i % 2 == 0) {
                    sumEvenRows += matrix[i][j];
                } else {
                    sumOddRows += matrix[i][j];
                }

                if (j % 2 == 0) {
                    productEvenColumns *= matrix[i][j];
                } else {
                    productOddColumns *= matrix[i][j];
                }
            }
        }

        System.out.println("Сума елементів у парних рядках: " + sumEvenRows);
        System.out.println("Сума елементів у непарних рядках: " + sumOddRows);
        System.out.println("Добуток елементів у парних стовпцях: " + productEvenColumns);
        System.out.println("Добуток елементів у непарних стовпцях: " + productOddColumns);

        boolean isMagicSquare = isMagicSquare(matrix);
        if (isMagicSquare) {
            System.out.println("Матриця є магічним квадратом.");
        } else {
            System.out.println("Матриця не є магічним квадратом.");
        }
    }

    private static void fillMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int) (Math.random() * 50) + 1;
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private static boolean isMagicSquare(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[0][i];
        }

        for (int i = 1; i < matrix.length; i++) {
            int tempSum = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                tempSum += matrix[i][j];
            }
            if (tempSum != sum) {
                return false;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            int tempSum = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                tempSum += matrix[j][i];
            }
            if (tempSum != sum) {
                return false;
            }
        }

        int tempSum = 0;
        for (int i = 0; i < matrix.length; i++) {
            tempSum += matrix[i][i];
        }
        if (tempSum != sum) {
            return false;
        }

        tempSum = 0;
        for (int i = 0; i < matrix.length; i++) {
            tempSum += matrix[i][matrix.length - 1 - i];
        }
        return tempSum == sum;
    }
}

