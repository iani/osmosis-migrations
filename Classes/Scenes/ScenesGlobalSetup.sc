Scenes {
	*init {
		Server.local.boot;
		BufferList.loadFolder;
		MIDIIn.connectAll;
		// MIDIFunc trace: true;
		this.connectJLC;
		this.connectLivid;
	}
	
	*connectJLC {
		JLbutton (1, 1, { HasanSong.plain }, { \hasansong release: 3 });
		JLbutton (1, 2, { HasanSong.ypochthonio }, { \hasansong release: 3 });
		JLbutton (1, 3, { HasanSong.dalwlk }, { \dalwlk release: 3 });
		JLbutton (2, 1, { Eisitirio.intro }, { \eisagogi release: 3 });
		JLbutton (2, 2, { Eisitirio.harmonies }, { \eisagogi release: 3 });
		JLbutton (3, 1, { Reza.start }, { \reza release: 3 });
		JLbutton(4, 1, { RezaSong.plain }, { \rezasong release: 3 } );
		JLbutton(4, 2, { RezaSong.pv }, { \rezasong release: 3 });
		JLbutton (5, 1, { Levteris.start }, { \levteris release: 3 });
		JLbutton (6, 1, { HasanSong.pv }, { \hasansong release: 3});
		JLbutton (7, 1, { Aerodromio.start }, { \aerodromio release: 10 });
	}

	*connectLivid {
		KnobOn (1, { Eisitirio.intro; });  // knob col 1 row 1
		// KnobOff (1, { "just testing knob off".postln; });
		KnobOn (5, { Reza.start });       // col 2 row 1
		KnobOn (9, { HasanSong.plain });  // col 3 row 1
		KnobOn (10, { HasanSong.pv });    // col 3 row 2
		KnobOn (13, { Levteris.start });  // col 4 row 1
	}
}
