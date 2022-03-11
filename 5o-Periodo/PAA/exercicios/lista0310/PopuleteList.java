package exercicios.lista0310;

import java.util.Random;

public class PopuleteList {
  private int size;
  private int[] list;
  private int countBin;

  public PopuleteList(int size) {
    this.size = size;

    this.list = new int[this.size];
  }

  public int[] crescente() {
    for (int i = 0; i < this.size; i++) {
      list[i] = i;
    }

    return list;
  }

  public int[] decrescente() {
    for (int i = 0; i < this.size; i++) {
      list[i] = (this.size - 1) - i;
    }

    return list;
  }

  public int[] aleatorio() {
    Random random = new Random(3);
    
    for (int i=0; i<this.size; i++) {
      list[i] = random.nextInt(199);
    }

    return list;
  }

  public String showArray(int[] arr) {
    String str = "";
    for (int i : arr) {
      str += i + ", ";
    }
    return str;
  }

  public String find78(int[] arr) {
    int count = 0;
    Long startTime = System.nanoTime();
    for (int i : arr) {
      if (i != 78) count++;
      else break;
    }
    Long endTime = System.nanoTime();
    Double diff = (endTime.doubleValue() - startTime.doubleValue())/ 1000000; 

    return String.format("%d\t%.4f ms", count, diff);
  }

  public String find78Binary(int[] arr) {
    this.list = arr;
    this.countBin = 0;

    Long startTime = System.nanoTime();
    binary(0, this.list.length - 1);
    Long endTime = System.nanoTime();
    Double diff = (endTime.doubleValue() - startTime.doubleValue())/ 1000000; 

    return String.format("%d\t%.4f ms", this.countBin, diff);
  }

  private int binary(int left, int right) {
    if (left <= right) {
      int middle = left + (right - left) / 2;

      if (this.list[middle] == 78) {
        this.countBin += 2;
        return middle;
      } else if (this.list[middle] > 78 ) {
        this.countBin += 3;
        return binary(left, middle - 1);
      }
      
      this.countBin += 3;
      return binary(middle + 1, right);
    } 
    return 1;
  }
}
