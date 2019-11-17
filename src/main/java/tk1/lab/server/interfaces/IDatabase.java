package tk1.lab.server.interfaces;

import tk1.lab.server.model.Flight;

public interface IDatabase {
	public boolean isUserAlreadyLoggedIn(String userName);
	public String loginUser(String userName);
	public String logOutUser(String userName);
	public boolean updateFlight(Flight flight);
	public boolean deleteFlight(Flight flight);
	
}
