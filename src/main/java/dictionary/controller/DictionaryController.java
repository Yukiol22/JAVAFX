package dictionary.controller;

import dictionary.model.Dictionary;

public class DictionaryController {
    private Dictionary dictionary = new Dictionary();

    public DictionaryController() {
        dictionary.addWord("cat", "A small furry animal that says meow.");
        dictionary.addWord("dog", "A loyal animal that barks.");
        dictionary.addWord("java", "A programming language.");
        dictionary.addWord("thread", "A separate path of execution in a program.");
        dictionary.addWord("hashmap", "A collection that stores key-value pairs.");
    }

    public String search(String word) {
        if (word == null || word.trim().isEmpty()) {
            return "Enter word pls";
        }

        String meaning = dictionary.search(word);

        if (meaning == null) {
            return "Unknown word not found: " + word;
        }
        return meaning;
    }
}

