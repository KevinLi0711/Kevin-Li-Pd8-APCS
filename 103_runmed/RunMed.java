/*
Gatekeeping Girlboss Gremlins: Lauren Lee, Kevin Li, Kevin Xiao
APCS
HW103 -- Erica’s Friends, Hugo, and The One in the Middle
time spent: 1 hour

DISCO
    - minOf and minChildPos are private because they are only meant to be used within the ALHeap classes
    - minVals is a maxHeap because we want to know the largest of the numbers less than the median
    - maxVals is a minHeap because we want to know the smallest of the numbers greater than the median
QCC
    - the instance variable names make sense but they also make brain go ouchie
    - Why do we keep getting null pointer exceptions when we feed scanner input.nums?
*/
public class RunMed {
    /*
    for adding
0. If both heaps are empty, add the value to maxVals
1. If the added value is greater than the median, add it to maxVals
2. If the added value is less than the median, add it to minVals
3. If adding the value would make the difference in size of the two heaps be > 1, remove the root of the larger heap and add it to the smaller

for getting the median
1. If the size of the heaps are the same, then return the average of the two roots
2. If the size of the heaps are different, return the root of the larger heap
    */
    public ALHeapMax minVals;
    public ALHeapMin maxVals;

    public RunMed() {
        maxVals = new ALHeapMin();
        minVals = new ALHeapMax();
    }

    public double getMedian() {
        if (minVals.size() == maxVals.size()) {
            return (maxVals.peekMin() + minVals.peekMax()) / 2.0;
        } else {
            if (minVals.size() > maxVals.size()) {
                return minVals.peekMax();
            } else {
                return maxVals.peekMin();
            }
        }
    }

    public void add(Integer newVal) {

        //If both heaps are empty, just add the value to min
        if (maxVals.isEmpty() && minVals.isEmpty()) {
            maxVals.add(newVal);
        } 
        //If the value is greater than median, add it into the minHeap (maxVals). Otherwise, put it in
        else if (newVal > getMedian()) {
            //if you are adding to maxVals, and maxVals has a higher size, add the root of maxVals into minVals to balance things out
            if (maxVals.size() > minVals.size()) {
                //System.out.println("min of maxVal moved");
                minVals.add(maxVals.removeMin());
            }
            maxVals.add(newVal);
        } else {
            if (minVals.size() > maxVals.size()) {
                //System.out.println("max of minVal moved");
                maxVals.add(minVals.removeMax());
            }
            minVals.add(newVal);
        }


    }

}
