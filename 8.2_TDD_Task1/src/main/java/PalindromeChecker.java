public class PalindromeChecker {
    public boolean isPalindrome(String str){
        str = str.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }

}