
S0 {
	*init {
		Server.local.boot;
		BufferList.loadFolder;
		MIDIIn.connectAll;
		this.initMIDI;
	}

	*initMIDI {
		KnobOn (1, { Eisitirio.intro; });  // knob col 1 row 1
		// KnobOff (1, { "just testing knob off".postln; });
		KnobOn (5, { Reza.start });       // col 2 row 1
		KnobOn (9, { HasanSong.plain });  // col 3 row 1
		KnobOn (10, { HasanSong.pv });    // col 3 row 2
		KnobOn (13, { Lefteris.start });  // col 4 row 1
	}
}

/*
S0.init;
*/
Eisitirio {
	*intro {
		//: PlayBuf: Use envelope to stop. Startpos, dur, rate
		this.introMIDI;
		"--- Scene 1 - INTRO".postln;
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
}

Reza {
	*start {
		"--- Starting Reza".postln;
		'reza1'.bufnum +>.buf \reza;
		0.8 +>.vol \reza;
		SF.playbufpan ++> \reza;
	}
}

HasanSong {
	*plain {
		"--- Starting Hasan Song: PLAIN".postln;
		'song1'.bufnum +>.buf \hasansong;
		0.2 +>.vol \hasansong;
		SF.playbuf ++> \hasansong;
	}

	*pv {
		"--- Starting Hasan Song: PV".postln;
		"(hasansong.pv)".arlink;

		SF.magabovepan ++> \pv;
		
		'song1'.bufnum +>.buf \hasansong;
		0.2 +>.vol \hasansong;
		SF.playbuf ++> \hasansong;	
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
		"--- Starting Reza".postln;
		'song4_hasan'.bufnum +>.buf \hasan;
		0.8 +>.vol \hasan;
		SF.playbufpan ++> \hasan;
	}
}

/*
Lefteris.start;
Reza.start;
Hasan.start;
10 +>.thresh 'pv';
*/