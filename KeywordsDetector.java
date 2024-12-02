public class KeywordsDetector {
    public static void main(String[] args) {
        String[] sentences = {
            "Our product will transform the market",
            "Programming is both painful and engaging",
            "This has nothing to do with machine learning",
            "We need to leverage our core competencies",
            "Let's talk about data and algorithms",
            "Chatbots are great but must be used carefully",
            "This blockchain-based solution will disrupt the industry",
            "The team showed great Synergy in the last project",
            "Use simple words without hype and fluff",
            "Our new technology presents a significant paradigm shift",
            "Effective presentations must be clear, concise, and humble"
        };
        // Some keywords that typically signal bullshit contents in business presentations 
        String[] keywords = {"synergy", "disrupt", "leverage", "Paradigm", "transform"};
        detectAndPrint(sentences, keywords);
    }

    // Iterates through all the sentences.
    // If a sentence contains one or more of the kewords, prints it.
    public static void detectAndPrint(String[] sentences, String[] keywords) {

  
        String[] newSentences = new String[sentences.length];
		for (int x = 0; x < sentences.length ;x++) {
            newSentences[x] = lowerCase(sentences[x]);
        }
        String[] newKeywords = new String[keywords.length];
		for (int z = 0; z < keywords.length ;z++) {
           newKeywords[z] = lowerCase(keywords[z]);
        }

        // Iterates over all sentences
        for (int i = 0; i < newSentences.length; i++) {
            // Iterates over all keywords for each sentence
            for (int n = 0; n < newKeywords.length; n++) {
                // Iterates through all possible starting positions in the sentence where a keyword can fit
                for (int k = 0; k <= newSentences[i].length() - newKeywords[n].length(); k++) {
                    int count = 0;
                    //Compares each character of the keyword with the corresponding characters in the sentence
                    for (int j = 0; j < newKeywords[n].length(); j++) {
                       if (newSentences[i].charAt(k + j) == newKeywords[n].charAt(j)) {
                            count++;
                        } else {
                            break;
                        }
                    }
                    if (count == newKeywords[n].length()) {
                        System.out.println(newSentences[i]);
                        break;
                    }
                }   
            }
        }
    }
    /** Returns the lowercase version of the given string. */
    public static String lowerCase(String str) {
    String newString = "";
        for (int i = 0; i < (str.length()) ;i++) {
            char c = str.charAt(i); 
            if ((c >= 65) && (c <= 90)) {
                c += 32;
            }
            newString += c;
        }
        return newString;
    }
}
