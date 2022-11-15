import javax.swing.JOptionPane;
public class PigLatin {

	public static void main(String[] args) {
		String userString;
		String translation = "";
		
		userString = JOptionPane.showInputDialog("Enter a sentence or word to translate: ");
		
		String[] words = userString.split(" ");
		for(int i = 0; i < words.length; i++) {
			translation += pigLatinTranslation(words[i]);
		}
		
		JOptionPane.showMessageDialog(null, translation);
		
	}
	
	public static String pigLatinTranslation(String sentence) {
		char[] temp = new char[sentence.length()];
		for(int i = 0; i < temp.length; i++) {
			temp[i] = sentence.toCharArray()[i];
		}
		
		if(isVowel(temp[0])) {
			return sentence += "-ay ";
		}		
		else {
			
			String strTemp = "";
			String newTranslation = "";
			int index = 0;
			
			for(int i = 0; i < temp.length; i++) {
				if(!isVowel(temp[i])) {
					strTemp += temp[i];
					index++;
				}
				else {
					break;
				}
			}
			
			for(int i = index; i < temp.length; i++) {
				newTranslation += temp[i];
			}
			
			newTranslation += "-";
			newTranslation += strTemp;
			newTranslation += "ay ";
			return newTranslation;
		}
		
	}
	
	public static boolean isVowel(char a) {
		char[] vowels = {'A', 'E', 'I', 'O', 'U'};
		for(int i = 0; i < vowels.length; i++) {
			if(vowels[i] == Character.toUpperCase(a)) {
				return true;
			}
		}
		return false;
	}
}
