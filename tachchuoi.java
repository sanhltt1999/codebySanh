package OnTap;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;

import javax.xml.crypto.Data;

import OnTap.ConectDB;

public class tachchuoi {
	public static void main(String[] args) {
		if(ConectDB.executeDB("insert into SinhVien values ('123456aD','nguyen van A', '2012-09-02', '0', '9.5')")) {
			System.out.print("thanh cong");
		} else {
			System.out.print("that bai");
		}
	}
}
