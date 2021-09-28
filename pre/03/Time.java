public class Time{ 
    public static void main(String[] args){
        double hour = 12;
	double minute = 52;
	double second = 47;
	double SSM = hour * 3600 + minute * 60 + second;
	double SSMtemp = SSM;
	double STM = 86400 - (hour * 3600 + minute * 60 + second);
	System.out.println(SSM);
	System.out.println(STM);
	System.out.println(SSM / 86400 * 100);
	hour = 13;
	minute = 8;
	second = 53;
	SSM = hour * 3600 + minute * 60 + second;
	System.out.println(SSM - SSMtemp);
    }
}