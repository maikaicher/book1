int[][] ar = new int[3][];
ar[0] = new int[] {1, 1};
ar[1] = new int[] {2, 2};
ar[2] = new int[] {3, 3};
foreach(int[] i in ar) {
  i[0]++;
}
foreach(int[] i in ar) {
  Console.WriteLine(i[0]);
}
