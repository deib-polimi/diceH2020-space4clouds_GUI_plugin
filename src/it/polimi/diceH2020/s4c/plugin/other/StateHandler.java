package it.polimi.diceH2020.s4c.plugin.other;

import java.io.Serializable;

public class StateHandler implements Serializable{

	private static final long serialVersionUID = 3500593748632009685L;
	public State currentState;

	public StateHandler() {
		currentState = State.IDLE;
	}

	public State getCurrentState(){
		return currentState;
	}

	public State stop(){
		State state = currentState.stop();
		if(state == null) throw new UnsupportedOperationException(": " + currentState);
		return currentState = state;
	}

}
