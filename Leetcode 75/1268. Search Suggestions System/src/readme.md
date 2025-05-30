# 1268. Search Suggestions System

## Problem Description

You are given an array of strings `products` and a string `searchWord`.

Design a system that suggests at most three product names from `products` after each character of `searchWord` is typed. Suggested products should have a common prefix with `searchWord`. If there are more than three products with a common prefix, return the three lexicographically minimum products.

Return a list of lists of the suggested products after each character of `searchWord` is typed.

---

## Examples

### Example 1:

**Input:**  
`products = ["mobile","mouse","moneypot","monitor","mousepad"]`,  
`searchWord = "mouse"`

**Output:**  
`[["mobile","moneypot","monitor"],["mobile","moneypot","monitor"],["mouse","mousepad"],["mouse","mousepad"],["mouse","mousepad"]]`

**Explanation:**  
- Products sorted lexicographically: `["mobile","moneypot","monitor","mouse","mousepad"]`.  
- After typing `m` and `mo`, all products match, and we show the user `["mobile","moneypot","monitor"]`.  
- After typing `mou`, `mous`, and `mouse`, the system suggests `["mouse","mousepad"]`.

---

### Example 2:

**Input:**  
`products = ["havana"]`,  
`searchWord = "havana"`

**Output:**  
`[["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]`

**Explanation:**  
The only word `"havana"` will always be suggested while typing the search word.

---

## Constraints

- `1 <= products.length <= 1000`
- `1 <= products[i].length <= 3000`
- `1 <= sum(products[i].length) <= 2 * 10^4`
- All the strings of `products` are unique.
- `products[i]` consists of lowercase English letters.
- `1 <= searchWord.length <= 1000`
- `searchWord` consists of lowercase English letters.