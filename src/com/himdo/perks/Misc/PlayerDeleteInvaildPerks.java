package com.himdo.perks.Misc;

import java.util.ArrayList;

import com.himdo.perks.hashMaps.MainDataBaseHashMap;

public class PlayerDeleteInvaildPerks {
	public static ArrayList Trim(ArrayList array){
		//int size = ;
		for(int x = 0; x<array.size();x++){
			if(MainDataBaseHashMap.items.get(array.get(x))==null){
				array.remove(array.get(x));
				//x--;
			}
		}
		return array;
	}
}
