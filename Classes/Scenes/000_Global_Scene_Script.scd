//:  Midi tests: 

MIDIIn.connectAll;
MIDIFunc trace: true;


//: ACTUAL PLAY
Scenes.start; // also starts recording

Scenes.end;   // ends recording

//:

Scenes.init;

Server.default.boot;

Reza.start;

HasanSong