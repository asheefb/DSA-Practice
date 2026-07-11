Two Pointers
-------------
###
    Read Problem
    │
    ▼
    Is it a LeetCode.String or Array?
    │
    ▼
    Compare both ends?
    │
    ├── Yes → Two Pointers
    │
    ▼
    Sorted?
    │
    ├── Yes → Think Two Pointers
    │
    ▼
    Need pair?
    │
    ├── Yes → Think Two Pointers
    │
    ▼
    Need in-place modification?
    │
    ├── Yes → Think Two Pointers

Sliding Window
-------------
###
    WHAT?
    Process a continuous window.
    
    WHY?
    Avoid recalculating repeated work.
    
    WHEN?
    ✔ Subarray
    ✔ Substring
    ✔ Consecutive
    ✔ Continuous
    ✔ Window
    
    WHEN NOT?
    ✘ Random elements
    
    Types
    1. Fixed Window
    2. Variable Window

Difference
-
####
    Two Pointers
    ↓
    
    Two indices solving a problem.
    
    Sliding Window
    
    ↓
    
    A continuous range whose size is fixed or changes.