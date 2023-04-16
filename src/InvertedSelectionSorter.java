public class InvertedSelectionSorter implements ISorter {
    private final IChecker checker;

    public InvertedSelectionSorter(IChecker checker) {
        this.checker = checker;
    }

    @Override
    public void sort(int[] values) {
        // Zaimplementuj algorytm SelectionSort "w drugą stronę" (czyli przechodząc od drugiej strony tablicy)
        // Pamiętaj o wywołaniu checker.check(values); po kazdym wywołaniu zewnętrznej petli
        // for each position, from values.length-1 down (left), find the next biggest item
        for(int i = values.length-1; i >= 1; i--){
            int maxIndex = i;
            for(int j = i-1; j >= 0; j--){
                if(values[j] > values[maxIndex]){
                    maxIndex = j;
                }
            }
            // and swap it into place "i"
            int temp = values[maxIndex];
            values[maxIndex] = values[i];
            values[i] = temp;

        checker.check(values);
        }
    }
}
