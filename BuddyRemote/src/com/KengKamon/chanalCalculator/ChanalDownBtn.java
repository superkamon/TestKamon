package com.KengKamon.chanalCalculator;

public  class ChanalDownBtn {
	
	public static String checkChanalDown(int Ch) {//<= �Ѻ��� Ch �Ѩ�غѹ�ҡ�ҡ�ա Function
		
		String formattedChanal = "";

		// �ӡ��Ŵ��� Ch �Ѩ�غѹ ����� �觤���͡��纷�� log 
		//Ch = Ch - 1;

		switch (Ch) {
		case 1:
			formattedChanal = "��ͧ 5";
			break;
		case 2:
			formattedChanal = "��ͧ ʷ�.";
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
			formattedChanal = "��ͧ 3 FAMILY";
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
			formattedChanal = "��ͧ 8";
			break;
		case 28:
			formattedChanal = "��ͧ 3 SD";
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
			formattedChanal = "��ͧ 3 HD";
			break;
		case 34:
			formattedChanal = "AMARIN TV HD";
			break;
		case 35:
			formattedChanal = "��ͧ 7 HD";
			break;
		case 36:
			formattedChanal = "PPTV HD";
			break;
		default:
			Ch = 36; // ��Ѻ�����������ͧ 36
			break;

		}
		return formattedChanal;
	}


}
