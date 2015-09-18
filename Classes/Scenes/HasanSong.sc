HasanSong {
	*plain {
		"--- Starting Hasan Song: PLAIN".postln;
		"hasansong".arlink;
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