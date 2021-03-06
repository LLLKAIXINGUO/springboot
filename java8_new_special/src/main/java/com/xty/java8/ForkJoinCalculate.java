package com.xty.java8;

import java.io.Serializable;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

public class ForkJoinCalculate extends RecursiveTask<Long>  {


    private static final long serialVersionUID = 134L;

    private long start;
    private long end;

    public ForkJoinCalculate(){

    }

    public ForkJoinCalculate(long start,long end){
        this.start = start;
        this.end = end;
    }

    // 临界值
    private static final long THRESHOLD = 10000;
    @Override
    protected Long compute() {
        long length =  end - start;

        if (length <= THRESHOLD){
            long sum = 0;
            //计算值
            for (long i = start; i <= end; i++){
                sum += i;
            }
            return sum;
        }else {
            // 拆分任务
            long middle = (start + end)/2;

            ForkJoinCalculate left = new ForkJoinCalculate(start,middle);
            left.fork(); // 拆分子任务，同时压入线程队列
            ForkJoinCalculate right = new ForkJoinCalculate(middle+1,end);
            right.fork();

            return left.join() + right.join();
        }

    }
}
