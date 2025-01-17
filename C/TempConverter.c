#include<stdio.h>
#include<ctype.h>



    char unit;
    char bool;
    float temp;



//Prompts user if he wants to continue the program.

void continueProgram(){

    printf("\nDo you want to continue the program? (Y/N)? : ");
    scanf(" %c", &bool);     //Note: leave space before %c when using scanf with char.
    while (getchar() != '\n');      //Clears stdin buffer
    bool = toupper(bool);        //Converts to upper case char.

}





int main(){

   
//Main program loop
        do {
                
                
                    printf("\nIs the temperature in (C) or (F)? : ");
                    scanf(" %c", &unit);
                    unit = toupper(unit);

            if (unit == 'C') {
                    printf("\nEnter temperature in Celsius : ");
                    scanf("%f", &temp);
                    
                    temp = temp * 9/5 + 32; //C to F conversion formula
                    printf("\nThe temperature in Fahrenheit is : %.2f", temp);
                    
                    continueProgram();
                    
           


        }   else if (unit == 'F') {
                    printf("\nEnter temperature in Fahrenheit : ");
                    scanf("%f", &temp);
                    temp = (temp - 32) * 5/9;  //F to C conversion formula
                    printf("\nThe temperature in Celsius is : %.2f", temp);

                    continueProgram();
            

        }   else {
                    printf("Invalid input!!");
                    continueProgram();
        } 
        
        
    }   while (bool == 'Y'); 
        

return 0;

}