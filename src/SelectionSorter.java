public class SelectionSorter implements ISorter {
    private final IChecker checker;

    public SelectionSorter(IChecker checker) {
        this.checker = checker;
    }

    @Override
    public void sort(int[] values) {

        int n = values.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (values[j] < values[min_idx])
                    min_idx = j;

            // Swap the found minimum element with the first
            // element
            int temp = values[min_idx];
            values[min_idx] = values[i];
            values[i] = temp;
        // Pamiętaj o wywołaniu checker.check(values); po kazdym wywołaniu zewnętrznej petli
        checker.check(values);
        }
    }
}
