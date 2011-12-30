package org.svenehrke.swing.swingworker;

import javax.swing.*;
import java.awt.*;

// see http://stackoverflow.com/questions/782265/how-do-i-use-swingworker-in-java
public class Main {
	public static void main(String[] args) {
		Runnable runnable = new Runnable() {
			public void run() {
				JFrame frame = new ApplicationFrame().newComponent();

			}
		};
		EventQueue.invokeLater(runnable);
	}
}
