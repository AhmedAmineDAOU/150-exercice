# Merging Two Sorted Arrays

## Problem Description

Given two sorted arrays `A` and `B`:
- `A` has enough space at the end (filled with zeros) to accommodate all elements of `B`.
- The task is to merge both arrays into `A`, so that `A` remains sorted.

### Example

```plaintext
A = [1, 3, 5, 0, 0, 0], B = [2, 4, 6]

Result:
A = [1, 2, 3, 4, 5, 6]
````

### Logical Approach
#### 1. Understanding the Problem
   We have two arrays:
   Array A of size m + n, where the first m elements are sorted, and the last n elements are 0s.
   Array B of size n, which is also sorted.
   The task is to merge both arrays in place, placing the merged result in A.
#### 2. Key Insight: Merge from the End
   Since both arrays are sorted, the largest elements will be at the end of both arrays. Therefore, instead of merging from the beginning (which would require shifting many elements), we can start from the end of both arrays and place the largest elements at the back of A.

#### 3. Steps
   Initialize Pointers:

Set i to point to the last non-zero element in A (i.e., A[m-1]).
Set j to point to the last element in B (i.e., B[n-1]).
Set k to point to the last position in A (i.e., A[m + n - 1]), which is where the merged result will be placed.
Merge Process:

Compare the elements A[i] and B[j]:
If A[i] is greater than B[j], place A[i] at A[k], and decrement i and k.
Otherwise, place B[j] at A[k], and decrement j and k.
Repeat this process until all elements from either A or B are processed.
Edge Case:

If all elements of A are already merged and there are still elements left in B, simply copy the remaining elements from B into A.
Termination:

The process ends when all elements from B have been merged into A.
#### 4. Example Walkthrough
   Input:

A = [1, 3, 5, 0, 0, 0]
B = [2, 4, 6]
Steps:

Compare A[2] = 5 with B[2] = 6. Since 6 is greater, place 6 at A[5].

A = [1, 3, 5, 0, 0, 6]
Compare A[2] = 5 with B[1] = 4. Since 5 is greater, place 5 at A[4].

A = [1, 3, 5, 0, 5, 6]
Compare A[1] = 3 with B[1] = 4. Since 4 is greater, place 4 at A[3].

A = [1, 3, 5, 4, 5, 6]
Compare A[1] = 3 with B[0] = 2. Since 3 is greater, place 3 at A[2].

A = [1, 3, 3, 4, 5, 6]
Compare A[0] = 1 with B[0] = 2. Since 2 is greater, place 2 at A[1].

A = [1, 2, 3, 4, 5, 6]
#### 5. Complexity
   Time Complexity: O(m + n), where m is the number of non-zero elements in A and n is the size of B. Each element is processed exactly once.
   Space Complexity: O(1), since the merging is done in place using the extra space available in A.