package com.zagniotov.puzzles.rotatearray;

public class MatrixFlipperTakeOne {


   public static void main(final String[] args) {
      final Matrix matrix = new Matrix(6, 6);
      matrix.dump();
      //matrix.rotateCounterClockWise();
      matrix.rotateClockWise();
      matrix.dump();
   }

   private static class Matrix {

      private final int columns;
      private final int rows;
      private final int[][] matrix;

      Matrix(final int columns, final int rows) {
         this.columns = columns;
         this.rows = rows;
         matrix = new int[this.rows][this.columns];
         init();
      }

      void rotateCounterClockWise() {
         int cache;

         for (int row = 0; row < this.rows / 2; row++) {
            for (int col = 0; col < Math.ceil(((double) this.columns) / 2.0); col++) {
               cache = matrix[row][col];

               matrix[row][col] = matrix[col][this.rows - 1 - row];
               matrix[col][this.rows - 1 - row] = matrix[this.rows - 1 - row][this.columns - 1 - col];
               matrix[this.rows - 1 - row][this.columns - 1 - col] = matrix[this.columns - 1 - col][row];
               matrix[this.columns - 1 - col][row] = cache;

               System.out.println("Cached: " + cache);
            }
         }
      }

      void rotateClockWise() {
         int cache;
         for (int row = 0; row < this.rows / 2; row++) {
            for (int col = 0; col < Math.ceil(((double) this.columns) / 2.0); col++) {
               cache = matrix[row][col];

               matrix[row][col] = matrix[this.columns - 1 - col][row];
               matrix[this.columns - 1 - col][row] = matrix[this.rows - 1 - row][this.columns - 1 - col];
               matrix[this.rows - 1 - row][this.columns - 1 - col] = matrix[col][this.rows - 1 - row];
               matrix[col][this.rows - 1 - row] = cache;

               System.out.println("Cached: " + cache);
            }
         }
      }

      void dump() {
         for (int row = 0; row < this.rows; row++) {
            for (int col = 0; col < this.columns; col++) {
               System.out.print(matrix[row][col] + "\t");
            }
            System.out.println();
         }
         System.out.println();
      }

      private void init() {
         int counter = 1;
         for (int row = 0; row < this.rows; row++) {
            for (int col = 0; col < this.columns; col++) {
               matrix[row][col] = counter++;
            }
         }
      }
   }
}
