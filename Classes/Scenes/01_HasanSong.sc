HasanSong {
	*plain {
		"--- Starting Hasan Song: PLAIN".postln;
		"hasansong".arlink;
		'song4_hasan'.bufnum +>.buf \hasansong;
		0.2 +>.vol \hasansong;
		SF.playbuf ++> \hasansong;
	}

	*bridge {
		"--- Starting Hasan Song: PV".postln;
		"(hasansong.pinkamp)".arlink;

		//	SF.magbelowpan ++> \pv;
		SF.magsmearpan ++> \pv;
		1 +>.wet \pinkamp;
		SF.pinkamppan ++> \pinkamp;
		
		'song4_hasan'.bufnum +>.buf \hasansong;
		0.2 +>.vol \hasansong;
		SF.playbuf ++> \hasansong;

		JLslider(1, 1, { | val |
			var scaled;
			scaled = val / 127;
			1 - scaled +>.wet 'pinkamp';
			// scaled + 0.5 +>.vol 'pv';
		});

		JLbutton (4, 3, {
			
		});

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

/*

HasanSong.pv;
HasanSong.bridge;

2 +>.thresh \pv;

0.5 +>.rate \hasansong;

1 +>.wet \pinkamp;


*/