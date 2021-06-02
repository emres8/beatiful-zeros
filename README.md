# beatiful-zeros


Amir loves binary strings, and whenever he gets bored, he makes a new challenge about binary strings to entertain himself. However, recently, he has devised a problem that really irritates him since he could not find a solution.
The game starts with n string of ones, and Amir’s goal is to turn all the ones to zeros. There are some rules that govern the game which are as follow:
1. You are allowed to change a bit in the sequence, however, all the bits with the most k distance would be toggled. For example, if k=2, then if you change a specific bit in the sequence the next two adjacent bits are also toggled.
2. The cost of changing the value of i-th bit is equal to ci

## Comp305 Final Project

### Progression
* 12 May First Meeting
* 17 May Second Meeting 
  * Discussed Greedy Approach & Proof of Correctness of the suggested algorithm
  * Work-load is distributed among group members
  
 
 
### TO-DO List
- [ ] Develop baseline solutions based on Greedy, D&C and Dynamic Programming -  burcu
- [ ] [Further work on Proof of Correctness](https://docs.google.com/document/d/1eOTC2359NbwAgNOjKBcMZR5nXTQ7ITE5bAXADvZxS6k/edit) -burcu and her friends
- [ ] Demo Implementation - Levent
- [ ] Presentation - all group
- [ ] github repo update - ulas emre
- [ ] Test cases 


Terminology: <br>
Toggle: stands for both active and passive alteration of a bit.<br>
Change: used when chosen bits are actively altered with their costs added <br>
Flip: used for collateral passive alterations <br>




Lemma 1: The number of toggle is same for all bits <br>
Proof: <br>
For two consecutive bits, M and M+1, they will be toggled simultaneously unless the bits M-k or M+k+1 are changed. Considering that these two initial bits will end up as “zeros”, these bits have to be toggled even times. Since the difference between the toggle numbers of two consecutive bits can at most be 1, they necessarily have to be toggled the same amount. That means if M-k is changed, so must M+k+1. Similarly, if M-k is unchanged, so won’t M+k+1. For a potential solution, it will be arranged that there will be 2k spacing between each “change”. In order to cover the first and last elements, one bit from the first k+1 bits from both left and right must be changed. 
<br>

<br>
Lemma 2: Any solution that requires more than one toggle on a specific bit can be reduced to another solution with at most one toggle switch per bit. <br>
Proof: <br>
For a solution S, the last element needs to be toggled, so a bit from the last k+1 bits must have been changed, coming to the first element by changing every (2k+1)th bit from the initial bit, we managed to flip the first elements as well. That would mean any solution S can be reduced to a version where no bit is changed more than once. 

