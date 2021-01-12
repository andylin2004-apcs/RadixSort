import java.lang.Math;

class Radix{
  public static int nth(int n, int col){
    return (n/(int)(Math.pow(10, col)))%10;
  }
  public static int length(int n){
    return (int)(Math.log10(Math.abs(n))+1);
  }
  public static void merge(MyLinkedList original,MyLinkedList[]buckets){
    for (int i = 0; i<buckets.length; i++){
      original.extend(buckets[i]);
    }
  }
  public static void merge( SortableLinkedList original, SortableLinkedList[]buckets){
    for (int i = 0; i<buckets.length; i++){
      original.extend(buckets[i]);
    }
  }
  public static void radixSortSimple(SortableLinkedList data){
    int maxLength = length(findMax(data));
    SortableLinkedList toProcess = data;
    for (int slot = 0; slot<maxLength; slot++){
      SortableLinkedList[] bucket = new SortableLinkedList[10];
      for (int i = 0; i < 10; i++){
        bucket[i] = new SortableLinkedList();
      }
      for (int i = 0; i<toProcess.size(); i++){
        int curNum = toProcess.get(i);
        bucket[nth(curNum, slot)].add(curNum);
      }
      toProcess = new SortableLinkedList();
      merge(toProcess, bucket);
    }
    data = new SortableLinkedList();
    data.extend(toProcess);
  }
  private static int findMax(SortableLinkedList data){
    int max = data.get(0);
    for (int i = 1; i<data.size(); i++){
      max = Math.max(max, data.get(i));
    }
    return max;
  }
  // Assume there are no negative values.
  // Use the algorithm described in class/class notes
  //
  // Hint: Try to calculate the largest number on your least significant digit pass. This tells your method how many passes are needed.
  //
  // 6. Write a method that sorts any integer values: [This part can be very easy or not as easy depending how you wrote the first method. It is the least important part, and I expect some students will not complete it.]
  // public static void radixSort(SortableLinkedList data)
  // We have not discussed a strategy to handle this in class.
  // If you cannot complete this method, make sure the method is present so that the tester will compile!
}
