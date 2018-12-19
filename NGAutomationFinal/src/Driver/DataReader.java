package Driver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.log4j.xml.DOMConfigurator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataReader {
	
	@DataProvider(name="EtherNetP2PNewOrder")
	public static Object[][] datareader() throws IOException
	{
		
		 FileInputStream file = new FileInputStream(new File("src\\Data\\EtherNetP2PNewOrder.xlsx"));
		 XSSFWorkbook workbook = new XSSFWorkbook(file);
		 XSSFSheet sheet = workbook.getSheetAt(0);
		 XSSFRow r1=sheet.getRow(0);
		 XSSFRow r;
		 int rowindex=0;
		 int totalrowrequired=0;
		 for(int k=2;k<=sheet.getLastRowNum();k++){
		 XSSFRow counter=sheet.getRow(k);
		 if(counter.getCell(1).toString().equals("Yes"))
		 {
			 totalrowrequired=totalrowrequired+1;
			
		 }
		 
		 }
		 Log.info("Total Data Set for Ethernet P2P will be"+totalrowrequired);
		 Object[][] listOfLists = new Object[totalrowrequired][1];
		//Object[][] data= new Object[sheet.getLastRowNum()][r.getLastCellNum()];  
		 //Log.info("Total number of Columns" +r.getLastCellNum());
		 //Log.info("Total number of Columns" +sheet.getLastRowNum());
		 for(int i=2;i<=sheet.getLastRowNum();i++)
		 { 
			 r=sheet.getRow(i);
			 Object[]  data=new Object[r1.getLastCellNum()];
			 //Log.info(r.getLastCellNum());
		if(r.getCell(1).toString().equals("Yes")){
		   for(int j=3;j<=r1.getLastCellNum()-1;j++)
			 {
			   String strCellValue;
			   try {
				   if(r.getCell(j).getCellType()==Cell.CELL_TYPE_NUMERIC)
				   {
					   int value=(int)r.getCell(j).getNumericCellValue();
					   strCellValue=String.valueOf(value);
					   Log.info("The Value is in Int Format and Value is:"+strCellValue);
					   
				   }
				   
				   else {
					   strCellValue=r.getCell(j).toString();
					   Log.info("The Value of this cell is in String Format and Value is : "+strCellValue);
				   }
				   }
				   catch(java.lang.NullPointerException e)
				   {
					   strCellValue="";
					   Log.info("The Value of this cell is: "+strCellValue);
				   }
			   data[j-3] = strCellValue;
			  
			    //data[i-1][j] = ;
			 
			 }
		   data[r1.getLastCellNum()-2]=r.getCell(0).toString();
		   data[r1.getLastCellNum()-1]=r.getCell(1).toString();
		   Log.info("The Value of this cell is: "+data[r1.getLastCellNum()-2]);
		   Log.info("The Value of this cell is: "+data[r1.getLastCellNum()-1]);
		   listOfLists[rowindex][0]=data;
		   rowindex=rowindex+1;
		 }
		 //Log.info(data.toString());
		 workbook.close();
		 }
		 return listOfLists;
		 
	}
	
	@DataProvider(name="HubAndSpokeNewOrder")
	public static Object[][] hubreader() throws IOException
	{
		
		 FileInputStream file = new FileInputStream(new File("src\\Data\\HubAndSpokeNewOrder.xlsx"));
		 XSSFWorkbook workbook = new XSSFWorkbook(file);
		 XSSFSheet sheet = workbook.getSheetAt(0);
		 XSSFRow r1=sheet.getRow(0);
		 XSSFRow r;
		 int rowindex=0;
		 int totalrowrequired=0;
		 for(int k=2;k<=sheet.getLastRowNum();k++){
		 XSSFRow counter=sheet.getRow(k);
		 if(counter.getCell(1).toString().equals("Yes"))
		 {
			 totalrowrequired=totalrowrequired+1;
			
		 }
		 
		 }
		 Log.info("Total Data Set for Ethernet H&S will be"+totalrowrequired);
		 Object[][] listOfLists = new Object[totalrowrequired][1];
		//Object[][] data= new Object[sheet.getLastRowNum()][r.getLastCellNum()];  
		 //Log.info("Total number of Columns" +r.getLastCellNum());
		 //Log.info("Total number of Columns" +sheet.getLastRowNum());
		 for(int i=2;i<=sheet.getLastRowNum();i++)
		 { 
			 r=sheet.getRow(i);
			 Object[]  data=new Object[r1.getLastCellNum()];
			 //Log.info(r.getLastCellNum());
		if(r.getCell(1).toString().equals("Yes")){
		   for(int j=3;j<=r1.getLastCellNum()-1;j++)
			 {
			   String strCellValue;
			   try {
				   if(r.getCell(j).getCellType()==Cell.CELL_TYPE_NUMERIC)
				   {
					   int value=(int)r.getCell(j).getNumericCellValue();
					   strCellValue=String.valueOf(value);
					   Log.info("The Value is in Int Format and Value is:"+strCellValue);
					   
				   }
				   
				   else {
					   strCellValue=r.getCell(j).toString();
					   Log.info("The Value of this cell is in String Format and Value is : "+strCellValue);
				   }
				   }
				   catch(java.lang.NullPointerException e)
				   {
					   strCellValue="";
					   Log.info("The Value of this cell is: "+strCellValue);
				   }
			   data[j-3] = strCellValue;
			  
			    //data[i-1][j] = ;
			 
			 }
		   data[r1.getLastCellNum()-2]=r.getCell(0).toString();
		   data[r1.getLastCellNum()-1]=r.getCell(1).toString();
		   //Log.info("The Value of this cell is: "+data[r1.getLastCellNum()-2]);
		  // Log.info("The Value of this cell is: "+data[r1.getLastCellNum()-1]);
		   listOfLists[rowindex][0]=data;
		   rowindex=rowindex+1;
		 }
		 //Log.info(data.toString());
		 workbook.close();
		 }
		 return listOfLists;
		 
	}

	@DataProvider(name="ModifyOrder")
	public static Object[][] modreader() throws IOException
	{
		
		 FileInputStream file = new FileInputStream(new File("src\\Data\\ModifyOrder.xlsx"));
		 XSSFWorkbook workbook = new XSSFWorkbook(file);
		 XSSFSheet sheet = workbook.getSheetAt(0);
		 XSSFRow r1=sheet.getRow(0);
		 XSSFRow r;
		 int rowindex=0;
		 int totalrowrequired=0;
		 for(int k=2;k<=sheet.getLastRowNum();k++){
		 XSSFRow counter=sheet.getRow(k);
		 if(counter.getCell(1).toString().equals("Yes"))
		 {
			 totalrowrequired=totalrowrequired+1;
			
		 }
		 
		 }
		 Log.info("Total Data Set for Ethernet Modify will be"+totalrowrequired);
		 Object[][] listOfLists = new Object[totalrowrequired][1];
		//Object[][] data= new Object[sheet.getLastRowNum()][r.getLastCellNum()];  
		 //Log.info("Total number of Columns" +r.getLastCellNum());
		 //Log.info("Total number of Columns" +sheet.getLastRowNum());
		 for(int i=2;i<=sheet.getLastRowNum();i++)
		 { 
			 r=sheet.getRow(i);
			 Object[]  data=new Object[r1.getLastCellNum()];
			 //Log.info(r.getLastCellNum());
		if(r.getCell(1).toString().equals("Yes")){
		   for(int j=2;j<=r1.getLastCellNum()-1;j++)
			 {
			   String strCellValue;
			   try {
				   if(r.getCell(j).getCellType()==Cell.CELL_TYPE_NUMERIC)
				   {
					   int value=(int)r.getCell(j).getNumericCellValue();
					   strCellValue=String.valueOf(value);
					   Log.info("The Value is in Int Format and Value is:"+strCellValue);
					   
				   }
				   
				   else {
					   strCellValue=r.getCell(j).toString();
					   Log.info("The Value of this cell is in String Format and Value is : "+strCellValue);
				   }
				   }
				   catch(java.lang.NullPointerException e)
				   {
					   strCellValue="";
					   Log.info("The Value of this cell is: "+strCellValue);
				   }
			   data[j-2] = strCellValue;
			  
			    //data[i-1][j] = ;
			 
			 }
		   data[r1.getLastCellNum()-2]=r.getCell(0).toString();
		   data[r1.getLastCellNum()-1]=r.getCell(1).toString();
		   //Log.info("The Value of this cell is: "+data[r1.getLastCellNum()-2]);
		  // Log.info("The Value of this cell is: "+data[r1.getLastCellNum()-1]);
		   listOfLists[rowindex][0]=data;
		   rowindex=rowindex+1;
		 }
		 //Log.info(data.toString());
		 workbook.close();
		 }
		 return listOfLists;
		 
	}	

	@DataProvider(name="InflightModifyOrder")
	public static Object[][] inmodreader() throws IOException
	{
		
		 FileInputStream file = new FileInputStream(new File("src\\Data\\ModifyOrder.xlsx"));
		 XSSFWorkbook workbook = new XSSFWorkbook(file);
		 XSSFSheet sheet = workbook.getSheetAt(0);
		 XSSFRow r1=sheet.getRow(0);
		 XSSFRow r;
		 int rowindex=0;
		 Object[][] listOfLists = null;
		 int totalrowrequired=0;
		 for(int k=2;k<=sheet.getLastRowNum();k++){
		 XSSFRow counter=sheet.getRow(k);
		 
		 if(counter.getCell(1).toString().equals("Yes")&& counter.getCell(3).toString().equals("In flight Soft Mod"))
		 {
			 totalrowrequired=totalrowrequired+1;
			
		 }
		 
		 }
		 Log.info("Total Data Set for Ethernet Inflight Modify will be"+totalrowrequired);
		 listOfLists = new Object[totalrowrequired][1];
		//Object[][] data= new Object[sheet.getLastRowNum()][r.getLastCellNum()];  
		 //Log.info("Total number of Columns" +r.getLastCellNum());
		 //Log.info("Total number of Columns" +sheet.getLastRowNum());
		 for(int i=2;i<=sheet.getLastRowNum();i++)
		 { 
			 r=sheet.getRow(i);
			 Object[]  data=new Object[r1.getLastCellNum()];
			 //Log.info(r.getLastCellNum());
		if(r.getCell(1).toString().equals("Yes")&& r.getCell(3).toString().equals("In flight Soft Mod")){
		   for(int j=2;j<=r1.getLastCellNum()-1;j++)
			 {
			   String strCellValue;
			   try {
				   if(r.getCell(j).getCellType()==Cell.CELL_TYPE_NUMERIC)
				   {
					   int value=(int)r.getCell(j).getNumericCellValue();
					   strCellValue=String.valueOf(value);
					   Log.info("The Value is in Int Format and Value is:"+strCellValue);
					   
				   }
				   
				   else {
					   strCellValue=r.getCell(j).toString();
					   Log.info("The Value of this cell is in String Format and Value is : "+strCellValue);
				   }
				   }
				   catch(java.lang.NullPointerException e)
				   {
					   strCellValue="";
					   Log.info("The Value of this cell is: "+strCellValue);
				   }
			   data[j-2] = strCellValue;
			  
			    //data[i-1][j] = ;
			 
			 }
		   data[r1.getLastCellNum()-2]=r.getCell(0).toString();
		   data[r1.getLastCellNum()-1]=r.getCell(1).toString();
		   //Log.info("The Value of this cell is: "+data[r1.getLastCellNum()-2]);
		  // Log.info("The Value of this cell is: "+data[r1.getLastCellNum()-1]);
		   listOfLists[rowindex][0]=data;
		   rowindex=rowindex+1;
		 }
		 //Log.info(data.toString());
		 workbook.close();
		 }
		 
		 return listOfLists;
	}	

	@DataProvider(name="CarNor")
	public static Object[][] carnorreader() throws IOException
	{
		
		 FileInputStream file = new FileInputStream(new File("src\\Data\\ModifyOrder.xlsx"));
		 XSSFWorkbook workbook = new XSSFWorkbook(file);
		 XSSFSheet sheet = workbook.getSheetAt(1);
		 XSSFRow r1=sheet.getRow(0);
		 XSSFRow r;
		 int rowindex=0;
		 int totalrowrequired=0;
		 for(int k=2;k<=sheet.getLastRowNum();k++){
		 XSSFRow counter=sheet.getRow(k);
		 if(counter.getCell(1).toString().equals("Yes"))
		 {
			 totalrowrequired=totalrowrequired+1;
			
		 }
		 
		 }
		 Log.info("Total Data Set for Ethernet CarNor will be"+totalrowrequired);
		 Object[][] listOfLists = new Object[totalrowrequired][1];
		//Object[][] data= new Object[sheet.getLastRowNum()][r.getLastCellNum()];  
		 //Log.info("Total number of Columns" +r.getLastCellNum());
		 //Log.info("Total number of Columns" +sheet.getLastRowNum());
		 for(int i=2;i<=sheet.getLastRowNum();i++)
		 { 
			 r=sheet.getRow(i);
			 Object[]  data=new Object[r1.getLastCellNum()];
			 //Log.info(r.getLastCellNum());
		if(r.getCell(1).toString().equals("Yes")){
		   for(int j=3;j<=r1.getLastCellNum()-1;j++)
			 {
			   String strCellValue;
			   try {
				   if(r.getCell(j).getCellType()==Cell.CELL_TYPE_NUMERIC)
				   {
					   int value=(int)r.getCell(j).getNumericCellValue();
					   strCellValue=String.valueOf(value);
					   Log.info("The Value is in Int Format and Value is:"+strCellValue);
					   
				   }
				   
				   else {
					   strCellValue=r.getCell(j).toString();
					   Log.info("The Value of this cell is in String Format and Value is : "+strCellValue);
				   }
				   }
				   catch(java.lang.NullPointerException e)
				   {
					   strCellValue="";
					   Log.info("The Value of this cell is: "+strCellValue);
				   }
			   data[j-3] = strCellValue;
			  
			    //data[i-1][j] = ;
			 
			 }
		   data[r1.getLastCellNum()-2]=r.getCell(0).toString();
		   data[r1.getLastCellNum()-1]=r.getCell(1).toString();
		   //Log.info("The Value of this cell is: "+data[r1.getLastCellNum()-2]);
		  // Log.info("The Value of this cell is: "+data[r1.getLastCellNum()-1]);
		   listOfLists[rowindex][0]=data;
		   rowindex=rowindex+1;
		 }
		 //Log.info(data.toString());
		 workbook.close();
		 }
		 return listOfLists;
		 
	}	

	@DataProvider(name="CeaseOrder")
	public static Object[][] ceasereader() throws IOException
	{
		
		 FileInputStream file = new FileInputStream(new File("src\\Data\\CeaseOrder.xlsx"));
		 XSSFWorkbook workbook = new XSSFWorkbook(file);
		 XSSFSheet sheet = workbook.getSheetAt(0);
		 XSSFRow r1=sheet.getRow(0);
		 XSSFRow r;
		 int rowindex=0;
		 int totalrowrequired=0;
		 for(int k=2;k<=sheet.getLastRowNum();k++){
		 XSSFRow counter=sheet.getRow(k);
		 if(counter.getCell(1).toString().equals("Yes"))
		 {
			 totalrowrequired=totalrowrequired+1;
			
		 }
		 
		 }
		 Log.info("Total Data Set for Cease Order will be"+totalrowrequired);
		 Object[][] listOfLists = new Object[totalrowrequired][1];
		//Object[][] data= new Object[sheet.getLastRowNum()][r.getLastCellNum()];  
		 //Log.info("Total number of Columns" +r.getLastCellNum());
		 //Log.info("Total number of Columns" +sheet.getLastRowNum());
		 for(int i=2;i<=sheet.getLastRowNum();i++)
		 { 
			 r=sheet.getRow(i);
			 Object[]  data=new Object[r1.getLastCellNum()];
			 //Log.info(r.getLastCellNum());
		if(r.getCell(1).toString().equals("Yes")){
		   for(int j=3;j<=r1.getLastCellNum()-1;j++)
			 {
			   String strCellValue;
			   try {
				   if(r.getCell(j).getCellType()==Cell.CELL_TYPE_NUMERIC)
				   {
					   int value=(int)r.getCell(j).getNumericCellValue();
					   strCellValue=String.valueOf(value);
					   Log.info("The Value is in Int Format and Value is:"+strCellValue);
					   
				   }
				   
				   else {
					   strCellValue=r.getCell(j).toString();
					   Log.info("The Value of this cell is in String Format and Value is : "+strCellValue);
				   }
				   }
				   catch(java.lang.NullPointerException e)
				   {
					   strCellValue="";
					   Log.info("The Value of this cell is: "+strCellValue);
				   }
			   data[j-3] = strCellValue;
			  
			    //data[i-1][j] = ;
			 
			 }
		   data[r1.getLastCellNum()-2]=r.getCell(0).toString();
		   data[r1.getLastCellNum()-1]=r.getCell(1).toString();
		   //Log.info("The Value of this cell is: "+data[r1.getLastCellNum()-2]);
		  // Log.info("The Value of this cell is: "+data[r1.getLastCellNum()-1]);
		   listOfLists[rowindex][0]=data;
		   rowindex=rowindex+1;
		 }
		 //Log.info(data.toString());
		 workbook.close();
		 }
		 return listOfLists;
		 
	}
	
	@DataProvider(name="SiebelNewOrder")
	public static Object[][] siebelreader() throws IOException
	{
		
		 FileInputStream file = new FileInputStream(new File("src\\Data\\SiebelNewOrder.xlsx"));
		 XSSFWorkbook workbook = new XSSFWorkbook(file);
		 XSSFSheet sheet = workbook.getSheetAt(0);
		 XSSFRow r1=sheet.getRow(0);
		 XSSFRow r;
		 int rowindex=0;
		 int totalrowrequired=0;
		 for(int k=1;k<=sheet.getLastRowNum();k++){
		 XSSFRow counter=sheet.getRow(k);
		 if(counter.getCell(1).toString().equals("Yes"))
		 {
			 totalrowrequired=totalrowrequired+1;
			
		 }
		 
		 }
		 Log.info("Total Data Set for Siebel P2P will be"+totalrowrequired);
		 Object[][] listOfLists = new Object[totalrowrequired][1];
		//Object[][] data= new Object[sheet.getLastRowNum()][r.getLastCellNum()];  
		 //Log.info("Total number of Columns" +r.getLastCellNum());
		 //Log.info("Total number of Columns" +sheet.getLastRowNum());
		 for(int i=1;i<=sheet.getLastRowNum();i++)
		 { 
			 r=sheet.getRow(i);
			 Object[]  data=new Object[r1.getLastCellNum()];
			 //Log.info(r.getLastCellNum());
		if(r.getCell(1).toString().equals("Yes")){
		   for(int j=3;j<=r1.getLastCellNum()-1;j++)
			 {
			   String strCellValue;
			   try {
				   if(r.getCell(j).getCellType()==Cell.CELL_TYPE_NUMERIC)
				   {
					   int value=(int)r.getCell(j).getNumericCellValue();
					   strCellValue=String.valueOf(value);
					   Log.info("The Value is in Int Format and Value is:"+strCellValue);
					   
				   }
				   
				   else {
					   strCellValue=r.getCell(j).toString();
					   Log.info("The Value of this cell is in String Format and Value is : "+strCellValue);
				   }
				   }
				   catch(java.lang.NullPointerException e)
				   {
					   strCellValue="";
					   Log.info("The Value of this cell is: "+strCellValue);
				   }
			   data[j-3] = strCellValue;
			  
			    //data[i-1][j] = ;
			 
			 }
		   data[r1.getLastCellNum()-2]=r.getCell(0).toString();
		   data[r1.getLastCellNum()-1]=r.getCell(1).toString();
		   Log.info("The Value of this cell is: "+data[r1.getLastCellNum()-2]);
		   Log.info("The Value of this cell is: "+data[r1.getLastCellNum()-1]);
		   listOfLists[rowindex][0]=data;
		   rowindex=rowindex+1;
		 }
		 //Log.info(data.toString());
		 workbook.close();
		 }
		 return listOfLists;
	}	
	
	@DataProvider(name="SiebelModifyOrder")
	public static Object[][] siebelmodifyreader() throws IOException
	{
		
		 FileInputStream file = new FileInputStream(new File("src\\Data\\SiebelNewOrder.xlsx"));
		 XSSFWorkbook workbook = new XSSFWorkbook(file);
		 XSSFSheet sheet = workbook.getSheetAt(1);
		 XSSFRow r1=sheet.getRow(0);
		 XSSFRow r;
		 int rowindex=0;
		 int totalrowrequired=0;
		 for(int k=1;k<=sheet.getLastRowNum();k++){
		 XSSFRow counter=sheet.getRow(k);
		 if(counter.getCell(1).toString().equals("Yes"))
		 {
			 totalrowrequired=totalrowrequired+1;
			
		 }
		 
		 }
		 Log.info("Total Data Set for Siebel Modify will be"+totalrowrequired);
		 Object[][] listOfLists = new Object[totalrowrequired][1];
		//Object[][] data= new Object[sheet.getLastRowNum()][r.getLastCellNum()];  
		 //Log.info("Total number of Columns" +r.getLastCellNum());
		 //Log.info("Total number of Columns" +sheet.getLastRowNum());
		 for(int i=1;i<=sheet.getLastRowNum();i++)
		 { 
			 r=sheet.getRow(i);
			 Object[]  data=new Object[r1.getLastCellNum()];
			 //Log.info(r.getLastCellNum());
		if(r.getCell(1).toString().equals("Yes")){
		   for(int j=2;j<=r1.getLastCellNum()-1;j++)
			 {
			   String strCellValue;
			   try {
				   if(r.getCell(j).getCellType()==Cell.CELL_TYPE_NUMERIC)
				   {
					   int value=(int)r.getCell(j).getNumericCellValue();
					   strCellValue=String.valueOf(value);
					   Log.info("The Value is in Int Format and Value is:"+strCellValue);
					   
				   }
				   
				   else {
					   strCellValue=r.getCell(j).toString();
					   Log.info("The Value of this cell is in String Format and Value is : "+strCellValue);
				   }
				   }
				   catch(java.lang.NullPointerException e)
				   {
					   strCellValue="";
					   Log.info("The Value of this cell is: "+strCellValue);
				   }
			   data[j-2] = strCellValue;
			  
			    //data[i-1][j] = ;
			 
			 }
		   data[r1.getLastCellNum()-2]=r.getCell(0).toString();
		   data[r1.getLastCellNum()-1]=r.getCell(1).toString();
		   //Log.info("The Value of this cell is: "+data[r1.getLastCellNum()-2]);
		  // Log.info("The Value of this cell is: "+data[r1.getLastCellNum()-1]);
		   listOfLists[rowindex][0]=data;
		   rowindex=rowindex+1;
		 }
		 //Log.info(data.toString());
		 workbook.close();
		 }
		 return listOfLists;
	}	
	
	@DataProvider(name="SiebelCeaseOrder")
	public static Object[][] siebelceasereader() throws IOException
	{
		
		 FileInputStream file = new FileInputStream(new File("src\\Data\\SiebelNewOrder.xlsx"));
		 XSSFWorkbook workbook = new XSSFWorkbook(file);
		 XSSFSheet sheet = workbook.getSheetAt(2);
		 XSSFRow r1=sheet.getRow(0);
		 XSSFRow r;
		 int rowindex=0;
		 int totalrowrequired=0;
		 for(int k=1;k<=sheet.getLastRowNum();k++){
		 XSSFRow counter=sheet.getRow(k);
		 if(counter.getCell(1).toString().equals("Yes"))
		 {
			 totalrowrequired=totalrowrequired+1;
			
		 }
		 
		 }
		 Log.info("Total Data Set for Siebel Cease will be"+totalrowrequired);
		 Object[][] listOfLists = new Object[totalrowrequired][1];
		//Object[][] data= new Object[sheet.getLastRowNum()][r.getLastCellNum()];  
		 //Log.info("Total number of Columns" +r.getLastCellNum());
		 //Log.info("Total number of Columns" +sheet.getLastRowNum());
		 for(int i=1;i<=sheet.getLastRowNum();i++)
		 { 
			 r=sheet.getRow(i);
			 Object[]  data=new Object[r1.getLastCellNum()];
			 //Log.info(r.getLastCellNum());
		if(r.getCell(1).toString().equals("Yes")){
		   for(int j=2;j<=r1.getLastCellNum()-1;j++)
			 {
			   String strCellValue;
			   try {
				   if(r.getCell(j).getCellType()==Cell.CELL_TYPE_NUMERIC)
				   {
					   int value=(int)r.getCell(j).getNumericCellValue();
					   strCellValue=String.valueOf(value);
					   Log.info("The Value is in Int Format and Value is:"+strCellValue);
					   
				   }
				   
				   else {
					   strCellValue=r.getCell(j).toString();
					   Log.info("The Value of this cell is in String Format and Value is : "+strCellValue);
				   }
				   }
				   catch(java.lang.NullPointerException e)
				   {
					   strCellValue="";
					   Log.info("The Value of this cell is: "+strCellValue);
				   }
			   data[j-2] = strCellValue;
			  
			    //data[i-1][j] = ;
			 
			 }
		   data[r1.getLastCellNum()-2]=r.getCell(0).toString();
		   data[r1.getLastCellNum()-1]=r.getCell(1).toString();
		   //Log.info("The Value of this cell is: "+data[r1.getLastCellNum()-2]);
		  // Log.info("The Value of this cell is: "+data[r1.getLastCellNum()-1]);
		   listOfLists[rowindex][0]=data;
		   rowindex=rowindex+1;
		 }
		 //Log.info(data.toString());
		 workbook.close();
		 }
		 return listOfLists;
	}	
	
	@DataProvider(name="Siebeldata")
	public static Object[][] SiebleInput() throws IOException
	{
		
		 FileInputStream file = new FileInputStream(new File("src\\Data\\SiebelNewOrder.xlsx"));
		 XSSFWorkbook workbook = new XSSFWorkbook(file);
		 XSSFSheet sheet = workbook.getSheetAt(0);
		 XSSFRow r1=sheet.getRow(0);
		 XSSFRow r;
		 Object[][] listOfLists = new Object[sheet.getLastRowNum()][1];
		//Object[][] data= new Object[sheet.getLastRowNum()][r.getLastCellNum()];  
		 //System.out.println("Total number of Columns" +r.getLastCellNum());
		 //System.out.println("Total number of Columns" +sheet.getLastRowNum());
		 for(int i=1;i<=sheet.getLastRowNum();i++)
		 { 
			 r=sheet.getRow(i);
			 Object[]  data=new Object[r1.getLastCellNum()];
			 //System.out.println(r.getLastCellNum());
		   for(int j=0;j<=r1.getLastCellNum()-1;j++)
			 {
			   String strCellValue;
			   try {
				   if(r.getCell(j).getCellType()==Cell.CELL_TYPE_NUMERIC)
				   {
					   int value=(int)r.getCell(j).getNumericCellValue();
					   strCellValue=String.valueOf(value);
					   System.out.println("The Value is in Int Format and Value is:"+strCellValue);
					   
				   }
				   
				   else {
					   strCellValue=r.getCell(j).toString();
					   System.out.println("The Value of this cell is in String Format and Value is : "+strCellValue);
				   }
				   }
				   catch(java.lang.NullPointerException e)
				   {
					   strCellValue="";
					   System.out.println("The Value of this cell is: "+strCellValue);
				   }
			   data[j] = strCellValue;
			    //data[i-1][j] = ;
			 
			 }
		   listOfLists[i-1][0]=data;
		 }
		 //System.out.println(data.toString());
		 workbook.close();
		 return listOfLists;
		 
	}
	
	//@DataProvider(name="Logindata")
//	public static Object[][] LogindataReader() throws IOException
//	{
//		
////		 FileInputStream file = new FileInputStream(new File("C:\\Users\\ashwanis\\eclipse-workspace\\Demo\\src\\Data\\Data.xlsx"));
////		 XSSFWorkbook workbook = new XSSFWorkbook(file);
////		 XSSFSheet sheet = workbook.getSheetAt(0);
////		 XSSFRow r=sheet.getRow(0);
////		Object[][] data= new Object[sheet.getLastRowNum()][r.getLastCellNum()];  
////		 for(int i=1;i<=sheet.getLastRowNum();i++)
////		 { 
////			 r=sheet.getRow(i);
////			 //Log.info(r.getLastCellNum());
////		   for(int j=0;j<=r.getLastCellNum()-1;j++)
////			 {
////			    //Log.info(r.getCell(j));
////			    data[i-1][j] = r.getCell(j).toString();
////			 }
////		
////		 }
////		 Log.info(data.toString());
////		 workbook.close();
////		 return data;
//		
//		return new Object[][] { { "C4C", "Salesuser" }};
//		 
//	}
	
	public static void main(String []args) throws Exception {
	DOMConfigurator.configure("log4j.xml");
	Log.info(Integer.toString(datareader().length));
	Log.info(Integer.toString(hubreader().length));
	Log.info(Integer.toString(modreader().length));
	Log.info(Integer.toString(inmodreader().length));
	Log.info(Integer.toString(carnorreader().length));
	Log.info(Integer.toString(ceasereader().length));
	Log.info(Integer.toString(siebelreader().length));
	Log.info(Integer.toString(siebelmodifyreader().length));
	Log.info(Integer.toString(siebelceasereader().length));
	Log.info("in main method");
	Log.info(Integer.toString(SiebleInput().length));
	
}
}