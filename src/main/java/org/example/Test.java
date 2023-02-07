package org.example;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

@Slf4j
public class Test {

    private static final Logger logger = LoggerFactory.getLogger(Test.class);

    public static void main(String[] args) {

        // -1 + 2 - 3 + 4 - 5 = 3
        // +1 - 2 + 3 -4 + 5 = 3
        int [] numbers = {1, 2, 3, 4, 5};
        int target = 3;

        int cnt = dfs(numbers, 0, 0, 3);
        System.out.println("cnt: "+ cnt);

    }


//    public static int dfs(int[] numbers, int n, int sum, int target){
//
//        if(n == numbers.length){
//            if(sum == target){
//                return 1;
//            }
//            return 0;
//        }
//        log.info("sum[{}] >>  dfs({}, {}, {}, {}) + dsf({}, {}, {}, {})" ,sum , Arrays.toString(numbers), n+1, sum+numbers[n], target, numbers, n+1, sum - numbers[n], target);
//        return dfs(numbers, n+1, sum + numbers[n], target) + dfs(numbers, n+1, sum - numbers[n], target);
//
//    }



    public static int dfs(int[] numbers, int n, int sum, int target){

        if(n == numbers.length){
            log.info("n == array size sum:[{}]", sum);
            if(sum == target){
                return 1;
            }
            return 0;
        }

        log.info("sum[{}] >>  dfs({}, {}, {}, {}) + dsf({}, {}, {}, {})" ,sum , Arrays.toString(numbers), n+1, sum+numbers[n], target, numbers, n+1, sum - numbers[n], target);


        int resultPlus =  dfs(numbers, n+1, sum + numbers[n], target);
        log.info("resultPlus: {}", resultPlus);
        int resultMinus = dfs(numbers, n+1, sum - numbers[n], target);
        log.info("resultMinus: {}", resultMinus);
        int result = resultPlus + resultMinus;
        log.info("result: {}", result);
        return result;
    }

    public static int dfsTs(int [] numbers, int n, int sum, int cnt){
        if(sum == 15 || sum == 10){
            cnt++;
        }
        if(n == numbers.length){
            return cnt;
        }
        log.info("sum [{}] >>  dfsTs({}, {}, {}, {})", sum, numbers, n+1, sum+numbers[n], cnt);
        int result = dfsTs(numbers, n+1, sum + numbers[n], cnt);
        log.info("sum [{}] >> result: {}", sum, result);
        return result;
    }
}
