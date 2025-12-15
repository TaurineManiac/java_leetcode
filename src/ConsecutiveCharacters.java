public class ConsecutiveCharacters {
    public int maxPower(String s) {
        int tempCounter=1;
        int max=1;
        int leftPoitner=0;
        int rightPoitner=1;
        for(int i=0;i<s.length();i++){
            if(rightPoitner<s.length() && leftPoitner<s.length() && (s.charAt(leftPoitner)==s.charAt(rightPoitner))){
                rightPoitner++;
                tempCounter++;
                max=Math.max(tempCounter,max);

            }
            else{
                leftPoitner=i;
                rightPoitner=i+1;
                tempCounter=1;
            }

        }

        return max;
    }
}
