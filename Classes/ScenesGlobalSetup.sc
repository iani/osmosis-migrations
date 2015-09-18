Scenes {
	*init {
		Server.local.boot;
		BufferList.loadFolder;
		MIDIIn.connectAll;
		MIDIFunc trace: true;
		this.connectJLC;
		this.connectLivid;
	}
	
	*connectJLC {
		JLbutton (1, 1, { HasanSong.plain });
		JLbutton (2, 1, { Eisitirio.intro });
		JLbutton (2, 2, { Eisitirio.harmonies });
		JLbutton (3, 1, { Reza.start });
		JLbutton(4, 1, { RezaSong.plain });
		JLbutton(4, 2, { RezaSong.pv });
		JLbutton (5, 1, { Levteris.start });
		JLbutton (6, 1, { HasanSong.pv });
		JLbutton (7, 1, { Aerodromio.start });
	}

	*connectLivid {
		KnobOn (1, { Eisitirio.intro; });  // knob col 1 row 1
		// KnobOff (1, { "just testing knob off".postln; });
		KnobOn (5, { Reza.start });       // col 2 row 1
		KnobOn (9, { HasanSong.plain });  // col 3 row 1
		KnobOn (10, { HasanSong.pv });    // col 3 row 2
		KnobOn (13, { Lefteris.start });  // col 4 row 1
	}
}
