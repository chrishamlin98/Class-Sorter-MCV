package classSorter.dataModel;

public class MySQLDAOFactory extends DAOFactory {

	@Override
	public PersonDAO getPersonDAO() {
		return new MySQLPersonDAO();
	}


	@Override
	public LogDAO getLogDAO() {
		return new MySQLLogDAO();
	}
}
