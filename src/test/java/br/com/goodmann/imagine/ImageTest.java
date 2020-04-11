package br.com.goodmann.imagine;

import java.io.File;
import java.net.FileNameMap;
import java.net.URLConnection;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ImageTest {

	private static final Logger logger = LoggerFactory.getLogger(ImageTest.class);

	@Test
	public void imageTest() {

		String sFile = "/home/osboxes/Downloads/23461233.jpg";

		File file = new File(sFile);
		FileNameMap fileNameMap = URLConnection.getFileNameMap();
		String mimeType = fileNameMap.getContentTypeFor(file.getName());

		logger.trace("Validar se arquivo é imagem: " + file.getName());
		logger.trace("Tipo de arquivo: " + mimeType);

		assert (mimeType.contains("image"));
	}

}
