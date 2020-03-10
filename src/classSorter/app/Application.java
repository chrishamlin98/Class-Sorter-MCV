package classSorter.app;

import javax.swing.SwingUtilities;

import classSorter.controller.Controller;
import classSorter.dataModel.Model;
import classSorter.viewer.View;

public class Application {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				runApp();
			}

		});
	}

	public static void runApp() {
		Model model = new Model();
		View view = new View(model);

		Controller controller = new Controller(view, model);

		view.setCreateUserListener(controller);
		view.setSaveListener(controller);
		view.setAppListener(controller);

		model.setPeopleChangedListener(view);
	}

}
