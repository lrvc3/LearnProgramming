# Recursion: 

We dont make the input smaller explictly. 
We make decisions on each input which results in reducing the input size/problem
So each decision we make, the problem becomes smaller and smaller.

## Identification:

How to identify whether we can solve using recursion:
-> Given a problem at hand, we will have to make some choice, based on that we take decision.

## Recursive Tree

Example: 
Subset Problem
string -> abc
O/P Subsets: a ab abc b bc c ""

#### Choices:

a  |  b | c  |
|  :---: |  :---: | :---:
:heavy_check_mark:/:x: | :heavy_check_mark:/:x:    | :heavy_check_mark:/:x: |


#### Decision:
| a  |  b | c  | Output |
|  :---: |  :---: | :---: | :---: |
|:heavy_check_mark: | :heavy_check_mark: | :heavy_check_mark:| abc |
|:heavy_check_mark: | :x: | :x:| a |
|:x: | :heavy_check_mark: | :x:| b |
|:x: | :x: | :heavy_check_mark:| c |
|:heavy_check_mark: | :heavy_check_mark: | :x:| ab |
|:x: | :heavy_check_mark: | :heavy_check_mark:| bc |
|:heavy_check_mark: | :x: | :heavy_check_mark:| ac |
|:x: | :x: | :x:| "" |

Choices: I had was to include or not include a particular alphabet.
Decision: i took the decision to include all alphabet.


So now, once we decide for a then the input becomes bc.
So size of the problem got reduced.



Recursive Tree:
To represent the decision

How to get the tree:

Input/output method - Aditya verma


					" "  "abc"

#no of branches = no of choices in recursive tree

After each branch, we have taken the decision.



## Other methods to do recursion:

 - i/p - o/p = We know decisions to take
 - Base Condition - Induction - Hypothesis
 - Choice Diagram (DP series)


Base Condition:
Small valid/invalid output or you can say the smallest input for which you know the output
Example: Fact(0) = 1

Hypothesis:
if solve(n) - gives output for n elements
then solve(n-1) - will give output for n-1 elements

Induction:
Based on the hypothesis we need to do some calculation so as to the objective is achieved.


### Start with Basic Problems:
- Print 1 to N
- Print N to 1
- Factorial
- Height Of Binary Tree
- Sort An Array
- Sort a Stack
- Delete middle element from stack
- Reverse Stack
- Kth Grammer [LeetCode]
- Tower of Hanoi
