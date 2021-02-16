package org.reports;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class JVMReport {

	public static void generateJvmReport(String json) {

		// 1.Mention the target folder
		File f = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\Reports");

		// 2.Add details to the report
		Configuration con = new Configuration(f, "Facebook Application");
		con.addClassifications("Platform name", "Windows");
		con.addClassifications("Platform Version", "10");
		con.addClassifications("Browser name", "Chrome");
		con.addClassifications("Browser version", "87.0");
		con.addClassifications("Sprint no", "21");

		// 3.Create a list to store json filepaths
		List<String> li = new ArrayList<String>();
		li.add(json);

		//4.To generate report
		ReportBuilder r = new ReportBuilder(li, con);
		r.generateReports();

	}

}
