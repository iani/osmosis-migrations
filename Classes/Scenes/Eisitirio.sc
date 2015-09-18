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
		var volspec, freqspec, qspec, ratespec;
		volspec = \amp.asSpec;
		freqspec = \freq.asSpec;
		qspec = ControlSpec (0.1, 1.1, 0.0005, 1, \exp);
		ratespec = ControlSpec (0, 1, 0.2, 5);
		JLslider (2, 1, { | val |    //////////////// AMP
			val = volspec.map (val / 127);
			val * 3 +>.vol \harmonies;
		});
		JLslider (2, 2, { | val | //////////////// FREQ
			val = freqspec.map (val / 127);
			val +>.freq \harmonies;
		});
		/*
		JLslider (2, 3, { | val | //////////////// Q
			val = qspec.map (val / 127 + 0.1);
			val +>.q \harmonies;
		});
		*/
		/*
		JLslider (2, 4, { | val | //////////////// RATE
			val = ratespec.map (val / 127);
			val +>.rate \eisagogi;
		});
		*/
		"(eisagogi.harmonies)".arlink;
		'eisitirio'.bufnum +>.buf 'eisagogi';
		1 +>.rate 'eisagogi';
		SF.resonzpan ++> 'harmonies';
		SF.playbufpan ++> 'eisagogi';
	}
}

/*

\freq.asSpec.map(0);

0.3 +>.rate \eisagogi;
1 +>.rate \eisagogi;

0.1 +>.q \harmonies;
*/