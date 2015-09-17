
KnobOn {
	*new { | knobNum = 1 func |
		MIDIFunc.noteOn (func, knobNum, 0);
	}
}

KnobOff {
	*new { | knobNum = 1 func |
		MIDIFunc.noteOff (func, knobNum, 0);
	}
}

ButtonOn {
	*new { | knobNum = 1 func |
		KnobOn (knobNum + 32, func)
	}
}

ButtonOff {
	*new { | knobNum = 1 func |
		KnobOff (knobNum + 32, func)
	}
}

Dial {
	*new { | knobNum = 1 func |
		MIDIFunc.cc (func, knobNum, 0);
	}
}
