package org.example.graph;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Basic {

    int rs = 0;

    public static void main(String [] args){

        int [] numbers = {1,2,3,4,5};
        int target = 3;

        Basic basic = new Basic();
        basic.dfs(numbers, 0, 0, target);

        log.info("cnt: {}", basic.rs);

    }

    public void dfs(int [] numbers , int index, int sum, int target){

        if(index == numbers.length){
            if(sum == target){
                rs++;
                return;
            }
            return;
        }

        dfs(numbers, index+1, sum + numbers[index], target);
        dfs(numbers, index+1, sum - numbers[index], target);
    }
}
