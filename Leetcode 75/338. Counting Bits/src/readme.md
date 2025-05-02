# 338. Counting Bits

## Problem Statement

Given an integer `n`, return an array `ans` of length `n + 1` such that for each `i` (0 <= i <= n), `ans[i]` is the number of `1`s in the binary representation of `i`.

---

## Examples

### Example 1:
**Input:**  
`n = 2`  
**Output:**  
`[0,1,1]`  

**Explanation:**  
- `0` --> `0`  
- `1` --> `1`  
- `2` --> `10`  

---

### Example 2:
**Input:**  
`n = 5`  
**Output:**  
`[0,1,1,2,1,2]`  

**Explanation:**  
- `0` --> `0`  
- `1` --> `1`  
- `2` --> `10`  
- `3` --> `11`  
- `4` --> `100`  
- `5` --> `101`  

---

## Constraints

- `0 <= n <= 10^5`

---

## Follow-Up

1. Can you come up with a solution with a runtime of `O(n log n)`?  
2. Can you optimize it to linear time `O(n)` and possibly in a single pass?  
3. Can you solve it without using any built-in functions (e.g., `__builtin_popcount` in C++)?