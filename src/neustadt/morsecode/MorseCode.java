package neustadt.morsecode;

public class MorseCode {

	public MorseCode() {
	}

	public String encode(String message) {
		String encodedMessage = "";
		String[] messageWords = message.split(" ");
		for (int i = 0; i < messageWords.length; i++) {
			char[] messageCharacters = messageWords[i].toLowerCase()
					.toCharArray();
			for (int z = 0; z < messageCharacters.length; z++) {
				for (Code c : Code.values()) {
					if (messageCharacters[z] == (c.toString().charAt(0))) {
						encodedMessage += c.getCodeValue();
						continue;
					}
				}
				if (z + 1 < messageCharacters.length) {
					encodedMessage += ' ';
				}
			}
			if (i + 1 < messageWords.length) {
				encodedMessage += "   ";
			}
		}
		return encodedMessage;
	}

	public String decode(String code) {
		String decodedMessage = "";
		String[] codeWords = code.split("   ");
		for (int i = 0; i < codeWords.length; i++) {
			String[] codeCharacters = codeWords[i].split(" ");
			for (int z = 0; z < codeCharacters.length; z++) {
				for (Code c : Code.values()) {
					if (codeCharacters[z].equals(c.getCodeValue())) {
						decodedMessage += c.toString();
						break;
					}
				}
			}
			if (i + 1 < codeWords.length) {
				decodedMessage += ' ';
			}
		}
		return decodedMessage;
	}
}