

Aerodromio {
	*start {
		"--- Starting Aerodromio".postln;
		'istories'.bufnum +>.buf \aerodromio;
		0.8 +>.vol \aerodromio;
		SF.playbufpan ++> \aerodromio;
	}
}