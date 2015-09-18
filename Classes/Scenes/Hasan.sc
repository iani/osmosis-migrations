

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