## Problem Statement

Amir loves binary strings, and whenever he gets bored, he makes a new challenge about binary strings to entertain himself. However, recently, he has devised a problem that really irritates him since he could not find a solution.
The game starts with n string of ones, and Amir’s goal is to turn all the ones to zeros. There are some rules that govern the game which are as follow:
1. You are allowed to change a bit in the sequence, however, all the bits with the most k distance would be toggled. For example, if k=2, then if you change a specific bit in the sequence the next two adjacent bits are also toggled.
2. The cost of changing the value of i-th bit is equal to ci

## The Algorithm & Correctness


#### Terminology: 
* Flip: stands for both active and passive alteration of a bit.<br>
* Change: used when chosen bits are actively altered with their costs added <br>
* Toggle: used for collateral passive alterations <br>

#### Lemma 1: The number of toggle is same for all bits 
Proof: <br>
For two consecutive bits, M and M+1, they will be toggled simultaneously unless the bits M-k or M+k+1 are changed. Considering that these two initial bits will end up as “zeros”, these bits have to be toggled even times. Since the difference between the toggle numbers of two consecutive bits can at most be 1, they necessarily have to be toggled the same amount. That means if M-k is changed, so must M+k+1. Similarly, if M-k is unchanged, so won’t M+k+1. For a potential solution, it will be arranged that there will be 2k spacing between each “change”. In order to cover the first and last elements, one bit from the first k+1 bits from both left and right must be changed. 

#### Lemma 2: Any solution that requires more than one toggle on a specific bit can be reduced to another solution with at most one toggle switch per bit. 
Proof: <br>
For a solution S, the last element needs to be toggled, so a bit from the last k+1 bits must have been changed, coming to the first element by changing every (2k+1)th bit from the initial bit, we managed to flip the first elements as well. That would mean any solution S can be reduced to a version where no bit is changed more than once. 


#### The Algorithm: <br>
Lemma 1 and 2 together implies a particular solution of the problem needs to toggle each bit exactly one time.  There are finitely many such solutions and our strategy is simply to compute the corresponding cost values of all such solutions. Then, we compare results and select the solution with the minimum cost. Listing all available solutions is not a difficult task, since we know that the first bit must be toggled exactly one time. To provide that, we select one of the first k+1 bits and change it first. This means we have k+1 available solutions. Then the algorithm skips the next 2k bits and toggles the next bit iteratively until the last bit has the value 0. For this to happen the last changed bit must be between [n-k-1,n].

### Complexities:
Since this algorithm involves changing each bit (total of n bits) for k+1 times, total complexity is O(nk). Since we only use two arrays of size n for implementation, our space complexity is O(n).

#### Correctness: 
This section aims to show our solution indeed toggles all the bits to 0.<br>
We must ensure the first bit must be flipped once. Hence, the algorithm selects one of the first k+1 bits and changes it first. Suppose we changed the bit with index p. The fact that 0<p<=k+1 and the definition of the k proves the first k+1 bits are flipped. Next bit to change is the one with index   p + 2k + 1.
We skipped 2k bits [p+1,p+2k] and we want to show those bits are indeed flipped. The left k bits [p+1,p+k] are flipped by the toggle on p, and the right k bits [p+k+1,p+2k]  are flipped by the change on p+2k+1. Then continue to change bits with indexes  p + 4k + 2, p + 6k + 3 until there is not any bit with value 1. Since we started from the beginning of the bit string, we only check whether the last bit has value 0 to stop iterations. This shows all bits are toggled exactly one time.
<br>
Initially we chose one of the k+1 bits. This shows that we have k+1 possible solutions. The algorithm calculates the cost for each of them then selects the solution with the minimum cost.
