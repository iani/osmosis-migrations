SF {
	*playbuf {
		^{ | buf = 0, rate = 1, trigger = 0, startPos = 0, loop = 0,
			doneAction = 0, vol = 1 |
			var src;
			src = PlayBuf.ar(1, buf, rate * BufRateScale.kr(buf),
				trigger, startPos * BufSampleRate.kr (buf),
				loop, doneAction
			);
			src * vol;
		}
	}
 
	*playbufpan {
		^{ | buf = 0, rate = 1, trigger = 0, startPos = 0, loop = 0,
			doneAction = 0, pos = 0, vol = 1 |
			var src;
			src = PlayBuf.ar(1, buf, rate * BufRateScale.kr(buf),
				trigger, startPos * BufSampleRate.kr (buf),
				loop, doneAction
			);
			Pan2.ar (src, pos, vol);
		}
	}
 
	*playbufdurpan {
		^{ | buf = 0 from = 0 dur = 1 rate = 1 trigger = 1 pos = 0 vol = 1 |
			var src;
			src = PlayBuf.ar (1, buf,
				rate * BufRateScale.kr (buf),
				trigger,
				from * BufSampleRate.kr (buf),
				1, 0
			)
			* EnvGen.kr (Env ([0, 1, 1, 0], [0.01, dur - 0.02 max: 0.03, 0.01]),
				trigger, doneAction: 0
			);
			Pan2.ar (src, pos, vol)
		}
	}
}

/*
'song1'.bufnum +>.buf \hasansong;
0.2 +>.vol \hasansong;
SF.playbuf ++> \hasansong;


SF.amp ++> \pv;
*/