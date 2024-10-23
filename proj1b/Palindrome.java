public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        LinkedListDeque<Character> lldeque = new LinkedListDeque<Character>();
        for(int i = 0; i<word.length(); i++){
            lldeque.addLast(word.charAt(i));
        }
        return lldeque;
    }

    public boolean isPalindrome(String word){
        if(word.equals("")){
            return true;
        }else{
            Deque<Character> d = wordToDeque(word);
            String reverseString = "";
            for(int i = 0; i < word.length(); i++){
                reverseString += d.removeLast();
            } 

            return reverseString.equals(word);
        }
    }


    public boolean isPalindrome(String word, CharacterComparator cc){
        if(word.length() <= 1){
            return true;
        }else{
            for(int i = 0; i< word.length()/2; i++){
                if(cc.equalChars(word.charAt(i), word.charAt(word.length() - i -1)) == false){
                   return false;
                }
            }
            return true;
        }
    }
}
