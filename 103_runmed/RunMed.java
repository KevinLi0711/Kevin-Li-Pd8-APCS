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
        If greater than median, add to minHeap
        If less than median add to maxHeap

        If there is an odd number of values, return the root 
        If there is an even number of values, take the mean of the roots of minHeap and maxHeap

        If it's the first element added in, set median to whatever you put in
    */
    ALHeapMax minVals;
    ALHeapMin maxVals;

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

        if (newVal == maxVals.peekMin() || newVal == minVals.peekMax()) {
            if (maxVals.size() < minVals.size()) {
                maxVals.add(newVal);
            } else {
                minVals.add(newVal);
            }
        }

        //If the value is greater than median, add it into the minHeap (maxVals). Otherwise, put it in
        else if (newVal > getMedian()) {
            //if you are adding to maxVals, and maxVals has a higher size, add the root of maxVals into minVals to balance things out
            if (maxVals.size() > minVals.size()) {
                minVals.add(maxVals.removeMin());
            }
            maxVals.add(newVal);
        } else {
            if (minVals.size() > maxVals.size()) {
                minVals.add(maxVals.removeMin());
            }
            minVals.add(newVal);
        }


    }

}
                                   
                                    
                                    