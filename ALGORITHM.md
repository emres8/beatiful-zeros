## Problem Statement

Amir loves binary strings, and whenever he gets bored, he makes a new challenge about binary strings to entertain himself. However, recently, he has devised a problem that really irritates him since he could not find a solution.
The game starts with n string of ones, and Amir’s goal is to turn all the ones to zeros. There are some rules that govern the game which are as follow:
1. You are allowed to change a bit in the sequence, however, all the bits with the most k distance would be toggled. For example, if k=2, then if you change a specific bit in the sequence the next two adjacent bits are also toggled.
2. The cost of changing the value of i-th bit is equal to c<sub>i</sub>.

## The Algorithm & Correctness


### Terminology: ###
* Flip: stands for both active and passive alteration of a bit.<br>
* Change: used when chosen bits are actively altered with their costs added <br>
* Toggle: used for collateral passive alterations <br>

### Previous Attempts and Enhancement of the Algorithm
We seperately evaluate below stratetigies to tackle the given problem. 
#### Divide & Conquer  
*  Inapplicable
*  An operation on the subproblem has impact outside its domain 
*  Boundary elements could not have been changed.
#### Dynamic Programming 
* Similarly, a solution to a subproblem in most cases was incompatible with the main problem. 
#### Greedy Approach
We determine Greedy Approach is applicable to the problem and started to create baseline algorithm. 
Some of the initial ideas are given below:
1. Change the bit with lowest cost from left k+1 and right k+1 bits  <br>
Problem: Medium values impacted the total cost. 

2. Avoid changing  the bit with highest cost.  To toggle it, choose a bit that can toggle it. <br>
Problem: Yet again the medium values were ignored.

3. A new string with elements representing the absolute value of the “change”: The costs of the bits flipped minus the changing cost. <br>
Problem: Extra space allocated. 

4. Grouping bits with a difference of 2k+1 for full coverage. <br>
Problem:The solutions with uneven distribution were unavailable.

 Eventually, we fix problematic parts of the previous algorithms and develop our final algorithm. 
 <br> We came up with two lemmas which reduces the number of possible solutions significantly.
    





#### Lemma 1: The number of required toggle is same for all bits 
Proof: <br>
For two consecutive bits, M and M+1, they will be toggled simultaneously unless the bits M-k or M+k+1 are changed. Considering that these two initial bits will end up as “zeros”, these bits have to be toggled even times. Since the difference between the toggle numbers of two consecutive bits can at most be 1, they necessarily have to be toggled the same amount. That means if M-k is changed, so must M+k+1. Similarly, if M-k is unchanged, so won’t M+k+1. For a potential solution, it will be arranged that there will be 2k spacing between each “change”. In order to cover the first and last elements, one bit from the first k+1 bits from both left and right must be changed. 

#### Lemma 2: Any solution that requires more than one toggle on a specific bit can be reduced to another solution with at most one toggle switch per bit. 
Proof: <br>
For a solution S, the last element needs to be toggled, so a bit from the last k+1 bits must have been changed, coming to the first element by changing every (2k+1)th bit from the initial bit, we managed to flip the first elements as well. That would mean any solution S can be reduced to a version where no bit is changed more than once. 

### The Algorithm: <br>
Lemma 1 and 2 together implies a particular solution of the problem needs to toggle each bit exactly one time.  There are finitely many such solutions and our strategy is simply to compute the corresponding cost values of all such solutions. Then, we compare results and select the solution with the minimum cost. Listing all available solutions is not a difficult task, since we know that the first bit must be toggled exactly one time. To provide that, we select one of the first k+1 bits and change it first. This means we have k+1 available solutions. Then the algorithm skips the next 2k bits and toggles the next bit iteratively until the last bit has the value 0. For this to happen the last changed bit must be between [n-k-1,n].

### Complexities:
Since this algorithm involves changing each bit (total of n bits) for k+1 times, total complexity is O(nk). Since we only use two arrays of size n for the implementation, our space complexity is O(n).

### Correctness: 
This section aims to show our solution indeed toggles all the bits to 0.<br>
We must ensure the first bit must be flipped once. Hence, the algorithm selects one of the first k+1 bits and changes it first. Suppose we changed the bit with index p. The fact that 0<p<=k+1 and the definition of the k proves the first k+1 bits are flipped. Next bit to change is the one with index   p + 2k + 1.
We skipped 2k bits [p+1,p+2k] and we want to show those bits are indeed flipped. The left k bits [p+1,p+k] are flipped by the toggle on p, and the right k bits [p+k+1,p+2k]  are flipped by the change on p+2k+1. Then continue to change bits with indexes  p + 4k + 2, p + 6k + 3 until there is not any bit with value 1. Since we started from the beginning of the bit string, we only check whether the last bit has value 0 to stop iterations. This shows all bits are toggled exactly one time.
<br>
Initially we chose one of the k+1 bits. This shows that we have k+1 possible solutions. The algorithm calculates the cost for each of them then selects the solution with the minimum cost.

### An improved algorithm with better run times: <br>
After consideration of future improvements, we have come up with an improved version of the previously described algorithm. Instead of changing each bit to 0 and then checking if that is a valid solution, it calculates the k+1 bits that would give a possible solution. Then it compares the costs of each solution and returns the minimum, similar to the previous algorithm. Cuts the run-time from O(nk) to O(n), and even to O(n/k) or O(k) for some inputs.<br>
The algorithm makes use of some interesting results we encountered during testing. It divides the problem into cases and acts accordingly:
#### Case 1: n <= k+1 <br>
This would mean any individual bit would flip the entire string, so the optimal solution is the minimum cost between the bits. This case is clearly O(n).<br>
#### Case 2: k + 2 < n <= 2k+1
In this case we only have the option to change a single bit, as we do not have the option to add 2k+1 and flip another. The bit we choose must flip every other, so it must not be among the first n-k-1 bits or the last n-k-1 bits. Say that we chose a bit t among the first n-k-1 bits and changed it. The last bit to be flipped by this bit would be t+k <= n-1, so it does not change the n^th bit. Similarly, if we choose a bit t among the last n-k-1, t would at least be n-(n-k-1)+1 = k+2, which would not flip the first bit upon change. So, the bit we change must reside in (n-k, k+1). There are 2k-n+2 numbers to iterate over, remembering that k+2 < n < 2k+1, this case results in O(k) complexity.
#### Case 3: (2k+1)|n 
This means that there's only 1 solution, and it starts with changing the index k+1 and following. This creates an exact k-neighborhood among any changed bit. Changing something smaller than k+1, say k, would mean that there is 1 bit unflipper at the end. Following this, even changing 1 would create k many unflipped bits at the end, so we could not change anything among the end to have those flip, without flipping the previously flipped bits. Knowing the solution, we simply sum n/(2k+1) numbers, which means this case is O(n/k).
#### Case 4: n%(2k+1) = C for some integer C such that 0 < C < 2k+1
There are two subcases. On both cases, we iterate over O(k) elements to find the minimum cost, and each iteration takes O(n/k) time, so this case is O(n).
##### Subcase 1: C <= k
Starting with any bit t <= C gives a valid solution, as there are C many bits after the last changed bit, and incrementing t would carry the last changed bit, l, by 1. We could do that C times; if we carried 1 more time, l would be out of bounds and the second-to-last changed bit, p,  would not flip all bits at the end, as the distance between two changed bits is 2k+1 and we carried p from n-C-1 - (2k+1) = n-C-2k-2 to n-2k-1 by adding C+1 to it. Clearly, this leaves k bits unflipped, which cannot be fixed by a change as doing so would flip preivously flipped bits. 
##### Subcase 2: C > k
In this case changing any bit < C-k would not give a solution. Suppose we changed the bit t, which is among the first C-k-1. Then we would change each bit of the form (2k+1)n + t. So, among the last C bits, t^th bit would change. This bit would flip k others, so the last bit to be flipped would be t+k < C-1, hence the last bit would not flip. So any possible solution would require changing the bits >= C-k. <br>

So, for all cases, we know exactly which bits would provide us with possible solves Then, the only remaining task is to calculate the cost of each solution, and find the minimum. Please note that this algorithm does not directly turn each bit to 0, but only calculates the minimum cost of doing so in its current state. However, turning each bit to 0, given the optimal solution is also an O(n) operation, so it does not hurt the complexity. Space complexity stays at O(n).
