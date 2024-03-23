class Solution {
    private boolean checkOtherPart(String str){
        switch(str){
                case "(":
                    otherPart = ")";
                    if(loop(i, array,otherPart) == false){
                        return false;
                    }else{
                        continue;
                    }
                case "[":
                    otherPart = "]";
                    if(loop(i, array,otherPart) == false){
                        return false;
                    }else{
                        continue;
                    }
                case "{":
                    otherPart = "}";
                    if(loop(i, array,otherPart) == false){
                        return false;
                    }else{
                        continue;
                    }
            }
    }
    private boolean loop(String s,int count, String[] array, String otherPart){
            for(int e = count + 1; e < array.length;e++){
                if(array[e].equals(otherPart)){
                    return true;
                }else if(array[e].equals("(") || array[e].equals("[") || array[e].equals("{")){
                    
                }
            }
            return false;
    }
    public boolean isValid(String s) {
        String[] array = new String[s.split("").length];
        array = s.split("");
        String otherPart = "";
        for(int i = 0;i<array.length; i++){
            checkOtherPart(array[i]);
        }
        return true;
    }
}
