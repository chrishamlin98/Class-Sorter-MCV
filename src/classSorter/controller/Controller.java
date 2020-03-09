package classSorter.controller;

import java.sql.SQLException;

import classSorter.dataModel.Model;
import classSorter.dataModel.Person;
import classSorter.dataModel.PersonDAO;
import classSorter.viewer.CreateUserEvent;
import classSorter.viewer.CreateUserListener;
import classSorter.viewer.View;

public class Controller implements CreateUserListener {
	private View view;
	private Model model;
	
	private PersonDAO personDAO = new PersonDAO();

	public Controller(View view, Model model) {
		this.view = view;
		this.model = model;
	}

	@Override
	public void userCreated(CreateUserEvent event) {
		System.out.println("Login event received: " + event.getName() + "; " + event.getPassword());

		try {
			personDAO.addPerson(new Person(event.getName(), event.getPassword()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
