# 649. Dota2 Senate

In the world of Dota2, there are two parties: the Radiant and the Dire.

The Dota2 senate consists of senators coming from two parties. Now the Senate wants to decide on a change in the Dota2 game. The voting for this change is a round-based procedure. In each round, each senator can exercise one of the two rights:

1. **Ban one senator's right**: A senator can make another senator lose all their rights in this and all the following rounds.
2. **Announce the victory**: If this senator finds that the senators who still have rights to vote are all from the same party, they can announce the victory and decide on the change in the game.

Given a string `senate` representing each senator's party belonging, the character `'R'` and `'D'` represent the Radiant party and the Dire party, respectively. If there are `n` senators, the size of the given string will be `n`.

The round-based procedure starts from the first senator to the last senator in the given order. This procedure will last until the end of voting. All the senators who have lost their rights will be skipped during the procedure.

Suppose every senator is smart enough and will play the best strategy for their own party. Predict which party will finally announce the victory and change the Dota2 game. The output should be `"Radiant"` or `"Dire"`.

---

## Examples

### Example 1:
**Input:**  
`senate = "RD"`

**Output:**  
`"Radiant"`

**Explanation:**  
- The first senator comes from Radiant and can ban the next senator's right in round 1.  
- The second senator can't exercise any rights anymore since their right has been banned.  
- In round 2, the first senator can announce the victory since they are the only one in the senate who can vote.

---

### Example 2:
**Input:**  
`senate = "RDD"`

**Output:**  
`"Dire"`

**Explanation:**  
- The first senator comes from Radiant and can ban the next senator's right in round 1.  
- The second senator can't exercise any rights anymore since their right has been banned.  
- The third senator comes from Dire and can ban the first senator's right in round 1.  
- In round 2, the third senator can announce the victory since they are the only one in the senate who can vote.

---

## Constraints:
- `n == senate.length`
- `1 <= n <= 10⁴`
- `senate[i]` is either `'R'` or `'D'`.