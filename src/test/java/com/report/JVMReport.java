package com.report;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class JVMReport {
	public static void generateReport(String jsonFile) {
		Configuration configuration = new Configuration(new File(
				"C:\\Users\\admin\\eclipse-workspace_UptoMaven\\CucumberDay7\\src\\test\\resources\\Report"),
				"CucumberDay7");

		configuration.addClassifications("Browser", "Chrome");
		configuration.addClassifications("Browser version", "88");
		configuration.addClassifications("sprint", "35");
		configuration.addClassifications("os", "Windows");

		List<String> jsonFiles = new ArrayList<String>();

		jsonFiles.add(jsonFile);

		ReportBuilder builder = new ReportBuilder(jsonFiles, configuration);
		builder.generateReports();

	}

}
