package lab2;

public class Task5 {
    public static void main(String[] args) {
        String text = "Ось кілька адрес: test1@gmail.com, spammer@site.ru, user123@yahoo.com, another@domain.ru!";
        String result = removeRuEmails(text);
        System.out.println("Результат:\n" + result);
    }

    public static String removeRuEmails(String text) {
        String[] words = text.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            String cleanWord = word;

            char lastChar = word.charAt(word.length() - 1);
            boolean hasPunctuation = (lastChar == ',' || lastChar == '.' || lastChar == '!' || lastChar == ';' || lastChar == ':');
            if (hasPunctuation) {
                cleanWord = word.substring(0, word.length() - 1);
            }

            if (cleanWord.contains("@") && cleanWord.endsWith(".ru")) {
                continue;
            }
            result.append(word).append(" ");
        }

        return result.toString().trim();
    }
}
