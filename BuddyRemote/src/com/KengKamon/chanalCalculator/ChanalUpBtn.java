package com.KengKamon.chanalCalculator;

public class ChanalUpBtn {	

	public static String checkChanalUp(int Ch) {  //<= รับค่า Ch ปัจจุบันมากจากอีก Function
		
		String formattedChanal = "";
				
		// ทำการเพิ่มค่า Ch ปัจจุบัน เเล้ว ส่งค่าออกไปเก็บที่ log 
		//Ch = Ch + 1;

		switch (Ch) {
		case 1:
			formattedChanal = "CH 5";
			break;
		case 2:
			formattedChanal = "NBT";
			break;
		case 3:
			formattedChanal = "Thai PBS";
			break;
		case 4:
			formattedChanal = "null"; 
			break;
		case 5:
			formattedChanal = "null";
			break;
		case 6:
			formattedChanal = "null";
			break;
		case 7:
			formattedChanal = "null";
			break;
		case 8:
			formattedChanal = "null";
			break;
		case 9:
			formattedChanal = "null";
			break;
		case 10:
			formattedChanal = "null";
			break;
		case 11:
			formattedChanal = "null";
			break;
		case 12:
			formattedChanal = "null";
			break;
		case 13:
			formattedChanal = "CH 3 FAMILY";
			break;
		case 14:
			formattedChanal = "MCOT";
			break;
		case 15:
			formattedChanal = "LOCA";
			break;
		case 16:
			formattedChanal = "TNN 24";
			break;
		case 17:
			formattedChanal = "THV";
			break;
		case 18:
			formattedChanal = "new)tv";
			break;
		case 19:
			formattedChanal = "spring NEWS";
			break;
		case 20:
			formattedChanal = "BRIGHT TV";
			break;
		case 21:
			formattedChanal = "VOICE TV 21";
			break;
		case 22:
			formattedChanal = "Nation";
			break;
		case 23:
			formattedChanal = "workpoint TV";
			break;
		case 24:
			formattedChanal = "true 4U";
			break;
		case 25:
			formattedChanal = "null";
			break;
		case 26:
			formattedChanal = "Now26";
			break;
		case 27:
			formattedChanal = "CH 8";
			break;
		case 28:
			formattedChanal = "CH 3 SD";
			break;
		case 29:
			formattedChanal = "MONO 29";
			break;
		case 30:
			formattedChanal = "MCOT HD";
			break;
		case 31:
			formattedChanal = "ONE";
			break;
		case 32:
			formattedChanal = "Thairat";
			break;
		case 33:
			formattedChanal = "CH 3 HD";
			break;
		case 34:
			formattedChanal = "AMARIN TV HD";
			break;
		case 35:
			formattedChanal = "CH 7 HD";
			break;
		case 36:
			formattedChanal = "PPTV HD";
			break;
		default:
			formattedChanal = "null" ;  // กลับมาเริ่มที่ช่อง 1
			break;

		}
		return formattedChanal;
	}
	
}
