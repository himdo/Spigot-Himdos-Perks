package com.himdo.perks.Misc;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class DiceRoller {
	public static int Roll(int MaxNumber){
		return ThreadLocalRandom.current().nextInt(1, MaxNumber+1);
	}
}
