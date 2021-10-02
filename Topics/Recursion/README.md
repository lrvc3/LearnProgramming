Recursion: 

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


Choices:
	a 			b 					c
Include/not		Include/not		Include/not


Decision:
	a 			b 			c
Include		Include		Include ==> abc


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



## other methods to do recursion:

i/p - o/p = We know decisions to take
Base Condition - Induction - Hypothesis
Choice Diagram (DP series)


Base Condition:
Small valid/invalid output


