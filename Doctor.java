public class Table {
        
        public static void main(String[] args) {
                //Declaring a initializing data to required arrays
                //id is a integer array, spec is an string array
                //gender is a string array, experience is an integer array
                int [] id ={531,532,533,534};
                String[] spec = {"Musculoskeletal","Wellness","Symptom Relief","Structural Correction"};
                String[] gen = {"Female","Male","Female","Male"};
                int[] exp = {5,12,6,18};
                
                //Printing table headings with necessary spaces
                System.out.printf("    id     spec        gender    experience\n");
                System.out.printf("---------------------------------------------\n");
                
                //Using for loop to iterate through block of code 4 times
                //to print 4 data groups.
                for(int i=0;i<4;i++) {
                        //Printing serial number,id 
                        System.out.printf("%d %5d ",i+1,id[i]);
                        
                        //After printing id, printing necessary spaces using for loop
                        for(int j=0;j<3;j++)
                                System.out.printf(" ");
                        
                        //Printing specialty of respective id in same line
                        System.out.printf("%s",spec[i]);
                        
                        //Printing necessary spaces after printing specialty
                        for(int j=0;j<(5+9-spec[i].length());j++)
                                System.out.printf(" ");
                        
                        //Printing gender of respective id in same line
                        System.out.printf("%s",gen[i]);
                        
                        //Printing spaces
                        for(int j=0;j<4+6-gen[i].length();j++)
                                System.out.printf(" ");
                        
                        //Printing experience and new line
                        System.out.printf("%d\n",exp[i]);               
                
                }
        }
}

