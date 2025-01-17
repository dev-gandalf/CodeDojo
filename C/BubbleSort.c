#include <stdio.h>


int main(){

    int array[] = {1,5,4,2,9,0,7,8,6,5,4,};
    
    int arraySize = sizeof(array)/sizeof(array[0]);
   

    for (int i = 0; i < arraySize; i++) {

        for (int j = 0; j < arraySize - 1; j++) {

            if (array[j] > array[j+1]) {

                int temp = array[j];
                array[j] = array[j+1];
                array[j+1] = temp; 
            
            }
        
        }
    
    }

for (int k = 0; k < arraySize; k++) {

  

printf("%d ", array[k]);

}



    return 0;
}