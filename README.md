# CKYAlgorithm
This project is about the simplest implementation of Cocke-Younger-Kasami (CYK) Algorithm (using 2D String array in Java Netbeans) for acceptance of string of a Context Free Grammar.

Input : Grammar in 2D String array in the show format, Input string in a 1D String array

Output : The java program will generate a table using the CYK Algorithm.
The String will be acceptable if the last cell of the first row of the table contains the Start Symbol. (which in the sample grammar is 'S')

Notations :
If the Grammar has the following 4 productions :
S->AB/BC
A->BA/a
B->CC/b
C->AB/a
Then it will be stored in a 2D String Array eliminating the '->' and '/' symbols.
String G[4][3]={{"S","AB","BC"},
                {"A","BA","a"},
                {"B","CC","b"},
                {"C","AB","a"}};
                
If the input string is "baaba" then it will be stored in a 1D String :
String w[]={"b","a","a","b","a"};
