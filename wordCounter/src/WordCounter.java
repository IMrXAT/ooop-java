import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WordCounter {
    private final HashMap<String, Integer> map;
    private int wordsAmount;

    public WordCounter() {
        map = new HashMap<>();
        wordsAmount = 0;
    }

    public void count(String path) {
        Reader reader = new Reader(path);
        String string;
        while (reader.hasNextLine()) {
            string = reader.getNextLine();
            parseLine(string);
        }
        reader.close();
    }

    public void outputResult(String path) {
        Writer writer = new Writer(path);
        map.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(e -> {
                    try {
                        writer.println(e.getKey() + ", " + e.getValue() + ", " + (double) e.getValue() / wordsAmount * 100);
                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }
                });
        writer.close();
    }

    private void parseLine(String string) {
        StringBuilder word = new StringBuilder();
        int stringSize = string.length();
        char symbol;
        for (int i = 0; i < stringSize; i++) {
            symbol = string.charAt(i);
            if (Character.isLetterOrDigit(symbol)) {
                word.append((symbol));
            } else {
                countWord(word.toString());
                word = new StringBuilder();
            }
        }
        if (!word.toString().isEmpty()) {
            countWord(word.toString());
        }
    }

    private void countWord(String word) {
        if (!map.containsKey(word)) {
            map.put(word, 0);
        }
        map.put(word, map.get(word) + 1);
        wordsAmount++;
    }

}