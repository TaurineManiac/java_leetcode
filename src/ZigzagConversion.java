public class ZigzagConversion {
    public String convert(String s, int numRows) {
        if(numRows==1){
            return s;
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<numRows;i++){
            for(int j=i;j<s.length();j+=2*(numRows-1)){
                sb.append(s.charAt(j));
                if(i > 0 && i < numRows - 1 && j+2*(numRows-1-i)<s.length()){
                    sb.append(s.charAt(j+2*(numRows-1-i)));
                }
            }
        }
        return sb.toString();
    }
}

class MainOfZigzagConversion {
    public static void main(String[] args) {
        ZigzagConversion zc = new ZigzagConversion();
        System.out.println("PAYPALISHIRING");
        System.out.println(zc.convert("PAYPALISHIRING", 3));
    }
}

