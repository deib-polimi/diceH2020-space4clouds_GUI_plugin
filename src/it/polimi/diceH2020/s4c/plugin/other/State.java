package it.polimi.diceH2020.s4c.plugin.other;

public enum State {

	IDLE {

		@Override
		public State migrate() {
			return CHARGED;
		}

		@Override
		public State stop() {
			return ERROR;
		}

	},
	CHARGED {
		@Override
		public State migrate() {
			return RUNNING;
		}

		@Override
		public State stop() {
			return ERROR;
		}

	},
	RUNNING {

		@Override
		public State migrate() {
			return FINISH;
		}

		@Override
		public State stop() {
			return ERROR;
		}

	},
	FINISH {

		@Override
		public State migrate() {
			return IDLE;
		}

		@Override
		public State stop() {
			return ERROR;
		}

	},

	ERROR {

		@Override
		public State migrate() {
			return IDLE;
		}

		@Override
		public State stop() {
			return null;
		}
	};
	public abstract State migrate();

	public abstract State stop();

}
