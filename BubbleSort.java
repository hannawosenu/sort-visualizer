public class BubbleSort {
    public static void sort(int[] arr, SortingVisualizerPanel panel, int sleepVal) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    panel.updateArray(arr);
                    panel.repaint();
                    try {
                        Thread.sleep(sleepVal);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
