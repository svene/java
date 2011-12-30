package org.svenehrke.swing.swingworker;

import javax.swing.*;

public class AnswerWorker extends SwingWorker<Integer, Integer> {
	final JFrame frame;

	public AnswerWorker(JFrame aFrame) {
		frame = aFrame;
	}

	@Override
	protected Integer doInBackground() throws Exception {
		// do a time consuming task:
		Thread.sleep(1000);
		return 42;
	}

	@Override
	protected void done() {
		try {
			JOptionPane.showMessageDialog(frame, get());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
