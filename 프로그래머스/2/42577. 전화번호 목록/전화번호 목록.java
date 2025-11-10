import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        int n = phone_book.length;
        
        Arrays.sort(phone_book);
        
        for(int i=0; i<n-1; i++){
            if(phone_book[i+1].startsWith(phone_book[i])){
                return false;
            }
            // for(int j=i+1; j<n; j++){
            //     if(phone_book[j].startsWith(phone_book[i])){
            //         return false;
            //     }
            // }
        }
        // for(String phone : phone_book){
        //     System.out.println(phone);
        // }
        return true;
    }
    
}
