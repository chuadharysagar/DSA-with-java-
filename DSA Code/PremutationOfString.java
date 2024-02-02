import java.util.ArrayList;

public class PremutationOfString {

      // alll the prermutation of the string printed
      static void Premutation(String p, String up){
           if(up.isEmpty()){
            System.out.println(p);
            return;
           }
           char ch= up.charAt(0);

           for(int i=0;i<=p.length();i++){
            String f= p.substring(0, i);
            String s= p.substring(i,p.length());

            Premutation(f+ch+s,up.substring(1));
           }

      }
    

      // all the premutation of the list will be retyurned in list form
      static ArrayList<String> PremutationList(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> ans = new ArrayList<>();
            ans.add(p);
            return ans;
        }
        char ch= up.charAt(0);
        ArrayList<String> plist= new ArrayList<>();

        for(int i=0;i<=p.length();i++){
         String f= p.substring(0, i);
         String s= p.substring(i,p.length());

         plist.addAll(PremutationList(f+ch+s,up.substring(1)));
        }
        return plist;
   }

   //premutation count == factorial of the lenght of the list 
   static int PremutationCount(String p, String up){
    if(up.isEmpty()){
     return 1;
    }
    char ch= up.charAt(0);
    int count=0;

    for(int i=0;i<=p.length();i++){
     String f= p.substring(0, i);
     String s= p.substring(i,p.length());

    count=count+ PremutationCount(f+ch+s,up.substring(1));
    }
     return count;
}
     public static void main(String[] args) {
         String str= "abc";
         Premutation("", str);
         ArrayList<String> result= new ArrayList<>();
         result=PremutationList("",str);
         System.out.println(result);

         int n= PremutationCount("",str);
         System.out.println("all the premutation count "+n);
     }

}
