RezaSong {
	*plain {
		"--- Starting Hasan Song: PLAIN".postln;
		"rezasong".arlink;
		'song1'.bufnum +>.buf \rezasong;
		0.2 +>.vol \rezasong;
		SF.playbuf ++> \rezasong;
	}

	*pv {
		"--- Starting Hasan Song: PV".postln;
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
