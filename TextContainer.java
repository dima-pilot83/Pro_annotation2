package ru.mail.dimapilot;

import java.io.FileWriter;
import java.io.IOException;

@SaveTo(path = "file.txt")

public class TextContainer {

	String text = "My name is Dima";

	@Save
	public void save(String folderAdress, String data) throws IOException {
		try (FileWriter writer = new FileWriter(folderAdress)) {
			writer.write(data);
		}

	}

}
