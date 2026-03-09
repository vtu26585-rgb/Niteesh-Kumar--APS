class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int p1 = 0;
        int p2 = 0;
        Stack<Integer> s = new Stack<>();
        while (p1 < pushed.length) {
            if (pushed[p1] == popped[p2]) {
                p2++;
                while (!s.isEmpty() && s.peek() == popped[p2]) {
                    s.pop();
                    p2++;
                }
            } else {
                s.push(pushed[p1]); 
            }
            p1++;
        }
        while (!s.isEmpty()) {
            if (s.pop() != popped[p2]) {
                return false;
            }
            p2++;
        }
        return true;
    }
}