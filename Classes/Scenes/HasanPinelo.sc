HasanPinelo {
	*start {
		"--- Starting hasan pinelo".postln;
		"hasanpinelo".arlink;
		'pinelo'.bufnum +>.buf \hasanpinelo;
		0.8 +>.vol \hasanpinelo;
		SF.playbufpan ++> \hasanpinelo;
	}
}