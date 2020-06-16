package OnTap;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Locale;

import OnTap.ConectDB;

public class readfile {
	public static void main(String[] args) throws Exception {
		File file = new File("C:\\Users\\chang\\Desktop\\file.txt");
		FileInputStream fis = new FileInputStream(file);
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<String> mssv = new ArrayList<String>();
		ArrayList<String> ngaysinh = new ArrayList<String>();
		ArrayList<String> gioitinh = new ArrayList<String>();
		ArrayList<String> diem = new ArrayList<String>();
		int c;
		int i = 0;
		String strname = "";
		String strMssv = "";
		String strNgaySinh = "";
		String strGioiTinh = "";
		String strDiem = "";
		
		while((c=fis.read()) != -1) {
			i++;
			if(i<= 10) {
				strMssv = strMssv + (char)c;
			}
			if(i>10 && i<=40) {
				
				strname = strname + (char)c;
			}
			if(i>40 && i<=50) {
				strNgaySinh = strNgaySinh + (char)c;
			}
			if(i>50 && i<=53) {
				strGioiTinh = strGioiTinh + (char)c;
			}
			if(i>53 && (char)c != '\n') {
				strDiem = strDiem + (char)c;
			}else if(i>53 && (char)c == '\n') {
				System.out.println(strNgaySinh);
				names.add(strname);
				mssv.add(strMssv);
				ngaysinh.add(strNgaySinh);
				gioitinh.add(strGioiTinh);
				diem.add(strDiem);
				i = 0;
				strMssv = "";
				strGioiTinh = "";
				strDiem = "";
				strname = "";
				strNgaySinh = "";
			}
		}
		
		for(int k = 0; k < ngaysinh.size(); k++) {
			String dateString = ngaysinh.get(k);
			SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			df.setLenient(false);
			try {
				int GIOITINH = 0;
				if(gioitinh.get(k) == "Nam") {
					GIOITINH = 1;
				}
			    df.parse(dateString); 
			    System.out.println( df.parse(dateString));
			    
			    String deliverydate= ngaysinh.get(k);
			    
			    DateTimeFormatter formatter = new DateTimeFormatterBuilder()
		                .parseCaseInsensitive()
		                .appendPattern("dd/MM/yyyy")
		                .toFormatter(Locale.UK);
			    LocalDate ld = LocalDate.parse(deliverydate, formatter);
			    
			    
			    
			    String query = "insert into SinhVien values ('"
			    		+ 
			    		mssv.get(k) 
			    		//"123456"
			    		+ "','"
			    		+ 
			    		names.get(k)
			    		//"nguyen van A"
			    		+"', '"
			    		+ 
			    		ld
			    		//"2012-09-02"
			    		+ "', '"
			    		+ 
			    		GIOITINH
			    		//"0"
			    		+ "', "
			    		+ 
			    		diem.get(k)
			    		//"9.5"
			    		+")";
			    String qString = "insert into SinhVien values ('123456aD','nguyen van A', '2012-09-02', '0', '9.5')";
			    if(ConectDB.executeDB(query)) {
			    	System.out.println("tnha cong"); 	
			    } else {
			    	System.out.println("that bai");
			    }
			    
			}
			catch (ParseException e) { 
			   System.out.println(k);
			}
		}
		
		
		
		fis.close();
	}

}
