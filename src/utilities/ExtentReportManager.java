package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;


public class ExtentReportManager {
public static ExtentReports report;
	
	public static ExtentReports getReportInstance() {
		
		if(report==null) {
			String reportName=DateUtil.getTimeStamp() +".html";
			
			ExtentHtmlReporter htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir") + "\\test-output\\" + reportName);
			
			report=new ExtentReports();
			report.attachReporter(htmlReporter);
			
			report.setSystemInfo("Default_OS", "Windows10");
			report.setSystemInfo("Default_Browser", "Chrome");
			report.setSystemInfo("By", "Manish");
			
			htmlReporter.config().setDocumentTitle("POM TestCases");
			htmlReporter.config().setReportName("POM test cases");
			htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
			htmlReporter.config().setTimeStampFormat("MM dd yyyy, hh::mm::ss");
		}
		return report;
	}
}
