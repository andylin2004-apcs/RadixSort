import java.lang.Math;
import java.util.Arrays;

class Radix{
  public static int nth(int n, int col){
    return Math.abs((n/(int)(Math.pow(10, col)))%10);
  }
  public static int length(int n){
    return (int)(Math.log10(Math.abs(n))+1);
  }
  // public static void merge(MyLinkedList original,MyLinkedList[]buckets){
  //   for (int i = 0; i<buckets.length; i++){
  //     original.extend(buckets[i]);
  //   }
  // }
  public static void merge( SortableLinkedList original, SortableLinkedList[]buckets){
    for (int i = 0; i<buckets.length; i++){
      original.extend(buckets[i]);
    }
  }
  public static void radixSortSimple(SortableLinkedList data){
    int maxLength = length(findMax(data));
    for (int slot = 0; slot<maxLength; slot++){
      SortableLinkedList[] bucket = new SortableLinkedList[10];
      for (int i = 0; i < 10; i++){
        bucket[i] = new SortableLinkedList();
      }
      while(data.size() > 0){
        int curNum = data.remove(0);
        bucket[nth(curNum, slot)].add(curNum);
      }
      merge(data, bucket);
    }
  }
  private static int findMax(SortableLinkedList data){
    SortableLinkedList test = new SortableLinkedList();
    int max = data.remove(0);
    test.add(max);
    while (data.size() > 0){
      int removed = data.remove(0);
      test.add(removed);
      max = Math.max(max, Math.abs(removed));
    }
    data.extend(test);
    return max;
  }
  private static SortableLinkedList reverseLinkedList(SortableLinkedList toReverse){
    SortableLinkedList result = new SortableLinkedList();
    while (toReverse.size() > 0){
      result.add(0, toReverse.remove(0));
    }
    return result;
  }
  // public static void main(String[] args) {
  //   SortableLinkedList meme = new SortableLinkedList();
  //   meme.add(1);
  //   meme.add(2);
  //   meme.add(3);
  //   meme.add(11);
  //   meme.add(9);
  //   meme.add(-1);
  //   meme.add(7);
  //   meme.add(1);
  //   meme.add(-11);
  //   meme.add(2);
  //   meme.add(1);
  //   meme.add(2);
  //   meme.add(3);
  //   meme.add(11);
  //   meme.add(9);
  //   meme.add(-1);
  //   meme.add(7);
  //   meme.add(1);
  //   meme.add(-11);
  //   meme.add(2);
  //   // radixSortSimple(meme);
  //   radixSort(meme);
  //   System.out.println(meme);
  // }
  // Assume there are no negative values.
  // Use the algorithm described in class/class notes
  //
  // Hint: Try to calculate the largest number on your least significant digit pass. This tells your method how many passes are needed.
  //
  // 6. Write a method that sorts any integer values: [This part can be very easy or not as easy depending how you wrote the first method. It is the least important part, and I expect some students will not complete it.]
  public static void radixSort(SortableLinkedList data){
    SortableLinkedList[] bucket = new SortableLinkedList[2];
    for (int i = 0; i<2; i++){
      bucket[i] = new SortableLinkedList();
    }
    while (data.size() != 0){
      int now = data.remove(0);
      if (now < 0){
        bucket[0].add(now);
      }else{
        bucket[1].add(now);
      }
    }
    if (bucket[0].size() > 0){
      radixSortSimple(bucket[0]);
    }
    if (bucket[1].size() > 0){
      radixSortSimple(bucket[1]);
    }
    bucket[0] = reverseLinkedList(bucket[0]);
    merge(data, bucket);
  }
  // We have not discussed a strategy to handle this in class.
  // If you cannot complete this method, make sure the method is present so that the tester will compile!
}
