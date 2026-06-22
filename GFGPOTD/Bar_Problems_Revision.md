# DSA Revision Sheet - Bar Problems & Pattern Recognition

## Step 1: Identify the Pattern

### A. Need answer for every index?

Examples:

* Trapping Rain Water
* Daily Temperatures
* Stock Span

Ask yourself:

```text
For each index i,
do I need information from left/right?
```

Possible tools:

* Prefix/Suffix Arrays
* Monotonic Stack
* Dynamic Programming

---

### B. Need to choose a pair (i, j)?

Examples:

* Container With Most Water
* Two Sum Sorted
* Pair Difference Problems

Ask yourself:

```text
Am I selecting two positions
to maximize/minimize something?
```

Possible tools:

* Two Pointers
* Sorting + Two Pointers

---

### C. Need nearest greater/smaller element?

Examples:

* Largest Rectangle Histogram
* Next Greater Element
* Stock Span

Ask yourself:

```text
How far can I extend
until a smaller/greater element appears?
```

Possible tools:

* Monotonic Stack

---

# 1. Trapping Rain Water

## Formula

```text
water[i] =
min(maxLeft[i], maxRight[i])
- height[i]
```

## Visualization

```text
Height:
3 0 2 0 4

maxLeft:
3 3 3 3 4

maxRight:
4 4 4 4 4
```

## Recognition Clues

* Water
* Rain
* Trapped
* Amount stored

## Approach

```text
Prefix/Suffix Arrays
OR
Two Pointers
```

## Complexity

```text
O(n) time
O(n) space

Optimized:
O(n) time
O(1) space
```

---

# 2. Container With Most Water

## Formula

```text
area =
min(height[left], height[right])
*
(right - left)
```

## GFG: Maximum Area Between Bars

```text
area =
min(height[left], height[right])
*
(right - left - 1)
```

## Recognition Clues

* Select any two bars
* Maximum area
* Choose pair

## Approach

```text
Two Pointers
```

## Key Observation

Always move the shorter bar.

```text
If left height < right height

Move left

Else move right
```

## Complexity

```text
O(n)
O(1)
```

---

# 3. Largest Rectangle in Histogram

## Core Idea

Every bar acts as the smallest bar.

Find:

```text
Previous Smaller Element (PSE)
Next Smaller Element (NSE)
```

## Formula

```text
width =
NSE - PSE - 1

area =
height[i] * width
```

## Example

```text
heights = [2,1,5,6,2,3]
```

For height = 5

```text
PSE = 1
NSE = 4

width = 4 - 1 - 1 = 2

area = 10
```

## Approach

```text
Monotonic Increasing Stack
```

## Complexity

```text
O(n)
O(n)
```

---

# Monotonic Stack Recognition

Immediately think Stack if you see:

```text
Next Greater Element
Previous Greater Element
Next Smaller Element
Previous Smaller Element
Stock Span
Largest Rectangle Histogram
Daily Temperatures
```

### Template

```java
while (!stack.isEmpty() &&
       arr[stack.peek()] >= arr[i]) {
    stack.pop();
}
```

---

# Two Pointer Recognition

Immediately think Two Pointers if you see:

```text
Choose two elements
Pair sum
Container problem
Sorted array pair problems
Palindrome checks
```

### Template

```java
while (left < right) {

    if (condition) {
        left++;
    } else {
        right--;
    }
}
```

---

# Interview Mental Checklist

## Question 1

```text
Am I computing an answer
for every index?
```

YES →

```text
Prefix/Suffix
Stack
DP
```

---

## Question 2

```text
Am I selecting a pair?
```

YES →

```text
Two Pointers
Sorting
```

---

## Question 3

```text
Do I need nearest greater/smaller?
```

YES →

```text
Monotonic Stack
```

---

# Quick Mapping Table

| Problem                     | Pattern                      |
| --------------------------- | ---------------------------- |
| Trapping Rain Water         | Prefix/Suffix + Two Pointers |
| Container With Most Water   | Two Pointers                 |
| Maximum Area Between Bars   | Two Pointers                 |
| Largest Rectangle Histogram | Monotonic Stack              |
| Next Greater Element        | Monotonic Stack              |
| Stock Span                  | Monotonic Stack              |
| Daily Temperatures          | Monotonic Stack              |
| Sliding Window Maximum      | Monotonic Deque              |
| Two Sum Sorted              | Two Pointers                 |

---

# One-Line Memory Trick

```text
Water → LeftMax + RightMax

Choose Two Bars → Two Pointers

Rectangle Histogram → Smaller Elements + Stack
```

---

# Pattern Recognition Flowchart

```text
Array Problem
│
├── Need answer for every index?
│      ├── Yes → Prefix/Suffix, Stack, DP
│      └── No
│
├── Choosing pair (i,j)?
│      ├── Yes → Two Pointers
│      └── No
│
├── Need nearest greater/smaller?
│      ├── Yes → Monotonic Stack
│      └── No
│
└── Fixed/Variable window?
       └── Sliding Window
```
