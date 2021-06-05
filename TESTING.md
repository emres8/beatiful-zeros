This file includes runtime and results for prepared 10 test cases.
It also includes information about how to operate the program for
additional tests.

--- 

The cases were prepared with attention to different options between n
and k, and the costs were chosen randomly for each case, and they are 
hard-coded in the project code. Different run times using both the
Base Algorithm and the Improved Algorithm is given below, for the
exact same test cases.

---

### Hand-written tests: 

#### Option 1: 2k+1|n-1

    n: 21 k: 2 
    Costs:1, 5, 3, 2, 4, 6, 8, 4, 5, 1, 0, 2, 1, 3, 1, 1, 4, 7, 5, 1, 4 
    -------------------------------------------------------------------
    ###### Baseline Algorithm ######
    Starting at 1 gives the best solution.  
    The minimum cost should be 12, and it is: 12
    The test took 826279 milliseconds. 
    ###### Improved Algorithm ###### 
    The minimum cost should be 12, and it is: 12
    The test took 9430 milliseconds.
---
    n: 22 k: 3 
    Costs:3, 5, 3, 2, 4, 6, 8, 4, 5, 1, 0, 2, 1, 3, 1, 1, 4, 7, 5, 1, 4, 6 
    ----------------------------------------------------------------------
    ###### Baseline Algorithm ######
    Starting at 1 gives the best solution. 
    The minimum cost should be 14, and it is: 14 
    The test took 1395928 milliseconds. 
    ###### Enhanced Algorithm ###### 
    The minimum cost should be 14, and it is: 14
    The test took 2194 milliseconds.

#### Option 2: n%(2k+1) < k+1
    n: 17 k: 3 
    Costs: 4, 2, 9, 8, 4, 2, 6, 2, 9, 12, 14, 15, 18, 9, 0, 14, 17 
    --------------------------------------------------------------
    ###### Baseline Algorithm ######
    Starting at 1 gives the best solution. 
    The minimum cost should be 6, and it is: 6 
    The test took 322616 milliseconds. 
    ###### Improved Algorithm ###### 
    The minimum cost should be 6, and it is: 6
    The test took 2331 milliseconds.
---
    n: 11 k: 4 
    Costs: 2, 1, 11, 4, 7, 13, 6, 12, 21, 5, 11 
    --------------------------------------------------------------
    ###### Baseline Algorithm ######
    Starting at 1 gives the best solution. 
    The minimum cost should be 7, and it is: 7 
    The test took 661462 milliseconds. 
    ###### Improved Algorithm ###### 
    The minimum cost should be 7, and it is: 7
    The test took 1973 milliseconds.

#### Option 3: n%(2k+1) = k+1
    n: 18 k: 3 
    Costs: 4, 2, 5, 9, 1, 11, 4, 16, 8, 6, 5, 13, 1, 0, 1, 2, 14, 15
    --------------------------------------------------------------
    ###### Baseline Algorithm ######
    Starting at 2 gives the best solution.
    The minimum cost should be 12, and it is: 12 
    The test took 40307 milliseconds.
    ###### Improved Algorithm ###### 
    The minimum cost should be 12, and it is: 12
    The test took 2329 milliseconds.

#### Option 4: n%(2k+1) > k+1
    n: 19 k: 3 
    Costs: 4, 2, 9, 8, 4, 2, 6, 2, 9, 12, 14, 15, 18, 9, 0, 14, 17, 14, 2 
    --------------------------------------------------------------
    ###### Baseline Algorithm ######
    Starting at 2 gives the best solution.
    The minimum cost should be 25, and it is: 25 
    The test took 384348 milliseconds. 
    ###### Improved Algorithm ###### 
    The minimum cost should be 25, and it is: 25
    The test took 3514 milliseconds.
---
    n: 16 k: 4 
    Costs: 2, 1, 11, 4, 7, 13, 6, 12, 21, 5, 11, 5, 2, 4, 12, 2 
    --------------------------------------------------------------
    ###### Baseline Algorithm ######
    Starting at 4 gives the best solution.
    The minimum cost should be 6, and it is: 6 
    The test took 709375 milliseconds. 
    ###### Improved Algorithm ###### 
    The minimum cost should be 6, and it is: 6
    The test took 2477 milliseconds.
#### Option 5: n <= k+1
    n: 20 k: 19 
    Costs: 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 0, 20, 30, 40, 50, 60, 70, 80, 90, 100 
    --------------------------------------------------------------
    ###### Baseline Algorithm ######
    Starting at 11 gives the best solution. 
    The minimum cost should be 0, and it is: 0
    The test took 57009 milliseconds.
    ###### Improved Algorithm ###### 
    The minimum cost should be 0, and it is: 0
    The test took 2825 milliseconds.    
---
    n: 30 k: 29 
    Costs:10, 20, 30, 40, 50, 60, 70, 80, 90, 9, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 
    --------------------------------------------------------------
    ###### Baseline Algorithm ######
    Starting at 10 gives the best solution. 
    The minimum cost should be 9, and it is: 9 
    The test took 87655 milliseconds. 
    ###### Improved Algorithm ###### 
    The minimum cost should be 9, and it is: 9
    The test took 4094 milliseconds.
#### Option 6: k = 0
    n: 10 k: 0 
    Costs: 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 
    --------------------------------------------------------------
    ###### Baseline Algorithm ######
    Starting at 1 gives the best solution. 
    The minimum cost should be 55, and it is: 55 
    The test took 54790 milliseconds. 
    ###### Improved Algorithm ###### 
    The minimum cost should be 55, and it is: 55
    The test took 2425 milliseconds.
    
As can be seen clearly, the run times are reduced by a
great factor upon using the proven algorithm.
Setup | Runtime of Improved Algorithm
--| -- 
 n: 21 k: 2 | 9430 milliseconds
 n: 22 k: 3 | 2194 milliseconds
 n: 17 k: 3 | 2331 milliseconds
 n: 11 k: 4 | 1973 milliseconds
 n: 18 k: 3 | 2329 milliseconds
 n: 19 k: 3 | 3514 milliseconds
 n: 16 k: 4 | 2477 milliseconds
 n: 20 k:19 |2825 milliseconds
 n: 30 k: 29 | 4094 milliseconds
 n: 10 k: 0 | 2425 milliseconds

---

The program also provides the option to do tests with
random values of n, k, and random costs. Doing
preferred tests by inputing n, k, and costs also
an option.

---

The program can run in two modes, one using the base
algorithm and other using the improved one. User can switch
between the two at any time. There is also an option to
compare the two algorithms' outputs with random inputs,
which does 100 tests by default. Please note that the 
option to change how many random tests to be done is 
is not directly given for simplicity, but it is softcoded.



    
    

