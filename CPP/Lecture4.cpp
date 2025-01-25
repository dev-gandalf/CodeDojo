#include<iostream>

using namespace std;


int main(){
	
	int n = 4;
	
	

	for(int i = 0; i < n ; i++){



		for(int k = n - 1; k > i; k--){
					
					cout << "  "; 
					
				}


		for(int j = 0; j <= i; j++){
					
					cout << " " << j + 1 ; 
					
				}

		for(int l = i; l > 0; l--){
					
					cout<< " " << l; 
					
				}
		
		cout << "\n";
	}

	
	
	return 0;
}
