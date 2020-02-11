## 多线程

### 并发性与并行性是2个概念：

- 并发性（concurrency):同一时刻只有一条指令在一个处理器上执行，但多条指令快速轮换执行
- 并行性（parallel)：同一时刻，多条指令在多个处理器上同时执行。

### 分别使用3种创建线程的方式打印出1到100的数字，Callable方式返回最后一个数字的值？

```java
public class TestThread {
    public static void main(String[] args) {
        //实现Runnable接口的方式
        //{{c1::
        Runnable runnable= ()->{
          for(int i=1;i<=100;i++){
              try {
                  Thread.sleep(1);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
              System.out.println(Thread.currentThread().getName()+":"+i);
          }
        };
        //}}

        //实现Callable接口的方式
        //{{c1::
        FutureTask<Integer> futureTask=new FutureTask<Integer>((Callable<Integer>)()->{
            int i;
            for(i=1;i<=100;i++){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
            return i;
        });
	   //}}
        
        //调用
        //{{c1::
        new Thread(runnable).start();
        new Thread(futureTask).start();
        new FirstThread().start();
      	//}}
        
        //打印callable方式的返回值
        //{{c1::
        try {
            System.out.println("callable方式的返回值："+ task.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        //}}
        
    }
}
//继承Thread接口的方式
//{{c1::
class FirstThread extends Thread{
    @Override
    public void run() {
        for(int i=1;i<=100;i++){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.getName()+":"+i);
        }
    }
}
//}}
```

### 实现接口 创建线程VS 继承 Thread创建线程

实现接口会更好一些，因为：

- Java 不支持多重继承，{{c1:: 因此继承了 Thread 类就无法继承其它类，但是可以实现多个接口；}}
- 类可能只要求可执行就行，{{c1:: 继承整个 Thread 类开销过大。}}

### 如何获取当前线程对象以及名字

- Callable与Runnable的方式：{{c1:: 需要调用`Thread.currentThread()`}}
- 继承Thread类的方式：{{c1:: 直接使用`this`即可}}
- 获取线程名字：{{c1:: 获得线程对象后调用`getName()`方法 }}

### Future接口

作用：`Future接口用于代表函数接口Callable的返回值`

- `boolean cancel (boolean mayInterruptIfRunning)`：{{c1:: 试图取消对此任务的执行。}}
- `boolean isCancelled()`：{{c1:: 如果在任务正常完成前将其取消，则返回 true。}} 
- `boolean isDone()`：{{c1:: 如果任务已完成，则返回 true。 可能由于正常终止、异常或取消而完成，在所有这些情况`中，此方法都将返回 true。}} 
- `V get() throws InterruptedException,ExecutionException`：{{c1:: 如有必要，等待计算完成，然后获取其结果，阻塞。}}
- `V get(long timeout,TimeUnit unit) throws InterruptedException,ExecutionException,TimeoutException`：{{c1:: 如有必要，最多等待为使计算完成所给定的时间之后，获取其结果（如果没有返回值则抛出`TimeoutException`）。}}

### 线程6种状态转换图

{{c1::![image-20200206215027374](C:\Users\谢云\Desktop\note\codeNote\01 java\assets\image-20200206215027374.png)

}}

测试某个线程是否已经死亡使用：{{c1::`isAlive()`方法:线程如果处于新建与死亡2种状态，返回false,否则返回true.}}

死亡线程不可再次调用{{c1:: start()方法 }}

### Thread对象的Join()方法简单使用

执行结果：

![image-20200207080337367](C:\Users\谢云\Desktop\note\codeNote\01 java\assets\image-20200207080337367.png)

程序如下：

```java
	public static void main(String[] args)throws Exception
	{
        //{{c1::
		 // 启动子线程
         // JoinThread打印出1到100的数字
		new JoinThread("新线程").start();
		for (int i = 0; i < 100 ; i++ )
		{
            //从20开始等待被join的线程
			if (i == 20)
			{
				JoinThread jt = new JoinThread("被Join的线程");
				jt.start();
				// main线程调用了jt线程的join()方法，main线程
				// 必须等jt执行结束才会向下执行
				jt.join();
			}
			System.out.println(Thread.currentThread().getName()
				+ "  " + i);
		}
        //}}
	}
```

### 后台线程（也称守护线程）

后台线程有个特征：如果所有的前台线程都死亡，后台线程会自动死亡。

{{c1:: 在线程启动之前使用 setDaemon() 方法 }}可以将一个线程设置为守护线程。

```java
public static void main(String[] args) {
    //{{c1::
    Thread thread = new Thread(new MyRunnable());
    thread.setDaemon(true);
    //}}
}s
```

### Thread类的sleep与yield方法的区别

- `sleep`:{{c1::让当前线程暂停指定的毫秒数，线程进入阻塞状态，会抛异常。}}
- `yield`:{{c1::让当前线程暂停，线程进入就绪状态，有可能接着当前线程继续执行，不建议使用}}
- 设置线程的优先级：{{c1::Thread对象的`setPriority(Thread.MAX_PRIORITY)`。}}

### 线程同步的三种方式

- 同步代码块

  - 同步监视器是{{c1::`synchronized(obj)`中的obj}}

  - ```java
    //代码如下{{c1::
    synchronized(obj){
        //同步代码块
    }
    //}}
    ```

- 同步方法

  - 同步监视器是{{c1::`this`}}

  - ```java
    //代码如下{{c1::
    public synchronized void draw(double drawAmount){
        ...
    }
    //}}
    ```

- 同步锁（lock)

  - Lock的一个实现类：{{c1::`ReentrantLock`}}

  - ReadWriteLock的一个实现类：{{c1::`ReentrantReadWriteLock`}}

  - 通常使用Lock的代码格式如下

    ```java
    class X
    {
        //{{c1::
    	// 定义锁对象
    	private final ReentrantLock lock = new ReentrantLock();
        // ...
        
    	// 定义需要保证线程安全的方法
    	public void m(double drawAmount)
    	{
    		// 加锁
    		lock.lock();
    		try
    		{
                // 需要保证现场安全的代码
                // ... method body
    		}
            // 使用finally块来保证释放锁
    		finally
    		{
    			释放锁
    			lock.unlock();
    		}
    	}
        //}}
    }
    ```

    ## 线程池

    ### Executor接口

    作用：Executor一般用来代替Thread类的创建`new Thread(new(RunnableTask())).start()`

    使用例子：

    ```java
    //{{c1::
    Executor executor = Executors.newCachedThreadPool();;
    executor.execute(new RunnableTask1());
    //}}
    ```

    ### ExecutorService接口

    ExecutorService接口继承了{{c1:: Executor接口 }}

    | 方法                | 作用                                                         |
    | ------------------- | ------------------------------------------------------------ |
    | **shutdown()**      | {{c1::已经被提交的任务可以运行到结束，不接受新任务的提交}}   |
    | **submit()**：      | {{c1::submit扩展了execute方法,将指定的Runnable或者Callable任务提交到线程池，它会返回Future，Runnable任务future会返回null。}} |
    | **shutdownNow()**： | {{c1::正在运行的任务不可以运行到结束，要马上停止}}           |

    对应在Executors
    
    ### ScheduledExecutorService接口
    
    作用：定时执行线程任务
    
    主要方法如下：
    
    `schedule`:{{c1:: 指定任务在delay后延迟}}
    `scheduleAtFixedRate`：{{c1:: 指定任务定期执行}}
    `scheduleWithFixedDelay`：{{c1:: 指定任务定期执行}}
    
    