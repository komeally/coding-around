#include<stdio.h>

int decimalToBinary(int decimalNumber) {
    int quotient = decimalNumber;
    int remainder;

    char binary[256];

    int i = 0;
    while (quotient > 0)
    {
        remainder = quotient % 2;
        quotient = quotient / 2;

        char remChar = (char)remainder;
        binary[i] = remChar;
        i++;
    }
    
    
    // convert concatenated object back to int
    // return int
    
}