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
        for (int i = 0; i < sentences.length; i++) {
            for (int n = 0; n < keywords.length; n++) {
                for (int k = 0; k <= sentences[i].length() - keywords[n].length(); k++) {
                    int count = 0;
                    for (int j = 0; j < keywords[n].length(); j++) {
                       if (sentences[i].charAt(k + j) == keywords[n].charAt(j)) {
                                count++;
                            } else if (sentences[i].charAt(k + j) != keywords[n].charAt(j)) {
                                break;
                            }
                        }
                    if (count == keywords[n].length()) {
                        System.out.println(sentences[i]);
                        break;
                    }
                }
                
            }
        }      
    }
}
