package elevator;

import elevator.LiftProcess.DIRECTIONS;
import elevator.LiftProcess.STATE;

public class Lift {
	private int id;
	private STATE state = STATE.IDLE;
	private DIRECTIONS direction = DIRECTIONS.NAN;
	private int person = 0;
	private int floor = 1;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public STATE getState() {
		return state;
	}
	public void setState(STATE state) {
		this.state = state;
	}
	public DIRECTIONS getDirection() {
		return direction;
	}
	public void setDirection(DIRECTIONS direction) {
		this.direction = direction;
	}
	public int getPerson() {
		return person;
	}
	public void setPerson(int person) {
		this.person = person;
	}
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}

}
