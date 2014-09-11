package utils;

import java.util.UUID;


public class IDGenerator {

	public static String generate() {
		UUID uuid = UUID.randomUUID();
		String randomUUIDString = uuid.toString();
		return randomUUIDString;
	}
}
