This file includes runtime and results for prepared 10 test cases.
It also includes information about how to operate the program for
additional tests.
_____________________________________________ <br>
The cases were prepared with attention to different options between n
and k, and the costs were chosen randomly for each case, and they are 
hard-coded in the project code. Different run times using both the
Base Algorithm and the Improved Algorithm is given below, for the
exact same test cases.
_____________________________________________ <br>
--- Put run times and tests here
_____________________________________________ <br>

As can be seen clearly, the run times are reduced by a
great factor upon using the proven algorithm.

_____________________________________________<br>
The program also provides the option to do tests with
random values of n, k, and random costs. Doing
preferred tests by inputing n, k, and costs also
an option.
_____________________________________________ <br>

The program can run in two modes, one using the base
algorithm and other using the improved one. User can switch
between the two at any time. There is also an option to
compare the two algorithms' outputs with random inputs,
which does 100 tests by default. Please note that the 
option to change how many random tests to be done is 
is not directly given for simplicity, but it is softcoded.


### Hand-written tests: 

#### Option 1: 2k+1|n-1
* n: 21 k: 2 <br>
* Costs:1, 5, 3, 2, 4, 6, 8, 4, 5, 1, 0, 2, 1, 3, 1, 1, 4, 7, 5, 1, 4 <br>
Starting at 1 gives the best solution. <br> 
The minimum cost should be 12, and it is: 12 <br>
The test took 826279 milliseconds. <br>

n: 22 k: 3 <br>
Costs:3, 5, 3, 2, 4, 6, 8, 4, 5, 1, 0, 2, 1, 3, 1, 1, 4, 7, 5, 1, 4, 6 <br>
Starting at 1 gives the best solution. <br>
The minimum cost should be 14, and it is: 14 <br>
The test took 1395928 milliseconds. <br>


#### Option 2: n%(2k+1) < k+1
n: 17 k: 3 <br>
Costs: 4, 2, 9, 8, 4, 2, 6, 2, 9, 12, 14, 15, 18, 9, 0, 14, 17 <br>
Starting at 1 gives the best solution. <br>
The minimum cost should be 6, and it is: 6 <br>
The test took 322616 milliseconds. <br>

n: 11 k: 4 <br> 
Costs: 2, 1, 11, 4, 7, 13, 6, 12, 21, 5, 11 <br>
Starting at 1 gives the best solution. <br>
The minimum cost should be 7, and it is: 7 <br>
The test took 661462 milliseconds. <br>

#### Option 3: n%(2k+1) = k+1
n: 18 k: 3 <br>
Starting at 2 gives the best solution.<br>
The minimum cost should be 12, and it is: 12 <br>
The test took 40307 milliseconds.<br>


#### Option 4: n%(2k+1) > k+1
n: 19 k: 3 <br>
Costs: 4, 2, 9, 8, 4, 2, 6, 2, 9, 12, 14, 15, 18, 9, 0, 14, 17, 14, 2 <br>
Starting at 2 gives the best solution.<br>
The minimum cost should be 25, and it is: 25 <br>
The test took 384348 milliseconds. <br>

n: 16 k: 4 <br>
Costs: 2, 1, 11, 4, 7, 13, 6, 12, 21, 5, 11, 5, 2, 4, 12, 2 <br>
Starting at 4 gives the best solution.<br>
The minimum cost should be 6, and it is: 6 <br>
The test took 709375 milliseconds. <br>

#### Option 5: n <= k+1

n: 20 k: 19 <br>
Costs: 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 0, 20, 30, 40, 50, 60, 70, 80, 90, 100 <br>
Starting at 11 gives the best solution. <br>
The minimum cost should be 0, and it is: 0 <br>
The test took 57009 milliseconds. <br>

n: 30 k: 29 <br>
Costs:10, 20, 30, 40, 50, 60, 70, 80, 90, 9, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 <br>
Starting at 10 gives the best solution. <br>
The minimum cost should be 9, and it is: 9 <br>
The test took 87655 milliseconds. <br>


#### Option 6: k = 0

n: 10 k: 0 <br>
Costs: 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 <br>
Starting at 1 gives the best solution. <br>
The minimum cost should be 55, and it is: 55 <br>
The test took 54790 milliseconds. <br>
