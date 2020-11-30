package yolo;

public class DataSetInfo 
{
//Attributes
public String Data_Name;
public String Data_Cust; //Data Custodian
public String Data_Cur;  //Data Currency Comments
public String Data_Des;  //Dataset Description
public String Data_Acc;	 //Data Accuracy Comments
public String Data_Att;  //Attributes

public DataSetInfo (String z,String a, String b, String c, String d,String e)
{
	Data_Name = z;
	Data_Cust = a;
	Data_Cur = b;
	Data_Des = c;
	Data_Acc = d;
	Data_Att = e;
}

public String toString()
{
	return "Data Custodian:" + "<br>" + Data_Cust + "<br><br>" + "Data Currency Comments:" + "<br>" + Data_Cur + "<br><br>" + "Dataset Description:" + "<br>" + Data_Des + "<br><br>" + "Data Accuracy Comments:" + "<br>" + Data_Acc + "<br><br>" + "Attributes:" + "<br>" + Data_Att + "<br><br>";
}

}
