package lab6.Task2;

import java.util.*;

public class Dictionary {
    private final List<String> translations;
    private int usageCount;

    public Dictionary(List<String> translations) {
        this.translations = new ArrayList<>(translations);
        this.usageCount = 0;
    }

    public List<String> getTranslations() {
        usageCount++;
        return translations;
    }

    public void addTranslation(String translation) {
        translations.add(translation);
    }

    public void replaceTranslations(List<String> newTranslations) {
        translations.clear();
        translations.addAll(newTranslations);
    }

    public void removeTranslation(String translation) {
        translations.remove(translation);
    }

    public int getUsageCount() {
        return usageCount;
    }
}
