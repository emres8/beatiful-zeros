This file includes runtime and results for prepared 10 test cases.
It also includes information about how to operate the program for
additional tests.
_____________________________________________
The cases were prepared with attention to different options between n
and k, and the costs were chosen randomly for each case, and they are 
hard-coded in the project code. Different run times using both the
Proven Algorithm and the Protoype Algorithm is given below, for the
exact same test cases.
_____________________________________________
Using the Proven Algorithm:
Hand-written tests: 

///////////////////////////////
Option 1: 2k+1|n-1
///////////////////////////////

n: 21 k: 2
Could not solve at index 2
000000000000000000011
Could not solve at index 3
000000000000000000001
Starting at 1 gives the best solution.
The minimum cost should be 12, and it is: 12
The test took 544200 milliseconds.
n: 22 k: 3
Could not solve at index 2
0000000000000000000111
Could not solve at index 3
0000000000000000000011
Could not solve at index 4
0000000000000000000001
Starting at 1 gives the best solution.
The minimum cost should be 14, and it is: 14
The test took 744600 milliseconds.

///////////////////////////////
Option 2: n%(2k+1) < k+1
///////////////////////////////

n: 17 k: 3
Could not solve at index 4
00000000000000111
Starting at 1 gives the best solution.
The minimum cost should be 6, and it is: 6
The test took 145000 milliseconds.
n: 11 k: 4
Could not solve at index 3
00000001111
Could not solve at index 4
00000000111
Could not solve at index 5
00000000011
Starting at 1 gives the best solution.
The minimum cost should be 7, and it is: 7
The test took 435500 milliseconds.

///////////////////////////////
Option 3: n%(2k+1) = k+1
///////////////////////////////

n: 18 k: 3
Starting at 2 gives the best solution.
The minimum cost should be 12, and it is: 12
The test took 23000 milliseconds.

///////////////////////////////
Option 4: n%(2k+1) > k+1
///////////////////////////////

n: 19 k: 3
Could not solve at index 1
0000000000000000001
Starting at 2 gives the best solution.
The minimum cost should be 25, and it is: 25
The test took 141300 milliseconds.
n: 16 k: 4
Could not solve at index 1
0000000000000011
Could not solve at index 2
0000000000000001
Starting at 4 gives the best solution.
The minimum cost should be 6, and it is: 6
The test took 289600 milliseconds.

///////////////////////////////
Option 5: n <= k+1
///////////////////////////////

n: 20 k: 19
Starting at 11 gives the best solution.
The minimum cost should be 0, and it is: 0
The test took 32200 milliseconds.
n: 30 k: 29
Starting at 10 gives the best solution.
The minimum cost should be 9, and it is: 9
The test took 86900 milliseconds.

///////////////////////////////
Option 6: k = 0
///////////////////////////////

n: 10 k: 0
Starting at 1 gives the best solution.
The minimum cost should be 55, and it is: 55
The test took 18000 milliseconds.

All tests passed successfully.
_____________________________________________

Using the Protoype Algorithm:
Hand-written tests: 

///////////////////////////////
Option 1: 2k+1|n-1
///////////////////////////////

n: 21 k: 2
The minimum cost should be 12, and it is: 12
The test took 7300 milliseconds.
n: 22 k: 3
The minimum cost should be 14, and it is: 14
The test took 1200 milliseconds.

///////////////////////////////
Option 2: n%(2k+1) < k+1
///////////////////////////////

n: 17 k: 3
The minimum cost should be 6, and it is: 6
The test took 1800 milliseconds.
n: 11 k: 4
The minimum cost should be 7, and it is: 7
The test took 14200 milliseconds.

///////////////////////////////
Option 3: n%(2k+1) = k+1
///////////////////////////////

n: 18 k: 3
The minimum cost should be 12, and it is: 12
The test took 1200 milliseconds.

///////////////////////////////
Option 4: n%(2k+1) > k+1
///////////////////////////////

n: 19 k: 3
The minimum cost should be 25, and it is: 25
The test took 1600 milliseconds.
n: 16 k: 4
The minimum cost should be 6, and it is: 6
The test took 1000 milliseconds.

///////////////////////////////
Option 5: n <= k+1
///////////////////////////////

n: 20 k: 19
The minimum cost should be 0, and it is: 0
The test took 1200 milliseconds.
n: 30 k: 29
The minimum cost should be 9, and it is: 9
The test took 1100 milliseconds.

///////////////////////////////
Option 6: k = 0
///////////////////////////////

n: 10 k: 0
The minimum cost should be 55, and it is: 55
The test took 1400 milliseconds.

All tests passed successfully.
_____________________________________________

As can be seen clearly, the run times are reduced by a
factor of almost 100, upon using the proven algorithm.


The program also provides the option to do tests with
random values of n, k, and random costs. Doing
preferred tests by inputing n, k, and costs also
an option.
_____________________________________________

The program can run in two modes, one using the proven
algorithm and other using the prototype. User can switch
between the two at any time. There is also an option to
compare the two algorithms' outputs with random inputs,
which does 100 tests by default. Please note that the 
option to change random test counts is not directly 
given for simplicity.
