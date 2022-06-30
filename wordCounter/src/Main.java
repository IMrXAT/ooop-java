public class Main {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.exit(-1);
        }
        WordCounter wordCounter = new WordCounter();
        wordCounter.count(args[0]);
        wordCounter.outputResult(args[1]);
    }
}