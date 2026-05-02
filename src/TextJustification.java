import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int i=0;
        while(i<words.length){
            int j=i+1;
            int len = words[i].length();
            while(j< words.length && len+ words[j].length()+1<=maxWidth){
                len+=words[j].length()+1;
                j++;
            }
            int gaps=j-i-1;
            StringBuilder sb = new StringBuilder();
            if(gaps==0 || j>=words.length){
                for(int k=i;k<j-1;k++){
                    sb.append(words[k]);
                    sb.append(" ");
                }
                sb.append(words[j-1]);
                while(sb.length()<maxWidth){
                    sb.append(" ");
                }
            }
            else{
                int quantityOfSpaces=maxWidth;
                for(int k=i;k<j;k++){
                    quantityOfSpaces-=words[k].length();
                }
                int commonSpaceGap=quantityOfSpaces/gaps;
                int extraSpaceGap=quantityOfSpaces%gaps;
                for(int k=i;k<j-1;k++){
                    sb.append(words[k]);
                    sb.append(" ".repeat(commonSpaceGap));
                    if(k-i<extraSpaceGap){
                        sb.append(" ");
                    }
                }
                sb.append(words[j-1]);
            }
            res.add(sb.toString());
            i=j;
        }
        return res;



//        List<String> result = new ArrayList<>();
//        List<String> currentWords = new ArrayList<>();
//        int currentLength = 0;
//        for(String word: words){
//            if(currentLength + word.length() + currentWords.size() > maxWidth){
//                int quantityOfSpaces = maxWidth - currentLength;
//                int gaps = currentWords.size() - 1;
//                if(gaps==0){
//                    result.add(currentWords.get(0) + " ".repeat(quantityOfSpaces));
//                }
//                else{
//                    int defaultSpaces = quantityOfSpaces / gaps;
//                    int extraSpaces = quantityOfSpaces %  gaps;
//                    StringBuilder line = new StringBuilder();
//                    for(int i = 0; i < currentWords.size(); i++){
//                        line.append(currentWords.get(i));
//                        if(i<gaps){
//                            line.append(" ".repeat(defaultSpaces));
//                            if(i<extraSpaces){
//                                line.append(" ");
//                            }
//                        }
//                    }
//                    result.add(line.toString());
//                }
//                currentLength = 0;
//                currentWords.clear();
//            }
//            currentLength += word.length();
//            currentWords.add(word);
//        }
//
//        StringBuilder line = new StringBuilder(String.join(" ", currentWords));
//        while(line.length()<maxWidth){
//            line.append(" ");
//        }
//        result.add(line.toString());
//        return result;

    }
}

class MainOfTextJustification {
    public static void main(String[] args) {

    }
}
