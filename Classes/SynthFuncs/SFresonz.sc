+ SF {
	*resonzpan {
		^{ | q = 0.001, freq = 400, pos = 0, vol = 1 |
			var src;
			q = Lag.kr (q, 0.2);
			src = Resonz.ar (Inp.ar, freq * [1, 1.2, 1.25, 1.5, 1.6, 12], q);
			Pan2.ar (Mix (src), pos, vol * (q.reciprocal / 50));
		}
	}
}

/*
'song1'.bufnum +>.buf \hasansong;
0.2 +>.vol \hasansong;
SF.playbuf ++> \hasansong;


SF.amp ++> \pv;
*/