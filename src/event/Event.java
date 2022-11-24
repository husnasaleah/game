package event;

import Charactor.*;

public class Event {
		public static boolean checkHit(Trex trex,Wave wave,int trexSize,int waveHeight){
			if(trex.x+trexSize>wave.x&&trex.x<wave.x) {
				if(trex.y+trexSize>=wave.y-waveHeight) {
					return true;
				}
			}
				return false;
			}
		public static void gameStop(Wave[] wave,Environment[] env) {
		}

}
