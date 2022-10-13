#include<stdio.h>

int decimalToBinary(int decimalNumber) {
    int quotient = decimalNumber;
    int remainder;

    // Create a string or char object to hold data that will be concatentated

    while (quotient > 0)
    {
        remainder = quotient % 2;
        quotient = quotient / 2;
        

        // convert remainder to char/string
        // concat remainder to char/string object defined outside of loop
    }
    
    // convert concatenated object back to int
    // return int
    
}