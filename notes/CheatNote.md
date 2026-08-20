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

    Array / String
            │
            ▼
    Continuous?
            │
          YES
            │
            ▼
    Subarray?
    Substring?
    Consecutive?
            │
            ▼
    Sliding Window

Difference
-
####
    Two Pointers
    ↓
    
    Two indices solving a problem.
    
    Sliding Window
    
    ↓
    
    A continuous range whose size is fixed or changes.

Binary Search
-
    Array
    │
    ▼
    Sorted?
    │
    YES
    │
    ▼
    Searching?
    
    Finding Position?
    
    Finding Target?
    │
    ▼
    Binary Search

Stack
-----
        Read Problem
              │
              ▼
        Need the MOST RECENT element?
              │
              ├── Yes → Think Stack
              │
              ▼
        Need Last In, First Out (LIFO)?
              │
              ├── Yes → Think Stack
              │
              ▼
        Need to match pairs?
              │
              ├── Yes → Think Stack
              │
              ▼
        Need to undo operations?
              │
              ├── Yes → Think Stack
              │
              ▼
        Need to reverse something?
              │
              ├── Yes → Think Stack
              │
              ▼
        Need Previous / Next elements?
              │
              ├── Yes → Think Monotonic Stack

    Balanced, Nested, Undo, Reverse, History, Previous, Next, Nearest, Matching

Quick Comparison
-
####
    Two Pointers
    ↓
    Two indices
    -------------------------
    Sliding Window
    ↓
    Continuous range
    -------------------------
    Binary Search
    ↓
    Discard half the search space
    -------------------------
    Stack
    ↓
    Always care about the MOST RECENT element