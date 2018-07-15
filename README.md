# Java project to evalaute expressions using Reverse Polish Notation.
# This project includes the following operations
   Addition
   Subtraction
   Multiplication
   Division
   SQRT
   POW
# This project also includes undo operation - use the phrase "undo"
# The phrase "clear" is used to clear the expression/operands fed to the stack
# The phrase "exit" is used to quit the program execution

# Build the the jar file using mvn install command.

# Run the jar file using the command java -jar rpn-1.0-SNAPSHOT.jar

# Example expressions
	-> 1 2 3 * 5 results in  Stack: 1 6 5
	-> 4 sqrt results in Stack: 2
	-> 3 pow results in Stack: 9
	-> 1 2 3 4 5 undo results in 1 2 3 4
	-> 1 2 clear results in Stack: 