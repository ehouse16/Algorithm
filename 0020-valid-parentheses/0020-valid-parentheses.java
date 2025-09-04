class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for(int i = 0; i < s.length(); i++){
            char a = s.charAt(i);

            switch (a){
                case '(':
                    stack.push(a);
                    break;
                case '[':
                    stack.push(a);
                    break;
                case '{':
                    stack.push(a);
                    break;
                case ')':
                    if(stack.isEmpty() || stack.pop() != '(')
                        return false; 
                        break;
                case ']':
                    if(stack.isEmpty() || stack.pop() != '[')
                        return false;
                        break;
                case '}':
                    if(stack.isEmpty() || stack.pop() != '{')
                        return false;
                        break;
            }
        }
        return stack.isEmpty();
    }
}