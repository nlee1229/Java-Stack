public class StringManipulator {
    public String trimAndConcat(String stringy1, String stringy2) {
        String stringy3 = stringy1.trim().concat(stringy2.trim());
        return (stringy3); 
    }
    
    public Integer getIndexOrNull(String word, char letter) {
        //calling the String method "indexOf":
        int a = word.indexOf(letter);
        if(a == -1) {
            return null;
        }
        else {
            return a;
        }
    }

    public Integer getIndexOrNull(String ting1, String ting2) {
        int b = ting1.indexOf(ting2);
        if(b == -1) {
            return null;
        }
        else {
            return b;
        }
    }

    public String concatSubstring(String ting1, int num1, int num2, String ting2) {
        String ting3 = ting1.substring(num1, num2).concat(ting2);
        return (ting3);
    }
}