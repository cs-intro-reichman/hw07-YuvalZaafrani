

public class HashTagTokenizer {

	public static void main(String[] args) {

		String hashTag = args[0];
		String []dictionary = readDictionary("dictionary.txt");
		breakHashTag(hashTag, dictionary);
	}

	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];

		In in = new In(fileName);
		for (int i=0; i < dictionary.length; i++) {
			dictionary[i] = in.readLine();
		}
		
		return dictionary;
	}

	public static boolean existInDictionary(String word, String []dictionary) {
		boolean test = false;
		for (int i=0; i < dictionary.length; i++) {
			if ( dictionary[i].equals(word) ) 
			test = true;
		}
		return test;
	}		

	public static void breakHashTag(String hashtag, String[] dictionary) {

		// Base case: do nothing (return) if hashtag is an empty string.
        if (hashtag.isEmpty()) {
            return;
        }
 
        int N = hashtag.length();
		String word = ""; 
		String lowHash = hashtag.toLowerCase();
        for (int i = 1; i <= N; i++) {
			word = lowHash.substring(0,i);
			if (existInDictionary(word, dictionary )) {
				System.out.println(word);
				i = N + i;
		    }
        }
		String newHashtag = lowHash.substring(word.length());
		breakHashTag(newHashtag, dictionary);	

    }

}
