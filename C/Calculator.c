#include<stdio.h>


char operator;
double num1;
double num2;


void inputOperator(){
    printf("\nPlease enter an operator (+,-,*,/) : ");
    scanf(" %c", &operator);

}


void inputNumber(){
    printf("\nPlease enter first number : ");
    scanf("%lf", &num1);

    printf("\nPlease enter second number  : ");
    scanf("%lf", &num2);
}





int main(){


    inputOperator();



switch (operator) {

    case '+' : inputNumber();
               printf("\nSum is : %lf",num1 + num2);
    break;
    
    
    case '-' : inputNumber();
               printf("\nDifference is : %lf",num1 - num2);
    break;
    
    
    case '*' : inputNumber();
               printf("\nProduct is : %lf",num1 * num2);
    break;
    
    
    case '/' : inputNumber(); 
               printf("\nQuotient is : %lf",num1 / num2);
    break;
    
    
    default: printf("\nInvalid operator!!");

}



    return 0;
}