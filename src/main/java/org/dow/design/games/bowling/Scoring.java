package org.dow.design.games.bowling;

public enum Scoring {
	
	OPEN {
		/**
		 * This method is to get a shot score for an open frame.
		 * 
		 * @param shot 	This is the shot.
		 * @param shots This is the list of shots.
		 * @return 		The number of pins knocked down in frame.
		 */
		@Override
		protected int getScore(int shot, int[] shots) {
			int pins = shots[shot];
			int previous = shots[shot - 1];
			return pins + previous;
		}
	},

	STRIKE {
		/**
		 * This method is to get a shot score for a frame with a strike.
		 * 
		 * @param shot 	This is the shot index.
		 * @param shots This is the list of shots.
		 * @return 		10 pins in first shot of frame plus the sum of your 
		 * 				next two shots in the next frame(s).
		 */
		@Override
		protected int getScore(int shot, int[] shots) {
			int pins = shots[shot - 1];
			int next = shots[shot + 1];
			int next2;
			if (next == 10) {
				next2 = shots[shot + 3];
			} else {
				next2 = shots[shot + 2];
			}
			return pins + next + next2;
		}
	},
	SPARE {
		/**
		 * This method is to get a shot score for a frame with a spare.
		 * 
		 * @param shot This is the shot index.
		 * @param shots This is the list of shots.
		 * @return 		10 total pins in the frame plus the sum of your next shot.
		 */
		@Override
		protected int getScore(int shot, int[] shots) {
			int pins = shots[shot];
			int previous = shots[shot - 1];
			int next = shots[shot + 1];
			return pins + previous + next;
		}
	};

	protected abstract int getScore(int shot, int[] shots);
}
