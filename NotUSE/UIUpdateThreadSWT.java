package org.read.read;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class UIUpdateThreadSWT {

	private static int counter = 0;

	public static void main(String[] args) throws Exception {
		final Display display = new Display();
		/** create the new window */
		Shell shell = new Shell(display);

		/** adding the window title */
		shell.setText("Update UI from thread examples");

		/** add a layout of 1 columns */
		shell.setLayout(new GridLayout(1, true));

		/** setting up the window size */
		shell.setSize(600, 400);

		/** creating a new label widget on the new created shell */
		final Label label = new Label(shell, SWT.NONE);
		label.setText(counter + "");

		/** open the shell/window */
		shell.open();

		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					display.asyncExec(new Runnable() {
						public void run() {
							/**
							 * this is in case that the thread starts before the UI is created
							 */
							if (label == null || label.isDisposed())
								return;
							label.setText("" + counter);
						}
					});
					counter++;
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});

		/** start the working thread */
		thread.start();

		/** Loop to keep the application opened */
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}
}