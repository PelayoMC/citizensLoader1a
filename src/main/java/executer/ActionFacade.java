package executer;

import model.User;

public interface ActionFacade {
	public void saveData(User user);
	public void writeLog(String text);
	// public void verifySecurity();  Esto es una ampliacion opcional y no se en que consiste
}