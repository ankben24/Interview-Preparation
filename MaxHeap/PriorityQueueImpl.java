//Code without using PriorityQueue standard library, so that we can clear our MaxHeap concepts.

/**
* Article Link : https://www.hackerearth.com/practice/data-structures/trees/heapspriority-queues/tutorial/#c252342
**/

import java.util.*;

class TestClass {
  //size of the array = initialNumberOfElements (i.e. 10^5) + numberOfQuery (i.e. 10^4)
  static int[] array = new int[100005 + 10005];
  static int count = 1;
  public static void main(String args[]) throws Exception {
    // Initialize the first index of the array as we are not gonna use it
    array[0] = -1;
    //Scanner
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    //System.out.println("Input integer is : " + n);
    for (int i = 1; i <= n; i++) {
      int input = sc.nextInt();
      array[i] = input;
      count++;
    }

    // build maxheap
    buildMaxHeap(n);

    int q = sc.nextInt();

    for (int i = 1; i <= q; i++) {
      int operation = sc.nextInt();
      //System.out.println("Operation is : " + operation);
      if (operation == 1) {
        int elementToAdd = sc.nextInt();
        //System.out.println("elementToAdd is : " + elementToAdd);
        addElementInMaxHeap(elementToAdd);
      } else {
        int currentMaxElement = getMaxElementFromMaxHeap();
        System.out.println(currentMaxElement);
      }
    }
  }

  // adding new element in the array
  // O(logN)
  public static void addElementInMaxHeap(int x) {
    array[++count] = x;
    int parentOfCurrent = count / 2;
    int current = count;
    while (parentOfCurrent >= 1 && array[current] > array[parentOfCurrent]) {
      swap(current, parentOfCurrent);
      current = parentOfCurrent;
      parentOfCurrent = current / 2;
    }
  }

  //getting max element from the array
  // O(1)
  public static int getMaxElementFromMaxHeap() {
    return count > 1 ? array[1] : -1;
  }

  //O(N) or O(size) where size = n
  public static void buildMaxHeap(int size) {
    for (int i = size / 2; i >= 1; i--) {
      maxHeapify(size, i);
    }
  }

  //O(1)
  public static void swap(int a, int b) {
    int temp = array[a];
    array[a] = array[b];
    array[b] = temp;
  }

  // O(logN)
  public static void maxHeapify(int size, int i) {
    int left = 2 * i;
    int right = 2 * i + 1;
    int largest = i;
    if (left <= size && array[left] > array[i]) {
      largest = left;
    }
    if (right <= size && array[right] > array[largest]) {
      largest = right;
    }
    if (largest != i) {
      swap(largest, i);
      maxHeapify(size, largest);
    }
  }
}
