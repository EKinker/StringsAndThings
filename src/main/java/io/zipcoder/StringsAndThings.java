package io.zipcoder;


/**
 * @author tariq
 */
public class StringsAndThings {

    /**
     * Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez" count,
     * but not the 'y' in "yellow" (not case sensitive). We'll say that a y or z is at the end of a word if there is not an alphabetic
     * letter immediately following it. (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)
     * example : countYZ("fez day"); // Should return 2
     * countYZ("day fez"); // Should return 2
     * countYZ("day fyyyz"); // Should return 2
     */
    public Integer countYZ(String input) {
        int counter = 0;

        for (int i = 0; i < input.length(); i++) {       //check every letter in the string
            if (input.charAt(i) == 'y' || input.charAt(i) == 'z') { // looks for y or z
                if ((i < input.length() - 1) && !Character.isLetter(input.charAt(i + 1))) {
                    //if y or z is not the last character in the string and if the next character is not a letter, add to the count
                    counter++;
                } else if ((i == input.length() - 1)) {
                    // if y or z is the last letter of the string, add to the count
                    counter++;
                }
            }
        }
        return counter;
    }

    /**
     * Given two strings, base and remove, return a version of the base string where all instances of the remove string have
     * been removed (not case sensitive). You may assume that the remove string is length 1 or more.
     * Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
     * <p>
     * example : removeString("Hello there", "llo") // Should return "He there"
     * removeString("Hello there", "e") //  Should return "Hllo thr"
     * removeString("Hello there", "x") // Should return "Hello there"
     */
    public String removeString(String base, String remove) {
        return base.replace(remove, "");  //find all cases of the 'remove' input and replaces them with nothing
    }

    /**
     * Given a string, return true if the number of appearances of "is" anywhere in the string is equal
     * to the number of appearances of "not" anywhere in the string (case sensitive)
     * <p>
     * example : containsEqualNumberOfIsAndNot("This is not")  // Should return false
     * containsEqualNumberOfIsAndNot("This is notnot") // Should return true
     * containsEqualNumberOfIsAndNot("noisxxnotyynotxisi") // Should return true
     */
    public Boolean containsEqualNumberOfIsAndNot(String input) {
        int isCount = 0;
        int notCount = 0;

        //count all the 'is's
        for (int i = 0; i < input.length() - 1; i++) {
            if (input.charAt(i) == 'i' && input.charAt(i + 1) == 's') {
                isCount++;
            }
        }
        for (int n = 0; n < input.length() - 2; n++) { //count all the 'not's
            if (input.charAt(n) == 'n' && input.charAt(n + 1) == 'o' && input.charAt(n + 2) == 't') {
                notCount++;
            }
        }

        /* System.out.println(isCount); //test # of is
        System.out.println(notCount); //test # of not
        return null; */

        return (isCount == notCount);
    }

    /**
     * We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its left or right.
     * Return true if all the g's in the given string are happy.
     * example : gHappy("xxggxx") // Should return  true
     * gHappy("xxgxx") // Should return  false
     * gHappy("xxggyygxx") // Should return  false
     */
    public Boolean gIsHappy(String input) {
        boolean result = false;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'g') {
                result = input.charAt(i - 1) == 'g' || input.charAt(i + 1) == 'g';
            }
        }
        return result;
    }


    /**
     * We'll say that a "triple" in a string is a char appearing three times in a row.
     * Return the number of triples in the given string. The triples may overlap.
     * example :  countTriple("abcXXXabc") // Should return 1
     * countTriple("xxxabyyyycd") // Should return 3
     * countTriple("a") // Should return 0
     */
    public Integer countTriple(String input) {
        int tripleCount = 0;
            for (int i = 0; i < input.length()-2; i++) {
                if(input.charAt(i) == input.charAt(i+1) && input.charAt(i) == input.charAt(i+2)) {
                    tripleCount++;
                }
            }

        return tripleCount;
    }
}
