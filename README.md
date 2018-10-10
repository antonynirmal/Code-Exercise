<b>Command line Reverse Polish Notation Calculator</b>

Calculator waits for user input and expects to receive strings containing whitespace separated lists of numbers and operators. Available operators are +, -, *, /, sqrt, undo, clear & exit. 

+, -, *, / : Performs arithmentic operations on the last 2 operands.
sqrt : sqrt performs a square root on the top item from the stack
clear: resets all the value from the stack
undo: undoes the previous operation. 
undo undo: will undo the previous two operations.
exit: quit the application.

<b>Reqirements</b>
Java 8, JUnit & Maven

<b>Compile, Test & Run</b>
mvn compile
mvn test
mvn exec:run
