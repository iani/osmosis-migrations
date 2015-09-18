

Levteris {
	*start {
		"--- Starting Levteris".postln;
		'levteris_speaks'.bufnum +>.buf \levteris;
		0.8 +>.vol \levteris;
		SF.playbufpan ++> \levteris;
	}
}