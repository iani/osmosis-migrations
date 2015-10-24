
{ SinOsc.ar ([400, 500], 0, SinOsc.kr (0.1, [0, pi / 2], 0.1)) } ++> 'soundCheck';

//:

{ SinOsc.ar ([400, 500], 0, SinOsc.kr ([0.4, 0.05], [0, pi / 2], 0.1)) } ++> 'soundCheck';

//:

{ PinkNoise.ar (SinOsc.kr ([2 0.05], [0, pi / 2], 0.1)) } ++> 'soundCheck';

//: Sound Check Technopolis


{ WhiteNoise.ar (Decay.kr (Impulse.kr (1, [0, pi * 2]))) * 0.1 } ++> \pantest;

//:

{ | pos = 0, amp = 0.1 |
	Pan2.ar (WhiteNoise.ar (Decay.kr (Impulse.kr (1))), pos, amp)
}  ++> \pantest;

//:

{ | pos = 0, amp = 0.1 |
	Pan2.ar (WhiteNoise.ar (Decay.kr (Impulse.kr (1))),
		LFSaw.kr (0.5),
		amp
	)
}  ++> \pantest;

//:

{ | pos = 0, amp = 0.1 |
	Pan2.ar (WhiteNoise.ar (),
		LFSaw.kr (0.5),
		amp
	)
}  ++> \pantest;

//:

-1 +>.pos \pantest;
//:
1 +>.pos \pantest;
//:

{ Inp.ar }.scope;

// LevelIndicator.meterServer (Server.default);

//:
Server.default.meter;

//:
\soundCheck.release;