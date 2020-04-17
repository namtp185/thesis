package frsl;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import frsl.gui.MainWindow;

public class Application {

	public static void main(String[] args) {
		MainWindow win = new MainWindow();
		win.pack();
		win.setVisible(true);
	}

}
