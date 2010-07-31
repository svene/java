package org.svenehrke.effectivejava2nd.item69;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Pg275 {
	// Simple framework for timing concurrent execution
	public static long time(Executor executor, int concurrency,
		final Runnable action) throws InterruptedException {
		final CountDownLatch ready = new CountDownLatch(concurrency);
		final CountDownLatch start = new CountDownLatch(1);
		final CountDownLatch done = new CountDownLatch(concurrency);
		System.out.println("preparation");
		for (int i = 0; i < concurrency; i++) {
			executor.execute(new Runnable() {
				public void run() {
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("runnable" + " ready");
					ready.countDown(); // Tell timer we're ready (sven: this runnable is ready for execution)  /*1a: see also /*1b below
					try {
						start.await(); // Wait till peers are ready                                            /*2a this runnable now waits  for start signal, see /*2b below
						action.run();
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
					} finally {
						done.countDown();  // Tell timer we're done                                           /*3a: signal that this runnable is done, see /*3b below
					}
				}
			});
		}
		System.out.println("wait for all ready");
		ready.await();	 // Wait for all workers to be ready                       /*1b: wait until all runnable executed /*1a)
		long startNanos = System.nanoTime();
		System.out.println("give start signal");
		start.countDown(); // And they're off! (sven: give (start-signal))         /*2b: this is the start-signal for all runnables, see /*2a above
		System.out.println("wait for all done");
		done.await();	  // Wait for all workers to finish                        /*3b: wait until all runnable executed /*3a), see /*3a above
		System.out.println("all done");
		return System.nanoTime() - startNanos;
	}

	public static void main(String[] args) throws Exception {
		new Pg275().run();
	}

	private void run() throws Exception {
		final long l = time(Executors.newFixedThreadPool(50), 20, new Runnable() {
			public void run() {
				System.out.println("hallo");
			}
		});
		System.out.println("l = " + l);
	}
}
