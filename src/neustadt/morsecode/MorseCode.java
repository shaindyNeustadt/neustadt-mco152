package neustadt.morsecode;

public class MorseCode {

	public MorseCode() {

	}
	
	public String encode(String message) {
		StringBuilder encodedMessage = new StringBuilder();
		String[] messageWords = message.split(" ");
		for (int i = 0; i < messageWords.length; i++) {
			char[] messageCharacters = messageWords[i].toLowerCase().toCharArray();
			for (int z = 0; z < messageCharacters.length; z++) {
				for (Code c : Code.values()) {
					if (messageCharacters[z] == (c.toString().charAt(0))) {
						encodedMessage.append(c.getCodeValue());
						break;
					}
				}
				if (z + 1 < messageCharacters.length) {
					encodedMessage.append(' ');
				}
			}
			if (i + 1 < messageWords.length) {
				encodedMessage.append("   ");
			}
		}
		return encodedMessage.toString();
	}

	public String decode(String code) {
		StringBuilder decodedMessage = new StringBuilder();
		String[] codeWords = code.split("   ");
		for (int i = 0; i < codeWords.length; i++) {
			String[] codeCharacters = codeWords[i].split(" ");
			for (int z = 0; z < codeCharacters.length; z++) {
				for (Code c : Code.values()) {
					if (codeCharacters[z].equals(c.getCodeValue())) {
						decodedMessage.append(c.toString());
						break;
					}
				}
			}
			if (i + 1 < codeWords.length) {
				decodedMessage.append(' ');
			}
		}
		return decodedMessage.toString();
	}
}