package neustadt.morsecode;

import java.util.HashMap;

public class MorseCode {
	private HashMap<String, String> hashMap;

	public MorseCode() {
		this.hashMap = new HashMap<String, String>();
		for (Code c : Code.values()) {
			hashMap.put(c.toString(), c.getCodeValue());
			hashMap.put(c.getCodeValue(), c.toString());
		}
	}

	public String encode(String message) {
		StringBuilder encodedMessage = new StringBuilder();
		String[] messageWords = message.split(" ");
		for (int i = 0; i < messageWords.length; i++) {
			String[] messageCharacters = messageWords[i].toLowerCase()
					.split("");
			for (int z = 0; z < messageCharacters.length; z++) {
				encodedMessage.append(hashMap.get(messageCharacters[z]));
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
				decodedMessage.append(hashMap.get(codeCharacters[z]));
			}
			if (i + 1 < codeWords.length) {
				decodedMessage.append(' ');
			}
		}
		return decodedMessage.toString();
	}
}