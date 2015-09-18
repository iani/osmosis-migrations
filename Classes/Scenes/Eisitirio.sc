Eisitirio {
	*intro {
		//: PlayBuf: Use envelope to stop. Startpos, dur, rate
		"--- Scene 1 - INTRO".postln;
		this.introMIDI;
		"eisagogi".arlink;
		'eisitirio'.bufnum +>.buf 'eisagogi';
		0 +>.from 'eisagogi';
		1 +>.rate 'eisagogi';
		'eisitirio'.buf.duration * 1 +>.dur 'eisagogi';
		SF.playbufpan ++> 'eisagogi';
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
		"(eisagogi.harmonies)".arlink;
		'eisitirio'.bufnum +>.buf 'eisagogi';
		1 +>.rate 'eisagogi';
		SF.resonzpan ++> 'harmonies';
		SF.playbufpan ++> 'eisagogi';
	}
}