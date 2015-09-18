SF {
	*playbuf {
		^{ | buf = 0, rate = 1, trigger = 0, startPos = 0, loop = 0,
			doneAction = 0 |
			var src;
			src = PlayBuf.ar(1, buf, rate * BufRateScale.kr(buf),
				trigger, startPos * BufSampleRate.kr (buf),
				loop, doneAction
			);
			src;
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

	////////////////////////////////////////////////////////////////
	// PV
	////////////////////////////////////////////////////////////////

 /*
'song1'.bufnum +>.buf \hasansong;
0.2 +>.vol \hasansong;
SF.playbuf ++> \hasansong;

SF.pinkamppan ++> \pv;
SF.pitchpan ++> \pv;
SF.magbelowpan ++> \pv;

5 +>.thresh \pv;

"(hasansong.pv)".arlink;

1 +>.wet 'pv';

	*/
	
	*magbelow {
		^{ | thresh = 0 vol = 1 |
			var in, chain;
			in = Inp.ar;
			chain = FFT(LocalBuf(2048), in);
			chain = PV_MagBelow(chain, thresh);
			IFFT(chain) * vol;
		}
	}

	*magbelowpan {
		^{ | thresh = 0 pos = 0 vol = 1 |
			var in, chain;
			in = Inp.ar;
			chain = FFT(LocalBuf(2048), in);
			chain = PV_MagBelow(chain, thresh);
			Pan2.ar (IFFT(chain), pos, vol);
		}
	}

	*magabovepan {
		^{ | thresh = 0 pos = 0 vol = 1 |
			var in, chain;
			in = Inp.ar;
			chain = FFT(LocalBuf(2048), in);
			chain = PV_MagAbove(chain, thresh);
			Pan2.ar (IFFT(chain), pos, vol);
		}
	}

	*magsmearpan {
		^{ | thresh = 0 pos = 0 vol = 1 |
			var in, chain;
			in = Inp.ar;
			chain = FFT(LocalBuf(2048), in);
			chain = PV_MagSmear(chain, thresh);
			Pan2.ar (IFFT(chain), pos, vol);
		} 
	}

	////////////////////////////////////////////////////////////////
	// Features
	////////////////////////////////////////////////////////////////

	*pinkamp {
		^{ | wet = 0 |
			var in, amp, src;
			in = Inp.ar;
			amp = Amplitude.kr (in);
			1 - wet * in + (wet * PinkNoise.ar (amp));
		}
	}

	*pinkamppan {
		^{ | wet = 0 pos = 0 vol = 1 |
			var in, amp, src;
			in = Inp.ar;
			amp = Amplitude.kr (in);
			src = 1 - wet * in + (wet * PinkNoise.ar (amp));
			Pan2.ar (src, pos, vol);
		}
	}

	*pitch {
		^{ | wet = 0 |
			var in, freq, hasfreq, resynth;
			in = Inp.ar;
			#freq, hasfreq = Pitch.kr (in);
			resynth = SinOsc.ar (freq, 0, hasfreq);
			1 - wet * in + (wet * resynth);
		}
	}

	*pitchpan {
		^{ | wet = 0 pos = 0 vol = 1 |
			var in, freq, hasfreq, resynth, src;
			in = Inp.ar;
			#freq, hasfreq = Pitch.kr (in);
			resynth = SinOsc.ar (freq, 0, hasfreq);
			src = 1 - wet * in + (wet * resynth);
			Pan2.ar (src, pos, vol);
		}
	}
}

/*
'song1'.bufnum +>.buf \hasansong;
0.2 +>.vol \hasansong;
SF.playbuf ++> \hasansong;


SF.amp ++> \pv;
*/