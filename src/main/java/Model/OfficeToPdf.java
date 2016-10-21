package Model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OfficeToPdf {
	public String sourceFilePath;
	public String sourceFileName;
	
	public OfficeToPdf(String sourceFilePath, String sourceFileName) throws IOException, InterruptedException {
		this.setPath(sourceFilePath);
		this.setName(sourceFileName);
	}
	
	public String getPath() {
		return sourceFilePath;
	}

	public void setPath(String sourceFilePath) {
		this.sourceFilePath = sourceFilePath;
	}
	
	public String getName() {
		return sourceFileName;
	}

	public void setName(String sourceFileName) {
		this.sourceFileName = sourceFileName;
	}

    public int Permission() throws IOException, InterruptedException {
        List<String> cmd = new ArrayList<>();
        cmd.add("sh");
        cmd.add("-c");
        cmd.add("cd "+this.getPath()+"; echo arch53212765 | sudo -S chmod 777 "+"'"+this.getName()+"'"+";");
        ProcessBuilder process =new ProcessBuilder(cmd);
        int result = process.start().waitFor();
        return result;
    }
	
	public int ToPdf() throws IOException, InterruptedException{
        List<String> cmd = new ArrayList<>();
        cmd.add("sh");
        cmd.add("-c");
        cmd.add("cd "+this.getPath()+"; echo arch53212765 | sudo -S libreoffice --convert-to pdf "+"'"+this.getName()+"'");
        ProcessBuilder process =new ProcessBuilder(cmd);
        int result = process.start().waitFor();
        return result;
	}

	public static void main(String[] args) throws IOException, InterruptedException {
        // TODO Auto-generated method stub

        String uuid = "/var/lib/tomcat8/webapps/Doc_online/Files/dd1e3c4e-b4b4-420a-b292-cd06f67a0863/";
        String fileName = "fileOnline_db.sql";
		OfficeToPdf file = new OfficeToPdf(uuid,fileName);
        file.Permission();
        file.ToPdf();
	}

}
