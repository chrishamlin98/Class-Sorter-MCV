package classSorter.controller;

import classSorter.dataModel.Model;
import classSorter.dataModel.MyConnection;
import classSorter.dataModel.Person;
import classSorter.viewer.AppListener;
import classSorter.viewer.CreateUserEvent;
import classSorter.viewer.CreateUserListener;
import classSorter.viewer.SaveListener;
import classSorter.viewer.View;

public class Controller implements CreateUserListener, SaveListener,
AppListener {
private View view;
private Model model;

public Controller(View view, Model model) {
this.view = view;
this.model = model;
}

@Override
public void onUserCreated(CreateUserEvent event) {
model.addPerson(new Person(event.getName(), event.getPassword()));
}

@Override
public void onSave() {
try {
	model.save();
} catch (Exception e) {
	view.showError("Error saving to MyConnection.");
}
}

@Override
public void onOpen() {
try {
	MyConnection.getInstance().connect();
} catch (Exception e) {
	view.showError("Cannot connect to MyConnection.");
}

try {
	model.load();
} catch (Exception e) {
	view.showError("Error loading data from MyConnection.");
}
}

@Override
public void onClose() {
MyConnection.getInstance().disconnect();
}

}
