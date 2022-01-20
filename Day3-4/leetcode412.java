import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class leetcode412 {
//思路：给一个集合接收采用for遍历到n然后按需求添加对应的值（Fizz还是Buzz还是FizzBuzz）不是的就添加遍历i的下标

    class Solution {
        public List<String> fizzBuzz(int n) {
            List<String> answer = new LinkedList<String>();
            for (int i = 1; i <= n; i++) {
                if (i % 3 == 0 && i % 5 == 0) {
                    answer.add("FizzBuzz");
                } else if (i % 3 == 0) {
                    answer.add("Fizz");
                } else if (i % 5 == 0) {
                    answer.add("Buzz");
                } else {
                    answer.add(String.valueOf(i));
                }
            }
            return answer;
        }
    }
}
