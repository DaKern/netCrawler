package util.cli;

import java.io.InputStream;
import java.io.OutputStream;


public interface CommandLineInterface {
	
	public InputStream getInputStream();
	public OutputStream getOutputStream();
	
	public void close();
	
}