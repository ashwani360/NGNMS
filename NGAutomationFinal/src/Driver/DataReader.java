package Driver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataReader {
	@DataProvider(name="EtherNetP2PNewOrder")
	public static Object[][] datareader() throws IOException
	{
		
		 FileInputStream file = new FileInputStream(new File("src\\Data\\InputData.xlsx"));
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
					   System.out.println("The Valueis in Int Formate and Value is:"+strCellValue);
					   
				   }
				   
				   else {
					   strCellValue=r.getCell(j).toString();
					   System.out.println("The Value of this cell is in String Formate and avalue is : "+strCellValue);
				   }
				   }
				   catch(java.lang.NullPointerException e)
				   {
					   strCellValue="";
					   System.out.println("The vlue of this cell is: "+strCellValue);
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
	
	@DataProvider(name="Siebledata")
	public static Object[][] SiebleInput() throws IOException
	{
		
		 FileInputStream file = new FileInputStream(new File("src\\Data\\SiebelData.xlsx"));
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
	
	

	@DataProvider(name="HubAndSpokeNewOrder")
	public static Object[][] hubreader() throws IOException
	{
		
		 FileInputStream file = new FileInputStream(new File("src\\Data\\HubAndSpokeNewOrder.xlsx"));
		 XSSFWorkbook workbook = new XSSFWorkbook(file);
		 XSSFSheet sheet = workbook.getSheetAt(0);
		 XSSFRow r1=sheet.getRow(0);
		 XSSFRow r;
		 int totalrowrequired=0;
		 for(int k=1;k<=sheet.getLastRowNum();k++){
		 XSSFRow counter=sheet.getRow(k);
		 if(counter.getCell(1).toString().equals("Yes"))
		 {
			 totalrowrequired=totalrowrequired+1;
			
		 }
		 
		 }
		 System.out.println("Total Data Set will be"+totalrowrequired);
		 Object[][] listOfLists = new Object[totalrowrequired][1];
		//Object[][] data= new Object[sheet.getLastRowNum()][r.getLastCellNum()];  
		 //System.out.println("Total number of Columns" +r.getLastCellNum());
		 //System.out.println("Total number of Columns" +sheet.getLastRowNum());
		 for(int i=1;i<=sheet.getLastRowNum();i++)
		 { 
			 r=sheet.getRow(i);
			 Object[]  data=new Object[r1.getLastCellNum()];
			 //System.out.println(r.getLastCellNum());
		if(r.getCell(1).toString().equals("Yes")){
		   for(int j=3;j<=r1.getLastCellNum()-1;j++)
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
			   data[j-3] = strCellValue;
			  
			    //data[i-1][j] = ;
			 
			 }
		   data[r1.getLastCellNum()-2]=r.getCell(0).toString();
		   data[r1.getLastCellNum()-1]=r.getCell(1).toString();
		   //System.out.println("The Value of this cell is: "+data[r1.getLastCellNum()-2]);
		  // System.out.println("The Value of this cell is: "+data[r1.getLastCellNum()-1]);
		   listOfLists[i-1][0]=data;
		 }
		 //System.out.println(data.toString());
		 workbook.close();
		 }
		 return listOfLists;
		 
	}
	@DataProvider(name="Ceaseorder")
	public static Object[][] CeaseInputreader() throws IOException
	{
		
		 FileInputStream file = new FileInputStream(new File("src\\Data\\CeaseOrder.xlsx"));
		 XSSFWorkbook workbook = new XSSFWorkbook(file);
		 XSSFSheet sheet = workbook.getSheetAt(0);
		 XSSFRow r1=sheet.getRow(0);
		 XSSFRow r;
		 int totalrowrequired=0;
		 for(int k=1;k<=sheet.getLastRowNum();k++){
		 XSSFRow counter=sheet.getRow(k);
		 if(counter.getCell(1).toString().equals("Yes"))
		 {
			 totalrowrequired=totalrowrequired+1;
			
		 }
		 
		 }
		 System.out.println("Total Data Set will be"+totalrowrequired);
		 Object[][] listOfLists = new Object[totalrowrequired][1];
		//Object[][] data= new Object[sheet.getLastRowNum()][r.getLastCellNum()];  
		 //System.out.println("Total number of Columns" +r.getLastCellNum());
		 //System.out.println("Total number of Columns" +sheet.getLastRowNum());
		 for(int i=1;i<=sheet.getLastRowNum();i++)
		 { 
			 r=sheet.getRow(i);
			 Object[]  data=new Object[r1.getLastCellNum()];
			 //System.out.println(r.getLastCellNum());
		if(r.getCell(1).toString().equals("Yes")){
		   for(int j=3;j<=r1.getLastCellNum()-1;j++)
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
			   data[j-3] = strCellValue;
			  
			    //data[i-1][j] = ;
			 
			 }
		   data[r1.getLastCellNum()-2]=r.getCell(0).toString();
		   data[r1.getLastCellNum()-1]=r.getCell(1).toString();
		   //System.out.println("The Value of this cell is: "+data[r1.getLastCellNum()-2]);
		  // System.out.println("The Value of this cell is: "+data[r1.getLastCellNum()-1]);
		   listOfLists[i-1][0]=data;
		 }
		 //System.out.println(data.toString());
		 workbook.close();
		 }
		 return listOfLists;
		 
	}
	
	@DataProvider(name="ModifyOrder")
	public static Object[][] ModifyInputreader() throws IOException
	{
		
		 FileInputStream file = new FileInputStream(new File("src\\Data\\ModifyOrder.xlsx"));
		 XSSFWorkbook workbook = new XSSFWorkbook(file);
		 XSSFSheet sheet = workbook.getSheetAt(0);
		 XSSFRow r1=sheet.getRow(0);
		 XSSFRow r;
		 int totalrowrequired=0;
		 for(int k=1;k<=sheet.getLastRowNum();k++){
		 XSSFRow counter=sheet.getRow(k);
		 if(counter.getCell(1).toString().equals("Yes"))
		 {
			 totalrowrequired=totalrowrequired+1;
			
		 }
		 
		 }
		 System.out.println("Total Data Set will be"+totalrowrequired);
		 Object[][] listOfLists = new Object[totalrowrequired][1];
		//Object[][] data= new Object[sheet.getLastRowNum()][r.getLastCellNum()];  
		 //System.out.println("Total number of Columns" +r.getLastCellNum());
		 //System.out.println("Total number of Columns" +sheet.getLastRowNum());
		 for(int i=1;i<=sheet.getLastRowNum();i++)
		 { 
			 r=sheet.getRow(i);
			 Object[]  data=new Object[r1.getLastCellNum()];
			 //System.out.println(r.getLastCellNum());
		if(r.getCell(1).toString().equals("Yes")){
		   for(int j=3;j<=r1.getLastCellNum()-1;j++)
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
			   data[j-3] = strCellValue;
			  
			    //data[i-1][j] = ;
			 
			 }
		   data[r1.getLastCellNum()-2]=r.getCell(0).toString();
		   data[r1.getLastCellNum()-1]=r.getCell(1).toString();
		   //System.out.println("The Value of this cell is: "+data[r1.getLastCellNum()-2]);
		  // System.out.println("The Value of this cell is: "+data[r1.getLastCellNum()-1]);
		   listOfLists[i-1][0]=data;
		 }
		 //System.out.println(data.toString());
		 workbook.close();
		 }
		 return listOfLists;
		 
	}
	
	public static void main(String []args) throws Exception {
	System.out.println(datareader().length);
	System.out.println(hubreader().length);
}
//	
}