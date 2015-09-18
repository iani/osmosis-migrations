

Eisitirio {
	*intro {
		//: PlayBuf: Use envelope to stop. Startpos, dur, rate
		"--- Scene 1 - INTRO".postln;
		this.introMIDI;
		'eisitirio'.bufnum +>.buf 'eisagogi';
		0 +>.from 'eisagogi';
		1 +>.rate 'eisagogi';
		'eisitirio'.buf.duration * 1 +>.dur 'eisagogi';
		{ | buf = 0 from = 0 dur = 1 rate = 1 trigger = 1 |
			PlayBuf.ar (1, buf,
				rate * BufRateScale.kr (buf),
				trigger,
				from * BufSampleRate.kr (buf),
				1, 0
			)
			* EnvGen.kr (Env ([0, 1, 1, 0], [0.01, dur - 0.02 max: 0.03, 0.01]),
				trigger, doneAction: 2
			);
		} ++> 'eisagogi';
	}

	*introMIDI {
		var rate = 1;
		ButtonOn (2, {
			rate = 'eisagogi'.get (\rate).postln;
			0 +>.rate 'eisagogi';
		});
		ButtonOff (2, {
			rate +>.rate 'eisagogi';
		});
		Dial (2, { | ... vals |
			vals.postln;
		})
	}

	*harmonies {
		
	}
}

Reza {
	*start {
		"--- Starting Reza".postln;
		'reza1'.bufnum +>.buf \reza;
		0.8 +>.vol \reza;
		SF.playbufpan ++> \reza;
	}
}

RezaSong {
	*plain {
		"--- Starting Reza2 Song: PLAIN".postln;
		'song1'.bufnum +>.buf \rezasong;
		0.2 +>.vol \rezasong;
		SF.playbuf ++> \rezasong;
	}

	*pv {
		"--- Starting Reza2 Song: PV".postln;
		"(rezasong.pv)".arlink;

		SF.magabovepan ++> \pv;
		
		'song1'.bufnum +>.buf \rezasong;
		0.2 +>.vol \rezasong;
		SF.playbuf ++> \rezasong;

		JLslider(2, 1, { | val |
			var scaled;
			scaled = val / 127;
			scaled * 100 +>.thresh 'pv';
			scaled + 0.5 +>.vol 'pv';
		});

		JLbutton (4, 3, {
			
		});

	}
	
}

HasanSong {
	*plain {
		"--- Starting Hasan Song: PLAIN".postln;
		'song4_hasan'.bufnum +>.buf \hasansong;
		0.2 +>.vol \hasansong;
		SF.playbuf ++> \hasansong;
	}

	*pv {
		"--- Starting Hasan Song: PV".postln;
		"(hasansong.pv)".arlink;

		SF.magabovepan ++> \pv;
		
		'song4_hasan'.bufnum +>.buf \hasansong;
		0.2 +>.vol \hasansong;
		SF.playbuf ++> \hasansong;

		JLslider(2, 1, { | val |
			var scaled;
			scaled = val / 127;
			scaled * 100 +>.thresh 'pv';
			scaled + 0.5 +>.vol 'pv';
		});

		JLbutton (4, 3, {
			
		});

	}
	
}
Lefteris {
	*start {
		"--- Starting Levteris".postln;
		'levteris_speaks'.bufnum +>.buf \levteris;
		0.8 +>.vol \levteris;
		SF.playbufpan ++> \levteris;
	}
}

Hasan {
	*start {
		"--- Starting Hasan".postln;
		'song4_hasan'.bufnum +>.buf \hasan;
		0.8 +>.vol \hasan;
		SF.playbufpan ++> \hasan;
	}
	*pv {
		"--- Starting Hasan: PV".postln;
		"(hasansong.pv)".arlink;

		SF.magabovepan ++> \pv;
		
		'song4_hasan'.bufnum +>.buf \hasan;
		0.2 +>.vol \hasan;
		SF.playbuf ++> \hasan;

		JLslider(2, 1, { | val |
			var scaled;
			scaled = val / 127;
			scaled * 100 +>.thresh 'pv';
			scaled + 0.5 +>.vol 'pv';
		});

		JLbutton (4, 3, {
			
		});

	}
}

Aerodromio {
	*start {
		"--- Starting Aerodromio".postln;
		'istories'.bufnum +>.buf \aerodromio;
		0.8 +>.vol \aerodromio;
		SF.playbufpan ++> \aerodromio;
	}
}

/*
	Lefteris.start;
C	Reza.start;
	Hasan.start;
	10 +>.thresh 'pv';

HasanSong.plain;
HasanSong.pv;

Eisitirio.intro;
*/