Artificial Intelligence
Fall 2018
Ritu Prastina Melroy

For my implementation of the CYK parser, I followed the algorithm that was given in the class notes and explained in class.

My files are: (1) Node.java, which contains the node class and its initializations. (This is the "Tree" in the pseudo-code).
(2) Grammar.java, which contains 3 different ArrayLists for grammar, probabilities and nonterminals.
(3) cykparser.java which contains the main and the functions as stated in the pseudo-code.


One thing to note is that I use scanner for user to input data. 
However, the after the user types in a sentence the scanner closes. So if the user wishes to type in and parse another sentence, they will have to restart the program. 

Usage: It's a normal java program that takes in no arguments so after compiling, just open it and it should prompt the user for input. 
For example, if using ubuntu (or terminal on mac) compile using 

javac cykparser.java

And then it should produce the compiled program which you can run by typing

java cykparser

In hindsight, I should have definitely used Python.