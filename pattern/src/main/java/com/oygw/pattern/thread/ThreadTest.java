package com.oygw.pattern.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ThreadTest {

	/**
	 * 核心线程数，指保留的线程池大小
	 */
	private static int corePoolSize = 20;

	/**线程池**/
//	private static ExecutorService threadPool = new ThreadPoolExecutor(corePoolSize,20,1,TimeUnit.SECONDS,
//			new LinkedBlockingQueue<Runnable>());
//	private static ExecutorService singleThread = Executors.newSingleThreadExecutor();
	private static ExecutorService fixedThread = Executors.newFixedThreadPool(corePoolSize);

	private ThreadTest(){

	}


	static class TestSubmit implements Callable<String> {

	    private String taskName;

	    public TestSubmit(String taskName){
	        this.taskName = taskName;
        }

        @Override
        public String call() throws Exception {
            System.out.println(Thread.currentThread().getName() + " " + taskName + " begin..." );
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + " " + taskName + " end..." );
            return taskName + " 完成了";
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        ExecutorService executorService = Executors.newFixedThreadPool(10);
//
//        List<Future<String> > result = new ArrayList<>(100);
//
//
//        for (int i = 1 ; i <= 100 ; i ++){
//            Future<String> future = executorService.submit(new TestSubmit("任务"+i));
//            result.add(future);
//        }
//
//        System.out.println("add DONE");
//
//
//
//        for (Future<String> future:result){
//            System.out.println(future.get());
//        }

//        //TIME_WAITING
//        new Thread(() -> {
//            while (true) {
//                try {
//                    TimeUnit.SECONDS.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }, "timewaiting").start();
//
//        //WAITING，线程在ThreadStatus类锁上通过wait进行等待
//        new Thread(() -> {
//            while (true) {
//                synchronized (ThreadTest.class) {
//                    try {
//                        ThreadTest.class.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }, "Waiting").start();
//
//        //线程在ThreadStatus加锁后，不会释放锁
//        new Thread(new BlockedDemo(),"BlockDemo-01").start();
//	    new Thread(new BlockedDemo(),"BlockDemo-02").start();

//        Thread thread = new Thread(() -> {
//            while (true) {
//                boolean ii = Thread.currentThread().isInterrupted();
//                if (ii) {
//                    System.out.println("before:" + ii);
//                    Thread.interrupted();
//                    //对线程进行复位，中断标识为false
//                    System.out.println("after:" + Thread.currentThread().isInterrupted());
//                }
//            }
//        });
//        thread.start();
//        TimeUnit.SECONDS.sleep(1);
//        thread.interrupt(); // 设置中断标识,中断标识为true

//        Thread thread = new Thread(() -> {
//            while (true) {
//                try {
//                    Thread.sleep(10000);
//                } catch (InterruptedException e) {
//                    //抛出该异常，会将复位标识设置为false
//                    e.printStackTrace();
//                }
//            }
//        });
//        thread.start();
//        System.out.println(thread.isInterrupted());//false
//        TimeUnit.SECONDS.sleep(3);
//        thread.interrupt();
//        //设置复位标识为true
//        TimeUnit.SECONDS.sleep(3);
//        System.out.println(thread.isInterrupted());//false


        Thread thread = new Thread(() -> {
            int i = 0;
            while (!stop) {
                i++;
                System.out.println(i);
            }
            System.out.println("thread end:" + i);
        });
        thread.start();
        System.out.println("thread begin");
        Thread.sleep(1000);
        stop = true;




	}

    private volatile static boolean stop=false;

    static class BlockedDemo extends Thread {
        public void run() {
            synchronized (BlockedDemo.class) {
                while (true) {
                    try {
                        TimeUnit.SECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

        volatile String a = "string";
    public void test (){
    }
}

