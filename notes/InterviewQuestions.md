Binary Search
-
### 1. Why does Binary Search require a sorted array? 
Binary Search requires a sorted array because after comparing with the middle element, we must know which half can be safely discarded. Without sorting, we cannot make that decision.
### 2. What happens after comparing with the middle element?
If mid is less than target then we make left = mid + 1 because there is no use searching below mid.
### 3. Why is Binary Search O(log n)?
Because every iteration reduces 50% of comparisons or reduces the search space by half
### 4. Can Binary Search work on an unsorted array?
No, because without sorting we cannot determine which half contains the target after comparing with the middle element.