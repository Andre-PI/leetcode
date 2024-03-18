
import java.util.ArrayList;

public class Solution{
    private int[] romanToDecimal(String s){
        String[] value = new String[s.length()];
        int[] convertedList = new int[s.length()];
        value = s.split("");
        int num = 0;
        for(int i = 0;i < value.length;i++){
            if(value[i].equals("I")){
                num = 1;
            }else if(value[i].equals("V")){
                num = 5;
            }else if(value[i].equals("X")){
                num = 10;
            }else if(value[i].equals("L")){
                num = 50;
            }else if(value[i].equals("C")){
                num = 100;
            }else if(value[i].equals("D")){
                num = 500;
            }else if(value[i].equals("M")){
                num = 1000;
            }
            convertedList[i] = num;
        }
        return convertedList;
    }
    public int sumOfValues(String s){
        int[] convertedList = new int[s.length()];
        ArrayList<Integer> index = new ArrayList<>();
        ArrayList<Integer> readed = new ArrayList<>();
        convertedList = romanToDecimal(s);
        int totalSum = 0;
        int i = 0;
        while (i < convertedList.length -1) {
            if(convertedList[i] < convertedList[i + 1]){                
                index.add(convertedList[i + 1] - convertedList[i]);
                readed.add(i);
                readed.add(i + 1);
                if((i + 2) < convertedList.length){
                    i+=2;
                }else{
                    break;
                }
            }else{
                i++;
            }
        }      
        for(int j = 0;j < convertedList.length;j++){
            if (readed.contains(j)) {
                
                continue;
            }else{
                totalSum += convertedList[j];
            }
        }
    
        for(int k : index){
            totalSum += k;
        }

        return totalSum;                                                                      
    }
    public static void main(String[] args) {
        Solution app = new Solution();
        System.out.println(app.sumOfValues("LVIII"));
    }
}