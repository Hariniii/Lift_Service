package elevator;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

@Path("/smartkent/liftsimulation/")
public class LiftProcess {
	Lift lift = new Lift();
	public static int TRAVEL_TIME = 3;
	public static int PICK_DROP_TIME = 4;
	
	enum DIRECTIONS{
		UP,
		DOWN,
		NAN
		
	}
	
	enum STATE{
		IDLE,
		TO_PICKUP,
		PICKUP,
		TO_DROPOFF,
		DROPOFF
	}


	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String liftSimulation(@QueryParam("fromFloor") int fromFloor, @QueryParam("toFloor") int toFloor) {
		for(int i=1; i<3; i++) {
			lift.setId(i);
			System.out.println(lift.getId());
			System.out.print(lift.getState());
			System.out.println(lift.getDirection());
			System.out.println(lift.getPerson());
			System.out.println(lift.getFloor());
		}
		DIRECTIONS reqDir;
		if(toFloor>fromFloor) {
			reqDir = DIRECTIONS.UP;
		}else {
			reqDir = DIRECTIONS.DOWN;
		}
		
		int chosen_lift = chooseElevator(lift.getDirection(), reqDir, toFloor, lift.getFloor());
		
		return null;
		
	}
	
	
	public int chooseElevator(DIRECTIONS dir, DIRECTIONS reqDir, int reqFloor, int currFloor) {
		for(int i=1; i<3; i++) {
			if((dir==DIRECTIONS.UP && currFloor<reqFloor && reqDir==DIRECTIONS.UP) ||
				dir==DIRECTIONS.DOWN && currFloor>reqFloor && reqDir==DIRECTIONS.DOWN) {
				return i;
			}
		}
		
		for(int i=1; i<3; i++) {
			if(dir==DIRECTIONS.NAN) {
				return i;
			}
		}
		return -1;
	}
	
}
