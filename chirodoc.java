package arraylist.chiro;

import java.text.SimpleDateFormat;

import java.util.*;

import java.io.*;

public class ChiroProcess {

static ArrayList<Patient> arl = new ArrayList<Patient>();

static String joindate;

public static void main(String[] args) throws IOException {

char l='i';

Calendar currentDate = Calendar.getInstance();

SimpleDateFormat formatter= new SimpleDateFormat("yyyy/MMM/dd HH:mm:ss");

joindate = formatter.format(currentDate.getTime());

Patient p1 = new Patient(1,"Andy", "Macon,Georgia", 40, 'm', "Shoulder", 250f, joindate);

arl.add(p1);

Patient p2 = new Patient(2,"Tom", "Austell,Georgia", 45, 'm', "Chest", 250f, joindate);

arl.add(p2);

Patient p3 = new Patient(3,"James", "Atlanta,Georgia", 56, 'm', "Hip", 250f, joindate);

arl.add(p3);

do

{

Patient p = new Patient();

System.out.println("Enter 1 to register a Patient \n 2 to update Patient details \n 3 to deactivate Patient details \n 4 to display Patient details");

BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

int choice = Integer.parseInt(br.readLine());

switch(choice)

{

case 1:

p.registerPatient();

System.out.println("Patient Registered Successfully !!!");

p.showPatientDetails();

break;

case 2:

p.showPatientDetails();

p.updatePatientDetails();           

break;

case 3:

p.removeInactivePatient();

break;

case 4:

Collections.sort(arl);

p.showPatientDetails();

break;

default:

System.out.println("Patient does not exist with the entered ID");

System.out.println("Try again");

break;

}       

System.out.println("Do you want to continue selecting options (y/n):");

l=(char)br.read();

}while(l=='y');

}/*End of main() method */

} /************** End of ChiroProcess class ******************/

/************ Patient class to implement operations *******************/

class Patient implements Comparable<Patient>

{

int patientID;

String patientName;

String patientAddress;

int age;

char patientSex;

String patientIllness;

float amountForAppointment;

String joindate;

ChiroProcess hm = new ChiroProcess();

Patient() {}

public int compareTo(Patient p)

{

return this.patientID = p.patientID;

}

BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

Patient(int patientID,String patientName,String patientAddress,int age,char patientSex,String patientIllness,float amountForAppointment, String joindate)

{

this.patientID=patientID;

this.patientName=patientName;

this.patientAddress=patientAddress;

this.age=age;

this.patientSex=patientSex;

this.patientIllness=patientIllness;

this.amountForAppointment=amountForAppointment;

this.joindate = joindate;

}

void registerPatient()throws IOException //function to insert new patient records

{

Patient pr = new Patient();

@SuppressWarnings("static-access")

int patientID= hm.arl.size();

pr.patientID = patientID+1;

System.out.println("Enter Patient name:");

pr.patientName = br.readLine();

System.out.println("Enter Patient Address:");

pr.patientAddress = br.readLine();

System.out.println("Enter Patient Age:");

pr.age = Integer.parseInt(br.readLine());

System.out.println("Enter Patient Sex:");

String temp = br.readLine();

pr.patientSex =temp.charAt(0);

System.out.println("Enter Patient Illness:");

pr.patientIllness = br.readLine();

System.out.println("Enter the amount patient needs to pay for appointment:");

pr.amountForAppointment = Float.parseFloat(br.readLine());

pr.joindate = hm.joindate;

hm.arl.add(pr);

}

@SuppressWarnings("static-access")

void removeInactivePatient() throws IOException //function to remove patient records

{

BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

System.out.println("Enter Patient ID:");

int id1 = Integer.parseInt(br.readLine());

int flag=0;

int flag2=0;

String presentdate;

String afteraddingdays;

for(int i=0; i<hm.arl.size(); i++)

{

if(id1 != hm.arl.get(i).patientID)

{

flag=0;

}

else if(id1 == hm.arl.get(i).patientID)

{

presentdate = hm.arl.get(i).joindate;

Calendar cal = Calendar.getInstance();

cal.add(Calendar.DAY_OF_MONTH, 15);

SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MMM/dd HH:mm:ss");

afteraddingdays = formatter.format(cal.getTime());

flag=1;

if(presentdate == afteraddingdays)

{

hm.arl.remove(i);

System.out.println("Patient deleted as his validity expired");

flag2=1;

}

else{

flag2=0;

}

}

}       

if((flag) == 0)

{

System.out.println("Patient with the entered ID does not exist");

}

if(flag2==0)

{

System.out.println("Patient has still days left before his appointment expires");

}

}

/*Function to update patient records*/

void updatePatientDetails() throws IOException

{

char l='n';

Patient p2 = new Patient(patientID, patientName, patientAddress, age, patientSex, patientIllness, amountForAppointment, joindate);

do{

System.out.println("Enter patient ID you want to update:");

BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

int idnum = Integer.parseInt(br.readLine());

for(int i=0; i<hm.arl.size(); i++)

{

if(idnum == hm.arl.get(i).patientID)

{

System.out.println("Enter 1 to change patient's name \n 2 to change patient's address \n 3 to change patient's age \n 4 to change patient's illness \n 5 to change registration fees along with the medical expenses");

int ch = Integer.parseInt(br.readLine());

switch(ch)

{

case 1:

System.out.println("Enter new patient's name:");

p2.patientName = br.readLine();

p2.patientID= hm.arl.get(i).patientID;

p2.patientAddress= hm.arl.get(i).patientAddress;

p2.age=hm.arl.get(i).age;

p2.patientSex=hm.arl.get(i).patientSex;

p2.patientIllness = hm.arl.get(i).patientIllness;

p2.amountForAppointment = hm.arl.get(i).amountForAppointment;

p2.joindate = hm.arl.get(i).joindate;

hm.arl.set(i,p2);

System.out.println("Patient updated !!!");

break;

case 2:

System.out.println("Enter new patient Address:");

p2.patientAddress = br.readLine();

p2.patientID = hm.arl.get(i).patientID;

p2.patientName = hm.arl.get(i).patientName;

p2.age = hm.arl.get(i).age;

p2.patientSex = hm.arl.get(i).patientSex;

p2.patientIllness = hm.arl.get(i).patientIllness;

p2.amountForAppointment = hm.arl.get(i).amountForAppointment;

p2.joindate = hm.arl.get(i).joindate;

hm.arl.set(i,p2);

System.out.println("Patient updated !!!");

break;

case 3:

System.out.println("Enter new Patient age:");

p2.age = Integer.parseInt(br.readLine());

p2.patientID = hm.arl.get(i).patientID;

p2.patientName = hm.arl.get(i).patientName;

p2.patientAddress = hm.arl.get(i).patientAddress;

p2.patientSex = hm.arl.get(i).patientSex;

p2.patientIllness = hm.arl.get(i).patientIllness;

p2.amountForAppointment = hm.arl.get(i).amountForAppointment;

p2.joindate= hm.arl.get(i).joindate;

hm.arl.set(i,p2);

System.out.println("Patient updated !!!");

break;

case 4:

System.out.println("Enter new Patient illness:");

p2.age = hm.arl.get(i).age;

p2.patientID= hm.arl.get(i).patientID;

p2.patientName = hm.arl.get(i).patientName;

p2.patientAddress = hm.arl.get(i).patientAddress;

p2.patientSex = hm.arl.get(i).patientSex;

p2.patientIllness = br.readLine();

p2.amountForAppointment = hm.arl.get(i).amountForAppointment;

p2.joindate = hm.arl.get(i).joindate;

hm.arl.set(i,p2);

System.out.println("Patient updated !!!");

break;

case 5:

System.out.println("Enter the new amount that patient needs to pay:");

p2.age = hm.arl.get(i).age;

p2.patientID = hm.arl.get(i).patientID;

p2.patientName = hm.arl.get(i).patientName;

p2.patientAddress = hm.arl.get(i).patientAddress;

p2.patientSex = hm.arl.get(i).patientSex;

p2.patientIllness = hm.arl.get(i).patientIllness;

p2.amountForAppointment = Float.parseFloat(br.readLine());

p2.joindate = hm.arl.get(i).joindate;

hm.arl.set(i,p2);

System.out.println("Patient details updated !!!");

break;

default:

System.out.println("Invalid choice.");

break;

} /*End of switch block */

}/*End of if block */

} /*End of for block */

System.out.println("Do you want to continue updating (y/n):");

l=(char)br.read();

}while(l=='y'); /*End of do-while block */

}   

/* Function to display patients details*/

void showPatientDetails()

{

System.out.println("patient-ID \t Patient-Name \t Address \t\t Age \t Sex \t Illness \t Fees \t Join-date");    

for(int i=0; i<hm.arl.size(); i++)

{   

System.out.println(hm.arl.get(i).patientID + " \t\t "+hm.arl.get(i).patientName+" \t\t "+hm.arl.get(i).patientAddress+" \t "+hm.arl.get(i).age+" \t "+hm.arl.get(i).patientSex+" \t "+hm.arl.get(i).patientIllness+" \t\t "+hm.arl.get(i).amountForAppointment+" \t "+hm.arl.get(i).joindate);

}

}              

} /********* End of Patient class **************
