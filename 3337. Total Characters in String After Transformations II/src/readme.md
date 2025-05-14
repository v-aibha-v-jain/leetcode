# 3337. Total Characters in String After Transformations II

You are given:

- A string `s` consisting of lowercase English letters.
- An integer `t` representing the number of transformations to perform.
- An array `nums` of size 26.

In one transformation, every character in `s` is replaced according to the following rules:

- Replace `s[i]` with the next `nums[s[i] - 'a']` consecutive characters in the alphabet.
    - For example, if `s[i] = 'a'` and `nums[0] = 3`, then `'a'` transforms into `"bcd"`.
- The transformation wraps around the alphabet if it exceeds `'z'`.
    - For example, if `s[i] = 'y'` and `nums[24] = 3`, then `'y'` transforms into `"zab"`.

Return the length of the resulting string after exactly `t` transformations.

Since the answer may be very large, return it modulo `10^9 + 7`.

---

## Examples

### Example 1

**Input:**
```
s = "abcyy"
t = 2
nums = [1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2]
```

**Output:** `7`

**Explanation:**

- **First Transformation (t = 1):**
    - `'a'` → `'b'` (nums[0] = 1)
    - `'b'` → `'c'` (nums[1] = 1)
    - `'c'` → `'d'` (nums[2] = 1)
    - `'y'` → `'z'` (nums[24] = 1)
    - `'y'` → `'z'` (nums[24] = 1)
    - Result: `"bcdzz"`

- **Second Transformation (t = 2):**
    - `'b'` → `'c'` (nums[1] = 1)
    - `'c'` → `'d'` (nums[2] = 1)
    - `'d'` → `'e'` (nums[3] = 1)
    - `'z'` → `'ab'` (nums[25] = 2)
    - `'z'` → `'ab'` (nums[25] = 2)
    - Result: `"cdeabab"`

- **Final Length:** `7`

---

### Example 2

**Input:**
```
s = "azbk"
t = 1
nums = [2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2]
```

**Output:** `8`

**Explanation:**

- **First Transformation (t = 1):**
    - `'a'` → `'bc'` (nums[0] = 2)
    - `'z'` → `'ab'` (nums[25] = 2)
    - `'b'` → `'cd'` (nums[1] = 2)
    - `'k'` → `'lm'` (nums[10] = 2)
    - Result: `"bcabcdlm"`

- **Final Length:** `8`

---

## Constraints

- `1 <= s.length <= 10^5`
- `s` consists only of lowercase English letters.
- `1 <= t <= 10^9`
- `nums.length == 26`
- `1 <= nums[i] <= 25`