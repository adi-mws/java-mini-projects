package SmartTextAnalyzer;
import java.util.*;

// Smart Text Analyzer in Java
class App {
    private String text;

    App(String text) {
        this.text = text;
    }

    String getText() {
        return this.text;
    }

    int countVowels() {
        int vowels = 0;
        String[] splitString = this.text.split("");
        for (String s : splitString) {
            if (s.toLowerCase().equals("a") || s.toLowerCase().equals("e") || s.toLowerCase().equals("i") ||
                    s.toLowerCase().equals("o") || s.toLowerCase().equals("u")) {
                vowels++;
            }
        }
        return vowels;
    }

    int countUniqueChars() {
        Set<Character> uniqueChars = new HashSet<>();
        for (char i : this.text.toCharArray()) {
            uniqueChars.add(i);
        }
        return uniqueChars.size();
    }

    String mostFrequentWord() {
        String returnableString = "";

        Map<String, Integer> map = new HashMap<>();
        String words[] = this.text.split(" ");
        for (String word : words) {
            if (map.containsKey(word)) {
                map.getOrDefault(words, null);
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
        
        int max = 0;
        for (String key : map.keySet()) {
            if (max < map.get(key)) {
                max = map.get(key);
                returnableString = key;
            }
        }
        return returnableString;
    }
}

public class SmartTextAnalyzer {
    public static void main(String[] args) {

    }
}