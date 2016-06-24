package service.manager;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import util.CSVFileReader;

/**
 * Servlet implementation class UploadCSV
 */
@WebServlet("/UploadCSV")
@MultipartConfig
public class UploadCSV extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String UPLOAD_LOCATION = "D:\\test\\upload\\";
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadCSV() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processExecute(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processExecute(request, response);
	}

	private void processExecute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Part filePart = request.getPart("file");
		String fileName = filePart.getSubmittedFileName();
		
		File uploads = new File(UPLOAD_LOCATION);
		File file = new File(uploads, fileName);

		try (InputStream input = filePart.getInputStream()) {
		    Files.copy(input, file.toPath());
		}
		
		//A TESTER LA PARTIE QUI SUIT: 
		CSVFileReader.readCsvFile(file.getAbsolutePath());
	}

}
